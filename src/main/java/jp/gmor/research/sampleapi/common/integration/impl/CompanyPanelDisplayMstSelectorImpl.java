/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.integration.impl;

import jp.gmor.research.framework.core.integration.impl.SelectProvider;
import jp.gmor.research.sampleapi.common.domain.CompanyPanelDisplayMstDto;
import jp.gmor.research.sampleapi.common.integration.CompanyPanelDisplayMstSelector;

/**
 * @author kamachi
 * @since 2012/08/29
 */
public class CompanyPanelDisplayMstSelectorImpl
        extends SelectProvider<CompanyPanelDisplayMstDto>
        implements CompanyPanelDisplayMstSelector {

    /** {@inheritDoc} */
    public void setParameter(Integer companyId, String countryCd) {
        setParameter("company_id", companyId);
        setParameter("country_cd", countryCd);
    }

}
