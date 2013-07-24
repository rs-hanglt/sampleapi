/*-
 * Copyright (c) 2004-2013 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.domain;

import java.util.Date;

import jp.gmor.research.sampleapi.common.constant.CommonConstants;

/**
 * companyåüçıèåè
 * @author usr160056
 * @since 2013/07/09 phase 2.0
 */
public class CompanySelectorConditionBean {

    private Integer companyId;

    private Integer userCompanyId;

    private String companyNm;

    private Date registDateFrom;

    private Date registDateTo;

    private Integer limit = CommonConstants.COMPANY_SELECT_LIMIT_DEFAULT;

    private Integer offset = null;

    /**
     * @return the companyId
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId the companyId to set
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the userCompanyId
     */
    public Integer getUserCompanyId() {
        return userCompanyId;
    }

    /**
     * @param userCompanyId the userCompanyId to set
     */
    public void setUserCompanyId(Integer userCompanyId) {
        this.userCompanyId = userCompanyId;
    }

    /**
     * @return the companyNm
     */
    public String getCompanyNm() {
        return companyNm;
    }

    /**
     * @param companyNm the companyNm to set
     */
    public void setCompanyNm(String companyNm) {
        this.companyNm = companyNm;
    }

    /**
     * @return the registDateFrom
     */
    public Date getRegistDateFrom() {
        return registDateFrom;
    }

    /**
     * @param registDateFrom the registDateFrom to set
     */
    public void setRegistDateFrom(Date registDateFrom) {
        this.registDateFrom = registDateFrom;
    }

    /**
     * @return the registDateTo
     */
    public Date getRegistDateTo() {
        return registDateTo;
    }

    /**
     * @param registDateTo the registDateTo to set
     */
    public void setRegistDateTo(Date registDateTo) {
        this.registDateTo = registDateTo;
    }

    /**
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * @return the offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
