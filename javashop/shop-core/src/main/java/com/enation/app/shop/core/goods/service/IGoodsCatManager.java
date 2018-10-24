package com.enation.app.shop.core.goods.service;

import java.util.List;
import java.util.Map;

import com.enation.app.base.core.model.Adv;
import com.enation.app.shop.core.goods.model.Cat;
import com.enation.app.shop.core.goods.model.Brand;
import com.enation.app.shop.core.goods.model.Goods;

/**
 * 商品类别管理
 * @author kingapex
 * 2010-1-6上午12:39:09
 */
public interface IGoodsCatManager {
	
	
 
	/**
	 * 检测类名是否存在
	 * @param name
	 * @return 存在返回真，不存在返回假
	 */
	public boolean checkname(String name,Integer catid);
	
	
	
	/**
	 * 根据类别id获取类别
	 * @param cat_id
	 * @return
	 */
	public Cat getById(int cat_id);
	
	
	
	
	/**
	 * 添加商品类别
	 * @param cat
	 */
	public void saveAdd(Cat cat);
	
	
	
	
	/**
	 * 更新商品类别
	 * @param cat
	 */
	public void update(Cat cat);
	
	
	
	
	
	/**
	 * 删除商品类别
	 * @param cat_id
	 * @return 1删除失败有子类别，0删除成功
	 */
	public int delete(int cat_id);
	
	
	
	
	
	
	/**
	 * 获取某个类别的所有子类，所有的子孙
	 * @param cat_id
	 * @return
	 */
	public List<Cat> listAllChildren(Integer cat_id);
	

	
	
	
	/**
	 * 读取某类别下的子类别，只是儿子
	 * @param cat_id
	 * @return
	 */
	public List<Cat> listChildren(Integer cat_id);
	
	
	/**
	 * 读取某分类下的子分类，只是儿子（后台分类列表特有的异步读取）
	 * @author xulipeng			
	 * @param cat_id
	 * @return
	 * 
	 * 2015年10月26日
	 * 
	 */
	public List<Map> getListChildren(Integer cat_id);
	
	
	
	
	/**
	 * 保存排序
	 * @param cat_ids
	 * @param cat_sorts
	 */
	public void saveSort(int[] cat_ids, int[] cat_sorts) ;
	
	/**
	 * 获取某个分类的所有父
	 * @param catid
	 * @return
	 */
	public List<Cat> getParents(int catid);
	
	/**
	 * 获取商品类型所有父
	 * @return
	 */
	public List getGoodsParentsType();
	
	/**
	 * 商品发布，获取当前登录用户选择经营类目的所有父
	 * @param cat_id
	 * @return
	 */
	public List<Cat> getGoodsParentsType(Integer cat_id);

	/**
	 * 根据是否显示在首页判断 获取商品
	 * @param index_show
	 * @return
	 */
	public List<Cat> queryAllList(Integer index_show);

	/**
	 * 根据是否显示在首页判断 获取商品（获取指定字段）
	 * @param index_show
	 * @return
	 */
	public List<Cat> queryField(Integer index_show);

	/**
	 * 查询分类
	 * @return
	 */
	public List<Cat> queryGoodsCat();

	/**
	 * 查询品牌制造商直供
	 * @return
	 */
	public List<Brand> queryBrand();

	/**
	 * 查询人气推荐
	 * @return
	 */
	public List<Goods>queryGoods();
	/**
	 * 获取广告位
	 * @return
	 */
	public List<Adv>queryAdv();
	/**
	 * 获取二级菜单
	 * @return
	 */
	public List<Cat> queryCat();

	/**
	 * 获取当前子类父亲的所有兄弟
	 * @param parent_id
	 * @return
	 */
	public List<Cat> queryCatParent(Integer parent_id);
	/**
	 * 获取三级菜单
	 * @return
	 */
	public List<Cat> queryCatTypeId(Integer parent);
	/**
	 * 获取商品
	 * @return
	 */
	public List<Goods> queryGoodsList(Integer[] typeId);
	/**
	 * 获取商品个数
	 */
	public int countGoods ();

}
