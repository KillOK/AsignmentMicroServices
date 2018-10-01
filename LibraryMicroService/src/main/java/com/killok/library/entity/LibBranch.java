package com.killok.library.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tbl_library_branch", catalog="library")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="branchId", scope=LibBranch.class)
public class LibBranch implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int branchId;
	
	private String branchName;
	@Column(name="branchAddress")
	private String branchAdress;
	
	@Column(name="bookId")
//	@JoinColumns({
//		@JoinColumn(name = "bookId", referencedColumnName = "bookId",  insertable = false, updatable = false)
//	,
//		@JoinColumn(name = "branchId", referencedColumnName = "branchId",  insertable = false, updatable = false)
//	})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="bookCopyId.branchId")
	private List<BookCopy> bookCopies;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="bookLoanId.branch")
	private List<BookLoan> bookLoans;
	
	public LibBranch() {}
	public LibBranch(String branchName, String branchAdress) {
		this.branchName = branchName;
		this.branchAdress = branchAdress;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchAdress() {
		return branchAdress;
	}
	public void setBranchAdress(String branchAdress) {
		this.branchAdress = branchAdress;
	}
	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}
	public void setBookCopies(List<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}
	public List<BookLoan> getBookLoans() {
		return bookLoans;
	}
	public void setBookLoans(List<BookLoan> bookLoans) {
		this.bookLoans = bookLoans;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchAdress == null) ? 0 : branchAdress.hashCode());
		result = prime * result + branchId;
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
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
		LibBranch other = (LibBranch) obj;
		if (branchAdress == null) {
			if (other.branchAdress != null)
				return false;
		} else if (!branchAdress.equals(other.branchAdress))
			return false;
		if (branchId != other.branchId)
			return false;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LibBranch [branchId=" + branchId + ", branchName=" + branchName + ", branchAdress=" + branchAdress
				+ "]";
	}

}
