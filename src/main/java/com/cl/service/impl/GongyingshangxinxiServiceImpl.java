package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.GongyingshangxinxiDao;
import com.cl.entity.GongyingshangxinxiEntity;
import com.cl.service.GongyingshangxinxiService;
import com.cl.entity.view.GongyingshangxinxiView;

@Service("gongyingshangxinxiService")
public class GongyingshangxinxiServiceImpl extends ServiceImpl<GongyingshangxinxiDao, GongyingshangxinxiEntity> implements GongyingshangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongyingshangxinxiEntity> page = this.selectPage(
                new Query<GongyingshangxinxiEntity>(params).getPage(),
                new EntityWrapper<GongyingshangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongyingshangxinxiEntity> wrapper) {
		  Page<GongyingshangxinxiView> page =new Query<GongyingshangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GongyingshangxinxiView> selectListView(Wrapper<GongyingshangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongyingshangxinxiView selectView(Wrapper<GongyingshangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
