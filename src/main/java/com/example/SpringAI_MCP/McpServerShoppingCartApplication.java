package com.example.demo;

import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class McpServerShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpServerShoppingCartApplication.class, args);
	}

	@Bean
	public List<ToolCallback> shoppingCartToolCallbacks(ShoppingCart shoppingCart) {
		return List.of(ToolCallbacks.from(shoppingCart));
	}

}
