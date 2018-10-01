package com.killok.library.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Embeddable
public class BookCopyId implements Serializable{
	
	private static final long serialVersionUID = -2964859200395411455L;
//	@Column(name="bookId")
	@JoinColumn(name="bookId",  insertable = false, updatable = false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Book bookId;
//	@Column(name="branchId")
	@JoinColumn(name="branchId",  insertable = false, updatable = false)
	@ManyToOne(fetch=FetchType.LAZY)
	private LibBranch branchId;
	public Book getBook() {
		return bookId;
	}
	public void setBook(Book book) {
		this.bookId = book;
	}
	public LibBranch getBranch() {
		return branchId;
	}
	public void setBranch(LibBranch branch) {
		this.branchId = branch;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
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
		BookCopyId other = (BookCopyId) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (branchId == null) {
			if (other.branchId != null)
				return false;
		} else if (!branchId.equals(other.branchId))
			return false;
		return true;
	}
	
	
	
}
