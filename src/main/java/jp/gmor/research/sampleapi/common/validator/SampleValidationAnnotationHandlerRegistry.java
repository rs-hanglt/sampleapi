/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.validator;


import jp.gmor.research.framework.core.api.validator.annotation.handler.DateFormatValidationAnnotationHandler;
import jp.gmor.research.framework.core.api.validator.annotation.handler.DecryptValidationAnnotationHandler;
import jp.gmor.research.framework.core.api.validator.annotation.handler.GmorMailValidationAnnotationHandler;
import jp.gmor.research.framework.core.api.validator.annotation.handler.HankakuValidationAnnotationHandler;
import jp.gmor.research.framework.core.api.validator.annotation.handler.IntegerValidationAnnotationHandler;
import jp.gmor.research.framework.core.api.validator.annotation.handler.KatakanaValidationAnnotationHandler;
import jp.gmor.research.framework.core.api.validator.annotation.handler.NumericRangeValidationAnnotationHandler;
import jp.gmor.research.framework.core.api.validator.annotation.handler.RequiredValidationAnnotationHandler;
import jp.gmor.research.framework.core.api.validator.annotation.handler.ZenkakuValidationAnnotationHandler;

import org.springmodules.validation.bean.conf.loader.annotation.DefaultValidationAnnotationHandlerRegistry;

/**
 * @author kamachi
 * @since 2012/08/28
 */
public class SampleValidationAnnotationHandlerRegistry
        extends DefaultValidationAnnotationHandlerRegistry {

    /**
     * デフォルトのコンストラクタです。<br>
     * 使用するアノテーションのハンドラーを生成して登録します。
     */
    public SampleValidationAnnotationHandlerRegistry() {
        super();
        registerPropertyHandler(new RequiredValidationAnnotationHandler());
        registerPropertyHandler(new HankakuValidationAnnotationHandler());
        registerPropertyHandler(new ZenkakuValidationAnnotationHandler());
        registerPropertyHandler(new KatakanaValidationAnnotationHandler());
        registerPropertyHandler(new DateFormatValidationAnnotationHandler());
        registerPropertyHandler(new GmorMailValidationAnnotationHandler());
        registerPropertyHandler(new DecryptValidationAnnotationHandler());
        registerPropertyHandler(new NumericRangeValidationAnnotationHandler());
        registerPropertyHandler(new IntegerValidationAnnotationHandler());
    }

}
