package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LingshirukuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LingshirukuView;


/**
 * 零食入库
 *
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
public interface LingshirukuService extends IService<LingshirukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LingshirukuView> selectListView(Wrapper<LingshirukuEntity> wrapper);
   	
   	LingshirukuView selectView(@Param("ew") Wrapper<LingshirukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LingshirukuEntity> wrapper);
   	

}

