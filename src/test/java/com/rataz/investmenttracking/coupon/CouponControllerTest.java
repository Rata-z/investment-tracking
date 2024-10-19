package com.rataz.investmenttracking.coupon;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
    private CouponController couponController;


    @BeforeEach
    public void init() {
        coupon = Coupon.builder().isWon(false).odds(BigDecimal.valueOf(10))
                .stake(BigDecimal.valueOf(10)).build();
        couponController = new CouponController(couponService);
    }

    @Test
    void getAll() {
    }


    @Test
    public void CouponController_createValidCoupon_ReturnCreated() throws Exception {
        when(couponService.createCoupon(any(Coupon.class))).thenReturn(coupon);

        RequestBuilder request = MockMvcRequestBuilders.post("/api/coupons").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(coupon));
        ResultActions result = mvc.perform(request);
        result.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void CouponController_createInvalidCoupon_ReturnBadRequest() throws Exception {
        when(couponService.createCoupon(any(Coupon.class))).thenReturn(coupon);

        RequestBuilder request = MockMvcRequestBuilders.post("/api/coupons").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(""));
        ResultActions result = mvc.perform(request);
        result.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void getCouponById() {
    }

    @Test
    void deleteCouponById() {
    }
}