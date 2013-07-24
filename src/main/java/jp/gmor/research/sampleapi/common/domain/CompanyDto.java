/*-
 * Copyright (c) 2004-2013 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms;with or without
 * modification;is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.domain;

import java.math.BigDecimal;
import java.util.Date;

import jp.gmor.research.framework.core.domain.BaseDomainObject;

/**
 * 
 * @author kamachi
 * @since 2012/09/11
 */
public class CompanyDto
        extends BaseDomainObject {

    /** serialVersionUID */
    private static final long serialVersionUID = -4312877882115569081L;

    private Integer company_id;

    private String company_nm;

    private String branch_nm;

    private String zip_cd1;

    private String zip_cd2;

    private String pref_cd;

    private String address1;

    private String address2;

    private String phone_num1;

    private String phone_num2;

    private String phone_num3;

    private String fax_num1;

    private String fax_num2;

    private String fax_num3;

    private String email;

    private String delete_flg;

    private String entry_kbn;

    private Integer entry_id;

    private Date entry_dt;

    private String updater_kbn;

    private Integer updater_id;

    private Date update_dt;

    private String use_matter_type;

    private BigDecimal collectnum_coefficient;

    private String locale;

    private String collect_time_disp_flg;

    private String name_kj;

    private String name_kn;

    private String admin_auth_flg;

    private String order_auth_flg;

    private String inactive_order_auth_flg;

    private String resend_policy_auth_flg;

    private String note;

    private String regist_user;

    private Date regist_date;

    private String update_user;

    private Date update_date;

    /**
     * @return the company_id
     */
    public Integer getCompany_id() {
        return company_id;
    }

    /**
     * @param company_id the company_id to set
     */
    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    /**
     * @return the company_nm
     */
    public String getCompany_nm() {
        return company_nm;
    }

    /**
     * @param company_nm the company_nm to set
     */
    public void setCompany_nm(String company_nm) {
        this.company_nm = company_nm;
    }

    /**
     * @return the branch_nm
     */
    public String getBranch_nm() {
        return branch_nm;
    }

    /**
     * @param branch_nm the branch_nm to set
     */
    public void setBranch_nm(String branch_nm) {
        this.branch_nm = branch_nm;
    }

    /**
     * @return the zip_cd1
     */
    public String getZip_cd1() {
        return zip_cd1;
    }

    /**
     * @param zip_cd1 the zip_cd1 to set
     */
    public void setZip_cd1(String zip_cd1) {
        this.zip_cd1 = zip_cd1;
    }

    /**
     * @return the zip_cd2
     */
    public String getZip_cd2() {
        return zip_cd2;
    }

    /**
     * @param zip_cd2 the zip_cd2 to set
     */
    public void setZip_cd2(String zip_cd2) {
        this.zip_cd2 = zip_cd2;
    }

    /**
     * @return the pref_cd
     */
    public String getPref_cd() {
        return pref_cd;
    }

    /**
     * @param pref_cd the pref_cd to set
     */
    public void setPref_cd(String pref_cd) {
        this.pref_cd = pref_cd;
    }

    /**
     * @return the address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 the address1 to set
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return the phone_num1
     */
    public String getPhone_num1() {
        return phone_num1;
    }

    /**
     * @param phone_num1 the phone_num1 to set
     */
    public void setPhone_num1(String phone_num1) {
        this.phone_num1 = phone_num1;
    }

    /**
     * @return the phone_num2
     */
    public String getPhone_num2() {
        return phone_num2;
    }

    /**
     * @param phone_num2 the phone_num2 to set
     */
    public void setPhone_num2(String phone_num2) {
        this.phone_num2 = phone_num2;
    }

    /**
     * @return the phone_num3
     */
    public String getPhone_num3() {
        return phone_num3;
    }

    /**
     * @param phone_num3 the phone_num3 to set
     */
    public void setPhone_num3(String phone_num3) {
        this.phone_num3 = phone_num3;
    }

    /**
     * @return the fax_num1
     */
    public String getFax_num1() {
        return fax_num1;
    }

    /**
     * @param fax_num1 the fax_num1 to set
     */
    public void setFax_num1(String fax_num1) {
        this.fax_num1 = fax_num1;
    }

    /**
     * @return the fax_num2
     */
    public String getFax_num2() {
        return fax_num2;
    }

    /**
     * @param fax_num2 the fax_num2 to set
     */
    public void setFax_num2(String fax_num2) {
        this.fax_num2 = fax_num2;
    }

    /**
     * @return the fax_num3
     */
    public String getFax_num3() {
        return fax_num3;
    }

    /**
     * @param fax_num3 the fax_num3 to set
     */
    public void setFax_num3(String fax_num3) {
        this.fax_num3 = fax_num3;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the delete_flg
     */
    public String getDelete_flg() {
        return delete_flg;
    }

    /**
     * @param delete_flg the delete_flg to set
     */
    public void setDelete_flg(String delete_flg) {
        this.delete_flg = delete_flg;
    }

    /**
     * @return the entry_kbn
     */
    public String getEntry_kbn() {
        return entry_kbn;
    }

    /**
     * @param entry_kbn the entry_kbn to set
     */
    public void setEntry_kbn(String entry_kbn) {
        this.entry_kbn = entry_kbn;
    }

    /**
     * @return the entry_id
     */
    public Integer getEntry_id() {
        return entry_id;
    }

    /**
     * @param entry_id the entry_id to set
     */
    public void setEntry_id(Integer entry_id) {
        this.entry_id = entry_id;
    }

    /**
     * @return the entry_dt
     */
    public Date getEntry_dt() {
        return entry_dt;
    }

    /**
     * @param entry_dt the entry_dt to set
     */
    public void setEntry_dt(Date entry_dt) {
        this.entry_dt = entry_dt;
    }

    /**
     * @return the updater_kbn
     */
    public String getUpdater_kbn() {
        return updater_kbn;
    }

    /**
     * @param updater_kbn the updater_kbn to set
     */
    public void setUpdater_kbn(String updater_kbn) {
        this.updater_kbn = updater_kbn;
    }

    /**
     * @return the updater_id
     */
    public Integer getUpdater_id() {
        return updater_id;
    }

    /**
     * @param updater_id the updater_id to set
     */
    public void setUpdater_id(Integer updater_id) {
        this.updater_id = updater_id;
    }

    /**
     * @return the update_dt
     */
    public Date getUpdate_dt() {
        return update_dt;
    }

    /**
     * @param update_dt the update_dt to set
     */
    public void setUpdate_dt(Date update_dt) {
        this.update_dt = update_dt;
    }

    /**
     * @return the use_matter_type
     */
    public String getUse_matter_type() {
        return use_matter_type;
    }

    /**
     * @param use_matter_type the use_matter_type to set
     */
    public void setUse_matter_type(String use_matter_type) {
        this.use_matter_type = use_matter_type;
    }

    /**
     * @return the collectnum_coefficient
     */
    public BigDecimal getCollectnum_coefficient() {
        return collectnum_coefficient;
    }

    /**
     * @param collectnum_coefficient the collectnum_coefficient to set
     */
    public void setCollectnum_coefficient(BigDecimal collectnum_coefficient) {
        this.collectnum_coefficient = collectnum_coefficient;
    }

    /**
     * @return the locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     * @return the collect_time_disp_flg
     */
    public String getCollect_time_disp_flg() {
        return collect_time_disp_flg;
    }

    /**
     * @param collect_time_disp_flg the collect_time_disp_flg to set
     */
    public void setCollect_time_disp_flg(String collect_time_disp_flg) {
        this.collect_time_disp_flg = collect_time_disp_flg;
    }

    /**
     * @return the name_kj
     */
    public String getName_kj() {
        return name_kj;
    }

    /**
     * @param name_kj the name_kj to set
     */
    public void setName_kj(String name_kj) {
        this.name_kj = name_kj;
    }

    /**
     * @return the name_kn
     */
    public String getName_kn() {
        return name_kn;
    }

    /**
     * @param name_kn the name_kn to set
     */
    public void setName_kn(String name_kn) {
        this.name_kn = name_kn;
    }

    /**
     * @return the admin_auth_flg
     */
    public String getAdmin_auth_flg() {
        return admin_auth_flg;
    }

    /**
     * @param admin_auth_flg the admin_auth_flg to set
     */
    public void setAdmin_auth_flg(String admin_auth_flg) {
        this.admin_auth_flg = admin_auth_flg;
    }

    /**
     * @return the order_auth_flg
     */
    public String getOrder_auth_flg() {
        return order_auth_flg;
    }

    /**
     * @param order_auth_flg the order_auth_flg to set
     */
    public void setOrder_auth_flg(String order_auth_flg) {
        this.order_auth_flg = order_auth_flg;
    }

    /**
     * @return the inactive_order_auth_flg
     */
    public String getInactive_order_auth_flg() {
        return inactive_order_auth_flg;
    }

    /**
     * @param inactive_order_auth_flg the inactive_order_auth_flg to set
     */
    public void setInactive_order_auth_flg(String inactive_order_auth_flg) {
        this.inactive_order_auth_flg = inactive_order_auth_flg;
    }

    /**
     * @return the resend_policy_auth_flg
     */
    public String getResend_policy_auth_flg() {
        return resend_policy_auth_flg;
    }

    /**
     * @param resend_policy_auth_flg the resend_policy_auth_flg to set
     */
    public void setResend_policy_auth_flg(String resend_policy_auth_flg) {
        this.resend_policy_auth_flg = resend_policy_auth_flg;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the regist_user
     */
    public String getRegist_user() {
        return regist_user;
    }

    /**
     * @param regist_user the regist_user to set
     */
    public void setRegist_user(String regist_user) {
        this.regist_user = regist_user;
    }

    /**
     * @return the regist_date
     */
    public Date getRegist_date() {
        return regist_date;
    }

    /**
     * @param regist_date the regist_date to set
     */
    public void setRegist_date(Date regist_date) {
        this.regist_date = regist_date;
    }

    /**
     * @return the update_user
     */
    public String getUpdate_user() {
        return update_user;
    }

    /**
     * @param update_user the update_user to set
     */
    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

    /**
     * @return the update_date
     */
    public Date getUpdate_date() {
        return update_date;
    }

    /**
     * @param update_date the update_date to set
     */
    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

}
