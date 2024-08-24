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


import com.cl.dao.LingshixinxiDao;
import com.cl.entity.LingshixinxiEntity;
import com.cl.service.LingshixinxiService;
import com.cl.entity.view.LingshixinxiView;

@Service("lingshixinxiService")
public class LingshixinxiServiceImpl extends ServiceImpl<LingshixinxiDao, LingshixinxiEntity> implements LingshixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LingshixinxiEntity> page = this.selectPage(
                new Query<LingshixinxiEntity>(params).getPage(),
                new EntityWrapper<LingshixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LingshixinxiEntity> wrapper) {
		  Page<LingshixinxiView> page =new Query<LingshixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LingshixinxiView> selectListView(Wrapper<LingshixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LingshixinxiView selectView(Wrapper<LingshixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
