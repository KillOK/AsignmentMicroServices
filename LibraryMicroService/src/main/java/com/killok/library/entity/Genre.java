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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
	
	/**
	 * @author ppradhan
	 *
	 */
	@Entity
	@Table(name="tbl_genre", catalog="library")
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="genreName", scope=Genre.class)
	public class Genre {
		@Id
		@Column(name="genre_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer genreId;
		@Column(name="genre_name")
		private String genreName;
		
		@ManyToMany(fetch=FetchType.EAGER, mappedBy="genres")
		private List<Book> books;
		/**
		 * @return the genreId
		 */
		public Integer getGenreId() {
			return genreId;
		}
		/**
		 * @param genreId the genreId to set
		 */
		public void setGenreId(Integer genreId) {
			this.genreId = genreId;
		}
		/**
		 * @return the genreName
		 */
		public String getGenreName() {
			return genreName;
		}
		/**
		 * @param genreName the genreName to set
		 */
		public void setGenreName(String genreName) {
			this.genreName = genreName;
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
			result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
			result = prime * result + ((genreName == null) ? 0 : genreName.hashCode());
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
			Genre other = (Genre) obj;
			if (genreId == null) {
				if (other.genreId != null)
					return false;
			} else if (!genreId.equals(other.genreId))
				return false;
			if (genreName == null) {
				if (other.genreName != null)
					return false;
			} else if (!genreName.equals(other.genreName))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Genre [genreId=" + genreId + ", genreName=" + genreName + "]";
		}
		
		
	}
