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
 * @Description: 考生信息报名审核表
 * @author onlineGenerator
 * @date 2018-10-30 14:31:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "e_student", schema = "")
@SuppressWarnings("serial")
public class EStudentEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户id*/
	private java.lang.String userId;
	/**报名单位*/
	@Excel(name="报名单位",width=15,dictTable ="t_s_depart",dicCode ="id",dicText ="departname")
	private java.lang.String sOrg;
	/**报名职业*/
	@Excel(name="报名职业",width=15,dictTable ="e_work",dicCode ="id",dicText ="w_name")
	private java.lang.String sWork;
	/**学员姓名*/
	@Excel(name="学员姓名",width=15)
	private java.lang.String sStudient;
	/**学员性别*/
	@Excel(name="学员性别",width=15,dicCode="e_sex")
	private java.lang.String sSex;
	/**出生年月*/
	@Excel(name="出生年月",width=15)
	private java.lang.String sBirthday;
	/**民族*/
	@Excel(name="民族",width=15)
	private java.lang.String sNation;
	/**籍贯*/
	@Excel(name="籍贯",width=15)
	private java.lang.String sJiguan;
	/**户口*/
	@Excel(name="户口",width=15,dicCode="e_politics")
	private java.lang.String sHukou;
	/**政治面貌*/
	@Excel(name="政治面貌",width=15)
	private java.lang.String sPolitics;
	/**学历*/
	@Excel(name="学历",width=15,dicCode="e_edu")
	private java.lang.String sEducation;
	/**学位*/
	@Excel(name="学位",width=15,dicCode="e_degree")
	private java.lang.String sDegree;
	/**毕业学校*/
	@Excel(name="毕业学校",width=15)
	private java.lang.String sSchool;
	/**专业*/
	@Excel(name="专业",width=15)
	private java.lang.String sMajor;
	/**毕业年月*/
	@Excel(name="毕业年月",width=15)
	private java.lang.String sGDate;
	/**婚姻状况*/
	@Excel(name="婚姻状况",width=15,dicCode="e_marry")
	private java.lang.String sMarry;
	/**本人身份*/
	@Excel(name="本人身份",width=15,dicCode="e_identity")
	private java.lang.String sIndntity;
	/**现工作单位*/
	@Excel(name="现工作单位",width=15)
	private java.lang.String sOrgNow;
	/**现职务*/
	@Excel(name="现职务",width=15)
	private java.lang.String sJobNow;
	/**参加工作时间*/
	@Excel(name="参加工作时间",width=15)
	private java.lang.String sWorkDate;
	/**身份证号*/
	@Excel(name="身份证号",width=15)
	private java.lang.String sCode;
	/**通讯地址*/
	@Excel(name="通讯地址",width=15)
	private java.lang.String sAdress;
	/**联系电话*/
	@Excel(name="联系电话",width=15)
	private java.lang.String sTel;
	/**笔试成绩*/
	private java.lang.String sWrittenScore;
	/**面试成绩*/
	private java.lang.String sInterviewScore;
	/**总成绩*/
	private java.lang.String sTotalScore;
	/**排名*/
	private java.lang.String sRank;
	/**备注*/
	private java.lang.String sRemarks;
	/**审核状态*/
	private java.lang.String sStatus;
	/**审核人*/
	private java.lang.String sAuditor;
	/**报名时间*/
	private java.util.Date sCreateDate;
	/**审核不通过原因*/
	@Excel(name="审核不通过原因",width=15)
	private java.lang.String sReason;
	
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
	 *@return: java.lang.String  用户id
	 */

	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报名单位
	 */

	@Column(name ="S_ORG",nullable=true,length=50)
	public java.lang.String getSOrg(){
		return this.sOrg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  报名单位
	 */
	public void setSOrg(java.lang.String sOrg){
		this.sOrg = sOrg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  报名职业
	 */

	@Column(name ="S_WORK",nullable=true,length=50)
	public java.lang.String getSWork(){
		return this.sWork;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  报名职业
	 */
	public void setSWork(java.lang.String sWork){
		this.sWork = sWork;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学员姓名
	 */

	@Column(name ="S_STUDIENT",nullable=true,length=50)
	public java.lang.String getSStudient(){
		return this.sStudient;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学员姓名
	 */
	public void setSStudient(java.lang.String sStudient){
		this.sStudient = sStudient;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学员性别
	 */

	@Column(name ="S_SEX",nullable=true,length=50)
	public java.lang.String getSSex(){
		return this.sSex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学员性别
	 */
	public void setSSex(java.lang.String sSex){
		this.sSex = sSex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出生年月
	 */

	@Column(name ="S_BIRTHDAY",nullable=true,length=50)
	public java.lang.String getSBirthday(){
		return this.sBirthday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出生年月
	 */
	public void setSBirthday(java.lang.String sBirthday){
		this.sBirthday = sBirthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */

	@Column(name ="S_NATION",nullable=true,length=50)
	public java.lang.String getSNation(){
		return this.sNation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setSNation(java.lang.String sNation){
		this.sNation = sNation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  籍贯
	 */

	@Column(name ="S_JIGUAN",nullable=true,length=100)
	public java.lang.String getSJiguan(){
		return this.sJiguan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  籍贯
	 */
	public void setSJiguan(java.lang.String sJiguan){
		this.sJiguan = sJiguan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户口
	 */

	@Column(name ="S_HUKOU",nullable=true,length=100)
	public java.lang.String getSHukou(){
		return this.sHukou;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户口
	 */
	public void setSHukou(java.lang.String sHukou){
		this.sHukou = sHukou;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  政治面貌
	 */

	@Column(name ="S_POLITICS",nullable=true,length=32)
	public java.lang.String getSPolitics(){
		return this.sPolitics;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政治面貌
	 */
	public void setSPolitics(java.lang.String sPolitics){
		this.sPolitics = sPolitics;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */

	@Column(name ="S_EDUCATION",nullable=true,length=32)
	public java.lang.String getSEducation(){
		return this.sEducation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setSEducation(java.lang.String sEducation){
		this.sEducation = sEducation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学位
	 */

	@Column(name ="S_DEGREE",nullable=true,length=32)
	public java.lang.String getSDegree(){
		return this.sDegree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学位
	 */
	public void setSDegree(java.lang.String sDegree){
		this.sDegree = sDegree;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业学校
	 */

	@Column(name ="S_SCHOOL",nullable=true,length=32)
	public java.lang.String getSSchool(){
		return this.sSchool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业学校
	 */
	public void setSSchool(java.lang.String sSchool){
		this.sSchool = sSchool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业
	 */

	@Column(name ="S_MAJOR",nullable=true,length=32)
	public java.lang.String getSMajor(){
		return this.sMajor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业
	 */
	public void setSMajor(java.lang.String sMajor){
		this.sMajor = sMajor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业年月
	 */

	@Column(name ="S_G_DATE",nullable=true,length=32)
	public java.lang.String getSGDate(){
		return this.sGDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业年月
	 */
	public void setSGDate(java.lang.String sGDate){
		this.sGDate = sGDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  婚姻状况
	 */

	@Column(name ="S_MARRY",nullable=true,length=32)
	public java.lang.String getSMarry(){
		return this.sMarry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  婚姻状况
	 */
	public void setSMarry(java.lang.String sMarry){
		this.sMarry = sMarry;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本人身份
	 */

	@Column(name ="S_INDNTITY",nullable=true,length=32)
	public java.lang.String getSIndntity(){
		return this.sIndntity;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本人身份
	 */
	public void setSIndntity(java.lang.String sIndntity){
		this.sIndntity = sIndntity;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现工作单位
	 */

	@Column(name ="S_ORG_NOW",nullable=true,length=32)
	public java.lang.String getSOrgNow(){
		return this.sOrgNow;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现工作单位
	 */
	public void setSOrgNow(java.lang.String sOrgNow){
		this.sOrgNow = sOrgNow;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现职务
	 */

	@Column(name ="S_JOB_NOW",nullable=true,length=32)
	public java.lang.String getSJobNow(){
		return this.sJobNow;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现职务
	 */
	public void setSJobNow(java.lang.String sJobNow){
		this.sJobNow = sJobNow;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参加工作时间
	 */

	@Column(name ="S_WORK_DATE",nullable=true,length=32)
	public java.lang.String getSWorkDate(){
		return this.sWorkDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参加工作时间
	 */
	public void setSWorkDate(java.lang.String sWorkDate){
		this.sWorkDate = sWorkDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */

	@Column(name ="S_CODE",nullable=true,length=32)
	public java.lang.String getSCode(){
		return this.sCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setSCode(java.lang.String sCode){
		this.sCode = sCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通讯地址
	 */

	@Column(name ="S_ADRESS",nullable=true,length=32)
	public java.lang.String getSAdress(){
		return this.sAdress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通讯地址
	 */
	public void setSAdress(java.lang.String sAdress){
		this.sAdress = sAdress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */

	@Column(name ="S_TEL",nullable=true,length=32)
	public java.lang.String getSTel(){
		return this.sTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setSTel(java.lang.String sTel){
		this.sTel = sTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  笔试成绩
	 */

	@Column(name ="S_WRITTEN_SCORE",nullable=true,length=32)
	public java.lang.String getSWrittenScore(){
		return this.sWrittenScore;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  笔试成绩
	 */
	public void setSWrittenScore(java.lang.String sWrittenScore){
		this.sWrittenScore = sWrittenScore;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  面试成绩
	 */

	@Column(name ="S_INTERVIEW_SCORE",nullable=true,length=32)
	public java.lang.String getSInterviewScore(){
		return this.sInterviewScore;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  面试成绩
	 */
	public void setSInterviewScore(java.lang.String sInterviewScore){
		this.sInterviewScore = sInterviewScore;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  总成绩
	 */

	@Column(name ="S_TOTAL_SCORE",nullable=true,length=32)
	public java.lang.String getSTotalScore(){
		return this.sTotalScore;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  总成绩
	 */
	public void setSTotalScore(java.lang.String sTotalScore){
		this.sTotalScore = sTotalScore;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  排名
	 */

	@Column(name ="S_RANK",nullable=true,length=32)
	public java.lang.String getSRank(){
		return this.sRank;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  排名
	 */
	public void setSRank(java.lang.String sRank){
		this.sRank = sRank;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="S_REMARKS",nullable=true,length=32)
	public java.lang.String getSRemarks(){
		return this.sRemarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setSRemarks(java.lang.String sRemarks){
		this.sRemarks = sRemarks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核状态
	 */

	@Column(name ="S_STATUS",nullable=true,length=32)
	public java.lang.String getSStatus(){
		return this.sStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核状态
	 */
	public void setSStatus(java.lang.String sStatus){
		this.sStatus = sStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */

	@Column(name ="S_AUDITOR",nullable=true,length=32)
	public java.lang.String getSAuditor(){
		return this.sAuditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setSAuditor(java.lang.String sAuditor){
		this.sAuditor = sAuditor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  报名时间
	 */

	@Column(name ="S_CREATE_DATE",nullable=true,length=32)
	public java.util.Date getSCreateDate(){
		return this.sCreateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  报名时间
	 */
	public void setSCreateDate(java.util.Date sCreateDate){
		this.sCreateDate = sCreateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核不通过原因
	 */

	@Column(name ="S_REASON",nullable=true,length=500)
	public java.lang.String getSReason(){
		return this.sReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核不通过原因
	 */
	public void setSReason(java.lang.String sReason){
		this.sReason = sReason;
	}
}
