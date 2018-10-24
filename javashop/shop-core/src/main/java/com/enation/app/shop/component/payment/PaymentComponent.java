package com.enation.app.shop.component.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enation.framework.component.IComponent;
import com.enation.framework.database.data.IDataOperation;

/**
 * 支付组件
 * 
 * @author kingapex 2012-3-30上午9:30:37
 */
@Component
public class PaymentComponent implements IComponent {

	@Autowired
	private IDataOperation dataOperation;
	
	@Override
	public void install() {
//		dataOperation.imported("file:com/enation/app/shop/component/payment/plugin/weixin/weixin_install.xml");
	}

	@Override
	public void unInstall() {
//		dataOperation.imported("file:com/enation/app/shop/component/payment/plugin/weixin/weixin_uninstall.xml");
	}
}
