package com.walliee;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@SpringBootApplication
public class ImplicitFunctionBinderIssueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImplicitFunctionBinderIssueApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner() {
		return args -> {
			while (true) {
				System.out.println("do something");
				Thread.sleep(1000L);
			}
		};
	}

	@Bean
	public String field() {
		return "value";
	}

	@Component
	public static class StringSuppiler implements Supplier<String> {
		private String field;

		public StringSuppiler(String field) {
			this.field = field;
		}

		@Override
		public String get() {
			return field;
		}
	}
}
