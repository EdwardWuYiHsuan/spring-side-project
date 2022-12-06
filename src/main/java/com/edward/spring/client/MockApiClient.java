package com.edward.spring.client;

import com.edward.spring.client.response.QueryHealthCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mockApiClient", url = "${mock.server.url}")
public interface MockApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/common/health")
    QueryHealthCheckResponse healthCheck();

}
