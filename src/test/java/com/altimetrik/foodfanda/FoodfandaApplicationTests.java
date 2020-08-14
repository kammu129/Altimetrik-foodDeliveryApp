package com.altimetrik.foodfanda;

import com.altimetrik.foodfanda.controller.CustomerController;
import com.altimetrik.foodfanda.controller.OrderController;
import com.altimetrik.foodfanda.controller.RestaurantController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FoodfandaApplicationTests {
	@Autowired
	private RestaurantController restaurantController;
	@Autowired
	private CustomerController customerController;
	@Autowired
	private OrderController orderController;

	@Test
	void contextLoads() {
		assertThat(restaurantController).isNotNull();
		assertThat(customerController).isNotNull();
		assertThat(orderController).isNotNull();
	}

}
