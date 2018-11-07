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
 * @Description: 注册用户信息表
 * @author onlineGenerator
 * @date 2018-11-07 21:48:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "e_user", schema = "")
@SuppressWarnings("serial")
public class EUserEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户id*/
	private java.lang.String userId;
	/**真实姓名*/
	private java.lang.String realName;
	/**学员性别*/
	private java.lang.String userSex;
	/**出生日期*/
	private java.util.Date userBirthday;
	/**民族*/
	private java.lang.String userNation;
	/**籍贯*/
	private java.lang.String userJiguan;
	/**户口*/
	private java.lang.String userHukou;
	/**政治面貌*/
	private java.lang.String userPolitics;
	/**学历*/
	@Excel(name="学历",width=15,dicCode="e_edu")
	private java.lang.String userEducation;
	/**学位*/
	@Excel(name="学位",width=15,dicCode="e_degree")
	private java.lang.String userDegree;
	/**毕业学校*/
	@Excel(name="毕业学校",width=15)
	private java.lang.String userSchool;
	/**专业*/
	@Excel(name="专业",width=15)
	private java.lang.String userMajor;
	/**毕业年月*/
	@Excel(name="毕业年月",width=15)
	private java.lang.String userGDate;
	/**婚姻状况*/
	@Excel(name="婚姻状况",width=15,dicCode="e_marry")
	private java.lang.String userMarry;
	/**本人身份*/
	@Excel(name="本人身份",width=15,dicCode="e_identity")
	private java.lang.String userIndntity;
	/**参加工作时间*/
	@Excel(name="参加工作时间",width=15)
	private java.lang.String userWorkDate;
	/**身份证号码*/
	@Excel(name="身份证号码",width=15)
	private java.lang.String userCode;
	/**联系地址*/
	@Excel(name="联系地址",width=15)
	private java.lang.String userAdress;
	/**电话*/
	@Excel(name="电话",width=15)
	private java.lang.String userTel;
	/**邮箱*/
	@Excel(name="邮箱",width=15)
	private java.lang.String userEmail;
	
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

	@Column(name ="USER_ID",nullable=true,length=50)
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
	 *@return: java.lang.String  真实姓名
	 */

	@Column(name ="REAL_NAME",nullable=true,length=50)
	public java.lang.String getRealName(){
		return this.realName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  真实姓名
	 */
	public void setRealName(java.lang.String realName){
		this.realName = realName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学员性别
	 */

	@Column(name ="USER_SEX",nullable=true,length=50)
	public java.lang.String getUserSex(){
		return this.userSex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学员性别
	 */
	public void setUserSex(java.lang.String userSex){
		this.userSex = userSex;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生日期
	 */

	@Column(name ="USER_BIRTHDAY",nullable=true,length=20)
	public java.util.Date getUserBirthday(){
		return this.userBirthday;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生日期
	 */
	public void setUserBirthday(java.util.Date userBirthday){
		this.userBirthday = userBirthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */

	@Column(name ="USER_NATION",nullable=true,length=50)
	public java.lang.String getUserNation(){
		return this.userNation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setUserNation(java.lang.String userNation){
		this.userNation = userNation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  籍贯
	 */

	@Column(name ="USER_JIGUAN",nullable=true,length=100)
	public java.lang.String getUserJiguan(){
		return this.userJiguan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  籍贯
	 */
	public void setUserJiguan(java.lang.String userJiguan){
		this.userJiguan = userJiguan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户口
	 */

	@Column(name ="USER_HUKOU",nullable=true,length=100)
	public java.lang.String getUserHukou(){
		return this.userHukou;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户口
	 */
	public void setUserHukou(java.lang.String userHukou){
		this.userHukou = userHukou;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  政治面貌
	 */

	@Column(name ="USER_POLITICS",nullable=true,length=50)
	public java.lang.String getUserPolitics(){
		return this.userPolitics;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政治面貌
	 */
	public void setUserPolitics(java.lang.String userPolitics){
		this.userPolitics = userPolitics;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */

	@Column(name ="USER_EDUCATION",nullable=true,length=32)
	public java.lang.String getUserEducation(){
		return this.userEducation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setUserEducation(java.lang.String userEducation){
		this.userEducation = userEducation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学位
	 */

	@Column(name ="USER_DEGREE",nullable=true,length=32)
	public java.lang.String getUserDegree(){
		return this.userDegree;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学位
	 */
	public void setUserDegree(java.lang.String userDegree){
		this.userDegree = userDegree;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业学校
	 */

	@Column(name ="USER_SCHOOL",nullable=true,length=32)
	public java.lang.String getUserSchool(){
		return this.userSchool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业学校
	 */
	public void setUserSchool(java.lang.String userSchool){
		this.userSchool = userSchool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业
	 */

	@Column(name ="USER_MAJOR",nullable=true,length=32)
	public java.lang.String getUserMajor(){
		return this.userMajor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业
	 */
	public void setUserMajor(java.lang.String userMajor){
		this.userMajor = userMajor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业年月
	 */

	@Column(name ="USER_G_DATE",nullable=true,length=32)
	public java.lang.String getUserGDate(){
		return this.userGDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业年月
	 */
	public void setUserGDate(java.lang.String userGDate){
		this.userGDate = userGDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  婚姻状况
	 */

	@Column(name ="USER_MARRY",nullable=true,length=32)
	public java.lang.String getUserMarry(){
		return this.userMarry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  婚姻状况
	 */
	public void setUserMarry(java.lang.String userMarry){
		this.userMarry = userMarry;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本人身份
	 */

	@Column(name ="USER_INDNTITY",nullable=true,length=32)
	public java.lang.String getUserIndntity(){
		return this.userIndntity;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本人身份
	 */
	public void setUserIndntity(java.lang.String userIndntity){
		this.userIndntity = userIndntity;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参加工作时间
	 */

	@Column(name ="USER_WORK_DATE",nullable=true,length=32)
	public java.lang.String getUserWorkDate(){
		return this.userWorkDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参加工作时间
	 */
	public void setUserWorkDate(java.lang.String userWorkDate){
		this.userWorkDate = userWorkDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号码
	 */

	@Column(name ="USER_CODE",nullable=true,length=32)
	public java.lang.String getUserCode(){
		return this.userCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号码
	 */
	public void setUserCode(java.lang.String userCode){
		this.userCode = userCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系地址
	 */

	@Column(name ="USER_ADRESS",nullable=true,length=32)
	public java.lang.String getUserAdress(){
		return this.userAdress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系地址
	 */
	public void setUserAdress(java.lang.String userAdress){
		this.userAdress = userAdress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话
	 */

	@Column(name ="USER_TEL",nullable=true,length=32)
	public java.lang.String getUserTel(){
		return this.userTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setUserTel(java.lang.String userTel){
		this.userTel = userTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮箱
	 */

	@Column(name ="USER_EMAIL",nullable=true,length=32)
	public java.lang.String getUserEmail(){
		return this.userEmail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮箱
	 */
	public void setUserEmail(java.lang.String userEmail){
		this.userEmail = userEmail;
	}
}
