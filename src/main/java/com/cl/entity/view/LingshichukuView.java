package com.cl.entity.view;

import com.cl.entity.LingshichukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 零食出库
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
@TableName("lingshichuku")
public class LingshichukuView  extends LingshichukuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LingshichukuView(){
	}
 
 	public LingshichukuView(LingshichukuEntity lingshichukuEntity){
 	try {
			BeanUtils.copyProperties(this, lingshichukuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
