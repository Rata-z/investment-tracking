package com.rataz.investmenttracking.coupon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.MySQLContainer;

import java.math.BigDecimal;
import java.util.List;

@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CouponRepositoryTest {
    @Container
    @ServiceConnection
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0");

    @Autowired
    private CouponRepository couponRepository;

    @BeforeEach
    public void init() {
        Coupon coupon = Coupon.builder().isWon(false).stake(BigDecimal.valueOf(10)).odds(BigDecimal.valueOf(10)).events(null).build();
        couponRepository.save(coupon);
    }

    @Test
    void Connection() {
        Assertions.assertThat(mysql.isCreated()).isTrue();
        Assertions.assertThat(mysql.isRunning()).isTrue();
    }


    @Test
    void test() {
        Coupon c = couponRepository.getReferenceById(1L);
        List<Coupon> list = couponRepository.findAll();
        Assertions.assertThat(c).isNotNull();
        Assertions.assertThat(list.size()).isEqualTo(1);
    }
}
