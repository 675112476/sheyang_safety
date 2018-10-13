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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.web.system.pojo.base.TSDepart;

/**   
 * @Title: Entity
 * @Description: 行业
 * @author onlineGenerator
 * @date 2018-09-21 10:55:56
 * @version V1.0   
 *
 */
@Entity
@Table(name = "industry", schema = "")
@SuppressWarnings("serial")
public class IndustryEntity implements java.io.Serializable {
	private IndustryEntity industryEntity;//上级行业
	/**id*/
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
	/**行业名称*/
	@Excel(name="行业名称",width=15)
	private java.lang.String industryName;
	/**分管县长名称*/
	@Excel(name="分管县长名称",width=15)
	private java.lang.String industryFenguan;
	/**局长名称*/
	@Excel(name="局长名称",width=15)
	private java.lang.String industryJuzhang;
	/**行业简介*/
	@Excel(name="行业简介",width=15)
	private java.lang.String industryIntroduction;
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
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

	@Column(name ="CREATE_DATE",nullable=true)
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

	@Column(name ="UPDATE_DATE",nullable=true)
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
	 *@return: java.lang.String  行业名称
	 */

	@Column(name ="INDUSTRY_NAME",nullable=true,length=32)
	public java.lang.String getIndustryName(){
		return this.industryName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行业名称
	 */
	public void setIndustryName(java.lang.String industryName){
		this.industryName = industryName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分管县长名称
	 */

	@Column(name ="INDUSTRY_FENGUAN",nullable=true,length=32)
	public java.lang.String getIndustryFenguan(){
		return this.industryFenguan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分管县长名称
	 */
	public void setIndustryFenguan(java.lang.String industryFenguan){
		this.industryFenguan = industryFenguan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  局长名称
	 */

	@Column(name ="INDUSTRY_JUZHANG",nullable=true,length=32)
	public java.lang.String getIndustryJuzhang(){
		return this.industryJuzhang;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  局长名称
	 */
	public void setIndustryJuzhang(java.lang.String industryJuzhang){
		this.industryJuzhang = industryJuzhang;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行业简介
	 */

	@Column(name ="INDUSTRY_INTRODUCTION",nullable=true,length=300)
	public java.lang.String getIndustryIntroduction(){
		return this.industryIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行业简介
	 */
	public void setIndustryIntroduction(java.lang.String industryIntroduction){
		this.industryIntroduction = industryIntroduction;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  父节点
	 */

//	@Column(name ="PARENT_ID",nullable=true,length=32)
//	public java.lang.String getParentId(){
//		return this.parentId;
//	}
//
//	/**
//	 *方法: 设置java.lang.String
//	 *@param: java.lang.String  父节点
//	 */
//	public void setParentId(java.lang.String parentId){
//		this.parentId = parentId;
//	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentdepartid")
	public IndustryEntity getTSPDepart() {
		return this.industryEntity;
	}

	public void setTSPDepart(IndustryEntity industryEntity) {
		this.industryEntity = industryEntity;
	}
}
