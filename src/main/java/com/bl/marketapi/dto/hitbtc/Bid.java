package com.bl.marketapi.dto.hitbtc;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
class Bid {
    Double price;
    Double size;
}
