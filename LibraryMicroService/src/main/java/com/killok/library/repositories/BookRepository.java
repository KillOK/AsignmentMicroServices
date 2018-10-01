package com.killok.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.killok.library.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	@Query("from Book where title like %:searchString%")
	public List<Book> readBooksByTitle(@Param(value = "searchString") String title);
}
