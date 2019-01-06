package edu.just.sheyang.safety.model;

import java.util.Date;
import javax.persistence.*;

public class Patrol_record {
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
     * 巡查员姓名
     */
    @Column(name = "patrol_name")
    private String patrolName;

    /**
     * 整改措施
     */
    private String record;

    /**
     * 巡查时间
     */
    private String time;

    /**
     * 巡查公司
     */
    @Column(name = "factory_name")
    private String factoryName;

    /**
     * 风险点是否可控
     */
    private String iscontrol;

    /**
     * 具体地址
     */
    private String location;

    /**
     * 巡查员电话
     */
    private String telephone;

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
     * 获取巡查员姓名
     *
     * @return patrol_name - 巡查员姓名
     */
    public String getPatrolName() {
        return patrolName;
    }

    /**
     * 设置巡查员姓名
     *
     * @param patrolName 巡查员姓名
     */
    public void setPatrolName(String patrolName) {
        this.patrolName = patrolName == null ? null : patrolName.trim();
    }

    /**
     * 获取整改措施
     *
     * @return record - 整改措施
     */
    public String getRecord() {
        return record;
    }

    /**
     * 设置整改措施
     *
     * @param record 整改措施
     */
    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

    /**
     * 获取巡查时间
     *
     * @return time - 巡查时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置巡查时间
     *
     * @param time 巡查时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取巡查公司
     *
     * @return factory_name - 巡查公司
     */
    public String getFactoryName() {
        return factoryName;
    }

    /**
     * 设置巡查公司
     *
     * @param factoryName 巡查公司
     */
    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    /**
     * 获取风险点是否可控
     *
     * @return iscontrol - 风险点是否可控
     */
    public String getIscontrol() {
        return iscontrol;
    }

    /**
     * 设置风险点是否可控
     *
     * @param iscontrol 风险点是否可控
     */
    public void setIscontrol(String iscontrol) {
        this.iscontrol = iscontrol == null ? null : iscontrol.trim();
    }

    /**
     * 获取具体地址
     *
     * @return location - 具体地址
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置具体地址
     *
     * @param location 具体地址
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 获取巡查员电话
     *
     * @return telephone - 巡查员电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置巡查员电话
     *
     * @param telephone 巡查员电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Patrol_record(String patrolName, String record, String time, String factoryName, String iscontrol, String location, String telephone) {
        this.patrolName = patrolName;
        this.record = record;
        this.time = time;
        this.factoryName = factoryName;
        this.iscontrol = iscontrol;
        this.location = location;
        this.telephone = telephone;
    }

    public Patrol_record() {
    }
}