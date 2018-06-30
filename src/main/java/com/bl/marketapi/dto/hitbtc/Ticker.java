package com.bl.marketapi.dto.hitbtc;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Getter
public class Ticker {
    String symbol;
    String ask;
    String bid;
    String last;
    String low;
    String high;
    String open;
    String volume;
    String volumeQuoute;
    Date timestamp;
}
