package com.cl.dao;

import com.cl.entity.LingshirukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LingshirukuView;


/**
 * 零食入库
 * 
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
public interface LingshirukuDao extends BaseMapper<LingshirukuEntity> {
	
	List<LingshirukuView> selectListView(@Param("ew") Wrapper<LingshirukuEntity> wrapper);

	List<LingshirukuView> selectListView(Pagination page,@Param("ew") Wrapper<LingshirukuEntity> wrapper);
	
	LingshirukuView selectView(@Param("ew") Wrapper<LingshirukuEntity> wrapper);
	

}
