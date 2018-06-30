package com.bl.marketapi.feign.hitbtc;

import com.bl.marketapi.dto.hitbtc.Candle;
import com.bl.marketapi.dto.hitbtc.Orderbook;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient(name = "hitBtcPublicClient", url = "https://api.hitbtc.com/api/2")
@RequestMapping(value = "/public")
public interface HitBtcPublicClient {

    @GetMapping(value = "/orderbook/{symbol}")
    Orderbook getOrderbooks(@PathVariable(name = "symbol") String symbol,
                            @RequestParam(name = "limit") int limit);

    @GetMapping(value = "/candles/{symbol}")
    Collection<Candle> getCandles(@PathVariable(name = "symbol") String symbol,
                                  @RequestParam(name = "limit") int limit,
                                  @RequestParam(name = "period") String period);

}
