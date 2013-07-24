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

        // ��Џ��̌���
        companySelectService.setConditionBean(createCompanySelectorCondtionBean(requestDto));
        List<CompanyDto> companyList = companySelectService.service();

        // �S�������擾
        int totalCount = companySelectService.getTotalCount();

        // result�I�u�W�F�N�g�𐶐�
        return createResult(companyList, totalCount);
    }

    /**
     * ��Ќ��������𐶐����܂��B
     * @param requestDto ���N�G�X�g�p�����[�^�[
     * @return ��Ќ�������
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

        // ���t���ڂ͓��{���Ԃ�yyyy-MM-dd�`���œn����Ă��鎖��z�肵�Ă��܂�
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
     * ���t��������w��̃t�H�[�}�b�g�Ńp�[�X���ē��t�I�u�W�F�N�g��ԋp���܂�
     * @param dateString ���t������
     * @param dateFormat ���t�t�H�[�}�b�g
     * @return ���t�I�u�W�F�N�g �`���s���̏ꍇ��null��ԋp���܂�
     */
    private Date getDate(String dateString, String dateFormat) {
        DateFormat format = new SimpleDateFormat(dateFormat);
        Date targetDate = null;
        try {
            targetDate = format.parse(dateString);
        } catch (ParseException e) {
            //�o���f�[�V�����`�F�b�N���s���Ă��邽��null��Ԃ����͂��肦�Ȃ�
            return null;
        }
        return targetDate;
    }

    /**
     * result�I�u�W�F�N�g�𐶐����܂��B
     * @param companyDtoList ��Џ��
     * @param totalCount ������
     * @return result�I�u�W�F�N�g
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
