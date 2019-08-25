package com.enation.app.shop.core.other.service.impl;

import com.enation.app.shop.core.other.model.ServerConfig;
import com.enation.app.shop.core.other.service.IServerConfigManager;
import com.enation.framework.database.IDaoSupport;
import com.enation.framework.database.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerConfigManager implements IServerConfigManager {

    @Autowired
    private IDaoSupport daoSupport;

    public ServerConfig findByState(){

        String sql = "select * from es_server where state = 1";

        return this.daoSupport.queryForObject(sql,ServerConfig.class);

    }

    @Override
    public List<ServerConfig> serverConfigs() {
        String sql = "select * from es_server";
        List<ServerConfig> serverConfigs = this.daoSupport.queryForList(sql,ServerConfig.class);
        return serverConfigs;
    }

    @Override
    public Page getAllServerContent(Integer pageNo, Integer pageSize) {
        String sql = "select * from es_server";
        return this.daoSupport.queryForPage(sql,pageNo,pageSize);
    }

    @Override
    public ServerConfig get(int id){
        String sql = "select * from es_server where id = ?";
        return this.daoSupport.queryForObject(sql,ServerConfig.class,id);
    }

    @Override
    public void setOpen(int id) {
        this.daoSupport.execute("update es_server set state = 0");
        this.daoSupport.execute("update es_server set state = 1 where id = ?",id);
    }

    @Override
    public void saveEdit(ServerConfig config) {
        this.daoSupport.update("es_server",config,"id+"+config.getId());
    }

    @Override
    public void deleteById(int id) {
        this.daoSupport.execute("delete from es_server where id = ?",id);
    }

    @Override
    public void addSave(ServerConfig config) {
        this.daoSupport.insert("es_server",config);
    }


}
