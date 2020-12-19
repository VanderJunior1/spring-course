package com.springcourse.service.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;

import com.springcourse.services.util.HashUtil;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class HashUtilTests {
	
	@Test
	@Order(1)
	public void getSecurityHash() {
		String hash = HashUtil.getSecutityHash("123");
		System.out.println(hash);
		assertThat(hash.length()).isEqualTo(64);
	}

}
