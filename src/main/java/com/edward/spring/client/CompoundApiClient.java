package com.edward.spring.client;

import com.edward.spring.client.response.CompoundGetTokenApyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "compoundApiClient", url = "${server.compound.url}")
public interface CompoundApiClient {

    /**
     * Get Compound Token APY (supply_rate)
     *
     * @see <a href="https://compound.finance/docs/api#ctoken-service">CTokenRequest</a>
     * @param contractAddresses Smart contract address list
     * @return response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/ctoken?addresses[]={addresses}")
    CompoundGetTokenApyResponse getTokenApy(@PathVariable("addresses") List<String> contractAddresses);
}
