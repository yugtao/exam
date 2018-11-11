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
 * @date 2018-11-11 14:50:00
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
	/**岗位名称*/
	@Excel(name="岗位名称",width=15)
	private java.lang.String wName;
	/**岗位类别*/
	@Excel(name="岗位类别",width=15,dicCode="e_wtype")
	private java.lang.String wType;
	/**招聘人数*/
	@Excel(name="招聘人数",width=15)
	private java.lang.String wCount;
	/**报名人数*/
	@Excel(name="报名人数",width=15)
	private java.lang.String wBCount;
	/**学历要求*/
	@Excel(name="学历要求",width=15,dicCode="e_edu")
	private java.lang.String wAskEducation;
	/**学位要求*/
	@Excel(name="学位要求",width=15,dicCode="e_degree")
	private java.lang.String wAskDegree;
	/**专业*/
	@Excel(name="专业",width=15)
	private java.lang.String wAskMajor;
	/**年龄*/
	@Excel(name="年龄",width=15)
	private java.lang.String wAskAge;
	/**职称*/
	@Excel(name="职称",width=15)
	private java.lang.String wAskTitle;
	/**其他要求*/
	@Excel(name="其他要求",width=15)
	private java.lang.String wAskOther;
	/**资格审查通过人数*/
	@Excel(name="资格审查通过人数",width=15)
	private java.lang.String wPassCount;
	/**未通过人数*/
	@Excel(name="未通过人数",width=15)
	private java.lang.String wPassNot;
	/**职位状态*/
	@Excel(name="职位状态",width=15,dicCode="ew_status")
	private java.lang.String wStatus;
	/**笔试人数*/
	@Excel(name="笔试人数",width=15)
	private java.lang.String wWriCount;
	/**笔试开考比例*/
	@Excel(name="笔试开考比例",width=15)
	private java.lang.String wWriPro;
	/**面试人数*/
	@Excel(name="面试人数",width=15)
	private java.lang.String wIntCount;
	/**面试开考比例*/
	@Excel(name="面试开考比例",width=15)
	private java.lang.String wIntPro;
	/**实际招收人数*/
	@Excel(name="实际招收人数",width=15)
	private java.lang.String wRCount;
	/**解释*/
	@Excel(name="解释",width=15)
	private java.lang.String wReason;
	/**职业所属考试*/
	@Excel(name="职业所属考试",width=15,dictTable ="e_exam",dicCode ="id",dicText ="e_name")
	private java.lang.String wExam;
	
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
	 *@return: java.lang.String  岗位名称
	 */

	@Column(name ="W_NAME",nullable=true,length=50)
	public java.lang.String getWName(){
		return this.wName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位名称
	 */
	public void setWName(java.lang.String wName){
		this.wName = wName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  岗位类别
	 */

	@Column(name ="W_TYPE",nullable=true,length=32)
	public java.lang.String getWType(){
		return this.wType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位类别
	 */
	public void setWType(java.lang.String wType){
		this.wType = wType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘人数
	 */

	@Column(name ="W_COUNT",nullable=true,length=50)
	public java.lang.String getWCount(){
		return this.wCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘人数
	 */
	public void setWCount(java.lang.String wCount){
		this.wCount = wCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报名人数
	 */

	@Column(name ="W_B_COUNT",nullable=true,length=32)
	public java.lang.String getWBCount(){
		return this.wBCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  报名人数
	 */
	public void setWBCount(java.lang.String wBCount){
		this.wBCount = wBCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历要求
	 */

	@Column(name ="W_ASK_EDUCATION",nullable=true,length=32)
	public java.lang.String getWAskEducation(){
		return this.wAskEducation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历要求
	 */
	public void setWAskEducation(java.lang.String wAskEducation){
		this.wAskEducation = wAskEducation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学位要求
	 */

	@Column(name ="W_ASK_DEGREE",nullable=true,length=32)
	public java.lang.String getWAskDegree(){
		return this.wAskDegree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学位要求
	 */
	public void setWAskDegree(java.lang.String wAskDegree){
		this.wAskDegree = wAskDegree;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业
	 */

	@Column(name ="W_ASK_MAJOR",nullable=true,length=32)
	public java.lang.String getWAskMajor(){
		return this.wAskMajor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业
	 */
	public void setWAskMajor(java.lang.String wAskMajor){
		this.wAskMajor = wAskMajor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年龄
	 */

	@Column(name ="W_ASK_AGE",nullable=true,length=32)
	public java.lang.String getWAskAge(){
		return this.wAskAge;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年龄
	 */
	public void setWAskAge(java.lang.String wAskAge){
		this.wAskAge = wAskAge;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职称
	 */

	@Column(name ="W_ASK_TITLE",nullable=true,length=32)
	public java.lang.String getWAskTitle(){
		return this.wAskTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职称
	 */
	public void setWAskTitle(java.lang.String wAskTitle){
		this.wAskTitle = wAskTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他要求
	 */

	@Column(name ="W_ASK_OTHER",nullable=true,length=32)
	public java.lang.String getWAskOther(){
		return this.wAskOther;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他要求
	 */
	public void setWAskOther(java.lang.String wAskOther){
		this.wAskOther = wAskOther;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  资格审查通过人数
	 */

	@Column(name ="W_PASS_COUNT",nullable=true,length=32)
	public java.lang.String getWPassCount(){
		return this.wPassCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  资格审查通过人数
	 */
	public void setWPassCount(java.lang.String wPassCount){
		this.wPassCount = wPassCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  未通过人数
	 */

	@Column(name ="W_PASS_NOT",nullable=true,length=32)
	public java.lang.String getWPassNot(){
		return this.wPassNot;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  未通过人数
	 */
	public void setWPassNot(java.lang.String wPassNot){
		this.wPassNot = wPassNot;
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  笔试人数
	 */

	@Column(name ="W_WRI_COUNT",nullable=true,length=32)
	public java.lang.String getWWriCount(){
		return this.wWriCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  笔试人数
	 */
	public void setWWriCount(java.lang.String wWriCount){
		this.wWriCount = wWriCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  笔试开考比例
	 */

	@Column(name ="W_WRI_PRO",nullable=true,length=32)
	public java.lang.String getWWriPro(){
		return this.wWriPro;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  笔试开考比例
	 */
	public void setWWriPro(java.lang.String wWriPro){
		this.wWriPro = wWriPro;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  面试人数
	 */

	@Column(name ="W_INT_COUNT",nullable=true,length=32)
	public java.lang.String getWIntCount(){
		return this.wIntCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  面试人数
	 */
	public void setWIntCount(java.lang.String wIntCount){
		this.wIntCount = wIntCount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  面试开考比例
	 */

	@Column(name ="W_INT_PRO",nullable=true,length=32)
	public java.lang.String getWIntPro(){
		return this.wIntPro;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  面试开考比例
	 */
	public void setWIntPro(java.lang.String wIntPro){
		this.wIntPro = wIntPro;
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

	@Column(name ="W_REASON",nullable=true,length=255)
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
	 *@return: java.lang.String  职业所属考试
	 */

	@Column(name ="W_EXAM",nullable=true,length=32)
	public java.lang.String getWExam(){
		return this.wExam;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职业所属考试
	 */
	public void setWExam(java.lang.String wExam){
		this.wExam = wExam;
	}
}
