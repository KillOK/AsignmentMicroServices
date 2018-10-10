/**
 * 
 */
package com.killok.library.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


	@Entity
	@Table(name="tbl_author", catalog="library")
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="authorName", scope=Author.class)
	public class Author {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer authorId;
		
		private String authorName;
		
		@ManyToMany(fetch=FetchType.LAZY, mappedBy="authors")
		private List<Book> books;
		/**
		 * @return the authorId
		 */
		public Integer getAuthorId() {
			return authorId;
		}
		/**
		 * @param authorId the authorId to set
		 */
		public void setAuthorId(Integer authorId) {
			this.authorId = authorId;
		}
		/**
		 * @return the authorName
		 */
		public String getAuthorName() {
			return authorName;
		}
		/**
		 * @param authorName the authorName to set
		 */
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
		/**
		 * @return the books
		 */
		public List<Book> getBooks() {
			return books;
		}
		/**
		 * @param books the books to set
		 */
		public void setBooks(List<Book> books) {
			this.books = books;
		}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
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
		Author other = (Author) obj;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + "]";
	}

}
