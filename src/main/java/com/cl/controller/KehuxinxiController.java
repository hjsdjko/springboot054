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

import com.cl.entity.KehuxinxiEntity;
import com.cl.entity.view.KehuxinxiView;

import com.cl.service.KehuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 客户信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
@RestController
@RequestMapping("/kehuxinxi")
public class KehuxinxiController {
    @Autowired
    private KehuxinxiService kehuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KehuxinxiEntity kehuxinxi,
		HttpServletRequest request){
        EntityWrapper<KehuxinxiEntity> ew = new EntityWrapper<KehuxinxiEntity>();

		PageUtils page = kehuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kehuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KehuxinxiEntity kehuxinxi, 
		HttpServletRequest request){
        EntityWrapper<KehuxinxiEntity> ew = new EntityWrapper<KehuxinxiEntity>();

		PageUtils page = kehuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kehuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KehuxinxiEntity kehuxinxi){
       	EntityWrapper<KehuxinxiEntity> ew = new EntityWrapper<KehuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kehuxinxi, "kehuxinxi")); 
        return R.ok().put("data", kehuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KehuxinxiEntity kehuxinxi){
        EntityWrapper< KehuxinxiEntity> ew = new EntityWrapper< KehuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kehuxinxi, "kehuxinxi")); 
		KehuxinxiView kehuxinxiView =  kehuxinxiService.selectView(ew);
		return R.ok("查询客户信息成功").put("data", kehuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KehuxinxiEntity kehuxinxi = kehuxinxiService.selectById(id);
		kehuxinxi = kehuxinxiService.selectView(new EntityWrapper<KehuxinxiEntity>().eq("id", id));
        return R.ok().put("data", kehuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KehuxinxiEntity kehuxinxi = kehuxinxiService.selectById(id);
		kehuxinxi = kehuxinxiService.selectView(new EntityWrapper<KehuxinxiEntity>().eq("id", id));
        return R.ok().put("data", kehuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KehuxinxiEntity kehuxinxi, HttpServletRequest request){
    	kehuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kehuxinxi);
        kehuxinxiService.insert(kehuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KehuxinxiEntity kehuxinxi, HttpServletRequest request){
    	kehuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kehuxinxi);
        kehuxinxiService.insert(kehuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KehuxinxiEntity kehuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kehuxinxi);
        kehuxinxiService.updateById(kehuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kehuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
