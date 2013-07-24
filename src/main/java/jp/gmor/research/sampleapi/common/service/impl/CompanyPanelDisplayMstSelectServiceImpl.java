/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.service.impl;

import java.util.List;

import jp.gmor.research.framework.core.exception.application.ServiceException;
import jp.gmor.research.framework.core.service.impl.AbstractApplicationService;
import jp.gmor.research.sampleapi.common.domain.CompanyPanelDisplayMstDto;
import jp.gmor.research.sampleapi.common.integration.CompanyPanelDisplayMstSelector;
import jp.gmor.research.sampleapi.common.service.CompanyPanelDisplayMstSelectService;

/**
 * @author kamachi
 * @since 2012/08/29
 */
public class CompanyPanelDisplayMstSelectServiceImpl
        extends AbstractApplicationService<List<CompanyPanelDisplayMstDto>, ServiceException>
        implements CompanyPanelDisplayMstSelectService {

    private CompanyPanelDisplayMstSelector companyPanelDisplayMstSelector;

    private Integer companyId;

    private String countryCd;

    /** {@inheritDoc} */
    public void setParameter(Integer companyId, String countryCd) {
        this.companyId = companyId;
        this.countryCd = countryCd;
    }

    /** {@inheritDoc} */
    public List<CompanyPanelDisplayMstDto> service() throws ServiceException {
        companyPanelDisplayMstSelector.setParameter(companyId, countryCd);
        return companyPanelDisplayMstSelector.findList();
    }

    /**
     * @param companyPanelDisplayMstSelector the companyPanelDisplayMstSelector to set
     */
    public void setCompanyPanelDisplayMstSelector(CompanyPanelDisplayMstSelector companyPanelDisplayMstSelector) {
        this.companyPanelDisplayMstSelector = companyPanelDisplayMstSelector;
    }
}
