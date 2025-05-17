package com.entity.model;

import com.entity.DangzuzhixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 党组织信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
public class DangzuzhixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 组织名称
	 */
	private String zuzhimingcheng;
		
	/**
	 * 组织图片
	 */
	private String zuzhitupian;
		
	/**
	 * 组织地址
	 */
	private String zuzhidizhi;
		
	/**
	 * 成立时间
	 */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chenglishijian;
		
	/**
	 * 组织介绍
	 */
	private String zuzhijieshao;
				
	
	/**
	 * 设置：组织名称
	 */
	public void setZuzhimingcheng(String zuzhimingcheng) {
		this.zuzhimingcheng = zuzhimingcheng;
	}
	
	/**
	 * 获取：组织名称
	 */
	public String getZuzhimingcheng() {
		return zuzhimingcheng;
	}
				
	
	/**
	 * 设置：组织图片
	 */
	public void setZuzhitupian(String zuzhitupian) {
		this.zuzhitupian = zuzhitupian;
	}
	
	/**
	 * 获取：组织图片
	 */
	public String getZuzhitupian() {
		return zuzhitupian;
	}
				
	
	/**
	 * 设置：组织地址
	 */
	public void setZuzhidizhi(String zuzhidizhi) {
		this.zuzhidizhi = zuzhidizhi;
	}
	
	/**
	 * 获取：组织地址
	 */
	public String getZuzhidizhi() {
		return zuzhidizhi;
	}
				
	
	/**
	 * 设置：成立时间
	 */
	public void setChenglishijian(Date chenglishijian) {
		this.chenglishijian = chenglishijian;
	}
	
	/**
	 * 获取：成立时间
	 */
	public Date getChenglishijian() {
		return chenglishijian;
	}
				
	
	/**
	 * 设置：组织介绍
	 */
	public void setZuzhijieshao(String zuzhijieshao) {
		this.zuzhijieshao = zuzhijieshao;
	}
	
	/**
	 * 获取：组织介绍
	 */
	public String getZuzhijieshao() {
		return zuzhijieshao;
	}
			
}
