package com.enation.app.groupbuy.front.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.enation.app.groupbuy.core.model.GroupBuy;
import com.enation.app.groupbuy.core.service.IGroupBuyManager;
import com.enation.app.shop.core.goods.model.Product;
import com.enation.app.shop.core.goods.model.Specification;
import com.enation.app.shop.core.goods.service.IGoodsManager;
import com.enation.app.shop.core.goods.service.IProductManager;
import com.enation.framework.taglib.BaseFreeMarkerTag;

import freemarker.template.TemplateModelException;
/**
 * 
 * (商品规格标签) 
 * @author zjp
 * @version v1.0
 * @since v6.2
 * 2016年12月26日 上午2:33:22
 */
@Component
@Scope("prototype")
public class GroupBuyGoodsSpecTag extends BaseFreeMarkerTag {
	
	@Autowired
	private IProductManager productManager;
	
	@Autowired
	private IGoodsManager goodsManager;
	@Autowired
	private IGroupBuyManager groupBuyManager;
	/**
	 * 商品规格标签
	 * @param 无
	 * @return 商品规格，类型Map。根据have_spec(是否有规格 0无  1有) 的值不同，返回不同的值
	 * have_spec：0 时，返回值Map的key有： productid(商品的货品id)、productList(商品的货品列表){@link Product}
	 * have_spec：1 时，返回值Map的key有：specList(商品规格数据列表){@link Specification}、productList(商品的货品列表)
	 */
	@Override
	protected Object exec(Map params) throws TemplateModelException {
		Map goods = new HashMap();
		HttpServletRequest request  = this.getRequest();
		Integer goods_id ; 
		if(params.get("goods_id")==null){
			goods =(Map)request.getAttribute("goods");
			if(goods==null) throw new TemplateModelException("调用商规格标签前，必须先调用商品基本信息标签");
			goods_id = (Integer) goods.get("goods_id");
		}else{
			goods_id=Integer.parseInt(params.get("goods_id").toString());
			goods = this.goodsManager.get(goods_id);
		}
		List<Product> productList  = this.productManager.list(goods_id);
		
		Map data = new HashMap();
		if( (""+goods.get("have_spec")).equals("0")){
			data.put("productid", productList.get(0).getProduct_id());//商品的货品id
			data.put("productList", productList);//商品的货品列表
		}else{
			Integer is_groupbuy = Integer.parseInt(goods.get("is_groupbuy").toString());
			if(is_groupbuy==1){
				List<GroupBuy> buyGoodsList = groupBuyManager.getBuyGoodsList(goods_id);
				for (GroupBuy groupBuy : buyGoodsList) {
					for (Product product : productList) {
						if(groupBuy.getProduct_id().equals(product.getProduct_id())){
							product.setPrice(groupBuy.getPrice());
						}
					}
				}
			}
			
			List<Specification> specList = this.productManager.listSpecs(goods_id);
			data.put("specList", specList);//商品规格数据列表
			data.put("productList", productList);//商品的货品列表
		}
		data.put("have_spec", goods.get("have_spec"));//是否有规格
		return data;
	}


}
