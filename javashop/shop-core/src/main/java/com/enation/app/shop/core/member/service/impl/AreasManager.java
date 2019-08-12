package com.enation.app.shop.core.member.service.impl;

import com.enation.app.shop.core.member.model.Area;
import com.enation.app.shop.core.member.service.IAreasManager;
import com.enation.framework.database.IDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreasManager implements IAreasManager {


    @Autowired
    private IDaoSupport daoSupport;

    @Override
    public List<Area> getAreaByLevel() {
        String sql = "select * from es_area where level = 3";
        List<Area> area = this.daoSupport.queryForList(sql,Area.class);
        return area;
    }

    @Override
    public Area getAreaByPrantId(int prantId) {
        String sql = "select * from es_area where area_code = ?";
        Area area = this.daoSupport.queryForObject(sql,Area.class,prantId);
        return area;
    }


}
