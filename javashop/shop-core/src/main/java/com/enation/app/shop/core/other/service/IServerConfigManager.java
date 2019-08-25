package com.enation.app.shop.core.other.service;

import com.enation.app.shop.core.other.model.ServerConfig;
import com.enation.framework.database.Page;

import java.util.List;

public interface IServerConfigManager {


    ServerConfig findByState();

    List<ServerConfig> serverConfigs();


    Page getAllServerContent(Integer pageNo, Integer pageSize);

    ServerConfig get(int id);

    void setOpen(int id);

    void saveEdit(ServerConfig config);

    void deleteById(int id);

    void addSave(ServerConfig config);
}
