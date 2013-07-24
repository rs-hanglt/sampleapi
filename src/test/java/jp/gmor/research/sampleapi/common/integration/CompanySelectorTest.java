/*-
 * Copyright (c) 2004-2013 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract.
 */
package jp.gmor.research.sampleapi.common.integration;

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
public class CompanySelectorTest
        extends AbstractServiceTestCase {

    /** �e�X�g�Ώ� */
    private CompanySelector target;

    /**
     * �R���X�g���N�^�[
     * @param name ��
     */
    public CompanySelectorTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.target = super.getServiceBean(CompanySelector.class);
    }

    /** {@inheritDoc} */
    @Override
    protected IDataSet getIDataSet() throws Exception {
        return new XlsDataSet(getClass().getResourceAsStream("CompanySelector.xls"));
    }

    /**
     * �Ǘ���������̃��[�U�������̉��ID���w�肵�Č���
     * �S�Ă̍��ڂ��������擾�o���邩����
     * �����擾�̌��؂��s��
     * @throws Exception ��O
     */
    @SuppressWarnings("unchecked")
    public void testFind1() throws Exception {
        CompanySelectorConditionBean bean = new CompanySelectorConditionBean();
        bean.setCompanyId(111);
        bean.setUserCompanyId(111);

        target.setConditionBean(bean);
        List<CompanyDto> results = target.findList();
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

        assertEquals(1, target.getCount());

    }

    /**
     * �Ǘ������Ȃ��̃��[�U�������̉��ID���w�肵�Č���
     * �����擾�̌��؂��s��
     * @throws Exception ��O
     */
    @SuppressWarnings("unchecked")
    public void testFind2() throws Exception {

        CompanySelectorConditionBean bean = new CompanySelectorConditionBean();
        bean.setCompanyId(112);
        bean.setUserCompanyId(112);

        target.setConditionBean(bean);
        List<CompanyDto> results = target.findList();
        assertEquals(1, results.size());
        assertEquals(112, results.get(0).getCompany_id().intValue());

        assertEquals(1, target.getCount());

    }

    /**
     * �Ǘ���������̃��[�U�������z���̉��ID���w�肵�Č���
     * �����擾�̌��؂��s��
     * @throws Exception ��O
     */
    @SuppressWarnings("unchecked")
    public void testFind3() throws Exception {

        CompanySelectorConditionBean bean = new CompanySelectorConditionBean();
        bean.setCompanyId(112);
        bean.setUserCompanyId(111);

        target.setConditionBean(bean);
        List<CompanyDto> results = target.findList();
        assertEquals(1, results.size());
        assertEquals(112, results.get(0).getCompany_id().intValue());

        assertEquals(1, target.getCount());

    }

    /**
     * �Ǘ���������̃��[�U�������z���łȂ����ID���w�肵�Č���
     * �����擾�̌��؂��s��
     * @throws Exception ��O
     */
    @SuppressWarnings("unchecked")
    public void testFind4() throws Exception {

        CompanySelectorConditionBean bean = new CompanySelectorConditionBean();
        bean.setCompanyId(113);
        bean.setUserCompanyId(111);

        target.setConditionBean(bean);
        List<CompanyDto> results = target.findList();
        assertEquals(0, results.size());

        assertEquals(0, target.getCount());

    }

    /**
     * �Ǘ������Ȃ��̃��[�U�������ȊO�̉��ID���w�肵�Č���
     * �����擾�̌��؂��s��
     * @throws Exception ��O
     */
    @SuppressWarnings("unchecked")
    public void testFind5() throws Exception {

        CompanySelectorConditionBean bean = new CompanySelectorConditionBean();
        bean.setCompanyId(111);
        bean.setUserCompanyId(112);

        target.setConditionBean(bean);
        List<CompanyDto> results = target.findList();
        assertEquals(0, results.size());

        assertEquals(0, target.getCount());

    }

    /**
     * �Ǘ���������̃��[�U�����ID���w�肹���Ɍ���
     * �����擾�̌��؂��s��
     * @throws Exception ��O
     */
    @SuppressWarnings("unchecked")
    public void testFind6() throws Exception {

        CompanySelectorConditionBean bean = new CompanySelectorConditionBean();
        bean.setUserCompanyId(111);

        target.setConditionBean(bean);
        List<CompanyDto> results = target.findList();
        assertEquals(2, results.size());
        assertEquals(111, results.get(0).getCompany_id().intValue());
        assertEquals(112, results.get(1).getCompany_id().intValue());

        assertEquals(2, target.getCount());
    }

    /**
     * �Ǘ������Ȃ��̃��[�U�����ID���w�肹���Ɍ���
     * �����擾�̌��؂��s��
     * @throws Exception ��O
     */
    @SuppressWarnings("unchecked")
    public void testFind7() throws Exception {

        CompanySelectorConditionBean bean = new CompanySelectorConditionBean();
        bean.setUserCompanyId(112);

        target.setConditionBean(bean);
        List<CompanyDto> results = target.findList();
        assertEquals(1, results.size());
        assertEquals(112, results.get(0).getCompany_id().intValue());

        assertEquals(1, target.getCount());

    }

    /**
     * �S�Ă̏������w�肵�Č���
     * �����擾�̌��؂��s��
     * @throws Exception ��O
     */
    @SuppressWarnings("unchecked")
    public void testFind8() throws Exception {

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
        List<CompanyDto> results = target.findList();
        assertEquals(1, results.size());
        assertEquals(114, results.get(0).getCompany_id().intValue());

        assertEquals(1, target.getCount());

    }

}
