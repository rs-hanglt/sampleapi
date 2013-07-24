/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract.
 */
package jp.gmor.research.sampleapi.common.constant;

/**
 * 共通定数定義クラス
 * @author usr160056
 * @since 2013/07/09 phase 2.0
 */
public class CommonConstants {

    // locale
    //////////

    /** locale ja */
    public static final String LOCALE_JA = "ja";

    /** locale en */
    public static final String LOCALE_EN = "en";

    // DB
    //////

    // company
    /** company.company_id : GMOR */
    public static final Integer COMPANY_COMPANY_ID_GMOR = 10;

    /** company select時のlimitデフォルト */
    public static final Integer COMPANY_SELECT_LIMIT_DEFAULT = 50;

    // company_panel_display_mst
    /** company_panel_display_mst.default_select_kbn : use */
    public static final String COMPANY_PANEL_DISPLAY_MST_DEFAULT_SELECT_KBN_USE = "1";

    /** company_panel_display_mst.default_select_kbn : not_use */
    public static final String COMPANY_PANEL_DISPLAY_MST_DEFAULT_SELECT_KBN_NOT_USE = "0";

    /** company_panel_display_mst.default_select_kbn : exclude */
    public static final String COMPANY_PANEL_DISPLAY_MST_DEFAULT_SELECT_KBN_EXCLUDE = "2";

}
