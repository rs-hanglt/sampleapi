/*-
 * Copyright (c) 2004-2013 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.integration.impl;

import jp.gmor.research.framework.core.integration.impl.PagerSelectProvider;
import jp.gmor.research.sampleapi.common.domain.CompanyDto;
import jp.gmor.research.sampleapi.common.domain.CompanySelectorConditionBean;
import jp.gmor.research.sampleapi.common.integration.CompanySelector;

/**
 * @author usr160056
 * @since 2013/02/28 phase 2.0
 */
public class CompanySelectorImpl
        extends PagerSelectProvider<CompanyDto>
        implements CompanySelector {

    /** {@inheritDoc} */
    @Override
    public void setConditionBean(CompanySelectorConditionBean companySelectorConditionBean) {
        setParameter("company", companySelectorConditionBean);
    }

}
