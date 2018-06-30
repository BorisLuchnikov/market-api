package com.bl.marketapi.dto.hitbtc;

import lombok.Data;
import lombok.Getter;

import java.util.Collection;
import java.util.Date;

@Data
@Getter
public class Orderbook {
    Collection<Ask> ask;
    Collection<Bid> bid;
    Date timestamp;
}
