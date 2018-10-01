package com.killok.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.killok.library.entity.BookCopy;
import com.killok.library.entity.BookCopyId;

	@Repository
	public interface BookCopyRepository extends JpaRepository<BookCopy, BookCopyId> {
		@Query("from BookCopy where branchId like %:newbranchId%")
		public List<BookCopy> readBookCopiesByBranchId(@Param(value = "newbranchId") int branchId);
	}