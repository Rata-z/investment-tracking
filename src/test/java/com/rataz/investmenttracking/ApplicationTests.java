package com.rataz.investmenttracking;

import com.rataz.investmenttracking.coupon.CouponRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    private CouponRepository couponRepository;

    @Test
    void contextLoads() {
    }

//	@Test
//	public void testGetAll(){
//		List<Coupon> couponList=couponRepository.findAll();
//		couponList.forEach(System.out::println);
//	}

}
