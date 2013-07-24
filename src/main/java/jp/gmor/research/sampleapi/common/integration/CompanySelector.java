/*-
 * Copyright (c) 2004-2013 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.integration;

import jp.gmor.research.framework.core.integration.PagerSelector;
import jp.gmor.research.sampleapi.common.domain.CompanyDto;
import jp.gmor.research.sampleapi.common.domain.CompanySelectorConditionBean;

/**
 * ‰ïĞî•ñŒŸõ
 * @author usr160056
 * @since 2013/07/09 phase 2.0
 */
public interface CompanySelector
        extends PagerSelector<CompanyDto> {


    /**
     * ŒŸõğŒİ’è
     * @param companySelectorConditionBean ŒŸõğŒ
     */
    void setConditionBean(CompanySelectorConditionBean companySelectorConditionBean);

}
