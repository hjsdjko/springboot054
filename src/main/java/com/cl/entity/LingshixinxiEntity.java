package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 零食信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
@TableName("lingshixinxi")
public class LingshixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LingshixinxiEntity() {
		
	}
	
	public LingshixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 零食编号
	 */
					
	private String lingshibianhao;
	
	/**
	 * 零食名称
	 */
					
	private String lingshimingcheng;
	
	/**
	 * 供应商
	 */
					
	private String gongyingshang;
	
	/**
	 * 商品产地
	 */
					
	private String shangpinchandi;
	
	/**
	 * 销售价格
	 */
					
	private Double xiaoshoujiage;
	
	/**
	 * 规格
	 */
					
	private String guige;
	
	/**
	 * 包装
	 */
					
	private String baozhuang;
	
	/**
	 * 库存
	 */
					
	private Integer kucun;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：零食编号
	 */
	public void setLingshibianhao(String lingshibianhao) {
		this.lingshibianhao = lingshibianhao;
	}
	/**
	 * 获取：零食编号
	 */
	public String getLingshibianhao() {
		return lingshibianhao;
	}
	/**
	 * 设置：零食名称
	 */
	public void setLingshimingcheng(String lingshimingcheng) {
		this.lingshimingcheng = lingshimingcheng;
	}
	/**
	 * 获取：零食名称
	 */
	public String getLingshimingcheng() {
		return lingshimingcheng;
	}
	/**
	 * 设置：供应商
	 */
	public void setGongyingshang(String gongyingshang) {
		this.gongyingshang = gongyingshang;
	}
	/**
	 * 获取：供应商
	 */
	public String getGongyingshang() {
		return gongyingshang;
	}
	/**
	 * 设置：商品产地
	 */
	public void setShangpinchandi(String shangpinchandi) {
		this.shangpinchandi = shangpinchandi;
	}
	/**
	 * 获取：商品产地
	 */
	public String getShangpinchandi() {
		return shangpinchandi;
	}
	/**
	 * 设置：销售价格
	 */
	public void setXiaoshoujiage(Double xiaoshoujiage) {
		this.xiaoshoujiage = xiaoshoujiage;
	}
	/**
	 * 获取：销售价格
	 */
	public Double getXiaoshoujiage() {
		return xiaoshoujiage;
	}
	/**
	 * 设置：规格
	 */
	public void setGuige(String guige) {
		this.guige = guige;
	}
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
	/**
	 * 设置：包装
	 */
	public void setBaozhuang(String baozhuang) {
		this.baozhuang = baozhuang;
	}
	/**
	 * 获取：包装
	 */
	public String getBaozhuang() {
		return baozhuang;
	}
	/**
	 * 设置：库存
	 */
	public void setKucun(Integer kucun) {
		this.kucun = kucun;
	}
	/**
	 * 获取：库存
	 */
	public Integer getKucun() {
		return kucun;
	}

}
