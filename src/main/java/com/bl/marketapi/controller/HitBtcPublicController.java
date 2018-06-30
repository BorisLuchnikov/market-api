package com.bl.marketapi.controller;

import com.bl.marketapi.dto.hitbtc.Candle;
import com.bl.marketapi.dto.hitbtc.Orderbook;
import com.bl.marketapi.feign.hitbtc.HitBtcPublicClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController(value = "/public")
public class HitBtcPublicController {

    @Autowired
    private HitBtcPublicClient hitBtcPublicClient;

    @GetMapping("/orderbook/{symbol}")
    Orderbook getOrderbooks(@PathVariable("symbol") String symbol,
                            @RequestParam int limit) {

        return hitBtcPublicClient.getOrderbooks(symbol, limit);
    }

    @GetMapping("/candles/{symbol}")
    Collection<Candle> getCandles(@PathVariable("symbol") String symbol,
                                  @RequestParam int limit,
                                  @RequestParam String period) {

        return hitBtcPublicClient.getCandles(symbol, limit, period);
    }

}
