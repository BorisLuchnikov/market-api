package com.bl.marketapi.dto.hitbtc;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Getter
public class PublicTrade {
    Long id;
    String price;
    String quantity;
    Side side;
    Date timestamp;
}
