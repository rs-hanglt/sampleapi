/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms;with or without
 * modification;is limited by contract. 
 */
package jp.gmor.research.sampleapi.common.domain;

import java.util.List;

import jp.gmor.research.framework.core.domain.BaseDomainObject;

/**
 * @author kamachi
 * @since 2012/08/29
 */
public class CompanyPanelDisplayMstDto
        extends BaseDomainObject {

    /** serialVersionUID */
    private static final long serialVersionUID = 5710012986120962868L;

    private Integer company_id;

    private Integer panel_group_id;

    private Integer display_order;

    private String display_nm;

    private String tooltip_text;

    private String default_select_kbn;

    private List<PanelTypeMstDto> panelTypeMstList;

    /**
     * @return the company_id
     */
    public Integer getCompany_id() {
        return company_id;
    }

    /**
     * @param company_id the company_id to set
     */
    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    /**
     * @return the panel_group_id
     */
    public Integer getPanel_group_id() {
        return panel_group_id;
    }

    /**
     * @param panel_group_id the panel_group_id to set
     */
    public void setPanel_group_id(Integer panel_group_id) {
        this.panel_group_id = panel_group_id;
    }

    /**
     * @return the display_order
     */
    public Integer getDisplay_order() {
        return display_order;
    }

    /**
     * @param display_order the display_order to set
     */
    public void setDisplay_order(Integer display_order) {
        this.display_order = display_order;
    }

    /**
     * @return the display_nm
     */
    public String getDisplay_nm() {
        return display_nm;
    }

    /**
     * @param display_nm the display_nm to set
     */
    public void setDisplay_nm(String display_nm) {
        this.display_nm = display_nm;
    }

    /**
     * @return the tooltip_text
     */
    public String getTooltip_text() {
        return tooltip_text;
    }

    /**
     * @param tooltip_text the tooltip_text to set
     */
    public void setTooltip_text(String tooltip_text) {
        this.tooltip_text = tooltip_text;
    }

    /**
     * @return the default_select_kbn
     */
    public String getDefault_select_kbn() {
        return default_select_kbn;
    }

    /**
     * @param default_select_kbn the default_select_kbn to set
     */
    public void setDefault_select_kbn(String default_select_kbn) {
        this.default_select_kbn = default_select_kbn;
    }

    /**
     * @return the panelTypeMstList
     */
    public List<PanelTypeMstDto> getPanelTypeMstList() {
        return panelTypeMstList;
    }

    /**
     * @param panelTypeMstList the panelTypeMstList to set
     */
    public void setPanelTypeMstList(List<PanelTypeMstDto> panelTypeMstList) {
        this.panelTypeMstList = panelTypeMstList;
    }

}
