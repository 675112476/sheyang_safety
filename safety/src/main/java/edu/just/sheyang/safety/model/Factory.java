package edu.just.sheyang.safety.model;

import java.util.Date;
import javax.persistence.*;

public class Factory {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 创建人名称
     */
    @Column(name = "create_name")
    private String createName;

    /**
     * 创建人登录名称
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建日期
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新人名称
     */
    @Column(name = "update_name")
    private String updateName;

    /**
     * 更新人登录名称
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新日期
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 所属部门
     */
    @Column(name = "sys_org_code")
    private String sysOrgCode;

    /**
     * 所属公司
     */
    @Column(name = "sys_company_code")
    private String sysCompanyCode;

    /**
     * 流程状态
     */
    @Column(name = "bpm_status")
    private String bpmStatus;

    /**
     * 单位名称
     */
    @Column(name = "factory_name")
    private String factoryName;

    /**
     * 单位地址
     */
    @Column(name = "factory_location")
    private String factoryLocation;

    /**
     * 单位法人
     */
    @Column(name = "factory_manager")
    private String factoryManager;

    /**
     * 单位联系电话
     */
    @Column(name = "factory_phone")
    private String factoryPhone;

    /**
     * 员工人数
     */
    @Column(name = "factory_worker")
    private Integer factoryWorker;

    /**
     * 所属行业
     */
    private String industry;

    /**
     * 单位介绍
     */
    @Column(name = "factory_introduction")
    private String factoryIntroduction;

    /**
     * 场所风险点
     */
    private String riskpoints;

    /**
     * risk_display
     */
    @Column(name = "risk_display")
    private String riskDisplay;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取创建人名称
     *
     * @return create_name - 创建人名称
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 设置创建人名称
     *
     * @param createName 创建人名称
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * 获取创建人登录名称
     *
     * @return create_by - 创建人登录名称
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人登录名称
     *
     * @param createBy 创建人登录名称
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取创建日期
     *
     * @return create_date - 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期
     *
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新人名称
     *
     * @return update_name - 更新人名称
     */
    public String getUpdateName() {
        return updateName;
    }

    /**
     * 设置更新人名称
     *
     * @param updateName 更新人名称
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    /**
     * 获取更新人登录名称
     *
     * @return update_by - 更新人登录名称
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人登录名称
     *
     * @param updateBy 更新人登录名称
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取更新日期
     *
     * @return update_date - 更新日期
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新日期
     *
     * @param updateDate 更新日期
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取所属部门
     *
     * @return sys_org_code - 所属部门
     */
    public String getSysOrgCode() {
        return sysOrgCode;
    }

    /**
     * 设置所属部门
     *
     * @param sysOrgCode 所属部门
     */
    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode == null ? null : sysOrgCode.trim();
    }

    /**
     * 获取所属公司
     *
     * @return sys_company_code - 所属公司
     */
    public String getSysCompanyCode() {
        return sysCompanyCode;
    }

    /**
     * 设置所属公司
     *
     * @param sysCompanyCode 所属公司
     */
    public void setSysCompanyCode(String sysCompanyCode) {
        this.sysCompanyCode = sysCompanyCode == null ? null : sysCompanyCode.trim();
    }

    /**
     * 获取流程状态
     *
     * @return bpm_status - 流程状态
     */
    public String getBpmStatus() {
        return bpmStatus;
    }

    /**
     * 设置流程状态
     *
     * @param bpmStatus 流程状态
     */
    public void setBpmStatus(String bpmStatus) {
        this.bpmStatus = bpmStatus == null ? null : bpmStatus.trim();
    }

    /**
     * 获取单位名称
     *
     * @return factory_name - 单位名称
     */
    public String getFactoryName() {
        return factoryName;
    }

    /**
     * 设置单位名称
     *
     * @param factoryName 单位名称
     */
    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    /**
     * 获取单位地址
     *
     * @return factory_location - 单位地址
     */
    public String getFactoryLocation() {
        return factoryLocation;
    }

    /**
     * 设置单位地址
     *
     * @param factoryLocation 单位地址
     */
    public void setFactoryLocation(String factoryLocation) {
        this.factoryLocation = factoryLocation == null ? null : factoryLocation.trim();
    }

    /**
     * 获取单位法人
     *
     * @return factory_manager - 单位法人
     */
    public String getFactoryManager() {
        return factoryManager;
    }

    /**
     * 设置单位法人
     *
     * @param factoryManager 单位法人
     */
    public void setFactoryManager(String factoryManager) {
        this.factoryManager = factoryManager == null ? null : factoryManager.trim();
    }

    /**
     * 获取单位联系电话
     *
     * @return factory_phone - 单位联系电话
     */
    public String getFactoryPhone() {
        return factoryPhone;
    }

    /**
     * 设置单位联系电话
     *
     * @param factoryPhone 单位联系电话
     */
    public void setFactoryPhone(String factoryPhone) {
        this.factoryPhone = factoryPhone == null ? null : factoryPhone.trim();
    }

    /**
     * 获取员工人数
     *
     * @return factory_worker - 员工人数
     */
    public Integer getFactoryWorker() {
        return factoryWorker;
    }

    /**
     * 设置员工人数
     *
     * @param factoryWorker 员工人数
     */
    public void setFactoryWorker(Integer factoryWorker) {
        this.factoryWorker = factoryWorker;
    }

    /**
     * 获取所属行业
     *
     * @return industry - 所属行业
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置所属行业
     *
     * @param industry 所属行业
     */
    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    /**
     * 获取单位介绍
     *
     * @return factory_introduction - 单位介绍
     */
    public String getFactoryIntroduction() {
        return factoryIntroduction;
    }

    /**
     * 设置单位介绍
     *
     * @param factoryIntroduction 单位介绍
     */
    public void setFactoryIntroduction(String factoryIntroduction) {
        this.factoryIntroduction = factoryIntroduction == null ? null : factoryIntroduction.trim();
    }

    /**
     * 获取场所风险点
     *
     * @return riskpoints - 场所风险点
     */
    public String getRiskpoints() {
        return riskpoints;
    }

    /**
     * 设置场所风险点
     *
     * @param riskpoints 场所风险点
     */
    public void setRiskpoints(String riskpoints) {
        this.riskpoints = riskpoints == null ? null : riskpoints.trim();
    }

    /**
     * 获取risk_display
     *
     * @return risk_display - risk_display
     */
    public String getRiskDisplay() {
        return riskDisplay;
    }

    /**
     * 设置risk_display
     *
     * @param riskDisplay risk_display
     */
    public void setRiskDisplay(String riskDisplay) {
        this.riskDisplay = riskDisplay == null ? null : riskDisplay.trim();
    }

}