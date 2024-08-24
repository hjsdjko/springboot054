package com.cl.entity.view;

import com.cl.entity.GongyingshangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 供应商信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
@TableName("gongyingshangxinxi")
public class GongyingshangxinxiView  extends GongyingshangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GongyingshangxinxiView(){
	}
 
 	public GongyingshangxinxiView(GongyingshangxinxiEntity gongyingshangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, gongyingshangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
