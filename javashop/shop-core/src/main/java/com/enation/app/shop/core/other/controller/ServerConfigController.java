package com.enation.app.shop.core.other.controller;


import com.enation.app.shop.core.other.model.ServerConfig;
import com.enation.app.shop.core.other.service.IServerConfigManager;
import com.enation.framework.action.GridController;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.action.JsonResult;
import com.enation.framework.util.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shop/admin/server")
public class ServerConfigController extends GridController {


    @Autowired
    private IServerConfigManager serverConfigManager;


    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView view = this.getGridModelAndView();
        view.addObject("serverList",serverConfigManager.serverConfigs());
        view.setViewName("/shop/admin/server/server_content_list");
        return view;
    }


    @ResponseBody
    @RequestMapping(value="/list-json")
    public GridJsonResult listJson() {
        webpage = serverConfigManager.getAllServerContent(this.getPage(), this.getPageSize());
        return JsonResultUtil.getGridJson(webpage);
    }

    @RequestMapping("/edit")
    public ModelAndView edit(int id){
        ModelAndView view = this.getGridModelAndView();
        view.addObject("serverConfig",serverConfigManager.get(id));
        view.setViewName("/shop/admin/server/server_config_edit");
        return view;
    }

    @ResponseBody
    @RequestMapping("edit-save")
    public JsonResult saveEdit(ServerConfig config){
        try {
            this.serverConfigManager.saveEdit(config);
            return JsonResultUtil.getSuccessJson("域名修改成功");
        } catch (Exception e) {
            logger.error("系统异常:{}",e);
            return JsonResultUtil.getErrorJson("修改域名失败");
        }
    }

    @ResponseBody
    @RequestMapping("set-open")
    public JsonResult setOpen(int id){
        try {
            this.serverConfigManager.setOpen(id);
            return JsonResultUtil.getSuccessJson("启用成功");
        } catch (Exception e) {
            logger.error("系统异常:{}",e);
            return JsonResultUtil.getErrorJson("启用失败");
        }
    }

    @ResponseBody
    @RequestMapping("delete")
    public JsonResult delete(int id){
        try {
            this.serverConfigManager.deleteById(id);
            return JsonResultUtil.getSuccessJson("删除成功");
        } catch (Exception e) {
            logger.error("系统异常:{}",e);
            return JsonResultUtil.getErrorJson("删除失败");
        }

    }

    @RequestMapping("/add")
    public ModelAndView add(){
        ModelAndView view = this.getGridModelAndView();
        view.addObject("serverList",serverConfigManager.serverConfigs());
        view.setViewName("/shop/admin/server/server_content_add");
        return view;
    }


    @ResponseBody
    @RequestMapping("/add-save")
    public JsonResult addSave(ServerConfig config){
        try {
            this.serverConfigManager.addSave(config);
            return JsonResultUtil.getSuccessJson("添加域名成功");
        } catch (Exception e) {
            logger.error("系统异常:{}",e);
            return JsonResultUtil.getErrorJson("添加域名失败");
        }
    }
}

