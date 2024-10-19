package com.rataz.investmenttracking.coupon;


import java.util.Optional;


interface CouponService {

    Iterable<Coupon> getAllCoupons();

    Coupon createCoupon(Coupon coupon);

    Optional<Coupon> getCouponById(Long id);

    boolean deleteCoupon(Long id);
}
