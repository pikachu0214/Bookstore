package com.bookstore.bookstore.domain;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

//Class to save books to repository
public interface BookRepository extends CrudRepository <Book, Long> {
    List<Book> findByIsbn(String isbn);
    Optional<Book> findById(Long id);


}
