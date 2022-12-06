package com.edward.spring.client;

import com.edward.spring.client.response.QueryHealthCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mockApiClient", url = "${server.mock.url}")
public interface MockApiClient {

    /**
     * Query Health Check
     * <pre>
     *  {
     *      "code": "0",
     *      "msg": "suc",
     *      "data": null,
     *      "message": "",
     *      "timestamp": "2022-12-06T11:25:17.327Z",
     *      "request_id": "95xB2GqH"
     *  }
     * </pre>
     * @return {@link QueryHealthCheckResponse}
     */
    @RequestMapping(method = RequestMethod.GET, value = "/common/health")
    QueryHealthCheckResponse healthCheck();

}
