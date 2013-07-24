/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.publicgate;

import jp.gmor.research.framework.core.api.domain.MygmorApiRequestDto;
import jp.gmor.research.framework.core.api.domain.MygmorApiResponseDto;
import jp.gmor.research.framework.core.exception.application.ServiceException;
import jp.gmor.research.framework.core.facade.StatefulFacade;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindException;

/**
 * 会社検索API
 * @author usr160056
 * @since 2013/07/09 phase 2.0
 */
public interface CompanySelectFacade
        extends StatefulFacade {

    /**
     * 会社検索API
     * @param request リクエストパラメータ
     * @return レスポンスボディ
     * @throws ServiceException 例外
     * @throws BindException 例外
     */
    @Transactional(readOnly = true)
    MygmorApiResponseDto create(MygmorApiRequestDto request) throws ServiceException, BindException;
}
