package com.bl.marketapi.dto.hitbtc;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Currency {
    String id;
    String fullName;
    Boolean crypto;
    Boolean payinEnabled;
    Boolean payinPaymentId;
    Integer payinConfirmations;
    Boolean payoutEnabled;
    String payoutFee;
    Boolean payoutIsPaymentId;
    Boolean delisted;
    Boolean transferEnabled;
}
