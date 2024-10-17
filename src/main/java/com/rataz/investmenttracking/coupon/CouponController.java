package com.rataz.investmenttracking.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {
    CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService){
        this.couponService=couponService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Coupon> getAll(){
        return couponService.getAllCoupons();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coupon createCoupon(@RequestBody  Coupon coupon){
        return couponService.createCoupon(coupon);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Coupon> getCouponById(@PathVariable Integer id){
        return  couponService.getCoupon(id);
    }

}
