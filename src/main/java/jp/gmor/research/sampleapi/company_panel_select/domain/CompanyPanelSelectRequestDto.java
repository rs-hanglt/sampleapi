/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.company_panel_select.domain;

import jp.gmor.research.framework.core.api.validator.annotation.Required;
import jp.gmor.research.framework.core.api.validator.annotation.Integer;
import jp.gmor.research.framework.core.domain.BaseDomainObject;

import org.springmodules.validation.bean.conf.loader.annotation.handler.MaxLength;

/**
 * @author kamachi
 * @since 2012/08/31
 */
public class CompanyPanelSelectRequestDto
        extends BaseDomainObject {

    /** serialVersionUID */
    private static final long serialVersionUID = 2226396534413167192L;

    @Required
    @Integer
    private String company_id;

    @Required
    @MaxLength(5)
    private String country_cd;

    @Integer
    private String collect_range_cd;

    private String locale;

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
     * @return the country_cd
     */
    public String getCountry_cd() {
        return country_cd;
    }

    /**
     * @param country_cd the country_cd to set
     */
    public void setCountry_cd(String country_cd) {
        this.country_cd = country_cd;
    }

    /**
     * @return the collect_range_cd
     */
    public String getCollect_range_cd() {
        return collect_range_cd;
    }

    /**
     * @param collect_range_cd the collect_range_cd to set
     */
    public void setCollect_range_cd(String collect_range_cd) {
        this.collect_range_cd = collect_range_cd;
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

}
