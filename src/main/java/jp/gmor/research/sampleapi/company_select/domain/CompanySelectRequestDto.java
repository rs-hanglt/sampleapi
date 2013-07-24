/*-
 * Copyright (c) 2004-2013 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.company_select.domain;

import jp.gmor.research.framework.core.api.validator.annotation.DateFormat;
import jp.gmor.research.framework.core.api.validator.annotation.Integer;
import jp.gmor.research.framework.core.api.validator.annotation.Required;
import jp.gmor.research.framework.core.domain.BaseDomainObject;

import org.springmodules.validation.bean.conf.loader.annotation.handler.MaxLength;

/**
 * @author usr160056
 * @since 2013/07/09 phase 2.0
 */
public class CompanySelectRequestDto
        extends BaseDomainObject {

    /** serialVersionUID */
    private static final long serialVersionUID = -8197938424982335700L;

    /** regist_date format */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    @Required
    @Integer
    private String user_company_id;

    @Integer
    private String company_id;

    @MaxLength(255)
    private String company_nm;

    @DateFormat(value = DATE_FORMAT)
    private String regist_date_from;

    @DateFormat(value = DATE_FORMAT)
    private String regist_date_to;

    @Integer
    private String limit;

    @Integer
    private String offset;

    /**
     * @return the user_company_id
     */
    public String getUser_company_id() {
        return user_company_id;
    }

    /**
     * @param user_company_id the user_company_id to set
     */
    public void setUser_company_id(String user_company_id) {
        this.user_company_id = user_company_id;
    }

    /**
     * @return the company_id
     */
    public String getCompany_id() {
        return company_id;
    }

    /**
     * @param company_id the company_id to set
     */
    public void setCompany_id(String company_id) {
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
     * @return the limit
     */
    public String getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(String limit) {
        this.limit = limit;
    }

    /**
     * @return the offset
     */
    public String getOffset() {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(String offset) {
        this.offset = offset;
    }

    /**
     * @return the regist_date_from
     */
    public String getRegist_date_from() {
        return regist_date_from;
    }

    /**
     * @param regist_date_from the regist_date_from to set
     */
    public void setRegist_date_from(String regist_date_from) {
        this.regist_date_from = regist_date_from;
    }

    /**
     * @return the regist_date_to
     */
    public String getRegist_date_to() {
        return regist_date_to;
    }

    /**
     * @param regist_date_to the regist_date_to to set
     */
    public void setRegist_date_to(String regist_date_to) {
        this.regist_date_to = regist_date_to;
    }
}
