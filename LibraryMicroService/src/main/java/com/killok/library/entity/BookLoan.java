package com.killok.library.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tbl_book_loans", catalog="library")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="bookLoanId", scope=BookLoan.class)
public class BookLoan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6109445534996710037L;
	@EmbeddedId
	private BookLoanId bookLoanId;
	
	public BookLoanId getBookLoanId() {
		return bookLoanId;
	}


	public void setBookLoanId(BookLoanId bookLoanId) {
		this.bookLoanId = bookLoanId;
	}
	
	private Date dateOut;
	private Date dateIn;
	
	public BookLoan() {}
	
	
	public Date getDateOut() {
		return dateOut;
	}
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
	
	public Date getDateIn() {
		return dateIn;
	}
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	
}
