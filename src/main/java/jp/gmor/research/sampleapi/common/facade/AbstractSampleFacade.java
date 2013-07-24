/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.facade;

import static jp.gmor.research.framework.core.utils.GmorConstants.LOG_CATEGORY;
import jp.gmor.research.framework.core.api.facade.AbstractMygmorApiFacade;
import jp.gmor.research.framework.core.domain.BaseDomainObject;
import jp.gmor.research.security.utils.SegmEncryptUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;

/**
 * @author kamachi
 * @since 2012/08/28
 * @param <P> パラメータ
 */
public class AbstractSampleFacade<P extends BaseDomainObject>
        extends AbstractMygmorApiFacade<P> {

    /** log - ログオブジェクト*/
    protected static Log log = LogFactory.getLog(LOG_CATEGORY);

    /** {@inheritDoc} */
    @Override
    protected String decrypt(String p) {
        return SegmEncryptUtil.decrypt(p);
    }

    /** {@inheritDoc} */
    @Override
    protected void validate(P parameter, BindException bindException) {
    }
}
