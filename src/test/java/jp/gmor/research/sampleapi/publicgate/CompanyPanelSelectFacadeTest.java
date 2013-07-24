/*-
 * Copyright (c) 2004-2013 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract.
 */
package jp.gmor.research.sampleapi.publicgate;

import java.util.List;
import java.util.Map;

import jp.gmor.research.framework.core.api.domain.MygmorApiRequestDto;
import jp.gmor.research.framework.core.api.domain.MygmorApiResponseDto;
import jp.gmor.research.framework.test.service.AbstractServiceTestCase;
import jp.gmor.research.sampleapi.company_panel_select.domain.CompanyPanelSelectRequestDto;
import jp.gmor.research.security.utils.SegmEncryptUtil;
import net.arnx.jsonic.JSON;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;

/**
 * @author terasawa
 * @since 2013/07/08 phase 2.0
 */
public class CompanyPanelSelectFacadeTest
        extends AbstractServiceTestCase {

    /** テスト対象 */
    private CompanyPanelSelectFacade target;

    /**
     * コンストラクター
     * @param name 名
     */
    public CompanyPanelSelectFacadeTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.target = super.getServiceBean(CompanyPanelSelectFacade.class);
    }

    /** {@inheritDoc} */
    @Override
    protected IDataSet getIDataSet() throws Exception {
        //return new FlatXmlDataSet(getClass().getResourceAsStream("CompanyPanelSelectFacade.xml"));
        IDataSet dataSet = new XlsDataSet(getClass().getResourceAsStream("CompanyPanelSelectFacade.xls"));
        return dataSet;
    }

    /**
     * 検索の正常系テスト
     * 
     * @throws Exception 例外
     */
    @SuppressWarnings("unchecked")
    public void testFindXls() throws Exception {

        CompanyPanelSelectRequestDto requestDto = new CompanyPanelSelectRequestDto();
        requestDto.setCompany_id("111");
        requestDto.setCountry_cd("392");

        MygmorApiRequestDto apiRequest = new MygmorApiRequestDto();
        apiRequest.setP(SegmEncryptUtil.encrypt(JSON.encode(requestDto)));
        apiRequest.setT("20120710173030");

        MygmorApiResponseDto response = target.create(apiRequest);

        assertEquals("0", response.getStatus());
        assertEquals("success", response.getMessage());
        Map<String, Object> resultObject = (Map<String, Object>)response.getResult();
        List<Map<String, Object>> usePanelList = (List<Map<String, Object>>)resultObject.get("use_panels");

        assertEquals(2, usePanelList.size());
        assertEquals("2", String.valueOf(usePanelList.get(0).get("panel_group_id")));
        assertEquals("panel_group_2", String.valueOf(usePanelList.get(0).get("display_name")));
        assertEquals("tooltip2", String.valueOf(usePanelList.get(0).get("tooltip")));
        assertEquals("1", String.valueOf(usePanelList.get(1).get("panel_group_id")));
        assertEquals("panel_group_1", String.valueOf(usePanelList.get(1).get("display_name")));
        assertEquals("tooltip1", String.valueOf(usePanelList.get(1).get("tooltip")));

        List<Map<String, Object>> notUsePanelList = (List<Map<String, Object>>)resultObject.get("not_use_panels");
        assertEquals(3, notUsePanelList.size());
        assertEquals("4", String.valueOf(notUsePanelList.get(0).get("panel_group_id")));
        assertEquals("panel_group_4", String.valueOf(notUsePanelList.get(0).get("display_name")));
        assertEquals("tooltip4", String.valueOf(notUsePanelList.get(0).get("tooltip")));
        assertEquals("5", String.valueOf(notUsePanelList.get(1).get("panel_group_id")));
        assertEquals("panel_group_5", String.valueOf(notUsePanelList.get(1).get("display_name")));
        assertEquals("tooltip5", String.valueOf(notUsePanelList.get(1).get("tooltip")));
        assertEquals("6", String.valueOf(notUsePanelList.get(2).get("panel_group_id")));
        assertEquals("panel_group_6", String.valueOf(notUsePanelList.get(2).get("display_name")));
        assertEquals("tooltip6", String.valueOf(notUsePanelList.get(2).get("tooltip")));

        List<Map<String, Object>> excludePanelList = (List<Map<String, Object>>)resultObject.get("exclude_panels");
        assertEquals(1, excludePanelList.size());
        assertEquals("9", String.valueOf(excludePanelList.get(0).get("panel_group_id")));
        assertEquals("panel_group_9", String.valueOf(excludePanelList.get(0).get("display_name")));
        assertEquals("tooltip9", String.valueOf(excludePanelList.get(0).get("tooltip")));

        assertEquals(apiRequest.getT(), response.getTimestamp());
    }

    /**
     * 検索の正常系テスト
     * 
     * @throws Exception 例外
     */
    @SuppressWarnings("unchecked")
    public void testFind1() throws Exception {

        CompanyPanelSelectRequestDto requestDto = new CompanyPanelSelectRequestDto();
        requestDto.setCompany_id("111");
        requestDto.setCountry_cd("392");

        MygmorApiRequestDto apiRequest = new MygmorApiRequestDto();
        apiRequest.setP(SegmEncryptUtil.encrypt(JSON.encode(requestDto)));
        apiRequest.setT("20120710173030");

        MygmorApiResponseDto response = target.create(apiRequest);

        assertEquals("0", response.getStatus());
        assertEquals("success", response.getMessage());
        Map<String, Object> resultObject = (Map<String, Object>)response.getResult();
        List<Map<String, Object>> usePanelList = (List<Map<String, Object>>)resultObject.get("use_panels");

        assertEquals(2, usePanelList.size());
        assertEquals("2", String.valueOf(usePanelList.get(0).get("panel_group_id")));
        assertEquals("panel_group_2", String.valueOf(usePanelList.get(0).get("display_name")));
        assertEquals("tooltip2", String.valueOf(usePanelList.get(0).get("tooltip")));
        assertEquals("1", String.valueOf(usePanelList.get(1).get("panel_group_id")));
        assertEquals("panel_group_1", String.valueOf(usePanelList.get(1).get("display_name")));
        assertEquals("tooltip1", String.valueOf(usePanelList.get(1).get("tooltip")));

        List<Map<String, Object>> notUsePanelList = (List<Map<String, Object>>)resultObject.get("not_use_panels");
        assertEquals(3, notUsePanelList.size());
        assertEquals("4", String.valueOf(notUsePanelList.get(0).get("panel_group_id")));
        assertEquals("panel_group_4", String.valueOf(notUsePanelList.get(0).get("display_name")));
        assertEquals("tooltip4", String.valueOf(notUsePanelList.get(0).get("tooltip")));
        assertEquals("5", String.valueOf(notUsePanelList.get(1).get("panel_group_id")));
        assertEquals("panel_group_5", String.valueOf(notUsePanelList.get(1).get("display_name")));
        assertEquals("tooltip5", String.valueOf(notUsePanelList.get(1).get("tooltip")));
        assertEquals("6", String.valueOf(notUsePanelList.get(2).get("panel_group_id")));
        assertEquals("panel_group_6", String.valueOf(notUsePanelList.get(2).get("display_name")));
        assertEquals("tooltip6", String.valueOf(notUsePanelList.get(2).get("tooltip")));

        List<Map<String, Object>> excludePanelList = (List<Map<String, Object>>)resultObject.get("exclude_panels");
        assertEquals(1, excludePanelList.size());
        assertEquals("9", String.valueOf(excludePanelList.get(0).get("panel_group_id")));
        assertEquals("panel_group_9", String.valueOf(excludePanelList.get(0).get("display_name")));
        assertEquals("tooltip9", String.valueOf(excludePanelList.get(0).get("tooltip")));

        assertEquals(apiRequest.getT(), response.getTimestamp());
    }

    /**
     * 検索の正常系テスト
     * 
     * @throws Exception 例外
     */
    @SuppressWarnings("unchecked")
    public void testFind2() throws Exception {

        CompanyPanelSelectRequestDto requestDto = new CompanyPanelSelectRequestDto();
        requestDto.setCompany_id("11");
        requestDto.setCountry_cd("392");

        MygmorApiRequestDto apiRequest = new MygmorApiRequestDto();
        apiRequest.setP(SegmEncryptUtil.encrypt(JSON.encode(requestDto)));
        apiRequest.setT("20120710173030");

        MygmorApiResponseDto response = target.create(apiRequest);

        assertEquals("0", response.getStatus());
        assertEquals("success", response.getMessage());
        Map<String, Object> resultObject = (Map<String, Object>)response.getResult();
        List<Map<String, Object>> usePanelList = (List<Map<String, Object>>)resultObject.get("use_panels");
        assertEquals(0, usePanelList.size());

        List<Map<String, Object>> notUsePanelList = (List<Map<String, Object>>)resultObject.get("not_use_panels");
        assertEquals(0, notUsePanelList.size());

        List<Map<String, Object>> excludePanelList = (List<Map<String, Object>>)resultObject.get("exclude_panels");
        assertEquals(0, excludePanelList.size());

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

        CompanyPanelSelectRequestDto requestDto = new CompanyPanelSelectRequestDto();

        MygmorApiRequestDto apiRequest = new MygmorApiRequestDto();
        apiRequest.setP(SegmEncryptUtil.encrypt(JSON.encode(requestDto)));
        apiRequest.setT("20120710173030");

        MygmorApiResponseDto response = target.create(apiRequest);

        assertEquals("-100", response.getStatus());
        assertEquals("bad parameters. company_id(required), country_cd(required)", response.getMessage());

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

        CompanyPanelSelectRequestDto requestDto = new CompanyPanelSelectRequestDto();
        requestDto.setCompany_id("2147483648");
        requestDto.setCountry_cd("123456");

        MygmorApiRequestDto apiRequest = new MygmorApiRequestDto();
        apiRequest.setP(SegmEncryptUtil.encrypt(JSON.encode(requestDto)));
        apiRequest.setT("20120710173030");

        MygmorApiResponseDto response = target.create(apiRequest);

        assertEquals("-100", response.getStatus());
        assertEquals("bad parameters. company_id(format), country_cd(length)", response.getMessage());

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

        CompanyPanelSelectRequestDto requestDto = new CompanyPanelSelectRequestDto();
        requestDto.setCompany_id("2147483647");
        requestDto.setCountry_cd("12345");

        MygmorApiRequestDto apiRequest = new MygmorApiRequestDto();
        apiRequest.setP(SegmEncryptUtil.encrypt(JSON.encode(requestDto)));
        apiRequest.setT("20120710173030");

        MygmorApiResponseDto response = target.create(apiRequest);

        assertEquals("0", response.getStatus());
        assertEquals("success", response.getMessage());

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
    public void testValidation5() throws Exception {

        CompanyPanelSelectRequestDto requestDto = new CompanyPanelSelectRequestDto();
        requestDto.setCompany_id("10");
        requestDto.setCountry_cd("123456");

        System.out.println(SegmEncryptUtil.encrypt(JSON.encode(requestDto)));

    }

}
