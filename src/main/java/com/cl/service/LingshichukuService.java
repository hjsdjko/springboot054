package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LingshichukuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LingshichukuView;


/**
 * 零食出库
 *
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
public interface LingshichukuService extends IService<LingshichukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LingshichukuView> selectListView(Wrapper<LingshichukuEntity> wrapper);
   	
   	LingshichukuView selectView(@Param("ew") Wrapper<LingshichukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LingshichukuEntity> wrapper);
   	

}

