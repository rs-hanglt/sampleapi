/*-
 * Copyright (c) 2004-2012 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract.
 */
package jp.gmor.research.sampleapi.publicgate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import jp.gmor.research.framework.core.api.domain.MygmorApiRequestDto;
import jp.gmor.research.framework.core.api.domain.MygmorApiResponseDto;
import jp.gmor.research.framework.test.service.AbstractServiceTestCase;
import jp.gmor.research.sampleapi.company_select.domain.CompanySelectRequestDto;
import jp.gmor.research.security.utils.SegmEncryptUtil;
import net.arnx.jsonic.JSON;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;

/**
 * @author kamachi
 * @since 2012/08/30
 */
public class CompanySelectFacadeTest
        extends AbstractServiceTestCase {

    /** result日付フォーマット */
    DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    /** テスト対象 */
    private CompanySelectFacade target;

    /**
     * コンストラクター
     * @param name 名
     */
    public CompanySelectFacadeTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.target = super.getServiceBean(CompanySelectFacade.class);
    }

    /** {@inheritDoc} */
    @Override
    protected IDataSet getIDataSet() throws Exception {
        return new XlsDataSet(getClass().getResourceAsStream("CompanySelectFacade.xls"));
    }

    /**
     * 検索の正常系テスト
     * 
     * @throws Exception 例外
     */
    @SuppressWarnings("unchecked")
    public void testCreate1() throws Exception {

        CompanySelectRequestDto requestDto = new CompanySelectRequestDto();
        requestDto.setUser_company_id("111");
        requestDto.setCompany_id("111");
        requestDto.setCompany_nm("comp");
        requestDto.setRegist_date_from("2011-01-01");
        requestDto.setRegist_date_to("2012-01-01");
        requestDto.setLimit("10");
        requestDto.setOffset("0");

        MygmorApiRequestDto apiRequest = new MygmorApiRequestDto();
        apiRequest.setP(SegmEncryptUtil.encrypt(JSON.encode(requestDto)));
        apiRequest.setT("20130701173030");

        MygmorApiResponseDto response = target.create(apiRequest);

        assertEquals("0", response.getStatus());
        assertEquals("success", response.getMessage());
        Map<String, Object> resultObject = (Map<String, Object>)response.getResult();
        List<Map<String, Object>> companyList = (List<Map<String, Object>>)resultObject.get("companies");
        assertEquals(1, companyList.size());

        Map<String, Object> company1 = companyList.get(0);
        assertEquals("111", String.valueOf(company1.get("company_id")));
        assertEquals("comp01", String.valueOf(company1.get("company_nm")));
        assertEquals("2011/07/01 13:00:00", String.valueOf(company1.get("regist_date")));
        assertEquals("regist_user_test", String.valueOf(company1.get("regist_user")));

        assertEquals(1, ((Integer)resultObject.get("total_count")).intValue());

        assertEquals(apiRequest.getT(), response.getTimestamp());
    }

    /**
     * validationテスト
     * <pre>
     * 必須
     * </pre>
     * 
     * @throws Exception 例外
     */
    @SuppressWarnings("unchecked")
    public void testValidation1() throws Exception {

        CompanySelectRequestDto requestDto = new CompanySelectRequestDto();

        MygmorApiRequestDto apiRequest = new MygmorApiRequestDto();
        apiRequest.setP(SegmEncryptUtil.encrypt(JSON.encode(requestDto)));
        apiRequest.setT("20120710173030");

        MygmorApiResponseDto response = target.create(apiRequest);

        assertEquals("-100", response.getStatus());
        assertTrue(response.getMessage().contains("bad parameters."));
        assertTrue(response.getMessage().contains("user_company_id(required)"));
        assertEquals(1, response.getMessage().split(",").length);

        assertEquals(apiRequest.getT(), response.getTimestamp());
    }

    /**
     * validationテスト
     * <pre>
     * length
     * </pre>
     * 
     * @throws Exception 例外
     */
    @SuppressWarnings("unchecked")
    public void testValidation2() throws Exception {

        CompanySelectRequestDto requestDto = new CompanySelectRequestDto();
        requestDto.setUser_company_id("111");
        requestDto.setCompany_nm("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456");

        MygmorApiRequestDto apiRequest = new MygmorApiRequestDto();
        apiRequest.setP(SegmEncryptUtil.encrypt(JSON.encode(requestDto)));
        apiRequest.setT("20120710173030");

        MygmorApiResponseDto response = target.create(apiRequest);

        assertEquals("-100", response.getStatus());
        assertTrue(response.getMessage().contains("bad parameters."));
        assertTrue(response.getMessage().contains("company_nm(length)"));
        assertEquals(1, response.getMessage().split(",").length);

        assertEquals(apiRequest.getT(), response.getTimestamp());
    }

    /**
     * validationテスト
     * <pre>
     * 形式
     * </pre>
     * 
     * @throws Exception 例外
     */
    @SuppressWarnings("unchecked")
    public void testValidation3() throws Exception {

        CompanySelectRequestDto requestDto = new CompanySelectRequestDto();
        requestDto.setUser_company_id("2147483648");
        requestDto.setCompany_id("2147483648");
        requestDto.setRegist_date_from("2011/01/01");
        requestDto.setRegist_date_to("2012/01/01");
        requestDto.setLimit("a");
        requestDto.setOffset("a");

        MygmorApiRequestDto apiRequest = new MygmorApiRequestDto();
        apiRequest.setP(SegmEncryptUtil.encrypt(JSON.encode(requestDto)));
        apiRequest.setT("20120710173030");

        MygmorApiResponseDto response = target.create(apiRequest);

        assertEquals("-100", response.getStatus());
        assertTrue(response.getMessage().contains("bad parameters."));
        assertTrue(response.getMessage().contains("company_id(format)"));
        assertTrue(response.getMessage().contains("user_company_id(format)"));
        assertTrue(response.getMessage().contains("regist_date_from(format)"));
        assertTrue(response.getMessage().contains("regist_date_to(format)"));
        assertTrue(response.getMessage().contains("limit(format)"));
        assertTrue(response.getMessage().contains("offset(format)"));

        assertEquals(6, response.getMessage().split(",").length);

        assertEquals(apiRequest.getT(), response.getTimestamp());
    }

    /**
     * validationテスト
     * <pre>
     * 限界値
     * </pre>
     * 
     * @throws Exception 例外
     */
    @SuppressWarnings("unchecked")
    public void testValidation4() throws Exception {

        CompanySelectRequestDto requestDto = new CompanySelectRequestDto();
        requestDto.setUser_company_id("2147483647");
        requestDto.setCompany_id("2147483647");
        requestDto.setCompany_nm("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345");
        requestDto.setLimit("2147483647");
        requestDto.setOffset("2147483647");

        MygmorApiRequestDto apiRequest = new MygmorApiRequestDto();
        apiRequest.setP(SegmEncryptUtil.encrypt(JSON.encode(requestDto)));
        apiRequest.setT("20120710173030");

        MygmorApiResponseDto response = target.create(apiRequest);

        assertEquals("0", response.getStatus());
        assertEquals("success", response.getMessage());

        assertEquals(apiRequest.getT(), response.getTimestamp());
    }
}
