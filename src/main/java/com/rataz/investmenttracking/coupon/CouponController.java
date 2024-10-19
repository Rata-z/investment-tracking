package com.rataz.investmenttracking.coupon;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/coupons")
class CouponController {
    private final CouponService couponService;


    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping
    public Iterable<Coupon> getAll() {
        return couponService.getAllCoupons();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return couponService.createCoupon(coupon);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Optional<Coupon> getCouponById(@PathVariable Long id) {
        return couponService.getCouponById(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCouponById(@PathVariable Long id) {
        boolean deleted = couponService.deleteCoupon(id);
        HttpStatus status = deleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);

    }

}
