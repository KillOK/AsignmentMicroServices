package com.killok.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.killok.library.entity.Genre;

@Repository
public interface GenreRepoSitory extends JpaRepository<Genre, Integer> {
	@Query("from Genre where genreName like %:searchString%")
	public List<Genre> readGenresByTitle(@Param(value = "searchString") String title);
}
