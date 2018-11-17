package com.itemsharing.itemservice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.User;
import com.itemsharing.itemservice.service.ItemService;
import com.itemsharing.itemservice.service.UserService;

@SpringBootApplication
public class ItemServiceApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;
	
	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = userService.findByUsername("testy");
		
		Item i = new Item();
		i.setName("blargh");
		i.setDescription("oink oink");
		i.setItemCondition("new");
		i.setStatus("Active");
		i.setAddDate(new Date());
		i.setUser(user);
		
		itemService.addItemByUser(i, user.getUsername());
	}
}
