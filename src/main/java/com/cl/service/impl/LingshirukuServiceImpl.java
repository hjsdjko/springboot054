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


import com.cl.dao.LingshirukuDao;
import com.cl.entity.LingshirukuEntity;
import com.cl.service.LingshirukuService;
import com.cl.entity.view.LingshirukuView;

@Service("lingshirukuService")
public class LingshirukuServiceImpl extends ServiceImpl<LingshirukuDao, LingshirukuEntity> implements LingshirukuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LingshirukuEntity> page = this.selectPage(
                new Query<LingshirukuEntity>(params).getPage(),
                new EntityWrapper<LingshirukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LingshirukuEntity> wrapper) {
		  Page<LingshirukuView> page =new Query<LingshirukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LingshirukuView> selectListView(Wrapper<LingshirukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LingshirukuView selectView(Wrapper<LingshirukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
