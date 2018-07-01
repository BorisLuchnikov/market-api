package com.bl.marketapi.dto.hitbtc;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public enum Side {

    @JsonProperty("sell")
    SELL("sell"),
    @JsonProperty("buy")
    BUY("buy");

    private String value;

    Side(String value) {
        this.value = value;
    }

    public static Side fromValue(String value) {
        for (Side side : values()) {
            if (side.value.equalsIgnoreCase(value)) {
                return side;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }
}
