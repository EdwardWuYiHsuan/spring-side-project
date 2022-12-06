package com.edward.spring.client.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompoundGetTokenApyResponse {

    @JsonProperty("error")
    private String error;
    @JsonProperty("cToken")
    private List<Ctoken> ctoken = new ArrayList<>();

    public boolean isSuccess() {
        return null == this.error;
    }

    @Data
    public static class Ctoken {
        private static final String OBJ_KEY = "value";

        @JsonProperty("underlying_symbol")
        private String underlyingSymbol;
        @JsonProperty("supply_rate")
        private Map<String, String> supplyRate = new HashMap<>();

        public Optional<String> getSupplyRate() {
            return supplyRate.containsKey(OBJ_KEY) && StringUtils.isNotEmpty(supplyRate.get(OBJ_KEY)) ?
                    Optional.of(supplyRate.get(OBJ_KEY)) : Optional.empty();
        }
    }
}
