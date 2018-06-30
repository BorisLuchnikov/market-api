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

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetSymbol() throws Exception {
        mockMvc.perform(get("/hit-btc-public/symbol")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testGetOrderbooks() throws Exception {
        mockMvc.perform(get("/hit-btc-public/orderbook/ETHBTC?limit=10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ask", hasSize(10)))
                .andExpect(jsonPath("$.bid", hasSize(10)))
                .andDo(print());
    }

    @Test
    void testGetCandles() throws Exception {
        mockMvc.perform(get("/hit-btc-public/candles/ETHBTC?limit=10&period=M30")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)))
                .andDo(print());
    }
}
