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
     * Objectのリストに対して必須チェックを実行します
     * @param targetList チェック対象のリスト
     * @return true:OK, false:NG
     */
    public static boolean requiredInList(List< ? extends Object> targetList) {
        if (CollectionUtils.isEmpty(targetList)) {
            return false;
        }
        return true;
    }

    /**
     * Objectのリストに対して必須チェックを実行します
     * @param targetList チェック対象のリスト
     * @param fieldName フィールド
     * @param bindException パラメータの不正
     */
    public static void requiredInList(List< ? extends Object> targetList, String fieldName, BindException bindException) {
        if (!requiredInList(targetList)) {
            bindException.rejectValue(fieldName, null, "required");
        }
    }

    /**
     * Stringのリストに対してIntegerとして評価できるかチェックを実行します
     * @param targetList チェック対象のリスト
     * @return true:OK, false:NG
     */
    public static boolean isIntegerInStringList(List<String> targetList) {
        return isIntegerInStringList(targetList, true);
    }

    /**
     * 
     * Stringのリストに対してIntegerとして評価できるかチェックを実行します
     * @param targetList チェック対象のリスト
     * @param forgiveBlank null or 空文字を許容するか（trueを指定した場合、対象がnullもしくは空文字でもエラーとしません）
     * @return true:OK, false:NG
     */
    public static boolean isIntegerInStringList(List<String> targetList, boolean forgiveBlank) {
        if (CollectionUtils.isEmpty(targetList)) {
            return true;
        }
        for (String target : targetList) {
            // null or 空文字を許容しない場合、null or 空文字をチェック
            if (!forgiveBlank) {
                if (StringUtil.isEmptyTrim(target)) {
                    return false;
                }
            }
            // Integerとして評価できるかチェック
            if (!StringUtil.isEmptyTrim(target) && !GenericValidator.isInt(target)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Stringのリストに対してIntegerとして評価できるかチェックを実行します
     * @param targetList チェック対象のリスト
     * @param fieldName フィールド
     * @param bindException パラメータの不正
     */
    public static void isIntegerInStringList(List<String> targetList, String fieldName, BindException bindException) {
        if (!isIntegerInStringList(targetList)) {
            bindException.rejectValue(fieldName, null, "format");
        }
    }

    /**
     * Stringのリストに対してIntegerとして評価できるかチェックを実行します
     * @param targetList チェック対象のリスト
     * @param forgiveBlank null or 空文字を許容するか（trueを指定した場合、対象がnullもしくは空文字でもエラーとしません）
     * @param fieldName フィールド
     * @param bindException パラメータの不正
     */
    public static void isIntegerInStringList(List<String> targetList, boolean forgiveBlank, String fieldName, BindException bindException) {
        if (!isIntegerInStringList(targetList, forgiveBlank)) {
            bindException.rejectValue(fieldName, null, "format");
        }
    }

    /**
     * Stringのリストに対して文字数チェックを実行します
     * @param targetList チェック対象のリスト
     * @param maxLength 最大文字数
     * @param forgiveBlank null or 空文字を許容するか（trueを指定した場合、対象がnullもしくは空文字でもエラーとしません）
     * @return true:OK, false:NG
     */
    public static boolean isMaxLengthInStringList(List<String> targetList, int maxLength, boolean forgiveBlank) {
        if (CollectionUtils.isEmpty(targetList)) {
            return true;
        }
        for (String target : targetList) {
            // null or 空文字を許容しない場合、null or 空文字をチェック
            if (!forgiveBlank) {
                if (StringUtil.isEmptyTrim(target)) {
                    return false;
                }
            }
            // 文字数チェック
            if (target != null && target.length() > maxLength) {
                return false;
            }
        }
        return true;
    }

    /**
     * Stringのリストに対して文字数チェックを実行します
     * @param targetList チェック対象のリスト
     * @param maxLength 最大文字数
     * @return true:OK, false:NG
     */
    public static boolean isMaxLengthInStringList(List<String> targetList, int maxLength) {
        return isMaxLengthInStringList(targetList, maxLength, true);
    }

    /**
     * Stringのリストに対して文字数チェックを実行します
     * @param targetList チェック対象のリスト
     * @param maxLength 最大文字数
     * @param fieldName フィールド
     * @param bindException パラメータの不正
     */
    public static void isMaxLengthInStringList(List<String> targetList, int maxLength, String fieldName, BindException bindException) {
        if (!isMaxLengthInStringList(targetList, maxLength)) {
            bindException.rejectValue(fieldName, null, "max.length");
        }
    }

    /**
     * Stringのリストに対して文字数チェックを実行します
     * @param targetList チェック対象のリスト
     * @param maxLength 最大文字数
     * @param forgiveBlank null or 空文字を許容するか（trueを指定した場合、対象がnullもしくは空文字でもエラーとしません）
     * @param fieldName フィールド
     * @param bindException パラメータの不正
     */
    public static void isMaxLengthInStringList(List<String> targetList, int maxLength, boolean forgiveBlank, String fieldName, BindException bindException) {
        if (!isMaxLengthInStringList(targetList, maxLength, forgiveBlank)) {
            bindException.rejectValue(fieldName, null, "max.length");
        }
    }

    /**
     * Stringのリストに対して正規表現チェックを実行します
     * @param targetList チェック対象のリスト
     * @param regex 正規表現文字列
     * @return true:OK, false:NG
     */
    public static boolean isMatchInStringList(List<String> targetList, String regex) {
        return isMatchInStringList(targetList, regex, true);
    }

    /**
     * Stringのリストに対して正規表現チェックを実行します
     * @param targetList チェック対象のリスト
     * @param regex 正規表現文字列
     * @param forgiveBlank null or 空文字を許容するか（trueを指定した場合、対象がnullもしくは空文字でもエラーとしません）
     * @return true:OK, false:NG
     */
    public static boolean isMatchInStringList(List<String> targetList, String regex, boolean forgiveBlank) {
        if (CollectionUtils.isEmpty(targetList)) {
            return true;
        }
        for (String target : targetList) {
            // null or 空文字を許容しない場合、null or 空文字をチェック
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
     * BindExceptionにFieldErrorを追加します
     * @param fieldName エラーフィールド名
     * @param bindException the bindException to set
     * @param defaultMessage エラーメッセージキー
     * @param rejectedValue エラーになったオブジェクト
     */
    public static void addFieldError(String fieldName, BindException bindException, String defaultMessage, Object rejectedValue) {
        bindException.addError(new FieldError(bindException.getObjectName(), fieldName, rejectedValue, true, null, null, defaultMessage));
    }

    /**
     * BindExceptionにFieldError(必須)を追加します
     * @param fieldName エラーフィールド名
     * @param bindException the bindException to set
     * @param rejectedValue エラーになったオブジェクト
     */
    public static void addFieldErrorAsRequired(String fieldName, BindException bindException, Object rejectedValue) {
        addFieldError(fieldName, bindException, "required", rejectedValue);
    }

    /**
     * BindExceptionにFieldError(フォーマット)を追加します
     * @param fieldName エラーフィールド名
     * @param bindException the bindException to set
     * @param rejectedValue エラーになったオブジェクト
     */
    public static void addFieldErrorAsFormat(String fieldName, BindException bindException, Object rejectedValue) {
        addFieldError(fieldName, bindException, "format", rejectedValue);
    }

    /**
     * BindExceptionにFieldError(maxLength)を追加します
     * @param fieldName エラーフィールド名
     * @param bindException the bindException to set
     * @param rejectedValue エラーになったオブジェクト
     */
    public static void addFieldErrorAsMaxLength(String fieldName, BindException bindException, Object rejectedValue) {
        addFieldError(fieldName, bindException, "max.length", rejectedValue);
    }

    /**
     * BindExceptionにFieldError(必須)を追加します
     * @param fieldName エラーフィールド名
     * @param bindException the bindException to set
     */
    public static void addFieldErrorAsRequired(String fieldName, BindException bindException) {
        addFieldError(fieldName, bindException, "required", null);
    }

    /**
     * BindExceptionにFieldError(フォーマット)を追加します
     * @param fieldName エラーフィールド名
     * @param bindException the bindException to set
     */
    public static void addFieldErrorAsFormat(String fieldName, BindException bindException) {
        addFieldError(fieldName, bindException, "format", null);
    }

    /**
     * BindExceptionにFieldError(maxLength)を追加します
     * @param fieldName エラーフィールド名
     * @param bindException the bindException to set
     */
    public static void addFieldErrorAsMaxLength(String fieldName, BindException bindException) {
        addFieldError(fieldName, bindException, "max.length", null);
    }
}
