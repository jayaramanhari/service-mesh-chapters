package com.books.servicemesh.dockercompose;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository repository;

    @Test
    public void testFindByName() {
    	final String bookNameForTest="servicemesh";
    	
        entityManager.persist(new Book(bookNameForTest));

        List<Book> books = repository.findByName(bookNameForTest);
        assertEquals(1, books.size());

        assertThat(books).extracting(Book::getName).containsOnly(bookNameForTest);

    }

}