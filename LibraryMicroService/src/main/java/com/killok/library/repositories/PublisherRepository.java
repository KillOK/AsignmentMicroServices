package com.killok.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.killok.library.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
	@Query("from Publisher where publisherName like %:searchString%")
	public List<Publisher> readPublishersByTitle(@Param(value = "searchString") String title);
}