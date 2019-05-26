package com.jeecg.demo.entity;

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
 * @Description: 巡查记录
 * @author onlineGenerator
 * @date 2019-03-23 16:05:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "patrol_record", schema = "")
@SuppressWarnings("serial")
public class PatrolRecordEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**巡查员姓名*/
	@Excel(name="巡查员姓名",width=15)
	private java.lang.String patrolName;
	/**巡查员电话*/
	@Excel(name="巡查员电话",width=15)
	private java.lang.String telephone;
	/**巡查时间*/
	@Excel(name="巡查时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date time;
	/**巡查单位*/
	@Excel(name="巡查单位",width=15)
	private java.lang.String factoryName;
	/**整改措施*/
	@Excel(name="整改措施",width=15)
	private java.lang.String record;
	/**风险点是否可控*/
	private java.lang.String iscontrol;
	/**具体地址*/
	@Excel(name="具体地址",width=15)
	private java.lang.String location;
	/**不可控原因*/
	@Excel(name="不可控原因",width=15)
	private java.lang.String riskReason;
	
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
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
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
	 *@return: java.lang.String  巡查员姓名
	 */

	@Column(name ="PATROL_NAME",nullable=false,length=32)
	public java.lang.String getPatrolName(){
		return this.patrolName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  巡查员姓名
	 */
	public void setPatrolName(java.lang.String patrolName){
		this.patrolName = patrolName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  巡查员电话
	 */

	@Column(name ="TELEPHONE",nullable=true,length=32)
	public java.lang.String getTelephone(){
		return this.telephone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  巡查员电话
	 */
	public void setTelephone(java.lang.String telephone){
		this.telephone = telephone;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  巡查时间
	 */

	@Column(name ="TIME",nullable=false,length=32)
	public java.util.Date getTime(){
		return this.time;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  巡查时间
	 */
	public void setTime(java.util.Date time){
		this.time = time;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  巡查单位
	 */

	@Column(name ="FACTORY_NAME",nullable=false,length=32)
	public java.lang.String getFactoryName(){
		return this.factoryName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  巡查单位
	 */
	public void setFactoryName(java.lang.String factoryName){
		this.factoryName = factoryName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  整改措施
	 */

	@Column(name ="RECORD",nullable=true,length=3255)
	public java.lang.String getRecord(){
		return this.record;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  整改措施
	 */
	public void setRecord(java.lang.String record){
		this.record = record;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  风险点是否可控
	 */

	@Column(name ="ISCONTROL",nullable=true,length=32)
	public java.lang.String getIscontrol(){
		return this.iscontrol;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  风险点是否可控
	 */
	public void setIscontrol(java.lang.String iscontrol){
		this.iscontrol = iscontrol;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  具体地址
	 */

	@Column(name ="LOCATION",nullable=true,length=32)
	public java.lang.String getLocation(){
		return this.location;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  具体地址
	 */
	public void setLocation(java.lang.String location){
		this.location = location;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  不可控原因
	 */

	@Column(name ="RISK_REASON",nullable=true,length=3255)
	public java.lang.String getRiskReason(){
		return this.riskReason;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  不可控原因
	 */
	public void setRiskReason(java.lang.String riskReason){
		this.riskReason = riskReason;
	}
}
