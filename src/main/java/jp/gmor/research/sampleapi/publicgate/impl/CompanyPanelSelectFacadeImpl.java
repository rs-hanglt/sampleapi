/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract. 
 */
package jp.gmor.research.sampleapi.publicgate.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.gmor.research.framework.core.exception.application.ServiceException;
import jp.gmor.research.sampleapi.common.constant.CommonConstants;
import jp.gmor.research.sampleapi.common.domain.CompanyPanelDisplayMstDto;
import jp.gmor.research.sampleapi.common.facade.AbstractSampleFacade;
import jp.gmor.research.sampleapi.common.service.CompanyPanelDisplayMstSelectService;
import jp.gmor.research.sampleapi.company_panel_select.domain.CompanyPanelSelectRequestDto;
import jp.gmor.research.sampleapi.publicgate.CompanyPanelSelectFacade;

import org.apache.commons.lang.StringUtils;

/**
 * @author terasawa
 * @since 2013/07/08 phase 2.0
 */
public class CompanyPanelSelectFacadeImpl
        extends AbstractSampleFacade<CompanyPanelSelectRequestDto>
        implements CompanyPanelSelectFacade {

    private CompanyPanelDisplayMstSelectService companyPanelDisplayMstSelectService;

    /** {@inheritDoc} */
    @Override
    protected Object createImpl(CompanyPanelSelectRequestDto requestDto) throws ServiceException {
        // �p�l�����(���)���擾
        companyPanelDisplayMstSelectService.setParameter(Integer.valueOf(requestDto.getCompany_id()), requestDto.getCountry_cd());
        List<CompanyPanelDisplayMstDto> companyPanelDisplayMstDtoList = companyPanelDisplayMstSelectService.service();
        // result�I�u�W�F�N�g�𐶐�
        return createResult(companyPanelDisplayMstDtoList);
    }

    /**
     * result�I�u�W�F�N�g�𐶐����܂��B
     * @param companyPanelDisplayMstDtoList ��ЂɕR�t���p�l�����
     * @return result�I�u�W�F�N�g
     */
    private Map<String, Object> createResult(List<CompanyPanelDisplayMstDto> companyPanelDisplayMstDtoList) {
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        List<Map<String, Object>> usePanelList = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> notUsePanelList = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> excludePanelList = new ArrayList<Map<String, Object>>();
        for (String panelGroupId : createPanelGroupIdListFromCompanyPanelDisplayMst(companyPanelDisplayMstDtoList, CommonConstants.COMPANY_PANEL_DISPLAY_MST_DEFAULT_SELECT_KBN_USE)) {
            setPanelGroupMap(panelGroupId, companyPanelDisplayMstDtoList, usePanelList);
        }
        for (String panelGroupId : createPanelGroupIdListFromCompanyPanelDisplayMst(companyPanelDisplayMstDtoList, CommonConstants.COMPANY_PANEL_DISPLAY_MST_DEFAULT_SELECT_KBN_NOT_USE)) {
            setPanelGroupMap(panelGroupId, companyPanelDisplayMstDtoList, notUsePanelList);
        }
        for (String panelGroupId : createPanelGroupIdListFromCompanyPanelDisplayMst(companyPanelDisplayMstDtoList, CommonConstants.COMPANY_PANEL_DISPLAY_MST_DEFAULT_SELECT_KBN_EXCLUDE)) {
            setPanelGroupMap(panelGroupId, companyPanelDisplayMstDtoList, excludePanelList);
        }
        result.put("use_panels", usePanelList);
        result.put("not_use_panels", notUsePanelList);
        result.put("exclude_panels", excludePanelList);

        return result;
    }

    /**
     * �w�肳�ꂽ���p��ʂ̃p�l���O���[�vID���X�g�𐶐����܂�
     * @param companyPanelDisplayMstDtoList ��Ѓp�l�����
     * @param defaultSelectKbn ���p���
     * @return �w�肳�ꂽ���p��ʂ̃p�l���O���[�vID���X�g
     */
    private List<String> createPanelGroupIdListFromCompanyPanelDisplayMst(List<CompanyPanelDisplayMstDto> companyPanelDisplayMstDtoList, String defaultSelectKbn) {
        List<String> panelGroupList = new ArrayList<String>();
        for (CompanyPanelDisplayMstDto companyPanelDisplayMstDto : companyPanelDisplayMstDtoList) {
            if (defaultSelectKbn.equals(companyPanelDisplayMstDto.getDefault_select_kbn())) {
                panelGroupList.add(String.valueOf(companyPanelDisplayMstDto.getPanel_group_id()));
            }
        }
        return panelGroupList;
    }

    /**
     * �w�肳�ꂽ�p�l���O���[�vID�̃p�l��������Еʃp�l����񂩂�擾���ݒ肵�܂�
     * @param panelGroupId �p�l���O���[�vID
     * @param companyPanelDisplayMstDtoList ��Еʃp�l�����
     * @param panelList ���p�p�l���A���g�p�p�l���A���O�p�l���̃}�b�v
     */
    private void setPanelGroupMap(String panelGroupId, List<CompanyPanelDisplayMstDto> companyPanelDisplayMstDtoList, List<Map<String, Object>> panelList) {
        for (CompanyPanelDisplayMstDto companyPanelDisplayMstDto : companyPanelDisplayMstDtoList) {
            if (String.valueOf(companyPanelDisplayMstDto.getPanel_group_id()).equals(panelGroupId)) {
                Map<String, Object> panelGroupMap = new LinkedHashMap<String, Object>();
                panelGroupMap.put("panel_group_id", panelGroupId);
                panelGroupMap.put("display_name", StringUtils.defaultString(companyPanelDisplayMstDto.getDisplay_nm()));
                panelGroupMap.put("tooltip", StringUtils.defaultString(companyPanelDisplayMstDto.getTooltip_text()));
                panelList.add(panelGroupMap);
            }
        }
    }

    /**
     * @param companyPanelDisplayMstSelectService the companyPanelDisplayMstSelectService to set
     */
    public void setCompanyPanelDisplayMstSelectService(CompanyPanelDisplayMstSelectService companyPanelDisplayMstSelectService) {
        this.companyPanelDisplayMstSelectService = companyPanelDisplayMstSelectService;
    }
}
