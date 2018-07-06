package com.enation.app.shop.api;

import com.enation.app.base.core.service.IAdvManager;
import com.enation.framework.action.JsonResult;
import com.enation.framework.util.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Sylow
 * @Description 小程序首页API
 * @Date: Created in 22:25 2018/6/28
 */

@Controller
@RequestMapping("/api/shop/wx-index")
@Scope("prototype")
public class WxIndexController {



    @Autowired
    private IAdvManager iAdvManager;

    @ResponseBody
    @RequestMapping(value="/index",produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult index() {
        Map<String, Object> result = new HashMap<String, Object>();


        List advList = this.iAdvManager.listAdv(Long.parseLong("1"));

        result.put("banner",advList);

        return JsonResultUtil.getObjectJson(result);
    }



}
