/*-
 * Copyright (c) 2004-2013 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.service.impl;

import java.util.List;

import jp.gmor.research.framework.core.exception.application.ServiceException;
import jp.gmor.research.framework.core.service.impl.AbstractApplicationService;
import jp.gmor.research.sampleapi.common.domain.CompanyDto;
import jp.gmor.research.sampleapi.common.domain.CompanySelectorConditionBean;
import jp.gmor.research.sampleapi.common.integration.CompanySelector;
import jp.gmor.research.sampleapi.common.service.CompanySelectService;

/**
 * @author usr160056
 * @since 2013/02/28 phase 2.0
 */
public class CompanySelectServiceImpl
        extends AbstractApplicationService<List<CompanyDto>, ServiceException>
        implements CompanySelectService {

    private CompanySelector companySelector;

    private CompanySelectorConditionBean companySelectorConditionBean;

    /** {@inheritDoc} */
    public void setConditionBean(CompanySelectorConditionBean companySelectorConditionBean) {
        this.companySelectorConditionBean = companySelectorConditionBean;
    }

    /** {@inheritDoc} */
    public List<CompanyDto> service() throws ServiceException {
        companySelector.setConditionBean(companySelectorConditionBean);
        return companySelector.findList();
    }

    /** {@inheritDoc} */
    public int getTotalCount() {
        companySelector.setConditionBean(companySelectorConditionBean);
        return companySelector.getCount();
    }

    /**
     * @param companySelector the companySelector to set
     */
    public void setCompanySelector(CompanySelector companySelector) {
        this.companySelector = companySelector;
    }

}
