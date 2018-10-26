package com.bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.bookstore.domain.UserRepository;
import com.bookstore.bookstore.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
    private UserRepository urepository;
	
    @Test
    public void findByUserNameShouldReturnBook() {
        User user = urepository.findByUsername("user");
        
        assertThat(user).isNotNull();
        assertThat(user.getRole()).isEqualTo("USER");
    }
    @Test
    public void createNewCategory() {
    	User user = new User("user4", "password", "USER4");
    	urepository.save(user);
    	assertThat(user.getUsername()).isNotNull();
    }
}
