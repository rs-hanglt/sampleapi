/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.util;

import java.util.List;

import jp.gmor.research.framework.tools.util.StringUtil;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.validator.GenericValidator;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

/**
 * @author kamachi
 * @since 2012/08/29
 */
public class ValidationUtil {

    /**
     * Object�̃��X�g�ɑ΂��ĕK�{�`�F�b�N�����s���܂�
     * @param targetList �`�F�b�N�Ώۂ̃��X�g
     * @return true:OK, false:NG
     */
    public static boolean requiredInList(List< ? extends Object> targetList) {
        if (CollectionUtils.isEmpty(targetList)) {
            return false;
        }
        return true;
    }

    /**
     * Object�̃��X�g�ɑ΂��ĕK�{�`�F�b�N�����s���܂�
     * @param targetList �`�F�b�N�Ώۂ̃��X�g
     * @param fieldName �t�B�[���h
     * @param bindException �p�����[�^�̕s��
     */
    public static void requiredInList(List< ? extends Object> targetList, String fieldName, BindException bindException) {
        if (!requiredInList(targetList)) {
            bindException.rejectValue(fieldName, null, "required");
        }
    }

    /**
     * String�̃��X�g�ɑ΂���Integer�Ƃ��ĕ]���ł��邩�`�F�b�N�����s���܂�
     * @param targetList �`�F�b�N�Ώۂ̃��X�g
     * @return true:OK, false:NG
     */
    public static boolean isIntegerInStringList(List<String> targetList) {
        return isIntegerInStringList(targetList, true);
    }

    /**
     * 
     * String�̃��X�g�ɑ΂���Integer�Ƃ��ĕ]���ł��邩�`�F�b�N�����s���܂�
     * @param targetList �`�F�b�N�Ώۂ̃��X�g
     * @param forgiveBlank null or �󕶎������e���邩�itrue���w�肵���ꍇ�A�Ώۂ�null�������͋󕶎��ł��G���[�Ƃ��܂���j
     * @return true:OK, false:NG
     */
    public static boolean isIntegerInStringList(List<String> targetList, boolean forgiveBlank) {
        if (CollectionUtils.isEmpty(targetList)) {
            return true;
        }
        for (String target : targetList) {
            // null or �󕶎������e���Ȃ��ꍇ�Anull or �󕶎����`�F�b�N
            if (!forgiveBlank) {
                if (StringUtil.isEmptyTrim(target)) {
                    return false;
                }
            }
            // Integer�Ƃ��ĕ]���ł��邩�`�F�b�N
            if (!StringUtil.isEmptyTrim(target) && !GenericValidator.isInt(target)) {
                return false;
            }
        }
        return true;
    }

    /**
     * String�̃��X�g�ɑ΂���Integer�Ƃ��ĕ]���ł��邩�`�F�b�N�����s���܂�
     * @param targetList �`�F�b�N�Ώۂ̃��X�g
     * @param fieldName �t�B�[���h
     * @param bindException �p�����[�^�̕s��
     */
    public static void isIntegerInStringList(List<String> targetList, String fieldName, BindException bindException) {
        if (!isIntegerInStringList(targetList)) {
            bindException.rejectValue(fieldName, null, "format");
        }
    }

    /**
     * String�̃��X�g�ɑ΂���Integer�Ƃ��ĕ]���ł��邩�`�F�b�N�����s���܂�
     * @param targetList �`�F�b�N�Ώۂ̃��X�g
     * @param forgiveBlank null or �󕶎������e���邩�itrue���w�肵���ꍇ�A�Ώۂ�null�������͋󕶎��ł��G���[�Ƃ��܂���j
     * @param fieldName �t�B�[���h
     * @param bindException �p�����[�^�̕s��
     */
    public static void isIntegerInStringList(List<String> targetList, boolean forgiveBlank, String fieldName, BindException bindException) {
        if (!isIntegerInStringList(targetList, forgiveBlank)) {
            bindException.rejectValue(fieldName, null, "format");
        }
    }

    /**
     * String�̃��X�g�ɑ΂��ĕ������`�F�b�N�����s���܂�
     * @param targetList �`�F�b�N�Ώۂ̃��X�g
     * @param maxLength �ő啶����
     * @param forgiveBlank null or �󕶎������e���邩�itrue���w�肵���ꍇ�A�Ώۂ�null�������͋󕶎��ł��G���[�Ƃ��܂���j
     * @return true:OK, false:NG
     */
    public static boolean isMaxLengthInStringList(List<String> targetList, int maxLength, boolean forgiveBlank) {
        if (CollectionUtils.isEmpty(targetList)) {
            return true;
        }
        for (String target : targetList) {
            // null or �󕶎������e���Ȃ��ꍇ�Anull or �󕶎����`�F�b�N
            if (!forgiveBlank) {
                if (StringUtil.isEmptyTrim(target)) {
                    return false;
                }
            }
            // �������`�F�b�N
            if (target != null && target.length() > maxLength) {
                return false;
            }
        }
        return true;
    }

    /**
     * String�̃��X�g�ɑ΂��ĕ������`�F�b�N�����s���܂�
     * @param targetList �`�F�b�N�Ώۂ̃��X�g
     * @param maxLength �ő啶����
     * @return true:OK, false:NG
     */
    public static boolean isMaxLengthInStringList(List<String> targetList, int maxLength) {
        return isMaxLengthInStringList(targetList, maxLength, true);
    }

    /**
     * String�̃��X�g�ɑ΂��ĕ������`�F�b�N�����s���܂�
     * @param targetList �`�F�b�N�Ώۂ̃��X�g
     * @param maxLength �ő啶����
     * @param fieldName �t�B�[���h
     * @param bindException �p�����[�^�̕s��
     */
    public static void isMaxLengthInStringList(List<String> targetList, int maxLength, String fieldName, BindException bindException) {
        if (!isMaxLengthInStringList(targetList, maxLength)) {
            bindException.rejectValue(fieldName, null, "max.length");
        }
    }

    /**
     * String�̃��X�g�ɑ΂��ĕ������`�F�b�N�����s���܂�
     * @param targetList �`�F�b�N�Ώۂ̃��X�g
     * @param maxLength �ő啶����
     * @param forgiveBlank null or �󕶎������e���邩�itrue���w�肵���ꍇ�A�Ώۂ�null�������͋󕶎��ł��G���[�Ƃ��܂���j
     * @param fieldName �t�B�[���h
     * @param bindException �p�����[�^�̕s��
     */
    public static void isMaxLengthInStringList(List<String> targetList, int maxLength, boolean forgiveBlank, String fieldName, BindException bindException) {
        if (!isMaxLengthInStringList(targetList, maxLength, forgiveBlank)) {
            bindException.rejectValue(fieldName, null, "max.length");
        }
    }

    /**
     * String�̃��X�g�ɑ΂��Đ��K�\���`�F�b�N�����s���܂�
     * @param targetList �`�F�b�N�Ώۂ̃��X�g
     * @param regex ���K�\��������
     * @return true:OK, false:NG
     */
    public static boolean isMatchInStringList(List<String> targetList, String regex) {
        return isMatchInStringList(targetList, regex, true);
    }

    /**
     * String�̃��X�g�ɑ΂��Đ��K�\���`�F�b�N�����s���܂�
     * @param targetList �`�F�b�N�Ώۂ̃��X�g
     * @param regex ���K�\��������
     * @param forgiveBlank null or �󕶎������e���邩�itrue���w�肵���ꍇ�A�Ώۂ�null�������͋󕶎��ł��G���[�Ƃ��܂���j
     * @return true:OK, false:NG
     */
    public static boolean isMatchInStringList(List<String> targetList, String regex, boolean forgiveBlank) {
        if (CollectionUtils.isEmpty(targetList)) {
            return true;
        }
        for (String target : targetList) {
            // null or �󕶎������e���Ȃ��ꍇ�Anull or �󕶎����`�F�b�N
            if (!forgiveBlank) {
                if (StringUtil.isEmptyTrim(target)) {
                    return false;
                }
            }
            if (target != null && !target.matches(regex)) {
                return false;
            }
        }
        return true;
    }

    /**
     * BindException��FieldError��ǉ����܂�
     * @param fieldName �G���[�t�B�[���h��
     * @param bindException the bindException to set
     * @param defaultMessage �G���[���b�Z�[�W�L�[
     * @param rejectedValue �G���[�ɂȂ����I�u�W�F�N�g
     */
    public static void addFieldError(String fieldName, BindException bindException, String defaultMessage, Object rejectedValue) {
        bindException.addError(new FieldError(bindException.getObjectName(), fieldName, rejectedValue, true, null, null, defaultMessage));
    }

    /**
     * BindException��FieldError(�K�{)��ǉ����܂�
     * @param fieldName �G���[�t�B�[���h��
     * @param bindException the bindException to set
     * @param rejectedValue �G���[�ɂȂ����I�u�W�F�N�g
     */
    public static void addFieldErrorAsRequired(String fieldName, BindException bindException, Object rejectedValue) {
        addFieldError(fieldName, bindException, "required", rejectedValue);
    }

    /**
     * BindException��FieldError(�t�H�[�}�b�g)��ǉ����܂�
     * @param fieldName �G���[�t�B�[���h��
     * @param bindException the bindException to set
     * @param rejectedValue �G���[�ɂȂ����I�u�W�F�N�g
     */
    public static void addFieldErrorAsFormat(String fieldName, BindException bindException, Object rejectedValue) {
        addFieldError(fieldName, bindException, "format", rejectedValue);
    }

    /**
     * BindException��FieldError(maxLength)��ǉ����܂�
     * @param fieldName �G���[�t�B�[���h��
     * @param bindException the bindException to set
     * @param rejectedValue �G���[�ɂȂ����I�u�W�F�N�g
     */
    public static void addFieldErrorAsMaxLength(String fieldName, BindException bindException, Object rejectedValue) {
        addFieldError(fieldName, bindException, "max.length", rejectedValue);
    }

    /**
     * BindException��FieldError(�K�{)��ǉ����܂�
     * @param fieldName �G���[�t�B�[���h��
     * @param bindException the bindException to set
     */
    public static void addFieldErrorAsRequired(String fieldName, BindException bindException) {
        addFieldError(fieldName, bindException, "required", null);
    }

    /**
     * BindException��FieldError(�t�H�[�}�b�g)��ǉ����܂�
     * @param fieldName �G���[�t�B�[���h��
     * @param bindException the bindException to set
     */
    public static void addFieldErrorAsFormat(String fieldName, BindException bindException) {
        addFieldError(fieldName, bindException, "format", null);
    }

    /**
     * BindException��FieldError(maxLength)��ǉ����܂�
     * @param fieldName �G���[�t�B�[���h��
     * @param bindException the bindException to set
     */
    public static void addFieldErrorAsMaxLength(String fieldName, BindException bindException) {
        addFieldError(fieldName, bindException, "max.length", null);
    }
}
