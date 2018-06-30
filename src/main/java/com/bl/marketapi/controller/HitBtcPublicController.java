package com.bl.marketapi.controller;

import com.bl.marketapi.dto.hitbtc.Candle;
import com.bl.marketapi.dto.hitbtc.Orderbook;
import com.bl.marketapi.dto.hitbtc.Symbol;
import com.bl.marketapi.feign.hitbtc.HitBtcPublicClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController()
@RequestMapping(value = "/hit-btc-public")
public class HitBtcPublicController {

    @Autowired
    private HitBtcPublicClient hitBtcPublicClient;

    @GetMapping("/symbol")
    Collection<Symbol> getSymbols() {

        return hitBtcPublicClient.getSymbols();
    }

    @GetMapping("/orderbook/{symbol}")
    Orderbook getOrderbooks(@PathVariable("symbol") String symbol,
                            @RequestParam Integer limit) {

        return hitBtcPublicClient.getOrderbooks(symbol, limit);
    }

    @GetMapping("/candles/{symbol}")
    Collection<Candle> getCandles(@PathVariable("symbol") String symbol,
                                  @RequestParam Integer limit,
                                  @RequestParam String period) {

        return hitBtcPublicClient.getCandles(symbol, limit, period);
    }

}
