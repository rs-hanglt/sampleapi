/*-
 * Copyright (c) 2004-2013 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract.
 */
package jp.gmor.research.sampleapi.common.service;

import java.text.SimpleDateFormat;
import java.util.List;

import jp.gmor.research.framework.test.service.AbstractServiceTestCase;
import jp.gmor.research.sampleapi.common.domain.CompanyDto;
import jp.gmor.research.sampleapi.common.domain.CompanySelectorConditionBean;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;

/**
 * 
 * @author usr160056
 * @since 2013/07/09 phase 2.0
 */
public class CompanySelectServiceTest
        extends AbstractServiceTestCase {

    /** テスト対象 */
    private CompanySelectService target;

    /**
     * コンストラクター
     * @param name 名
     */
    public CompanySelectServiceTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.target = super.getServiceBean(CompanySelectService.class);
    }

    /** {@inheritDoc} */
    @Override
    protected IDataSet getIDataSet() throws Exception {
        return new XlsDataSet(getClass().getResourceAsStream("CompanySelectService.xls"));
    }

    /**
     * 管理権限ありのユーザが自分の会社IDを指定して検索
     * 全ての項目が正しく取得出来るか検証
     * 件数取得の検証も行う
     * @throws Exception 例外
     */
    @SuppressWarnings("unchecked")
    public void testService() throws Exception {
        CompanySelectorConditionBean bean = new CompanySelectorConditionBean();
        bean.setCompanyId(111);
        bean.setUserCompanyId(111);

        target.setConditionBean(bean);
        List<CompanyDto> results = target.service();
        assertEquals(1, results.size());
        assertEquals(111, results.get(0).getCompany_id().intValue());
        assertEquals("comp01", results.get(0).getCompany_nm());
        assertEquals("0", results.get(0).getDelete_flg());
        assertEquals("1", results.get(0).getUse_matter_type());
        assertEquals(9.9, results.get(0).getCollectnum_coefficient().doubleValue());
        assertEquals("name_kj_test", results.get(0).getName_kj());
        assertEquals("name_kn_test", results.get(0).getName_kn());
        assertEquals("1", results.get(0).getAdmin_auth_flg());
        assertEquals("0", results.get(0).getOrder_auth_flg());
        assertEquals("0", results.get(0).getResend_policy_auth_flg());
        assertEquals("0", results.get(0).getInactive_order_auth_flg());
        assertEquals("note_test", results.get(0).getNote());
        assertEquals("regist_user_test", results.get(0).getRegist_user());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        assertEquals("20110701", format.format(results.get(0).getRegist_date()));
        assertEquals("update_user_test", results.get(0).getUpdate_user());
        assertEquals("20110701", format.format(results.get(0).getUpdate_date()));

        assertEquals(1, target.getTotalCount());

    }

    /**
     * 全ての条件を指定して検索
     * 件数取得の検証も行う
     * @throws Exception 例外
     */
    @SuppressWarnings("unchecked")
    public void testService2() throws Exception {

        CompanySelectorConditionBean bean = new CompanySelectorConditionBean();
        bean.setCompanyId(114);
        bean.setUserCompanyId(114);
        bean.setCompanyNm("omp9");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        bean.setRegistDateFrom(format.parse("20130114"));
        bean.setRegistDateTo(format.parse("20130117"));
        bean.setLimit(1);
        bean.setOffset(0);
        target.setConditionBean(bean);
        List<CompanyDto> results = target.service();
        assertEquals(1, results.size());
        assertEquals(114, results.get(0).getCompany_id().intValue());

        assertEquals(1, target.getTotalCount());

    }

}
