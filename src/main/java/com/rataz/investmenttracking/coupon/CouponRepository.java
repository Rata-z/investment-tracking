package com.rataz.investmenttracking.coupon;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CouponRepository  extends JpaRepository<Coupon,Integer> {

//    @Query( "SELECT c FROM Coupon c")
//    List<Coupon> getAllCoupons();
}
