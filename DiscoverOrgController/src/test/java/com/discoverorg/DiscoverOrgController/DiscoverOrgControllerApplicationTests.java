package com.discoverorg.DiscoverOrgController;

import com.discoverorg.DiscoverOrgController.Classes.SmartFridgeComponent;
import com.discoverorg.DiscoverOrgController.Models.FridgeItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscoverOrgControllerApplicationTests {

	@Test
	public void testGetItemsInFridgeSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8080/getItemsInFridge";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testHandleItemRemoved() throws URISyntaxException {
		SmartFridgeComponent fridgeComponent = new SmartFridgeComponent();
		ArrayList<FridgeItem> items = new ArrayList<>();

		assertEquals(items, fridgeComponent.getItemsInFridge());
	}

	@Test
	public void testGetItemsEndpoint() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:8080/getItems?fillFactor=1.0";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testGetItemsEndpointDataType() throws URISyntaxException {
		SmartFridgeComponent fridgeComponent = new SmartFridgeComponent();
		ArrayList<FridgeItem> items = new ArrayList<>();

		assertEquals(items, fridgeComponent.getItems(1.0));
	}

	@Test
	public void testForgetItemsEndpoint() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		Long type = new Long(1000L);
		final String baseUrl = "http://localhost:8080/forgetItem?itemType=" + type;
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testGetFillFactorEndpoint() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		Long type = new Long(1000L);
		final String baseUrl = "http://localhost:8080/forgetItem?itemType=" + type;
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testAddItemSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		FridgeItem newItem = new FridgeItem(1000L, "1", "Milk", 1.0);
		final String baseUrl = "http://localhost:8080/addItem";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		assertEquals(200, result.getStatusCodeValue());
	}

}

