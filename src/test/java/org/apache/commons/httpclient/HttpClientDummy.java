/*-
 * Copyright (c) 2004-2011 GMO-RESEARCH Inc. All rights reserved.
 * Redistribution in source and binary forms, with or without
 * modification, is limited by contract.
 */
package org.apache.commons.httpclient;

import java.io.ByteArrayInputStream;
import java.io.IOException;



/**
 * @author endo
 * @since 2011/07/15
 */
public class HttpClientDummy
        extends HttpClient {

    /** {@inheritDoc} */
    @Override
    public int executeMethod(HttpMethod method) throws IOException {
        if (method.getURI().getURI().equals("http://dummy.200/")) {
            String result = "{\"error\":\"0\",\"id\":\"9999\",\"result\":null,\"returnCd\": \"00\"}";
            ByteArrayInputStream responseStream = new ByteArrayInputStream(result.getBytes());
            ((HttpMethodBase)method).setResponseStream(responseStream);
            return HttpStatus.SC_OK;
        }
        if (method.getURI().getURI().equals("http://dummy.200.error/")) {
            String result = "{\"error\":\"0\",\"id\":\"9999\",\"result\":null,\"returnCd\": \"01\"}";
            ByteArrayInputStream responseStream = new ByteArrayInputStream(result.getBytes());
            ((HttpMethodBase)method).setResponseStream(responseStream);
            return HttpStatus.SC_OK;
        }
        if (method.getURI().getURI().equals("http://dummy.http.404/")) {
            return HttpStatus.SC_NOT_FOUND;
        }
        if (method.getURI().getURI().equals("http://dummy.io.exception/")) {
            throw new IOException("IOException");
        }
        if (method.getURI().getURI().equals("http://dummy.http.exception/")) {
            throw new HttpException("HttpException");
        }
        return 0;
    }

}
