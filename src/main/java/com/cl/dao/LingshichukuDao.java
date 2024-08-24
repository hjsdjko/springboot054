package com.cl.dao;

import com.cl.entity.LingshichukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LingshichukuView;


/**
 * 零食出库
 * 
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
public interface LingshichukuDao extends BaseMapper<LingshichukuEntity> {
	
	List<LingshichukuView> selectListView(@Param("ew") Wrapper<LingshichukuEntity> wrapper);

	List<LingshichukuView> selectListView(Pagination page,@Param("ew") Wrapper<LingshichukuEntity> wrapper);
	
	LingshichukuView selectView(@Param("ew") Wrapper<LingshichukuEntity> wrapper);
	

}
