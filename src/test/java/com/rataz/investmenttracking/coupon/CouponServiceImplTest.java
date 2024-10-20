package com.rataz.investmenttracking.coupon;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CouponServiceImplTest {
    @Mock
    private CouponRepository couponRepository;

    @InjectMocks
    private CouponServiceImpl couponService;

    private Coupon coupon;


    @BeforeEach
    public void init() {
        coupon = Coupon.builder().isWon(false).odds(BigDecimal.valueOf(10))
                .stake(BigDecimal.valueOf(10)).build();
    }


    @Test
    public void couponService_getAllCoupons_returnsCouponList() {
        Coupon coupon2 = Coupon.builder().isWon(false).odds(BigDecimal.valueOf(10))
                .stake(BigDecimal.valueOf(10)).build();
        when(couponRepository.findAll()).thenReturn(Arrays.asList(coupon, coupon2));

        Iterable<Coupon> couponList = couponService.getAllCoupons();
        Assertions.assertThat(couponList).isNotNull();
    }

    @Test
    public void couponService_createCoupon_returnsCoupon() {
        when(couponRepository.save(Mockito.any(Coupon.class))).thenReturn(coupon);
        Coupon savedCoupon = couponService.createCoupon(coupon);

        Assertions.assertThat(savedCoupon).isNotNull();

    }

    @Test
    public void couponService_getCouponById_returnsCoupon() {
        when(couponRepository.findById(1L)).thenReturn(Optional.ofNullable(coupon));
        Optional<Coupon> savedCoupon = couponService.getCouponById(1L);

        Assertions.assertThat(savedCoupon).isNotNull();
    }

    @Test
    public void couponService_getCouponById_returnsEmpty() {
        Optional<Coupon> savedCoupon = couponService.getCouponById(1L);

        Assertions.assertThat(savedCoupon).isEmpty();
    }

    @Test
    void couponService_deleteCoupon_returnsTrue() {
        when(couponRepository.findById(1L)).thenReturn(Optional.ofNullable(coupon));
        boolean isDeleted = couponService.deleteCoupon(1L);

        Assertions.assertThat(isDeleted).isTrue();
    }

    @Test
    void couponService_deleteCoupon_returnsFalse() {
        when(couponRepository.findById(1L)).thenReturn(Optional.empty());
        boolean isDeleted = couponService.deleteCoupon(1L);

        Assertions.assertThat(isDeleted).isFalse();
    }
}