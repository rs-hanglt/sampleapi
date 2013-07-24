/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.service;

import java.util.List;

import jp.gmor.research.framework.core.exception.application.ServiceException;
import jp.gmor.research.framework.core.service.ApplicationService;
import jp.gmor.research.sampleapi.common.domain.CompanyPanelDisplayMstDto;

/**
 * âÔé–åüçı(âÔé–IDéwíË)
 * @author terasawa
 * @since 2013/07/08 phase 2.0
 */
public interface CompanyPanelDisplayMstSelectService
        extends ApplicationService<List<CompanyPanelDisplayMstDto>, ServiceException> {

    /**
     * @param companyId the companyId to set
     * @param countryCd the countryCd to set
     */
    void setParameter(Integer companyId, String countryCd);
}
