package com.bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.bookstore.domain.Book;
import com.bookstore.bookstore.domain.BookRepository;
import com.bookstore.bookstore.domain.Category;
import com.bookstore.bookstore.domain.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
    private BookRepository repository;
	
    @Test
    public void findByIsbnShouldReturnBook() {
        List<Book> books = repository.findByIsbn("123456789");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getPrice()).isEqualTo(50);
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Spin Selling", "Neil Rackham", 2000, "123123899", 20, new Category("Horror"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    } 
    
    @Test
    public void deleteBook() {
    	List<Book> books = repository.findByIsbn("123456789");
    	Long Id = books.get(0).getId();
    	
    	repository.deleteById(Id);
    	assertThat(repository.findByIsbn("123456789")).isNotNull();
    }
}
