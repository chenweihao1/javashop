--  添加字段
ALTER TABLE `es_goods_cat` ADD COLUMN `index_show` smallint(1) DEFAULT NULL COMMENT '是否显示在首页';
ALTER TABLE `es_tags` ADD COLUMN `goods_keyword` varchar(255) DEFAULT NULL COMMENT '判断商品类型，英文字段';
ALTER TABLE `es_tag_rel` ADD COLUMN `goods_keyword` varchar(255) DEFAULT NULL;
ALTER TABLE `es_tag_relb` ADD COLUMN `goods_keyword` varchar(255) DEFAULT NULL;
ALTER TABLE `es_adcolumn` ADD COLUMN `keyword` varchar(255) DEFAULT NULL COMMENT '首页最上方广告搜索关键字';
ALTER TABLE `es_adv` ADD COLUMN `keyword` varchar(255) DEFAULT NULL;

--  添加数据
update es_tag_rel set goods_keyword='hot-goods' where tag_id=1;