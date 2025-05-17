package com.entity.vo;

import com.entity.JiaogongrudangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 教工入党
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-04-13 00:31:03
 */
public class JiaogongrudangVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 组织名称
	 */
	
	private String zuzhimingcheng;
		
	/**
	 * 组织地址
	 */
	
	private String zuzhidizhi;
		
	/**
	 * 材料
	 */
	
	private String cailiao;
		
	/**
	 * 申请时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shenqingshijian;
		
	/**
	 * 教工账号
	 */
	
	private String jiaogongzhanghao;
		
	/**
	 * 教工姓名
	 */
	
	private String jiaogongxingming;
		
	/**
	 * 身份
	 */
	
	private String shenfen;
		
	/**
	 * 申请内容
	 */
	
	private String shenqingneirong;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
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
	 * 设置：材料
	 */
	 
	public void setCailiao(String cailiao) {
		this.cailiao = cailiao;
	}
	
	/**
	 * 获取：材料
	 */
	public String getCailiao() {
		return cailiao;
	}
				
	
	/**
	 * 设置：申请时间
	 */
	 
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
	}
				
	
	/**
	 * 设置：教工账号
	 */
	 
	public void setJiaogongzhanghao(String jiaogongzhanghao) {
		this.jiaogongzhanghao = jiaogongzhanghao;
	}
	
	/**
	 * 获取：教工账号
	 */
	public String getJiaogongzhanghao() {
		return jiaogongzhanghao;
	}
				
	
	/**
	 * 设置：教工姓名
	 */
	 
	public void setJiaogongxingming(String jiaogongxingming) {
		this.jiaogongxingming = jiaogongxingming;
	}
	
	/**
	 * 获取：教工姓名
	 */
	public String getJiaogongxingming() {
		return jiaogongxingming;
	}
				
	
	/**
	 * 设置：身份
	 */
	 
	public void setShenfen(String shenfen) {
		this.shenfen = shenfen;
	}
	
	/**
	 * 获取：身份
	 */
	public String getShenfen() {
		return shenfen;
	}
				
	
	/**
	 * 设置：申请内容
	 */
	 
	public void setShenqingneirong(String shenqingneirong) {
		this.shenqingneirong = shenqingneirong;
	}
	
	/**
	 * 获取：申请内容
	 */
	public String getShenqingneirong() {
		return shenqingneirong;
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
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
