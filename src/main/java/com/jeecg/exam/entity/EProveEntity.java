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
 * @Description: 准考证表
 * @author onlineGenerator
 * @date 2018-11-01 17:00:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "e_prove", schema = "")
@SuppressWarnings("serial")
public class EProveEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**考生名*/
	@Excel(name="考生名",width=15)
	private java.lang.String proveStuName;
	/**身份证号*/
	@Excel(name="身份证号",width=15)
	private java.lang.String proveCardCode;
	/**报考单位*/
	@Excel(name="报考单位",width=15)
	private java.lang.String proveOrg;
	/**报考职业*/
	@Excel(name="报考职业",width=15)
	private java.lang.String proveWork;
	/**准考证号*/
	@Excel(name="准考证号",width=15)
	private java.lang.String proveCode;
	/**考场地址*/
	@Excel(name="考场地址",width=15)
	private java.lang.String provePlace;
	/**座位信息*/
	@Excel(name="座位信息",width=15)
	private java.lang.String proveSeat;
	/**考生id*/
	@Excel(name="考生id",width=15)
	private java.lang.String proveStuId;
	/**考生账户id*/
	@Excel(name="考生账户id",width=15)
	private java.lang.String proveUserId;
	/**考试id*/
	@Excel(name="考试id",width=15)
	private java.lang.String proveExamId;
	/**考试名*/
	@Excel(name="考试名",width=15)
	private java.lang.String proveExamName;
	/**考试时间*/
	@Excel(name="考试时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date proveDate;
	
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
	 *@return: java.lang.String  考生名
	 */

	@Column(name ="PROVE_STU_NAME",nullable=true,length=32)
	public java.lang.String getProveStuName(){
		return this.proveStuName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考生名
	 */
	public void setProveStuName(java.lang.String proveStuName){
		this.proveStuName = proveStuName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */

	@Column(name ="PROVE_CARD_CODE",nullable=true,length=32)
	public java.lang.String getProveCardCode(){
		return this.proveCardCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setProveCardCode(java.lang.String proveCardCode){
		this.proveCardCode = proveCardCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报考单位
	 */

	@Column(name ="PROVE_ORG",nullable=true,length=32)
	public java.lang.String getProveOrg(){
		return this.proveOrg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  报考单位
	 */
	public void setProveOrg(java.lang.String proveOrg){
		this.proveOrg = proveOrg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报考职业
	 */

	@Column(name ="PROVE_WORK",nullable=true,length=32)
	public java.lang.String getProveWork(){
		return this.proveWork;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  报考职业
	 */
	public void setProveWork(java.lang.String proveWork){
		this.proveWork = proveWork;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  准考证号
	 */

	@Column(name ="PROVE_CODE",nullable=true,length=32)
	public java.lang.String getProveCode(){
		return this.proveCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  准考证号
	 */
	public void setProveCode(java.lang.String proveCode){
		this.proveCode = proveCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考场地址
	 */

	@Column(name ="PROVE_PLACE",nullable=true,length=32)
	public java.lang.String getProvePlace(){
		return this.provePlace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考场地址
	 */
	public void setProvePlace(java.lang.String provePlace){
		this.provePlace = provePlace;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  座位信息
	 */

	@Column(name ="PROVE_SEAT",nullable=true,length=32)
	public java.lang.String getProveSeat(){
		return this.proveSeat;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  座位信息
	 */
	public void setProveSeat(java.lang.String proveSeat){
		this.proveSeat = proveSeat;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考生id
	 */

	@Column(name ="PROVE_STU_ID",nullable=true,length=32)
	public java.lang.String getProveStuId(){
		return this.proveStuId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考生id
	 */
	public void setProveStuId(java.lang.String proveStuId){
		this.proveStuId = proveStuId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考生账户id
	 */

	@Column(name ="PROVE_USER_ID",nullable=true,length=32)
	public java.lang.String getProveUserId(){
		return this.proveUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考生账户id
	 */
	public void setProveUserId(java.lang.String proveUserId){
		this.proveUserId = proveUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考试id
	 */

	@Column(name ="PROVE_EXAM_ID",nullable=true,length=32)
	public java.lang.String getProveExamId(){
		return this.proveExamId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考试id
	 */
	public void setProveExamId(java.lang.String proveExamId){
		this.proveExamId = proveExamId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考试名
	 */

	@Column(name ="PROVE_EXAM_NAME",nullable=true,length=32)
	public java.lang.String getProveExamName(){
		return this.proveExamName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考试名
	 */
	public void setProveExamName(java.lang.String proveExamName){
		this.proveExamName = proveExamName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  考试时间
	 */

	@Column(name ="PROVE_DATE",nullable=true,length=32)
	public java.util.Date getProveDate(){
		return this.proveDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  考试时间
	 */
	public void setProveDate(java.util.Date proveDate){
		this.proveDate = proveDate;
	}
}
