package com.enation.app.shop.front.api.member;

import com.enation.app.base.core.model.Member;
import com.enation.app.shop.component.receipt.Receipt;
import com.enation.app.shop.core.member.model.Footprint;
import com.enation.app.shop.core.member.service.IFootprintManager;
import com.enation.eop.sdk.context.UserConext;
import com.enation.framework.action.JsonResult;
import com.enation.framework.context.webcontext.ThreadContextHolder;
import com.enation.framework.util.DateUtil;
import com.enation.framework.util.JsonMessageUtil;
import com.enation.framework.util.JsonResultUtil;
import com.enation.framework.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuyulei
 * @version 1.0
 * @Description: ${todo}
 * @date 2018-10-24 9:44 AM
 * @since v6.5
 */
@Controller
@RequestMapping("/api/shop/member-foot")
@Scope("prototype")
public class MemberFootprintController {

    @Autowired
    private IFootprintManager footprintManager;

    /**
     * 添加会员足迹，如果足迹已经存在则更新时间
     * @param goods_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/update")
    public JsonResult update(Integer goods_id) {

        Assert.notNull(goods_id,"参数错误");

        String sessionid = ThreadContextHolder.getHttpRequest().getSession().getId();
        //会员足迹
        Member member = UserConext.getCurrentMember();
        Integer member_id = -1;
        if(member != null ){
            member_id = member.getMember_id();
        }

        //如果此商品从在则只更新时间
        Footprint footprintNew = this.footprintManager.get(goods_id,member_id,sessionid);
        if(footprintNew==null){
            Footprint footprint = new Footprint();
            footprint.setGoods_id(goods_id);
            footprint.setMember_id(member_id);
            footprint.setIs_default("0");
            footprint.setSession_id(sessionid);
            this.footprintManager.add(footprint);
        }else{
            this.footprintManager.update(footprintNew.getFootprint_id());
        }
        return JsonResultUtil.getSuccessJson("添加成功");
    }

}
