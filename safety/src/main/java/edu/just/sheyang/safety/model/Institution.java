package edu.just.sheyang.safety.model;

import java.util.Date;
import javax.persistence.*;

public class Institution {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 流程状态
     */
    @Column(name = "bpm_status")
    private String bpmStatus;

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
     * 创建日期
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新日期
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 人员名称
     */
    @Column(name = "person_name")
    private String personName;

    /**
     * 父节点
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 部门岗位
     */
    private String status;

    /**
     * 监管行业
     */
    private String industry;

    /**
     * 监管行业
     */
    @Column(name = "industry_display")
    private String industryDisplay;

    /**
     * 监管公司
     */
    private String factory;

    /**
     * 是否巡查员
     */
    @Column(name = "is_patrol_person")
    private String isPatrolPerson;

    /**
     * 部门岗位
     */
    @Column(name = "depart_display")
    private String departDisplay;

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
     * 获取人员名称
     *
     * @return person_name - 人员名称
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * 设置人员名称
     *
     * @param personName 人员名称
     */
    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    /**
     * 获取父节点
     *
     * @return parent_id - 父节点
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父节点
     *
     * @param parentId 父节点
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 获取部门岗位
     *
     * @return status - 部门岗位
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置部门岗位
     *
     * @param status 部门岗位
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取监管行业
     *
     * @return industry - 监管行业
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置监管行业
     *
     * @param industry 监管行业
     */
    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    /**
     * 获取监管行业
     *
     * @return industry_display - 监管行业
     */
    public String getIndustryDisplay() {
        return industryDisplay;
    }

    /**
     * 设置监管行业
     *
     * @param industryDisplay 监管行业
     */
    public void setIndustryDisplay(String industryDisplay) {
        this.industryDisplay = industryDisplay == null ? null : industryDisplay.trim();
    }

    /**
     * 获取监管公司
     *
     * @return factory - 监管公司
     */
    public String getFactory() {
        return factory;
    }

    /**
     * 设置监管公司
     *
     * @param factory 监管公司
     */
    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    /**
     * 获取是否巡查员
     *
     * @return is_patrol_person - 是否巡查员
     */
    public String getIsPatrolPerson() {
        return isPatrolPerson;
    }

    /**
     * 设置是否巡查员
     *
     * @param isPatrolPerson 是否巡查员
     */
    public void setIsPatrolPerson(String isPatrolPerson) {
        this.isPatrolPerson = isPatrolPerson == null ? null : isPatrolPerson.trim();
    }

    /**
     * 获取部门岗位
     *
     * @return depart_display - 部门岗位
     */
    public String getDepartDisplay() {
        return departDisplay;
    }

    /**
     * 设置部门岗位
     *
     * @param departDisplay 部门岗位
     */
    public void setDepartDisplay(String departDisplay) {
        this.departDisplay = departDisplay == null ? null : departDisplay.trim();
    }
}