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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="dateIn", scope=BookLoan.class)
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookLoanId == null) ? 0 : bookLoanId.hashCode());
		result = prime * result + ((dateIn == null) ? 0 : dateIn.hashCode());
		result = prime * result + ((dateOut == null) ? 0 : dateOut.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookLoan other = (BookLoan) obj;
		if (bookLoanId == null) {
			if (other.bookLoanId != null)
				return false;
		} else if (!bookLoanId.equals(other.bookLoanId))
			return false;
		if (dateIn == null) {
			if (other.dateIn != null)
				return false;
		} else if (!dateIn.equals(other.dateIn))
			return false;
		if (dateOut == null) {
			if (other.dateOut != null)
				return false;
		} else if (!dateOut.equals(other.dateOut))
			return false;
		return true;
	}
	
}
