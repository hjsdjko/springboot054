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

import com.cl.entity.LingshirukuEntity;
import com.cl.entity.view.LingshirukuView;

import com.cl.service.LingshirukuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 零食入库
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
@RestController
@RequestMapping("/lingshiruku")
public class LingshirukuController {
    @Autowired
    private LingshirukuService lingshirukuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LingshirukuEntity lingshiruku,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			lingshiruku.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LingshirukuEntity> ew = new EntityWrapper<LingshirukuEntity>();

		PageUtils page = lingshirukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lingshiruku), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LingshirukuEntity lingshiruku, 
		HttpServletRequest request){
        EntityWrapper<LingshirukuEntity> ew = new EntityWrapper<LingshirukuEntity>();

		PageUtils page = lingshirukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lingshiruku), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LingshirukuEntity lingshiruku){
       	EntityWrapper<LingshirukuEntity> ew = new EntityWrapper<LingshirukuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lingshiruku, "lingshiruku")); 
        return R.ok().put("data", lingshirukuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LingshirukuEntity lingshiruku){
        EntityWrapper< LingshirukuEntity> ew = new EntityWrapper< LingshirukuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lingshiruku, "lingshiruku")); 
		LingshirukuView lingshirukuView =  lingshirukuService.selectView(ew);
		return R.ok("查询零食入库成功").put("data", lingshirukuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LingshirukuEntity lingshiruku = lingshirukuService.selectById(id);
		lingshiruku = lingshirukuService.selectView(new EntityWrapper<LingshirukuEntity>().eq("id", id));
        return R.ok().put("data", lingshiruku);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LingshirukuEntity lingshiruku = lingshirukuService.selectById(id);
		lingshiruku = lingshirukuService.selectView(new EntityWrapper<LingshirukuEntity>().eq("id", id));
        return R.ok().put("data", lingshiruku);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LingshirukuEntity lingshiruku, HttpServletRequest request){
    	lingshiruku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lingshiruku);
        lingshirukuService.insert(lingshiruku);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LingshirukuEntity lingshiruku, HttpServletRequest request){
    	lingshiruku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lingshiruku);
        lingshirukuService.insert(lingshiruku);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LingshirukuEntity lingshiruku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lingshiruku);
        lingshirukuService.updateById(lingshiruku);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<LingshirukuEntity> list = new ArrayList<LingshirukuEntity>();
        for(Long id : ids) {
            LingshirukuEntity lingshiruku = lingshirukuService.selectById(id);
            lingshiruku.setSfsh(sfsh);
            lingshiruku.setShhf(shhf);
            list.add(lingshiruku);
        }
        lingshirukuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lingshirukuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
