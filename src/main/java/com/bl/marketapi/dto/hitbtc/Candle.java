package com.bl.marketapi.dto.hitbtc;

import lombok.Data;

import java.util.Date;

@Data
public class Candle {
    Date timestamp;
    String open;
    String close;
    String min;
    String max;
    String volume;
    String volumeQuote;
}
