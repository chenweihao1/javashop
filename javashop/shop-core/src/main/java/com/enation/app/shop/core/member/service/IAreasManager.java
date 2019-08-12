package com.enation.app.shop.core.member.service;

import com.enation.app.shop.core.member.model.Area;

import java.util.List;

public interface IAreasManager {

    public List<Area> getAreaByLevel();

    public Area getAreaByPrantId(int prantId);

}
