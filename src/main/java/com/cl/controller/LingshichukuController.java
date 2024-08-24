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

import com.cl.entity.LingshichukuEntity;
import com.cl.entity.view.LingshichukuView;

import com.cl.service.LingshichukuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 零食出库
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
@RestController
@RequestMapping("/lingshichuku")
public class LingshichukuController {
    @Autowired
    private LingshichukuService lingshichukuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LingshichukuEntity lingshichuku,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			lingshichuku.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LingshichukuEntity> ew = new EntityWrapper<LingshichukuEntity>();

		PageUtils page = lingshichukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lingshichuku), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LingshichukuEntity lingshichuku, 
		HttpServletRequest request){
        EntityWrapper<LingshichukuEntity> ew = new EntityWrapper<LingshichukuEntity>();

		PageUtils page = lingshichukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lingshichuku), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LingshichukuEntity lingshichuku){
       	EntityWrapper<LingshichukuEntity> ew = new EntityWrapper<LingshichukuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lingshichuku, "lingshichuku")); 
        return R.ok().put("data", lingshichukuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LingshichukuEntity lingshichuku){
        EntityWrapper< LingshichukuEntity> ew = new EntityWrapper< LingshichukuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lingshichuku, "lingshichuku")); 
		LingshichukuView lingshichukuView =  lingshichukuService.selectView(ew);
		return R.ok("查询零食出库成功").put("data", lingshichukuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LingshichukuEntity lingshichuku = lingshichukuService.selectById(id);
		lingshichuku = lingshichukuService.selectView(new EntityWrapper<LingshichukuEntity>().eq("id", id));
        return R.ok().put("data", lingshichuku);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LingshichukuEntity lingshichuku = lingshichukuService.selectById(id);
		lingshichuku = lingshichukuService.selectView(new EntityWrapper<LingshichukuEntity>().eq("id", id));
        return R.ok().put("data", lingshichuku);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LingshichukuEntity lingshichuku, HttpServletRequest request){
    	lingshichuku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lingshichuku);
        lingshichukuService.insert(lingshichuku);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LingshichukuEntity lingshichuku, HttpServletRequest request){
    	lingshichuku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lingshichuku);
        lingshichukuService.insert(lingshichuku);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LingshichukuEntity lingshichuku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lingshichuku);
        lingshichukuService.updateById(lingshichuku);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<LingshichukuEntity> list = new ArrayList<LingshichukuEntity>();
        for(Long id : ids) {
            LingshichukuEntity lingshichuku = lingshichukuService.selectById(id);
            lingshichuku.setSfsh(sfsh);
            lingshichuku.setShhf(shhf);
            list.add(lingshichuku);
        }
        lingshichukuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lingshichukuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
