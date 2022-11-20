package com.example.javaSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringBootApplication.class, args);
	}

}

// @Bean
// CommandLineRunner commandLineRunner(UserRepository userRepository) {
// return args -> {
// Faker faker = new Faker();
// for (int i = 0; i <= 20; i++) {
// String firstName = faker.name().firstName();
// String lastName = faker.name().lastName();
// String email = String.format("%s.%s@tipu.edu", firstName, lastName);

// User user = new User(firstName, lastName, email, String.valueOf(i * 412860),
// String.valueOf(i * 431));
// userRepository.save(user);
// }
// };
// }
