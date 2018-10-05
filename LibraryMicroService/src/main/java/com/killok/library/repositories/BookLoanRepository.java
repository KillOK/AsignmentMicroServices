package com.killok.library.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.killok.library.entity.BookCopy;
import com.killok.library.entity.BookCopyId;
import com.killok.library.entity.BookLoan;
import com.killok.library.entity.BookLoanId;

	@Repository
	public interface BookLoanRepository extends JpaRepository<BookLoan, BookLoanId> {
		@Query("from BookLoan where branchId = :newbranchId and cardNo = :newCardNo and bookId = :newBookId and dueDate = :newDueDate")
		public List<BookLoan> readBookLoanById(@Param(value = "newbranchId") int branchId, @Param(value = "newCardNo")int newCardNo, @Param(value = "newBookId")int newBookId , @Param(value = "newDueDate")Date newDueDate );                       
		
		@Transactional
		@Modifying (flushAutomatically = true, clearAutomatically = true)
		@Query(value="update tbl_book_loans set dueDate =:newDate where cardNo =:card and branchId =:branch and bookId =:book and dueDate =:oldDate", nativeQuery=true)
		void overrideDueDate(@Param("book") int book, @Param("branch") int branch, @Param("card") int card, @Param("oldDate") Date oldDate, @Param("newDate") Date newDate);
		
	}
	
	