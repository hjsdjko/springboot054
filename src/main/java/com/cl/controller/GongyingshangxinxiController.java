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

import com.cl.entity.GongyingshangxinxiEntity;
import com.cl.entity.view.GongyingshangxinxiView;

import com.cl.service.GongyingshangxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 供应商信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
@RestController
@RequestMapping("/gongyingshangxinxi")
public class GongyingshangxinxiController {
    @Autowired
    private GongyingshangxinxiService gongyingshangxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongyingshangxinxiEntity gongyingshangxinxi,
		HttpServletRequest request){
        EntityWrapper<GongyingshangxinxiEntity> ew = new EntityWrapper<GongyingshangxinxiEntity>();

		PageUtils page = gongyingshangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongyingshangxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongyingshangxinxiEntity gongyingshangxinxi, 
		HttpServletRequest request){
        EntityWrapper<GongyingshangxinxiEntity> ew = new EntityWrapper<GongyingshangxinxiEntity>();

		PageUtils page = gongyingshangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongyingshangxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongyingshangxinxiEntity gongyingshangxinxi){
       	EntityWrapper<GongyingshangxinxiEntity> ew = new EntityWrapper<GongyingshangxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongyingshangxinxi, "gongyingshangxinxi")); 
        return R.ok().put("data", gongyingshangxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongyingshangxinxiEntity gongyingshangxinxi){
        EntityWrapper< GongyingshangxinxiEntity> ew = new EntityWrapper< GongyingshangxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongyingshangxinxi, "gongyingshangxinxi")); 
		GongyingshangxinxiView gongyingshangxinxiView =  gongyingshangxinxiService.selectView(ew);
		return R.ok("查询供应商信息成功").put("data", gongyingshangxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongyingshangxinxiEntity gongyingshangxinxi = gongyingshangxinxiService.selectById(id);
		gongyingshangxinxi = gongyingshangxinxiService.selectView(new EntityWrapper<GongyingshangxinxiEntity>().eq("id", id));
        return R.ok().put("data", gongyingshangxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongyingshangxinxiEntity gongyingshangxinxi = gongyingshangxinxiService.selectById(id);
		gongyingshangxinxi = gongyingshangxinxiService.selectView(new EntityWrapper<GongyingshangxinxiEntity>().eq("id", id));
        return R.ok().put("data", gongyingshangxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongyingshangxinxiEntity gongyingshangxinxi, HttpServletRequest request){
    	gongyingshangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongyingshangxinxi);
        gongyingshangxinxiService.insert(gongyingshangxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongyingshangxinxiEntity gongyingshangxinxi, HttpServletRequest request){
    	gongyingshangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongyingshangxinxi);
        gongyingshangxinxiService.insert(gongyingshangxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongyingshangxinxiEntity gongyingshangxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongyingshangxinxi);
        gongyingshangxinxiService.updateById(gongyingshangxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongyingshangxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
