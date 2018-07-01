package com.bl.marketapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
@AutoConfigureMockMvc
class HitBtcPublicControllerTest {

    private static final String GET_SYMBOLS_PATH = "/hit-btc-public/symbol";
    private static final String GET_SYMBOL_PATH = "/hit-btc-public/symbol/ETHBTC";
    private static final String GET_CURRENCIES_PATH = "/hit-btc-public/currency";
    private static final String GET_CURRENCY_PATH = "/hit-btc-public/currency/DDF";
    private static final String GET_TICKERS_PATH = "/hit-btc-public/ticker";
    private static final String GET_TICKER_PATH = "/hit-btc-public/ticker/ETHBTC";
    private static final String GET_TREADES_PATH = "/hit-btc-public/trades/ETCBTC?sort=DESC&by=timestamp&" +
            "from=2018-04-01T00:00:00.000Z&till=2018-04-03T00:00:00.000Z&limit=100&offset=0";
    private static final String GET_ORDERBOOKS_PATH = "/hit-btc-public/orderbook/ETHBTC?limit=10";
    private static final String GET_CANDELS_PATH = "/hit-btc-public/candles/ETHBTC?limit=10&period=M30";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetSymbols() throws Exception {
        mockMvc.perform(get(GET_SYMBOLS_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testGetSymbol() throws Exception {
        mockMvc.perform(get(GET_SYMBOL_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testGetCurrencies() throws Exception {
        mockMvc.perform(get(GET_CURRENCIES_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testGetCurrency() throws Exception {
        mockMvc.perform(get(GET_CURRENCY_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testGetTickers() throws Exception {
        mockMvc.perform(get(GET_TICKERS_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testGetTicker() throws Exception {
        mockMvc.perform(get(GET_TICKER_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testGetTrades() throws Exception {
        mockMvc.perform(get(GET_TREADES_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testGetOrderbooks() throws Exception {
        mockMvc.perform(get(GET_ORDERBOOKS_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ask", hasSize(10)))
                .andExpect(jsonPath("$.bid", hasSize(10)))
                .andDo(print());
    }

    @Test
    void testGetCandles() throws Exception {
        mockMvc.perform(get(GET_CANDELS_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)))
                .andDo(print());
    }
}
