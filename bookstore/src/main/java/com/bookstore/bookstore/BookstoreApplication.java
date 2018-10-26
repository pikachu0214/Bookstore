package com.bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.bookstore.bookstore.domain.Book;
import com.bookstore.bookstore.domain.BookRepository;
import com.bookstore.bookstore.domain.Category;
import com.bookstore.bookstore.domain.CategoryRepository;
import com.bookstore.bookstore.domain.User;
import com.bookstore.bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}	
	@Bean
	public CommandLineRunner bookDemo(BookRepository srepository, CategoryRepository drepository, UserRepository urepository) {
		return (args) -> {
			//Prints out in console
			log.info("save a couple of books");
			//Save Category into Category repository (H2/DB)
			drepository.save(new Category("Horror"));
			drepository.save(new Category("Drama"));
			drepository.save(new Category("Law"));
			
			//save Book into Book repository (H2/DB)
			srepository.save(new Book("Sports HighLight", "Michael Jordan", 2007, "123456789", 50, drepository.findByName("Horror").get(0)));
			srepository.save(new Book("Winning Championships", "Kobe Bryant", 2007, "987654321", 50, drepository.findByName("Drama").get(0)));
			srepository.save(new Book("Trading", "Lebron James", 2007, "111222333", 50, drepository.findByName("Law").get(0)));	
			
			// Create users: admin/admin user/user user1/user1
			User user1 = new User("user", "$2a$04$3i/lT05RXROGYFP28kw1nuVTFX79cLGgyQNNsky8BkpgwEnxzyUqO",   "USER");
			User user3 = new User("user1", "$2a$04$q1CmMga91fTgZ8Bs1lA1DucD53yxPkpcVrfxJOdQj3oma6IOZN.26",   "USER1");
			User user2 = new User("admin", "$2a$04$e6/yLOeObOBX6j.97nJaWOuEfUQceKQWcJBPArlWtn0ecteFLM1B2",  "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
									
			//Prints out in console
			log.info("fetch all books");
			//Book class is called with toString method in console
			for (Book book : srepository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
}
