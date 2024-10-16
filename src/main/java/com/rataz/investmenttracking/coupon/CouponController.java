package com.rataz.investmenttracking.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {
    @Autowired
    CouponRepository couponRepository;
    CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService){
        this.couponService=couponService;
    }

    @GetMapping("/")
    public List<Coupon> getAll(){
        return couponRepository.getAllCoupons();
    }

}
