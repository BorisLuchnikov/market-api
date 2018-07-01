package com.bl.marketapi.controller;

import com.bl.marketapi.dto.hitbtc.*;
import com.bl.marketapi.feign.hitbtc.HitBtcPublicClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@SuppressWarnings("ALL")
@RestController()
@RequestMapping(value = "/hit-btc-public")
public class HitBtcPublicController {

    @Autowired
    private HitBtcPublicClient hitBtcPublicClient;

    @GetMapping("/symbol")
    Collection<Symbol> getSymbols() {
        return hitBtcPublicClient.getSymbols();
    }

    @GetMapping(value = "/symbol/{symbol}")
    Symbol getSymbol(@PathVariable(name = "symbol") String symbol) {
        return hitBtcPublicClient.getSymbol(symbol);
    }

    @GetMapping(value = "/currency")
    Collection<Currency> getCurrencies() {
        return hitBtcPublicClient.getCurrencies();
    }

    @GetMapping(value = "/currency/{currency}")
    Currency getCurrency(@PathVariable(name = "currency") String currency) {
        return hitBtcPublicClient.getCurrency(currency);
    }

    @GetMapping(value = "/ticker")
    Collection<Ticker> getTickers() {
        return hitBtcPublicClient.getTickers();
    }

    @GetMapping(value = "/ticker/{symbol}")
    Ticker getTicker(@PathVariable(name = "symbol") String symbol) {
        return hitBtcPublicClient.getTicker(symbol);
    }

    @GetMapping(value = "/trades/{symbol}")
    Collection<PublicTrade> getTrades(@PathVariable(name = "symbol") String symbol,
                                      @RequestParam(name = "sort") String sort,
                                      @RequestParam(name = "by") String by,
                                      @RequestParam(name = "from") String from,
                                      @RequestParam(name = "till") String till,
                                      @RequestParam(name = "limit") Integer limit,
                                      @RequestParam(name = "offset") Integer offset) {
        return hitBtcPublicClient.getTrades(symbol, sort, by, from, till, limit, offset);
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
