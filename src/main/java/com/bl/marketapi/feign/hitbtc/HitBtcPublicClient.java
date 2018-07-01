package com.bl.marketapi.feign.hitbtc;

import com.bl.marketapi.dto.hitbtc.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient(name = "hitBtcPublicClient", url = "${feign.hitbtc.url}")
@RequestMapping(value = "/public")
public interface HitBtcPublicClient {

    @GetMapping(value = "/symbol")
    Collection<Symbol> getSymbols();

    @GetMapping(value = "/symbol/{symbol}")
    Symbol getSymbol(@PathVariable(name = "symbol") String symbol);

    @GetMapping(value = "/currency")
    Collection<Currency> getCurrencies();

    @GetMapping(value = "/currency/{currency}")
    Currency getCurrency(@PathVariable(name = "currency") String currency);

    @GetMapping(value = "/ticker")
    Collection<Ticker> getTickers();

    @GetMapping(value = "/ticker/{symbol}")
    Ticker getTicker(@PathVariable(name = "symbol") String symbol);

    @GetMapping(value = "/trades/{symbol}")
    Collection<PublicTrade> getTrades(@PathVariable(name = "symbol") String symbol,
                                      @RequestParam(name = "sort") String sort,
                                      @RequestParam(name = "by") String by,
                                      @RequestParam(name = "from") String from,
                                      @RequestParam(name = "till") String till,
                                      @RequestParam(name = "limit") Integer limit,
                                      @RequestParam(name = "offset") Integer offset);

    @GetMapping(value = "/orderbook/{symbol}")
    Orderbook getOrderbooks(@PathVariable(name = "symbol") String symbol,
                            @RequestParam(name = "limit") Integer limit);

    @GetMapping(value = "/candles/{symbol}")
    Collection<Candle> getCandles(@PathVariable(name = "symbol") String symbol,
                                  @RequestParam(name = "limit") Integer limit,
                                  @RequestParam(name = "period") String period);

}
