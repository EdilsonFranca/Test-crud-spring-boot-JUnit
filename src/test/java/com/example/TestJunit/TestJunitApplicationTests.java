package com.example.TestJunit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.TestJunit.entity.Product;
import com.example.TestJunit.repository.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//Edilson //
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestJunitApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	@Order(1)
	public void testCreate () {
		Product p = new Product();
		p.setId(1L);
		p.setName("iPhone XR");
		p.setDescription("Fantastic");
		p.setPrice(1000.00);
		productRepository.save(p);
		assertNotNull(productRepository.findById(1L).get());
	}

	@Test
	@Order(2)
	public void testReadAll () {
		List list = productRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testRead () {
		Product product = productRepository.findById(1L).get();
		assertEquals("iPhone XR", product.getName());
	}

	@Test
	@Order(4)
	public void testUpdate () {
		Product p = productRepository.findById(1L).get();
		p.setPrice(800.00);
		productRepository.save(p);
		assertNotEquals(700.00, productRepository.findById(1L).get().getPrice());
	}

	@Test
	@Order(5)
	public void testDelete () {
		productRepository.deleteById(1L);
		assertThat(productRepository.existsById(1L)).isFalse();
	}
}
