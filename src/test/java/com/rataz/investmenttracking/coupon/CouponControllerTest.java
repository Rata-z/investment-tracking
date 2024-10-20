package com.rataz.investmenttracking.coupon;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = CouponController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class CouponControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private CouponService couponService;

    @Autowired
    private ObjectMapper objectMapper;

    private Coupon coupon;


    @BeforeEach
    public void init() {
        coupon = Coupon.builder().isWon(false).odds(BigDecimal.valueOf(10))
                .stake(BigDecimal.valueOf(10)).build();
    }


    @Test
    public void couponController_createCoupon_returnsCreated() throws Exception {
        when(couponService.createCoupon(any(Coupon.class))).thenReturn(coupon);

        RequestBuilder request = MockMvcRequestBuilders.post("/api/coupons").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(coupon));
        ResultActions result = mvc.perform(request);
        result.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void couponController_createCoupon_returnsBadRequest() throws Exception {
        when(couponService.createCoupon(any(Coupon.class))).thenReturn(coupon);

        RequestBuilder request = MockMvcRequestBuilders.post("/api/coupons").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(""));
        ResultActions result = mvc.perform(request);
        result.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    @Test
    void couponController_deleteCouponById_returnsNoContent() throws Exception {
        when(couponService.deleteCoupon(any(Long.class))).thenReturn(true);
        RequestBuilder request = MockMvcRequestBuilders.delete("/api/coupons/{id}", 1).contentType(MediaType.APPLICATION_JSON);
        ResultActions result = mvc.perform(request);
        result.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void couponController_deleteCouponById_returnsNotFound() throws Exception {
        when(couponService.deleteCoupon(any(Long.class))).thenReturn(false);
        RequestBuilder request = MockMvcRequestBuilders.delete("/api/coupons/{id}", 1).contentType(MediaType.APPLICATION_JSON);
        ResultActions result = mvc.perform(request);
        result.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}