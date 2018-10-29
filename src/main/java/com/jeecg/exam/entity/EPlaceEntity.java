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
 * @Description: 考场信息
 * @author onlineGenerator
 * @date 2018-10-29 15:34:55
 * @version V1.0   
 *
 */
@Entity
@Table(name = "e_place", schema = "")
@SuppressWarnings("serial")
public class EPlaceEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**考试id*/
	private java.lang.String examId;
	/**考场名称*/
	@Excel(name="考场名称",width=15)
	private java.lang.String pName;
	/**考场地址信息*/
	@Excel(name="考场地址信息",width=15)
	private java.lang.String pInfo;
	/**考场容纳人数*/
	@Excel(name="考场容纳人数",width=15)
	private java.lang.String pCount;
	/**创建人*/
	private java.lang.String pCreatby;
	
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
	 *@return: java.lang.String  考试id
	 */
	
	@Column(name ="EXAM_ID",nullable=true,length=50)
	public java.lang.String getExamId(){
		return this.examId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考试id
	 */
	public void setExamId(java.lang.String examId){
		this.examId = examId;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考场名称
	 */
	
	@Column(name ="P_NAME",nullable=true,length=50)
	public java.lang.String getPName(){
		return this.pName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考场名称
	 */
	public void setPName(java.lang.String pName){
		this.pName = pName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考场地址信息
	 */
	
	@Column(name ="P_INFO",nullable=true,length=20)
	public java.lang.String getPInfo(){
		return this.pInfo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考场地址信息
	 */
	public void setPInfo(java.lang.String pInfo){
		this.pInfo = pInfo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  考场容纳人数
	 */
	
	@Column(name ="P_COUNT",nullable=true,length=50)
	public java.lang.String getPCount(){
		return this.pCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  考场容纳人数
	 */
	public void setPCount(java.lang.String pCount){
		this.pCount = pCount;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	
	@Column(name ="P_CREATBY",nullable=true,length=50)
	public java.lang.String getPCreatby(){
		return this.pCreatby;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setPCreatby(java.lang.String pCreatby){
		this.pCreatby = pCreatby;
	}
	
}
