package com.jeecg.exam.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 职位表
 * @author onlineGenerator
 * @date 2018-10-29 15:03:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "e_work", schema = "")
@SuppressWarnings("serial")
public class EWorkEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**职位所属单位*/
	@Excel(name="职位所属单位",width=15,dictTable ="t_s_depart",dicCode ="id",dicText ="departname")
	private java.lang.String wOrg;
	/**职位名称*/
	@Excel(name="职位名称",width=15)
	private java.lang.String wName;
	/**计划招收人数*/
	@Excel(name="计划招收人数",width=15)
	private java.lang.String wCount;
	/**实际招收人数*/
	private java.lang.String wRCount;
	/**解释*/
	private java.lang.String wReason;
	/**职位状态*/
	private java.lang.String wStatus;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位所属单位
	 */

	@Column(name ="W_ORG",nullable=true,length=32)
	public java.lang.String getWOrg(){
		return this.wOrg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位所属单位
	 */
	public void setWOrg(java.lang.String wOrg){
		this.wOrg = wOrg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位名称
	 */

	@Column(name ="W_NAME",nullable=true,length=50)
	public java.lang.String getWName(){
		return this.wName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位名称
	 */
	public void setWName(java.lang.String wName){
		this.wName = wName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计划招收人数
	 */

	@Column(name ="W_COUNT",nullable=true,length=50)
	public java.lang.String getWCount(){
		return this.wCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计划招收人数
	 */
	public void setWCount(java.lang.String wCount){
		this.wCount = wCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  实际招收人数
	 */

	@Column(name ="W_R_COUNT",nullable=true,length=50)
	public java.lang.String getWRCount(){
		return this.wRCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  实际招收人数
	 */
	public void setWRCount(java.lang.String wRCount){
		this.wRCount = wRCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  解释
	 */

	@Column(name ="W_REASON",nullable=true,length=50)
	public java.lang.String getWReason(){
		return this.wReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  解释
	 */
	public void setWReason(java.lang.String wReason){
		this.wReason = wReason;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位状态
	 */

	@Column(name ="W_STATUS",nullable=true,length=50)
	public java.lang.String getWStatus(){
		return this.wStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位状态
	 */
	public void setWStatus(java.lang.String wStatus){
		this.wStatus = wStatus;
	}
}
