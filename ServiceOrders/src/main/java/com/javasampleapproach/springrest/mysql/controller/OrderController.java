package com.javasampleapproach.springrest.mysql.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.omg.CORBA.portable.OutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.springrest.mysql.model.Order;
import com.javasampleapproach.springrest.mysql.model.OrderDetail;
import com.javasampleapproach.springrest.mysql.repo.OrderRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	OrderRepository repository;

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		System.out.println("Get all Orders...");

		List<Order> orders = new ArrayList<>();
		repository.findAll().forEach(orders::add);

		return orders;
	}

	@PostMapping(value = "/orders/create")
	public Order postOrder(@RequestBody Order order) {

		System.out.println("Add Order...");
		
		Order o = new Order(
				order.getAddress1(), 
				order.getAptounit(),
				order.getSuburb(),
				order.getCity(),
				order.getState(),
				order.getZipCode(),
				order.getCreateOrder(),
				order.getDateOrder(),
				order.getTimeOrder(),
				order.getObservations(),
				order.getPhoneNumber1(),
				order.getPhoneNumber2(),
				order.getEmail(),
				order.getUserId()
				);
				
		HashSet<OrderDetail> details = new HashSet<OrderDetail>();
	    for( OrderDetail det : order.getOrderDetails() ) {
	    	det.setOrder( o );
	    	details.add(det);
	    }
		
	    o.setOrderDetails(details);
	    	    
		Order _order = repository.save(o);
		
		//Send notification
		try {

			URL url = new URL("http://localhost:8091/sendMailEco");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"to\":\"sephiroth.125@hotmail.com\",\"subject\":\"Evento Ecosolida\",\"text\":\"-datos-\"}";

			java.io.OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			int a1=conn.getResponseCode();
			int a2 = HttpURLConnection.HTTP_OK;
			if (a1 != a2) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {
			  System.out.println("Output error .... \n"+e.getMessage());
			//e.printStackTrace();

		  } catch (IOException e) {
			  System.out.println("Output error  .... \n"+e.getMessage());	
			//e.printStackTrace();

		 }
		
		return _order;
	}
}
