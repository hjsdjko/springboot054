package com.cl.dao;

import com.cl.entity.LingshixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LingshixinxiView;


/**
 * 零食信息
 * 
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
public interface LingshixinxiDao extends BaseMapper<LingshixinxiEntity> {
	
	List<LingshixinxiView> selectListView(@Param("ew") Wrapper<LingshixinxiEntity> wrapper);

	List<LingshixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<LingshixinxiEntity> wrapper);
	
	LingshixinxiView selectView(@Param("ew") Wrapper<LingshixinxiEntity> wrapper);
	

}
