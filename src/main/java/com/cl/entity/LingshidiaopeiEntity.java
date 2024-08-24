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
 * 零食调配
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-12 13:49:30
 */
@TableName("lingshidiaopei")
public class LingshidiaopeiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LingshidiaopeiEntity() {
		
	}
	
	public LingshidiaopeiEntity(T t) {
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
	 * 商品产地
	 */
					
	private String shangpinchandi;
	
	/**
	 * 规格
	 */
					
	private String guige;
	
	/**
	 * 包装
	 */
					
	private String baozhuang;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 调配时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date diaopeishijian;
	
	/**
	 * 调配数量
	 */
					
	private Integer diaopeishuliang;
	
	/**
	 * 调配仓库
	 */
					
	private String diaopeicangku;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	
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
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：调配时间
	 */
	public void setDiaopeishijian(Date diaopeishijian) {
		this.diaopeishijian = diaopeishijian;
	}
	/**
	 * 获取：调配时间
	 */
	public Date getDiaopeishijian() {
		return diaopeishijian;
	}
	/**
	 * 设置：调配数量
	 */
	public void setDiaopeishuliang(Integer diaopeishuliang) {
		this.diaopeishuliang = diaopeishuliang;
	}
	/**
	 * 获取：调配数量
	 */
	public Integer getDiaopeishuliang() {
		return diaopeishuliang;
	}
	/**
	 * 设置：调配仓库
	 */
	public void setDiaopeicangku(String diaopeicangku) {
		this.diaopeicangku = diaopeicangku;
	}
	/**
	 * 获取：调配仓库
	 */
	public String getDiaopeicangku() {
		return diaopeicangku;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}

}
