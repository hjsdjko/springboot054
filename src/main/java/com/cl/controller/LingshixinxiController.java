package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.LingshixinxiEntity;
import com.cl.entity.view.LingshixinxiView;

import com.cl.service.LingshixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 零食信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
@RestController
@RequestMapping("/lingshixinxi")
public class LingshixinxiController {
    @Autowired
    private LingshixinxiService lingshixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LingshixinxiEntity lingshixinxi,
		HttpServletRequest request){
        EntityWrapper<LingshixinxiEntity> ew = new EntityWrapper<LingshixinxiEntity>();

		PageUtils page = lingshixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lingshixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LingshixinxiEntity lingshixinxi, 
		HttpServletRequest request){
        EntityWrapper<LingshixinxiEntity> ew = new EntityWrapper<LingshixinxiEntity>();

		PageUtils page = lingshixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lingshixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LingshixinxiEntity lingshixinxi){
       	EntityWrapper<LingshixinxiEntity> ew = new EntityWrapper<LingshixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lingshixinxi, "lingshixinxi")); 
        return R.ok().put("data", lingshixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LingshixinxiEntity lingshixinxi){
        EntityWrapper< LingshixinxiEntity> ew = new EntityWrapper< LingshixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lingshixinxi, "lingshixinxi")); 
		LingshixinxiView lingshixinxiView =  lingshixinxiService.selectView(ew);
		return R.ok("查询零食信息成功").put("data", lingshixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LingshixinxiEntity lingshixinxi = lingshixinxiService.selectById(id);
		lingshixinxi = lingshixinxiService.selectView(new EntityWrapper<LingshixinxiEntity>().eq("id", id));
        return R.ok().put("data", lingshixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LingshixinxiEntity lingshixinxi = lingshixinxiService.selectById(id);
		lingshixinxi = lingshixinxiService.selectView(new EntityWrapper<LingshixinxiEntity>().eq("id", id));
        return R.ok().put("data", lingshixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LingshixinxiEntity lingshixinxi, HttpServletRequest request){
    	lingshixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lingshixinxi);
        lingshixinxiService.insert(lingshixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LingshixinxiEntity lingshixinxi, HttpServletRequest request){
    	lingshixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lingshixinxi);
        lingshixinxiService.insert(lingshixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LingshixinxiEntity lingshixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lingshixinxi);
        lingshixinxiService.updateById(lingshixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lingshixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
