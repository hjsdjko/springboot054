package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LingshixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LingshixinxiView;


/**
 * 零食信息
 *
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
public interface LingshixinxiService extends IService<LingshixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LingshixinxiView> selectListView(Wrapper<LingshixinxiEntity> wrapper);
   	
   	LingshixinxiView selectView(@Param("ew") Wrapper<LingshixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LingshixinxiEntity> wrapper);
   	

}

