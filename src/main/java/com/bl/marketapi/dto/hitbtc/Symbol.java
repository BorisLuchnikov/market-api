package com.bl.marketapi.dto.hitbtc;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Symbol {
    String id;
    String baseCurrency;
    String quoteCurrency;
    String quantityIncrement;
    String tickSize;
    String takeLiquidityRate;
    String provideLiquidityRate;
    String feeCurrency;
}
