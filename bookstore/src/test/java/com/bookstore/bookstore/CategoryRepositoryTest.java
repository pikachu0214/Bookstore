package com.bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.bookstore.domain.Category;
import com.bookstore.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
    private CategoryRepository drepository;
	
    @Test
    public void findByCategoryShouldReturnBook() {
        List<Category> category = drepository.findByName("Law");
        
        assertThat(category).hasSize(1);
        assertThat(category.get(0).getName()).isEqualTo("Law");
        assertThat(category.get(0).getCategoryid()).isEqualTo(3);

    }     
    @Test
    public void createNewCategory() {
    	Category category = new Category("History");
    	drepository.save(category);
    	assertThat(category.getCategoryid()).isNotNull();
    }
}
