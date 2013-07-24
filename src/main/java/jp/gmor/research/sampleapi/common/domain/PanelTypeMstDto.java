/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms;with or without
 * modification;is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.domain;

import java.util.Date;

import jp.gmor.research.framework.core.domain.BaseDomainObject;

/**
 * @author kamachi
 * @since 2012/08/29
 */
public class PanelTypeMstDto
        extends BaseDomainObject {

    /** serialVersionUID */
    private static final long serialVersionUID = -6120520275496213779L;

    private String panel_type;

    private String prefix;

    private String panel_name;

    private String panel_name_en;

    private Integer priority;

    private String encrypt_key_id;

    private String point_sign;

    private String ans_status_name;

    private String member_info_name;

    private String member_property_name;

    private Integer member_update_type;

    private String display_flg;

    private Date entry_dt;

    private Date update_dt;

    private String hour_12_display_flg;

    private String hour_24_display_flg;

    private String hour_48_display_flg;

    private Integer order_type;

    private Integer company_id;

    /**
     * @return the panel_type
     */
    public String getPanel_type() {
        return panel_type;
    }

    /**
     * @param panel_type the panel_type to set
     */
    public void setPanel_type(String panel_type) {
        this.panel_type = panel_type;
    }

    /**
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * @return the panel_name
     */
    public String getPanel_name() {
        return panel_name;
    }

    /**
     * @param panel_name the panel_name to set
     */
    public void setPanel_name(String panel_name) {
        this.panel_name = panel_name;
    }

    /**
     * @return the panel_name_en
     */
    public String getPanel_name_en() {
        return panel_name_en;
    }

    /**
     * @param panel_name_en the panel_name_en to set
     */
    public void setPanel_name_en(String panel_name_en) {
        this.panel_name_en = panel_name_en;
    }

    /**
     * @return the priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * @return the encrypt_key_id
     */
    public String getEncrypt_key_id() {
        return encrypt_key_id;
    }

    /**
     * @param encrypt_key_id the encrypt_key_id to set
     */
    public void setEncrypt_key_id(String encrypt_key_id) {
        this.encrypt_key_id = encrypt_key_id;
    }

    /**
     * @return the point_sign
     */
    public String getPoint_sign() {
        return point_sign;
    }

    /**
     * @param point_sign the point_sign to set
     */
    public void setPoint_sign(String point_sign) {
        this.point_sign = point_sign;
    }

    /**
     * @return the ans_status_name
     */
    public String getAns_status_name() {
        return ans_status_name;
    }

    /**
     * @param ans_status_name the ans_status_name to set
     */
    public void setAns_status_name(String ans_status_name) {
        this.ans_status_name = ans_status_name;
    }

    /**
     * @return the member_info_name
     */
    public String getMember_info_name() {
        return member_info_name;
    }

    /**
     * @param member_info_name the member_info_name to set
     */
    public void setMember_info_name(String member_info_name) {
        this.member_info_name = member_info_name;
    }

    /**
     * @return the member_property_name
     */
    public String getMember_property_name() {
        return member_property_name;
    }

    /**
     * @param member_property_name the member_property_name to set
     */
    public void setMember_property_name(String member_property_name) {
        this.member_property_name = member_property_name;
    }

    /**
     * @return the member_update_type
     */
    public Integer getMember_update_type() {
        return member_update_type;
    }

    /**
     * @param member_update_type the member_update_type to set
     */
    public void setMember_update_type(Integer member_update_type) {
        this.member_update_type = member_update_type;
    }

    /**
     * @return the display_flg
     */
    public String getDisplay_flg() {
        return display_flg;
    }

    /**
     * @param display_flg the display_flg to set
     */
    public void setDisplay_flg(String display_flg) {
        this.display_flg = display_flg;
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
     * @return the hour_12_display_flg
     */
    public String getHour_12_display_flg() {
        return hour_12_display_flg;
    }

    /**
     * @param hour_12_display_flg the hour_12_display_flg to set
     */
    public void setHour_12_display_flg(String hour_12_display_flg) {
        this.hour_12_display_flg = hour_12_display_flg;
    }

    /**
     * @return the hour_24_display_flg
     */
    public String getHour_24_display_flg() {
        return hour_24_display_flg;
    }

    /**
     * @param hour_24_display_flg the hour_24_display_flg to set
     */
    public void setHour_24_display_flg(String hour_24_display_flg) {
        this.hour_24_display_flg = hour_24_display_flg;
    }

    /**
     * @return the hour_48_display_flg
     */
    public String getHour_48_display_flg() {
        return hour_48_display_flg;
    }

    /**
     * @param hour_48_display_flg the hour_48_display_flg to set
     */
    public void setHour_48_display_flg(String hour_48_display_flg) {
        this.hour_48_display_flg = hour_48_display_flg;
    }

    /**
     * @return the order_type
     */
    public Integer getOrder_type() {
        return order_type;
    }

    /**
     * @param order_type the order_type to set
     */
    public void setOrder_type(Integer order_type) {
        this.order_type = order_type;
    }

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

}
