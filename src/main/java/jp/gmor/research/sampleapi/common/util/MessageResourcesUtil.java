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

    /** �t�@�C���� */
    private static final String MESSAGE_RESOURCES_NAME = "MessageResources";

    /**
     * �w�肳�ꂽ���P�[���̃��b�Z�[�W���擾���܂�
     * @param key ���b�Z�[�W�L�[
     * @param locale ���P�[��
     * @return �w�肳�ꂽ���P�[���̃��b�Z�[�W
     */
    public static String getString(String key, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(MESSAGE_RESOURCES_NAME, locale);
        return resourceBundle.getString(key);
    }

    /**
     * �w�肳�ꂽ���P�[���L�[�̃��b�Z�[�W���擾���܂�
     * @param key ���b�Z�[�W�L�[
     * @param locale ���P�[���L�[
     * @return �w�肳�ꂽ���P�[���L�[�̃��b�Z�[�W
     */
    public static String getString(String key, String locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(MESSAGE_RESOURCES_NAME, new Locale(locale));
        return resourceBundle.getString(key);
    }
}
