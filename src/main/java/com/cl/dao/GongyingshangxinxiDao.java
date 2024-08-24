package com.cl.dao;

import com.cl.entity.GongyingshangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GongyingshangxinxiView;


/**
 * 供应商信息
 * 
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
public interface GongyingshangxinxiDao extends BaseMapper<GongyingshangxinxiEntity> {
	
	List<GongyingshangxinxiView> selectListView(@Param("ew") Wrapper<GongyingshangxinxiEntity> wrapper);

	List<GongyingshangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<GongyingshangxinxiEntity> wrapper);
	
	GongyingshangxinxiView selectView(@Param("ew") Wrapper<GongyingshangxinxiEntity> wrapper);
	

}
