/*-
 * Copyright (c) 2004-2013 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.service;

import java.util.List;

import jp.gmor.research.framework.core.exception.application.ServiceException;
import jp.gmor.research.framework.core.service.ApplicationService;
import jp.gmor.research.sampleapi.common.domain.CompanyDto;
import jp.gmor.research.sampleapi.common.domain.CompanySelectorConditionBean;

/**
 * @author usr160056
 * @since 2013/02/28 phase 2.0
 */
public interface CompanySelectService
        extends ApplicationService<List<CompanyDto>, ServiceException> {

    /**
     * ŒŸõğŒİ’è
     * @param companySelectorConditionBean ŒŸõğŒ
     */
    void setConditionBean(CompanySelectorConditionBean companySelectorConditionBean);

    /**
     * ‘Œ”‚ğæ“¾‚µ‚Ü‚·
     * @return ‘Œ”
     */
    int getTotalCount();

}
