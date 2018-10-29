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
 * @Description: 考试表
 * @author onlineGenerator
 * @date 2018-10-29 15:34:56
 * @version V1.0   
 *
 */
@Entity
@Table(name = "e_exam", schema = "")
@SuppressWarnings("serial")
public class EExamEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**创建人id*/
	private java.lang.String eCreateId;
	/**考试名称*/
	@Excel(name="考试名称",width=15)
	private java.lang.String eName;
	/**考试状态*/
	@Excel(name="考试状态",width=15,dicCode="ea_status")
	private java.lang.String eStatus;
	/**考试信息*/
	@Excel(name="考试信息",width=15)
	private java.lang.String eInfo;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**考试时间*/
	@Excel(name="考试时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date eDate;
	/**考试人数*/
	@Excel(name="考试人数",width=15)
	private java.lang.String eCount;
	
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
	 *@return: java.lang.String  流程状态
	 */
	
	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人id
	 */
	
	@Column(name ="E_CREATE_ID",nullable=true,length=50)
	public java.lang.String getECreateId(){
		return this.eCreateId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人id
	 */
	public void setECreateId(java.lang.String eCreateId){
		this.eCreateId = eCreateId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考试名称
	 */
	
	@Column(name ="E_NAME",nullable=true,length=50)
	public java.lang.String getEName(){
		return this.eName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考试名称
	 */
	public void setEName(java.lang.String eName){
		this.eName = eName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考试状态
	 */
	
	@Column(name ="E_STATUS",nullable=true,length=50)
	public java.lang.String getEStatus(){
		return this.eStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考试状态
	 */
	public void setEStatus(java.lang.String eStatus){
		this.eStatus = eStatus;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考试信息
	 */
	
	@Column(name ="E_INFO",nullable=true,length=50)
	public java.lang.String getEInfo(){
		return this.eInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考试信息
	 */
	public void setEInfo(java.lang.String eInfo){
		this.eInfo = eInfo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */
	
	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */
	
	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  考试时间
	 */
	
	@Column(name ="E_DATE",nullable=true,length=20)
	public java.util.Date getEDate(){
		return this.eDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  考试时间
	 */
	public void setEDate(java.util.Date eDate){
		this.eDate = eDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考试人数
	 */
	
	@Column(name ="E_COUNT",nullable=true,length=20)
	public java.lang.String getECount(){
		return this.eCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考试人数
	 */
	public void setECount(java.lang.String eCount){
		this.eCount = eCount;
	}
	
}
