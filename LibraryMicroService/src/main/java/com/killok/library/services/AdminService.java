package com.killok.library.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.killok.library.entity.Author;
import com.killok.library.entity.Book;
import com.killok.library.entity.BookCopy;
import com.killok.library.entity.BookLoan;
import com.killok.library.entity.BookLoanId;
import com.killok.library.entity.Borrower;
import com.killok.library.entity.Genre;
import com.killok.library.entity.Publisher;
import com.killok.library.repositories.AuthorRepository;
import com.killok.library.repositories.BookCopyRepository;
import com.killok.library.repositories.BookLoanRepository;
import com.killok.library.repositories.BookRepository;
import com.killok.library.repositories.BorrowerRepository;
import com.killok.library.repositories.GenreRepoSitory;
import com.killok.library.repositories.PublisherRepository;

@RestController
public class AdminService {

	@Autowired
	AuthorRepository authorRepo;

	@Autowired
	BookRepository bookRepo;

	@Autowired
	GenreRepoSitory genreRepo;

	@RequestMapping(value = "/lms/readAuthors", method = RequestMethod.GET, produces = "application/json")
	public List<Author> readAllAuthors(@RequestParam(required = false) String searchString) {
		List<Author> authors = new ArrayList<>();
		try {
			if (!searchString.isEmpty()) {
				authors = authorRepo.readAuthorsByName(searchString);
			} else {
				authors = (List<Author>) authorRepo.findAll();
			}
		} catch (Exception e) {
			authors = (List<Author>) authorRepo.findAll();
			e.printStackTrace();
		}
		return authors;
	}

	@RequestMapping(value = "/lms/readAuthors/{searchString}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Author> readAuthorsByName(@PathVariable("searchString") String searchString) {
		List<Author> authors = new ArrayList<>();
		try {
			if (!searchString.isEmpty()) {
				authors = authorRepo.readAuthorsByName(searchString);
			} else {
				authors = (List<Author>) authorRepo.findAll();
			}
		} catch (Exception e) {
			authors = (List<Author>) authorRepo.findAll();
			e.printStackTrace();
		}
		return authors;
	}

	@Transactional
	@RequestMapping(value = "/lms/saveAuthor", method = RequestMethod.POST, consumes = "application/json")
	public String saveAuthor(@RequestBody Author author) {
		String returnString = "";
		try {
			if (author.getAuthorId() != null && author.getAuthorName() != null) {
				authorRepo.save(author);
				returnString = "Auther updated sucessfully";
			} else if (author.getAuthorId() != null) {
				authorRepo.deleteById(author.getAuthorId());
				returnString = "Auther deleted sucessfully";
			} else {
				authorRepo.save(author);
				returnString = "Auther saved sucessfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "Error... try again";
		}
		return returnString;
	}

	////////////////////////////////////////// Books////////////////////////////////////////////////////////////

	@RequestMapping(value = "/lms/readAllBooks", method = RequestMethod.GET, produces = "application/json")
	public List<Book> readAllBooks(@RequestParam(required = false) String searchString) {
		List<Book> books = new ArrayList<>();
		try {
			if (!searchString.isEmpty()) {
				books = bookRepo.readBooksByTitle(searchString);
			} else {
				books = (List<Book>) bookRepo.findAll();
			}
		} catch (Exception e) {
			books = (List<Book>) bookRepo.findAll();
			e.printStackTrace();
		}
		return books;
	}

	@RequestMapping(value = "/lms/readAllBooks/{searchString}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Book> readBooks(@PathVariable("searchString") String searchString) {
		List<Book> books = new ArrayList<>();
		try {
			if (!searchString.isEmpty()) {
				books = bookRepo.readBooksByTitle(searchString);
			} else {
				books = (List<Book>) bookRepo.findAll();
			}
		} catch (Exception e) {
			books = (List<Book>) bookRepo.findAll();
			e.printStackTrace();
		}
		return books;
	}

	@Transactional
	@RequestMapping(value = "/lms/updateBook", method = RequestMethod.POST, consumes = "application/json")
	public String saveBook(@RequestBody Book book) {
		String returnString = "";
		try {
			if (book.getBookId() != null && book.getTitle() != null) {
				bookRepo.save(book);
				returnString = "Book updated sucessfully";
			} else if (book.getBookId() != null) {
				bookRepo.deleteById(book.getBookId());
				returnString = "Book deleted sucessfully";
			} else {
				bookRepo.save(book);
				returnString = "Book saved sucessfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "Error... try again";
		}
		return returnString;
	}

/////////////////////////////////////////////////////////Genre///////////////////////////////////////////////////

	@RequestMapping(value = "/lms/readAllGenres", method = RequestMethod.GET, produces = "application/json")
	public List<Genre> readAllGenres(@RequestParam(required = false) String searchString) {
		List<Genre> genres = new ArrayList<>();
		try {
			if (searchString!=null&&!searchString.isEmpty()) {
				genres = genreRepo.readGenresByTitle(searchString);
			} else {
				genres = (List<Genre>) genreRepo.findAll();
			}
		} catch (Exception e) {
			genres = (List<Genre>) genreRepo.findAll();
			e.printStackTrace();
		}
		return genres;
	}

	@RequestMapping(value = "/lms/readAllGenres/{searchString}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Genre> readGenres(@PathVariable(value="searchString", required = false) String searchString) {
		List<Genre> genres = new ArrayList<>();
		try {
			if (searchString!=null&&!searchString.isEmpty()) {
				genres = genreRepo.readGenresByTitle(searchString);
			} else {
				genres = (List<Genre>) genreRepo.findAll();
			}
		} catch (Exception e) {
			genres = (List<Genre>) genreRepo.findAll();
			e.printStackTrace();
		}
		return genres;
	}

	@Transactional
	@RequestMapping(value = "/lms/updateGenre", method = RequestMethod.POST, consumes = "application/json")
	public String saveGenre(@RequestBody Genre genre) {
		String returnString = "";
		try {
			if (genre.getGenreId() != null && genre.getGenreName() != null) {
				genreRepo.save(genre);
				returnString = "Genre updated sucessfully";
			} else if (genre.getGenreId() != null) {
				genreRepo.deleteById(genre.getGenreId());
				returnString = "Genre deleted sucessfully";
			} else {
				genreRepo.save(genre);
				returnString = "Genre saved sucessfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "Error... try again";
		}
		return returnString;
	}
	
	///////////////////////////////////////////Publisher//////////////////////////////////////////////////////////////////
	@Autowired
	PublisherRepository publisherRepo;


	@RequestMapping(value = "/lms/readAllPublishers", method = RequestMethod.GET, produces = "application/json")
	public List<Publisher> readAllPublishers(@RequestParam(required = false) String searchString) {
		List<Publisher> sublishers = new ArrayList<>();
		try {
			if (searchString!=null&&!searchString.isEmpty()) {
				sublishers = publisherRepo.readPublishersByTitle(searchString);
			} else {
				sublishers = (List<Publisher>) publisherRepo.findAll();
			}
		} catch (Exception e) {
			sublishers = (List<Publisher>) publisherRepo.findAll();
			e.printStackTrace();
		}
		return sublishers;
	}

	@RequestMapping(value = "/lms/readAllPublishers/{searchString}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Publisher> readPublishers(@PathVariable(value="searchString", required = false) String searchString) {
		List<Publisher> sublishers = new ArrayList<>();
		try {
			if (searchString!=null&&!searchString.isEmpty()) {
				sublishers = publisherRepo.readPublishersByTitle(searchString);
			} else {
				sublishers = (List<Publisher>) publisherRepo.findAll();
			}
		} catch (Exception e) {
			sublishers = (List<Publisher>) publisherRepo.findAll();
			e.printStackTrace();
		}
		return sublishers;
	}

	@Transactional
	@RequestMapping(value = "/lms/updatePublisher", method = RequestMethod.POST, consumes = "application/json")
	public String savePublisher(@RequestBody Publisher genre) {
		String returnString = "";
		try {
			if (genre.getPublisherId() != null && genre.getPubName() != null) {
				publisherRepo.save(genre);
				returnString = "Publisher updated sucessfully";
			} else if (genre.getPublisherId() != null) {
				publisherRepo.deleteById(genre.getPublisherId());
				returnString = "Publisher deleted sucessfully";
			} else {
				publisherRepo.save(genre);
				returnString = "Publisher saved sucessfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "Error... try again";
		}
		return returnString;
	}
	
	////////////////////////////////////////////BookCopy/////////////////////////////////////////////////////////////
	
	@Autowired
	BookCopyRepository copyRepo;

///////////////////////////////didn't finish, but lower one does the same with path variables////////////////////////////
	
	
//	@RequestMapping(value = "/lms/readAllBookCopys", method = RequestMethod.GET, produces = "application/json")
//	public List<BookCopy> readAllBookCopys(@RequestParam(required = false) int bookId,@RequestParam(required = false) int branchId) {
//		List<BookCopy> sublishers = new ArrayList<>();
//		try {
//			if (bookId!=0 &&branchId!=0) {
//				sublishers = copyRepo.readBookCopyByName(bookId, branchId);
//			} else {
//				sublishers = (List<BookCopy>) copyRepo.findAll();
//			}
//		} catch (Exception e) {
//			sublishers = (List<BookCopy>) copyRepo.findAll();
//			e.printStackTrace();
//		}
//		return sublishers;
//	}
	
	@RequestMapping(value = "/lms/readAllBookCopies/{branchId}", method = RequestMethod.GET, produces = "application/json")
	public List<BookCopy> readAllBookCopys(@PathVariable(value="branchId", required=false) Integer branchId) {
		List<BookCopy> sublishers = new ArrayList<>();
		try {	
				if(branchId!=0&&branchId!=null) {
					sublishers = copyRepo.readBookCopiesByBranchId(branchId);
				}
				else {
					System.out.println("\n\n\n"+branchId+"\n\n\n");
					sublishers = copyRepo.findAll();
				}
		} catch (Exception e) {
//			sublishers = (List<BookCopy>) copyRepo.findAll();
			e.printStackTrace();
		}
		return sublishers;
	}
	
	@RequestMapping(value = "/lms/readAllBookCopies", method = RequestMethod.GET, produces = "application/json")
	public List<BookCopy> readAllBookCopys() {
		List<BookCopy> sublishers = new ArrayList<>();
		sublishers = copyRepo.findAll();
		return sublishers;
	}

	@Transactional
	@RequestMapping(value = "/lms/updateBookCopy", method = RequestMethod.POST, consumes = "application/json")
	public String saveBookCopy(@RequestBody BookCopy copy) {
		String returnString = "";
		try {
			if (copy.getBookCopyId()!=null) {
				copyRepo.save(copy);
				returnString = "BookCopy updated sucessfully";
			} else {
				returnString = "You can only update book copies in the library";
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "Error... try again";
		}
		return returnString;
	}
	
	///////////////////////////////////////Borrowers//////////////////////////////////////////////////////////
	
	
	@Autowired
	BorrowerRepository borrowerRepo;
	

	@RequestMapping(value = "/lms/getBorrowers", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Borrower> readBorrowers(@RequestParam(value="borrowerId", required = false) Integer borrowerId) {
		List<Borrower> sublishers = new ArrayList<>();
		try {
		if (borrowerId!=null) {
				sublishers = borrowerRepo.getBorrowerByCardNo(borrowerId);
			} else sublishers = (List<Borrower>) borrowerRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sublishers;
	}

	@RequestMapping(value = "/lms/getBorrowers/", method = RequestMethod.GET, produces = "application/json")
	public List<Borrower> readAllBorrowers() {
		List<Borrower> borrowers = new ArrayList<>();
		try {
			borrowers = (List<Borrower>) borrowerRepo.findAll();
		} catch (Exception e) {
			borrowers = (List<Borrower>) borrowerRepo.findAll();
			e.printStackTrace();
		}
		return borrowers;
	}
	
	
	@Transactional
	@RequestMapping(value = "/lms/updateBorrower", method = RequestMethod.POST, consumes = "application/json")
	public String saveBorrower(@RequestBody Borrower borrower) {
		String returnString = "";
		try {
			if (borrower.getCardNo() != null && (borrower.getName()!=null||borrower.getAdress()!=null||borrower.getPhone()!=null)) {
				borrowerRepo.save(borrower);
				returnString = "Borrower updated sucessfully";
			} else if(borrower.getName()!=null||borrower.getAdress()!=null||borrower.getPhone()!=null&&(borrower.getCardNo()==0||new Integer(borrower.getCardNo())==null)){
				borrowerRepo.save(borrower);
				returnString = "Borrower saved sucessfully";
			}else if(borrower.getCardNo() != null){
				borrowerRepo.delete(borrower);
				returnString = "Borrower deleted sucessfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "Error... try again";
		}
		return returnString;
	}
	
	
	//////////////////////////////////////////BookLoan//////////////////////////////////////////////////////////
	
	@Autowired
	BookLoanRepository loanRepository;
	
	
	@RequestMapping(value = "/lms/getBookLoans/", method = RequestMethod.GET, produces = "application/json")
	public List<BookLoan> readAllBookLoans() {
		List<BookLoan> loans = new ArrayList<>();
		try {
			loans = (List<BookLoan>) loanRepository.findAll();
		} catch (Exception e) {
			loans = (List<BookLoan>) loanRepository.findAll();
			e.printStackTrace();
		}
		return loans;
	}
	
	@RequestMapping(value = "/lms/getBookLoans", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<BookLoan> readBookLoans(
			@RequestParam(value="bookId", required = false) Integer bookId,
			@RequestParam(value="branchId", required = false) Integer branchId,
			@RequestParam(value="cardNo", required = false) Integer cardNo,
			@RequestParam(value="dueDate", required = false) Date dueDate) {
		List<BookLoan> sublishers = new ArrayList<>();
		try {
		if (bookId!=null&&branchId!=null&&cardNo!=null&&dueDate!=null) {
				sublishers = loanRepository.readBookLoanById(branchId, cardNo, bookId, dueDate);
			} else sublishers = (List<BookLoan>) loanRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sublishers;
	}
	//////////////////////Doesn't work...///////////////////////////////////////////////////////////////////
	@Transactional
	@RequestMapping(value = "/lms/updateBookLoan", method = RequestMethod.POST, consumes = "application/json")
	public String saveBookLoan(@RequestBody BookLoan loan) {
		String returnString = "";
		try {
			if (loan.getBookLoanId()!=null) {
				loanRepository.save(loan);
				returnString = "BookLoan updated sucessfully";
			} else {
				returnString = "Please send correct data";
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "Error... try again";
		}
		return returnString;
	}
	
	@Transactional
	@RequestMapping(value = "/lms/overrideDueDate", method = RequestMethod.POST, consumes = "application/json")
	public String overrideDueDate(@RequestBody BookLoan loan) {
		String returnString = "";
		try {
			if (loan.getBookLoanId()!=null) {
				BookLoanId id = loan.getBookLoanId();
				id.setDueDate(new Date(loan.getBookLoanId().getDueDate().getTime()+(7*24*3600*1000)));
				loan.setBookLoanId(id);
				loanRepository.save(loan);
				returnString = "BookLoan updated sucessfully";
			} else {
				returnString = "Please send correct data";
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "Error... try again";
		}
		return returnString;
	}
	
}


















