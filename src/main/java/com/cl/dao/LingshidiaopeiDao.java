package com.cl.dao;

import com.cl.entity.LingshidiaopeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LingshidiaopeiView;


/**
 * 零食调配
 * 
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
public interface LingshidiaopeiDao extends BaseMapper<LingshidiaopeiEntity> {
	
	List<LingshidiaopeiView> selectListView(@Param("ew") Wrapper<LingshidiaopeiEntity> wrapper);

	List<LingshidiaopeiView> selectListView(Pagination page,@Param("ew") Wrapper<LingshidiaopeiEntity> wrapper);
	
	LingshidiaopeiView selectView(@Param("ew") Wrapper<LingshidiaopeiEntity> wrapper);
	

}
