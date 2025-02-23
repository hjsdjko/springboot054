package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LingshidiaopeiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LingshidiaopeiView;


/**
 * 零食调配
 *
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
public interface LingshidiaopeiService extends IService<LingshidiaopeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LingshidiaopeiView> selectListView(Wrapper<LingshidiaopeiEntity> wrapper);
   	
   	LingshidiaopeiView selectView(@Param("ew") Wrapper<LingshidiaopeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LingshidiaopeiEntity> wrapper);
   	

}

