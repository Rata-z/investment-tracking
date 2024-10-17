package com.rataz.investmenttracking.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService{
    CouponRepository couponRepository;
    @Autowired
    public CouponServiceImpl(CouponRepository couponRepository){
        this.couponRepository=couponRepository;
    }

    @Override
    public Iterable<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Optional<Coupon> getCoupon(Integer id) {
        return couponRepository.findById(id);
    }
}
