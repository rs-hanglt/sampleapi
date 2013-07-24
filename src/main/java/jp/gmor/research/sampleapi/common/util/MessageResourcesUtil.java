/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author kamachi
 * @since 2012/08/29
 */
public class MessageResourcesUtil {

    /** ファイル名 */
    private static final String MESSAGE_RESOURCES_NAME = "MessageResources";

    /**
     * 指定されたロケールのメッセージを取得します
     * @param key メッセージキー
     * @param locale ロケール
     * @return 指定されたロケールのメッセージ
     */
    public static String getString(String key, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(MESSAGE_RESOURCES_NAME, locale);
        return resourceBundle.getString(key);
    }

    /**
     * 指定されたロケールキーのメッセージを取得します
     * @param key メッセージキー
     * @param locale ロケールキー
     * @return 指定されたロケールキーのメッセージ
     */
    public static String getString(String key, String locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(MESSAGE_RESOURCES_NAME, new Locale(locale));
        return resourceBundle.getString(key);
    }
}
