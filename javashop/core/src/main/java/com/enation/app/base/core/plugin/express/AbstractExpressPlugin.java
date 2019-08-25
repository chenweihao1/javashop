package com.enation.app.base.core.plugin.express;

import com.enation.framework.plugin.AutoRegisterPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractExpressPlugin extends AutoRegisterPlugin {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	/**
	 * 为短信插件定义唯一的id
	 * @return
	 */
	public abstract String getId();
	
	
	/**
	 * 定义插件名称
	 * @return
	 */
	public abstract String getName();

}
