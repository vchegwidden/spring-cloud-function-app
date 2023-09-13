package za.co.cesium.functionapp;

import java.net.URI;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

/**
 * Integration test for the HTTP server wrapping this application
 */
@FunctionalSpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FunctionWebApplicationTests {

	@Autowired
	private TestRestTemplate rest;

	@Test
	void contextLoads() {
	}

	@Test
	public void testUpperCaseString() throws Exception {
		ResponseEntity<String> result = this.rest.exchange(
			RequestEntity.post(new URI("/upperCaseString")).body("hello"), String.class);
		Assert.assertEquals("HELLO", result.getBody());
	}

	@Test
	public void testUpperCaseStringWithFilterNotRude() throws Exception {
		ResponseEntity<String> result = this.rest.exchange(
			RequestEntity.post(new URI("/upperCaseWithFilter")).body("hello"), String.class);
		Assert.assertEquals("[\"HELLO\"]", result.getBody());
	}

	@Test
	public void testUpperCaseStringWithFilterIsRude() throws Exception {
		ResponseEntity<String> result = this.rest.exchange(
			RequestEntity.post(new URI("/upperCaseWithFilter")).body("rude"), String.class);
		Assert.assertEquals("[]", result.getBody());
	}

	@Test
	public void testReverseString() throws Exception {
		ResponseEntity<String> result = this.rest.exchange(
			RequestEntity.post(new URI("/reverseString")).body("hello"), String.class);
		Assert.assertEquals("olleh", result.getBody());
	}

}
