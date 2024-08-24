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


import com.cl.dao.LingshidiaopeiDao;
import com.cl.entity.LingshidiaopeiEntity;
import com.cl.service.LingshidiaopeiService;
import com.cl.entity.view.LingshidiaopeiView;

@Service("lingshidiaopeiService")
public class LingshidiaopeiServiceImpl extends ServiceImpl<LingshidiaopeiDao, LingshidiaopeiEntity> implements LingshidiaopeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LingshidiaopeiEntity> page = this.selectPage(
                new Query<LingshidiaopeiEntity>(params).getPage(),
                new EntityWrapper<LingshidiaopeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LingshidiaopeiEntity> wrapper) {
		  Page<LingshidiaopeiView> page =new Query<LingshidiaopeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LingshidiaopeiView> selectListView(Wrapper<LingshidiaopeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LingshidiaopeiView selectView(Wrapper<LingshidiaopeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
