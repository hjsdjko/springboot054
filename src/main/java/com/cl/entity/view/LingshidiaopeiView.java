package com.cl.entity.view;

import com.cl.entity.LingshidiaopeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 零食调配
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
@TableName("lingshidiaopei")
public class LingshidiaopeiView  extends LingshidiaopeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LingshidiaopeiView(){
	}
 
 	public LingshidiaopeiView(LingshidiaopeiEntity lingshidiaopeiEntity){
 	try {
			BeanUtils.copyProperties(this, lingshidiaopeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
