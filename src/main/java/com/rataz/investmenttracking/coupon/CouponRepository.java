package com.rataz.investmenttracking.coupon;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

//    @Query( "SELECT c FROM Coupon c")
//    List<Coupon> getAllCoupons();
}
