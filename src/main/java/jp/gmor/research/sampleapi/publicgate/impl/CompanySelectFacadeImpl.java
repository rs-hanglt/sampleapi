/*-
 * Copyright (c) 2004-2013 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.publicgate.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.gmor.research.framework.core.exception.application.ServiceException;
import jp.gmor.research.framework.tools.util.StringUtil;
import jp.gmor.research.sampleapi.common.domain.CompanyDto;
import jp.gmor.research.sampleapi.common.domain.CompanySelectorConditionBean;
import jp.gmor.research.sampleapi.common.facade.AbstractSampleFacade;
import jp.gmor.research.sampleapi.common.service.CompanySelectService;
import jp.gmor.research.sampleapi.company_select.domain.CompanySelectRequestDto;
import jp.gmor.research.sampleapi.publicgate.CompanySelectFacade;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * @author usr160056
 * @since 2013/07/09 phase 2.0
 */
public class CompanySelectFacadeImpl
        extends AbstractSampleFacade<CompanySelectRequestDto>
        implements CompanySelectFacade {

    private CompanySelectService companySelectService;

    /** {@inheritDoc} */
    @Override
    protected Object createImpl(CompanySelectRequestDto requestDto) throws ServiceException {

        // 会社情報の検索
        companySelectService.setConditionBean(createCompanySelectorCondtionBean(requestDto));
        List<CompanyDto> companyList = companySelectService.service();

        // 全件数を取得
        int totalCount = companySelectService.getTotalCount();

        // resultオブジェクトを生成
        return createResult(companyList, totalCount);
    }

    /**
     * 会社検索条件を生成します。
     * @param requestDto リクエストパラメーター
     * @return 会社検索条件
     */
    private CompanySelectorConditionBean createCompanySelectorCondtionBean(CompanySelectRequestDto requestDto) {
        CompanySelectorConditionBean companySelectorConditionBean = new CompanySelectorConditionBean();

        companySelectorConditionBean.setUserCompanyId(Integer.valueOf(requestDto.getUser_company_id()));

        if (!StringUtil.isEmptyTrim(requestDto.getCompany_id())) {
            companySelectorConditionBean.setCompanyId(Integer.valueOf(requestDto.getCompany_id()));
        }

        if (!StringUtil.isEmptyTrim(requestDto.getCompany_nm())) {
            companySelectorConditionBean.setCompanyId(Integer.valueOf(requestDto.getCompany_id()));
        }

        companySelectorConditionBean.setCompanyNm(requestDto.getCompany_nm());

        // 日付項目は日本時間でyyyy-MM-dd形式で渡されてくる事を想定しています
        if (!StringUtil.isEmptyTrim(requestDto.getRegist_date_from())) {
            companySelectorConditionBean.setRegistDateFrom(getDate(requestDto.getRegist_date_from(), "yyyy-MM-dd"));
        }
        if (!StringUtil.isEmptyTrim(requestDto.getRegist_date_to())) {
            companySelectorConditionBean.setRegistDateTo(getDate(requestDto.getRegist_date_to(), "yyyy-MM-dd"));
        }

        if (!StringUtil.isEmpty(requestDto.getLimit())) {
            companySelectorConditionBean.setLimit(Integer.valueOf(requestDto.getLimit()));
        }
        if (!StringUtil.isEmpty(requestDto.getOffset())) {
            companySelectorConditionBean.setOffset(Integer.valueOf(requestDto.getOffset()));
        }
        return companySelectorConditionBean;
    }

    /**
     * 日付文字列を指定のフォーマットでパースして日付オブジェクトを返却します
     * @param dateString 日付文字列
     * @param dateFormat 日付フォーマット
     * @return 日付オブジェクト 形式不正の場合はnullを返却します
     */
    private Date getDate(String dateString, String dateFormat) {
        DateFormat format = new SimpleDateFormat(dateFormat);
        Date targetDate = null;
        try {
            targetDate = format.parse(dateString);
        } catch (ParseException e) {
            //バリデーションチェックを行っているためnullを返す事はありえない
            return null;
        }
        return targetDate;
    }

    /**
     * resultオブジェクトを生成します。
     * @param companyDtoList 会社情報
     * @param totalCount 総件数
     * @return resultオブジェクト
     */
    private Map<String, Object> createResult(List<CompanyDto> companyDtoList, int totalCount) {
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        List<Map<String, Object>> companyList = new ArrayList<Map<String, Object>>();
        for (CompanyDto companyDto : companyDtoList) {
            Map<String, Object> company = new LinkedHashMap<String, Object>();
            company.put("company_id", companyDto.getCompany_id());
            company.put("company_nm", StringUtils.defaultString(companyDto.getCompany_nm()));
            company.put("regist_date", DateFormatUtils.format(companyDto.getRegist_date(), "yyyy/MM/dd HH:mm:ss"));
            company.put("regist_user", companyDto.getRegist_user());
            companyList.add(company);
        }
        result.put("companies", companyList);
        result.put("total_count", totalCount);

        return result;
    }

    /**
     * @param companySelectService the companySelectService to set
     */
    public void setCompanySelectService(CompanySelectService companySelectService) {
        this.companySelectService = companySelectService;
    }

}
