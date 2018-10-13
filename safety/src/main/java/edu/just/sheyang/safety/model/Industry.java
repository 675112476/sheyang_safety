package edu.just.sheyang.safety.model;

import java.util.Date;
import javax.persistence.*;

public class Industry {
    /**
     * id
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
     * 行业名称
     */
    @Column(name = "industry_name")
    private String industryName;

    /**
     * 父级行业
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 行业简介
     */
    @Column(name = "industry_introduction")
    private String industryIntroduction;

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
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
     * 获取行业名称
     *
     * @return industry_name - 行业名称
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * 设置行业名称
     *
     * @param industryName 行业名称
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName == null ? null : industryName.trim();
    }

    /**
     * 获取父级行业
     *
     * @return parent_id - 父级行业
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父级行业
     *
     * @param parentId 父级行业
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 获取行业简介
     *
     * @return industry_introduction - 行业简介
     */
    public String getIndustryIntroduction() {
        return industryIntroduction;
    }

    /**
     * 设置行业简介
     *
     * @param industryIntroduction 行业简介
     */
    public void setIndustryIntroduction(String industryIntroduction) {
        this.industryIntroduction = industryIntroduction == null ? null : industryIntroduction.trim();
    }
}