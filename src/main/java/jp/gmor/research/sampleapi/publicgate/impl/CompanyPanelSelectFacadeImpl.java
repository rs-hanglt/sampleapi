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
        // パネル情報(会社)を取得
        companyPanelDisplayMstSelectService.setParameter(Integer.valueOf(requestDto.getCompany_id()), requestDto.getCountry_cd());
        List<CompanyPanelDisplayMstDto> companyPanelDisplayMstDtoList = companyPanelDisplayMstSelectService.service();
        // resultオブジェクトを生成
        return createResult(companyPanelDisplayMstDtoList);
    }

    /**
     * resultオブジェクトを生成します。
     * @param companyPanelDisplayMstDtoList 会社に紐付くパネル情報
     * @return resultオブジェクト
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
     * 指定された利用種別のパネルグループIDリストを生成します
     * @param companyPanelDisplayMstDtoList 会社パネル情報
     * @param defaultSelectKbn 利用種別
     * @return 指定された利用種別のパネルグループIDリスト
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
     * 指定されたパネルグループIDのパネル情報を会社別パネル情報から取得し設定します
     * @param panelGroupId パネルグループID
     * @param companyPanelDisplayMstDtoList 会社別パネル情報
     * @param panelList 利用パネル、未使用パネル、除外パネルのマップ
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
