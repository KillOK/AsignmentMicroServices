package com.killok.library.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tbl_book_copies", catalog="library")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="copieNumbersInBranch", scope=BookCopy.class)
public class BookCopy implements Serializable{
	
	@EmbeddedId
	private BookCopyId bookCopyId;
	
	@Column(name="noOfCopies")
	private int copieNumbersInBranch;
	
	public BookCopy() {}
	
	public BookCopyId getBookCopyId() {
		return bookCopyId;
	}

	public void setBookCopyId(BookCopyId bookCopyId) {
		this.bookCopyId = bookCopyId;
	}

	public int getCopieNumbersInBranch() {
		return copieNumbersInBranch;
	}
	public void setCopieNumbersInBranch(int copieNumbersInBranch) {
		this.copieNumbersInBranch = copieNumbersInBranch;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookCopyId == null) ? 0 : bookCopyId.hashCode());
		result = prime * result + copieNumbersInBranch;
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
		BookCopy other = (BookCopy) obj;
		if (bookCopyId == null) {
			if (other.bookCopyId != null)
				return false;
		} else if (!bookCopyId.equals(other.bookCopyId))
			return false;
		if (copieNumbersInBranch != other.copieNumbersInBranch)
			return false;
		return true;
	}
	
	
	
//	@Override
//	public String toString() {
//		return "BookCopies [book=" + book.getTitle() + ", branch=" + branch.getBranchName() + ", copieNumbersInBranch=" + copieNumbersInBranch
//				+ "]";
//	}
	
	
}
