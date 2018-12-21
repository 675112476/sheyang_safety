package edu.just.sheyang.safety.model;

import java.util.Date;
import javax.persistence.*;

public class Riskpoints {
    /**
     * 主键
     */
    @Id
    private Integer id;

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
     * 公司
     */
    private String factory;

    /**
     * 危险点
     */
    private String riskpoint;

    /**
     * 是否可控
     */
    private String iscontrol;

    /**
     * 时间
     */
    private String time;

    /**
     * 巡查员
     */
    @Column(name = "patrol_person")
    private String patrolPerson;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 获取公司
     *
     * @return factory - 公司
     */
    public String getFactory() {
        return factory;
    }

    /**
     * 设置公司
     *
     * @param factory 公司
     */
    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    /**
     * 获取危险点
     *
     * @return riskpoint - 危险点
     */
    public String getRiskpoint() {
        return riskpoint;
    }

    /**
     * 设置危险点
     *
     * @param riskpoint 危险点
     */
    public void setRiskpoint(String riskpoint) {
        this.riskpoint = riskpoint == null ? null : riskpoint.trim();
    }

    /**
     * 获取是否可控
     *
     * @return iscontrol - 是否可控
     */
    public String getIscontrol() {
        return iscontrol;
    }

    /**
     * 设置是否可控
     *
     * @param iscontrol 是否可控
     */
    public void setIscontrol(String iscontrol) {
        this.iscontrol = iscontrol == null ? null : iscontrol.trim();
    }

    /**
     * 获取时间
     *
     * @return time - 时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置时间
     *
     * @param time 时间
     */
    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    /**
     * 获取巡查员
     *
     * @return patrol_person - 巡查员
     */
    public String getPatrolPerson() {
        return patrolPerson;
    }

    /**
     * 设置巡查员
     *
     * @param patrolPerson 巡查员
     */
    public void setPatrolPerson(String patrolPerson) {
        this.patrolPerson = patrolPerson == null ? null : patrolPerson.trim();
    }

    public Riskpoints(String factory, String riskpoint, String iscontrol, String time, String patrolPerson) {
        this.factory = factory;
        this.riskpoint = riskpoint;
        this.iscontrol = iscontrol;
        this.time = time;
        this.patrolPerson = patrolPerson;
    }

    public Riskpoints() {
    }
}