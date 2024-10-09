package com.rataz.investmenttracking.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CouponController {
    @Autowired
    CouponRepository couponRepository;

    @GetMapping("/")
    public List<Coupon> getAll(){
        return couponRepository.getAllCoupons();
    }

}
