package com.rataz.investmenttracking.coupon;

import java.util.List;
import java.util.Optional;

public interface CouponService {

    Iterable<Coupon> getAllCoupons();
    Coupon createCoupon(Coupon coupon);
    Optional<Coupon> getCoupon(Integer id);
}
