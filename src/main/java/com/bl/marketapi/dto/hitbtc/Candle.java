package com.bl.marketapi.dto.hitbtc;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Getter
public class Candle {
    Date timestamp;
    String open;
    String close;
    String min;
    String max;
    String volume;
    String volumeQuote;
}
