/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.integration;

import jp.gmor.research.framework.core.integration.Selector;
import jp.gmor.research.sampleapi.common.domain.CompanyPanelDisplayMstDto;

/**
 * @author kamachi
 * @since 2012/08/29
 */
public interface CompanyPanelDisplayMstSelector
        extends Selector<CompanyPanelDisplayMstDto> {

    /**
     * @param companyId the companyId to set
     * @param countryCd the countryCd to set
     */
    void setParameter(Integer companyId, String countryCd);
}
