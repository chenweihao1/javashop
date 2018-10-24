package com.enation.app.base.core.model;
/**
 * 配置文件映射实体
 * @author dongxin
 * @version v1.0
 * @since v6.4.0
 * 2017年8月15日 上午11:35:42
 */
public class ConfigItem {
	/**配置文件name值 */
	private String name;
	/**配置文件name映射文本值 */
	private String text;
	/**配置文件显示在浏览器时，input的type属性*/
	private String type;
	/**
	 * 配置的值
	 */
	private String value;
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
