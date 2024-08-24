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


import com.cl.dao.LingshichukuDao;
import com.cl.entity.LingshichukuEntity;
import com.cl.service.LingshichukuService;
import com.cl.entity.view.LingshichukuView;

@Service("lingshichukuService")
public class LingshichukuServiceImpl extends ServiceImpl<LingshichukuDao, LingshichukuEntity> implements LingshichukuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LingshichukuEntity> page = this.selectPage(
                new Query<LingshichukuEntity>(params).getPage(),
                new EntityWrapper<LingshichukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LingshichukuEntity> wrapper) {
		  Page<LingshichukuView> page =new Query<LingshichukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LingshichukuView> selectListView(Wrapper<LingshichukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LingshichukuView selectView(Wrapper<LingshichukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
