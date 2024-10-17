package com.rataz.investmenttracking.coupon;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class CouponServiceImpl implements CouponService {
    CouponRepository couponRepository;

    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
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
    public Optional<Coupon> getCoupon(Long id) {
        return couponRepository.findById(id);
    }

    @Override
    public boolean deleteCoupon(Long id) {
        Optional<Coupon> deletedCoupon = couponRepository.findById(id);
        if (deletedCoupon.isPresent()) {
            couponRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
