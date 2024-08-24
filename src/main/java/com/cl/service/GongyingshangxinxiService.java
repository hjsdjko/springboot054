package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GongyingshangxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GongyingshangxinxiView;


/**
 * 供应商信息
 *
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
public interface GongyingshangxinxiService extends IService<GongyingshangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongyingshangxinxiView> selectListView(Wrapper<GongyingshangxinxiEntity> wrapper);
   	
   	GongyingshangxinxiView selectView(@Param("ew") Wrapper<GongyingshangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongyingshangxinxiEntity> wrapper);
   	

}

