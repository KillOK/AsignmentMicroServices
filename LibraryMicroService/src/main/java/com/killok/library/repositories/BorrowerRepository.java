package com.killok.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.killok.library.entity.BookCopy;
import com.killok.library.entity.BookCopyId;
import com.killok.library.entity.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {
	@Query("from Borrower where cardNo = :borrowerId ")
	public List<Borrower> getBorrowerByCardNo(@Param(value = "borrowerId") int borrowerId);
}