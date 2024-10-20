package com.rataz.investmenttracking.coupon;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.*;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CouponIntegrationTest {

    @Container
    @ServiceConnection
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0");

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    CouponServiceImpl couponService;

    @Autowired
    CouponRepository couponRepository;

    @BeforeEach
    void init() {
        couponRepository.deleteAll();
        Coupon coupon1 = Coupon.builder().isWon(false).stake(BigDecimal.valueOf(10)).odds(BigDecimal.valueOf(10)).events(null).build();
        Coupon coupon2 = Coupon.builder().isWon(true).stake(BigDecimal.valueOf(4)).odds(BigDecimal.valueOf(30)).events(null).build();
        couponRepository.saveAll(List.of(coupon1, coupon2));
    }


    @Test
    void CouponIntegration_getCouponById_returnsCoupon() {

        Optional<Coupon> coupon = Optional.ofNullable(restTemplate.getForObject("/api/coupons/2", Coupon.class));
        Assertions.assertThat(coupon).isNotEmpty();
        Assertions.assertThat(coupon.get().getId()).isEqualTo(2L);
        Assertions.assertThat(coupon.get().getStake()).isEqualByComparingTo(BigDecimal.valueOf(4));
        Assertions.assertThat(coupon.get().getOdds()).isEqualByComparingTo(BigDecimal.valueOf(30));
    }

    @Test
    void CouponIntegration_getAllCoupons_returnsCouponList() {
        Coupon[] couponList = restTemplate.getForObject("/api/coupons", Coupon[].class);
        Assertions.assertThat(couponList.length).isEqualTo(2);

    }

    @Test
    void CouponIntegration_addCoupon_returnsCoupon() {
        Coupon coupon = Coupon.builder().isWon(true).stake(BigDecimal.valueOf(10)).odds(BigDecimal.valueOf(25)).events(null).build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Coupon> request = new HttpEntity<>(coupon, headers);

        ResponseEntity<Coupon> response = restTemplate.exchange("/api/coupons", HttpMethod.POST, request, Coupon.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().getId()).isEqualTo(3L);
        Assertions.assertThat(response.getBody().getStake()).isEqualByComparingTo(BigDecimal.valueOf(10));
        Assertions.assertThat(response.getBody().getOdds()).isEqualByComparingTo(BigDecimal.valueOf(25));
        Assertions.assertThat(response.getBody().isWon()).isTrue();
    }


}
