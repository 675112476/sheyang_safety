package edu.just.sheyang.safety.model;

import java.util.Date;
import javax.persistence.*;

public class T_s_depart {
    /**
     * ID
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 部门名称
     */
    private String departname;

    /**
     * 父部门ID
     */
    private String parentdepartid;

    /**
     * 机构编码
     */
    @Column(name = "org_code")
    private String orgCode;

    /**
     * 机构类型
     */
    @Column(name = "org_type")
    private String orgType;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 传真
     */
    private String fax;

    /**
     * 地址
     */
    private String address;

    /**
     * 排序
     */
    @Column(name = "depart_order")
    private String departOrder;

    /**
     * 英文名
     */
    @Column(name = "departname_en")
    private String departnameEn;

    /**
     * 缩写
     */
    @Column(name = "departname_abbr")
    private String departnameAbbr;

    /**
     * 备注
     */
    private String memo;

    /**
     * 创建人名称
     */
    @Column(name = "create_name")
    private String createName;

    /**
     * 创建人账号
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
     * 更新人账号
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新日期
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 数据所属公司
     */
    @Column(name = "sys_company_code")
    private String sysCompanyCode;

    /**
     * 数据所属部门
     */
    @Column(name = "sys_org_code")
    private String sysOrgCode;

    /**
     * 描述
     */
    private String description;

    /**
     * 获取ID
     *
     * @return ID - ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取部门名称
     *
     * @return departname - 部门名称
     */
    public String getDepartname() {
        return departname;
    }

    /**
     * 设置部门名称
     *
     * @param departname 部门名称
     */
    public void setDepartname(String departname) {
        this.departname = departname == null ? null : departname.trim();
    }

    /**
     * 获取父部门ID
     *
     * @return parentdepartid - 父部门ID
     */
    public String getParentdepartid() {
        return parentdepartid;
    }

    /**
     * 设置父部门ID
     *
     * @param parentdepartid 父部门ID
     */
    public void setParentdepartid(String parentdepartid) {
        this.parentdepartid = parentdepartid == null ? null : parentdepartid.trim();
    }

    /**
     * 获取机构编码
     *
     * @return org_code - 机构编码
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * 设置机构编码
     *
     * @param orgCode 机构编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * 获取机构类型
     *
     * @return org_type - 机构类型
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * 设置机构类型
     *
     * @param orgType 机构类型
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取传真
     *
     * @return fax - 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真
     *
     * @param fax 传真
     */
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取排序
     *
     * @return depart_order - 排序
     */
    public String getDepartOrder() {
        return departOrder;
    }

    /**
     * 设置排序
     *
     * @param departOrder 排序
     */
    public void setDepartOrder(String departOrder) {
        this.departOrder = departOrder == null ? null : departOrder.trim();
    }

    /**
     * 获取英文名
     *
     * @return departname_en - 英文名
     */
    public String getDepartnameEn() {
        return departnameEn;
    }

    /**
     * 设置英文名
     *
     * @param departnameEn 英文名
     */
    public void setDepartnameEn(String departnameEn) {
        this.departnameEn = departnameEn == null ? null : departnameEn.trim();
    }

    /**
     * 获取缩写
     *
     * @return departname_abbr - 缩写
     */
    public String getDepartnameAbbr() {
        return departnameAbbr;
    }

    /**
     * 设置缩写
     *
     * @param departnameAbbr 缩写
     */
    public void setDepartnameAbbr(String departnameAbbr) {
        this.departnameAbbr = departnameAbbr == null ? null : departnameAbbr.trim();
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
     * 获取创建人账号
     *
     * @return create_by - 创建人账号
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人账号
     *
     * @param createBy 创建人账号
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
     * 获取更新人账号
     *
     * @return update_by - 更新人账号
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人账号
     *
     * @param updateBy 更新人账号
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
     * 获取数据所属公司
     *
     * @return sys_company_code - 数据所属公司
     */
    public String getSysCompanyCode() {
        return sysCompanyCode;
    }

    /**
     * 设置数据所属公司
     *
     * @param sysCompanyCode 数据所属公司
     */
    public void setSysCompanyCode(String sysCompanyCode) {
        this.sysCompanyCode = sysCompanyCode == null ? null : sysCompanyCode.trim();
    }

    /**
     * 获取数据所属部门
     *
     * @return sys_org_code - 数据所属部门
     */
    public String getSysOrgCode() {
        return sysOrgCode;
    }

    /**
     * 设置数据所属部门
     *
     * @param sysOrgCode 数据所属部门
     */
    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode == null ? null : sysOrgCode.trim();
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}