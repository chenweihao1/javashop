package com.enation.framework.util;;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpClient工具类
 * 
 * @author X-TAN
 * @Date 2018-08-30
 */
@SuppressWarnings("deprecation")

public abstract class HttpClientUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	/**
	 * HTTP GET请求
	 *
	 * @param url
	 * @param encoding
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String get(String url, String params, String encoding) {
		if (null == encoding || encoding.trim().equals("")) {
			encoding = HTTP.DEFAULT_CONTENT_CHARSET;
		}
		HttpClient httpClient = new DefaultHttpClient();
		String body = null;
		HttpEntity entity = null;
		try {
			/*
			 * Get请求
			 */
			HttpGet httpget = new HttpGet(url);
			/*
			 * 设置参数
			 */
			httpget.setURI(new URI(httpget.getURI().toString() + "?" + params));
			/*
			 * 发送请求
			 */
			HttpResponse httpresponse = httpClient.execute(httpget);
			/*
			 * 获取返回数据
			 */
			entity = httpresponse.getEntity();
			body = EntityUtils.toString(entity, encoding);
			logger.info("响应结果:"+body);
		} catch (Exception e) {
		}
		return body;
	}

	/**
	 * HTTP POST请求
	 *
	 * @param url
	 * @param paramsMap
	 * @param encoding
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String post(String url, Map<String, String> paramsMap, String encoding) {

		List<BasicNameValuePair> basicNameValuePairs = new ArrayList<BasicNameValuePair>();
		Iterator<Entry<String, String>> iterator = paramsMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			basicNameValuePairs.add(new BasicNameValuePair(next.getKey(), next.getValue()));
		}

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.addAll(basicNameValuePairs);

		if (null == encoding || encoding.trim().equals("")) {
			encoding = HTTP.DEFAULT_CONTENT_CHARSET;
		}

		String body = null;
		HttpEntity entity = null;
		HttpClient httpClient = new DefaultHttpClient();
		try {
			/*
			 * Post请求
			 */
			HttpPost httppost = new HttpPost(url);

			/*
			 * 设置参数
			 */
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, encoding);
			httppost.setEntity(formEntity);
			/*
			 * 发送请求
			 */
			HttpResponse httpresponse = httpClient.execute(httppost);
			int code = httpresponse.getStatusLine().getStatusCode();
			String newuri="";
			if (code == 302) {
				Header header = httpresponse.getFirstHeader("location"); // 跳转的目标地址是在 HTTP-HEAD 中的
				newuri = header.getValue(); // 这就是跳转后的地址，再向这个地址发出新申请，以便得到跳转后的信息是啥。
				return newuri;
			}
			/*
			 * 获取返回数据
			 */
			entity = httpresponse.getEntity();
			body = EntityUtils.toString(entity, encoding);

			logger.info("响应结果:"+body);
			System.out.println("响应结果:"+body);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}

	/**
	 * HTTP 文件传输
	 * @author X-TAN
	 * @throws IOException
	 * @throws ClientProtocolException
	 *
	 */
	public static String fileUpLoad(String url, Map<String,Object> map) throws ClientProtocolException, IOException {

		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();

		Set<String> keys = map.keySet();

		keys.forEach(key ->{
			Object obj = map.get(key);

			if(obj instanceof File){
				multipartEntityBuilder.addPart(key,new FileBody((File) map.get(key)));
			}else{
				multipartEntityBuilder.addPart(key, new StringBody(map.get(key).toString(), ContentType.TEXT_PLAIN));
			}
		});
		HttpEntity entity = multipartEntityBuilder.build();
		HttpPost httpPost = new HttpPost(url);
		//httpPost.setHeader("Content-Type","multipart/form-data");
		httpPost.setEntity(entity);
		System.out.println("创建post请求并装载好打包数据");
		// 4. 创建HttpClient对象，传入httpPost执行发送网络请求的动作
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(httpPost);
		System.out.println("发送post请求并获取结果");
		// 5. 获取返回的实体内容对象并解析内容
		HttpEntity resultEntity = response.getEntity();
		System.out.println(response.toString());
		String responseMessage = "";
		try{
			if(resultEntity!=null){
				InputStream is = resultEntity.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				StringBuffer sb = new StringBuffer();
				String line = "";
				while((line = br.readLine()) != null){
					sb.append(line);
				}
				responseMessage = sb.toString();
			}
			EntityUtils.consume(resultEntity);
		}finally{
			if (null != response){
				response.close();
			}
		}
		return responseMessage;
	}


	public static String postDownloadJson(String path, String post) throws IOException {
		String resp = "";
		URL url = new URL(path);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setDoInput(true);
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setUseCaches(false);
		httpURLConnection.setInstanceFollowRedirects(true);
		httpURLConnection.setRequestProperty("Content-Type", "application/json");
		httpURLConnection.connect();
		try (OutputStream os = httpURLConnection.getOutputStream()) {
			os.write(post.getBytes("UTF-8"));
		}
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(httpURLConnection.getInputStream()))) {
			String lines;
			StringBuffer sbf = new StringBuffer();
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sbf.append(lines);
			}
			System.out.println("返回来的报文：" + sbf.toString());
			resp = sbf.toString();

		}
		httpURLConnection.disconnect();
		return  resp;
	}

}
