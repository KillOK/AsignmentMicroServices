package com.killok.library;

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

import com.killok.library.entity.BookLoan;
import com.killok.library.entity.BookLoan;
import com.killok.library.repositories.BookCopyRepository;
import com.killok.library.repositories.BookLoanRepository;
import com.killok.library.repositories.BookLoanRepository;

public class NewClass {

//	@Autowired
//	BookLoanRepository loanRepository;
//
//
//	@RequestMapping(value = "/lms/getBookLoans", method = RequestMethod.GET, produces = "application/json")
//	public List<BookLoan> readAllBookLoans(@RequestParam(required = false) Integer loanId) {
//		List<BookLoan> loans = new ArrayList<>();
//		try {
//			if (loanId!=null&&loanId!=0) {
//				loans = loanRepository.getBookLoanByCardNo(loanId);
//			} else {
//				loans = loanRepository.findAll();
//			}
//		} catch (Exception e) {
//			loans = (List<BookLoan>) loanRepository.findAll();
//			e.printStackTrace();
//		}
//		return loans;
//	}
//
//	@RequestMapping(value = "/lms/getBookLoans/{loanId}", method = RequestMethod.GET, produces = "application/json")
//	@ResponseBody
//	public List<BookLoan> readBookLoans(@PathVariable(value="loanId", required = false) Integer loanId) {
//		List<BookLoan> sublishers = new ArrayList<>();
//		try {
//			if (loanId!=null&&loanId!=0) {
//				sublishers = loanRepository.getBookLoanByCardNo(loanId);
//			} else {
//				sublishers = (List<BookLoan>) loanRepository.findAll();
//			}
//		} catch (Exception e) {
//			sublishers = (List<BookLoan>) loanRepository.findAll();
//			e.printStackTrace();
//		}
//		return sublishers;
//	}
//
//	@Transactional
//	@RequestMapping(value = "/lms/updateBookLoan", method = RequestMethod.POST, consumes = "application/json")
//	public String saveBookLoan(@RequestBody BookLoan loan) {
//		String returnString = "";
//		try {
//			if (loan.getCardNo() != 0 && (loan.getName()!=null||loan.getAdress()!=null||loan.getPhone()!=null)) {
//				loanRepository.save(loan);
//				returnString = "BookLoan updated sucessfully";
//			} else if(loan.getName()!=null||loan.getAdress()!=null||loan.getPhone()!=null&&(loan.getCardNo()==0||new Integer(loan.getCardNo())==null)){
//				loanRepository.save(loan);
//				returnString = "BookLoan saved sucessfully";
//			}else if(loan.getCardNo()!=0){
//				loanRepository.delete(loan);
//				returnString = "BookLoan deleted sucessfully";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			returnString = "Error... try again";
//		}
//		return returnString;
//	}
//	
	
	@Autowired
	BookLoanRepository loanRepository;
	
	
//	@RequestMapping(value = "/lms/getBookLoans", method = RequestMethod.GET, produces = "application/json")
//	@ResponseBody
//	public List<BookLoan> readBookLoans(
//			@RequestParam(value="bookId", required = false) Integer bookId,
//			@RequestParam(value="branchId", required = false) Integer branchId,
//			@RequestParam(value="cardNo", required = false) Integer cardNo,
//			@RequestParam(value="dueDate", required = false) Date dueDate) {
//		List<BookLoan> sublishers = new ArrayList<>();
//		try {
//		if (bookId!=null&&branchId!=null&&cardNo!=null&&dueDate!=null) {
//				sublishers = loanRepository.readBookLoanById(branchId, cardNo, bookId, dueDate);
//			} else sublishers = (List<BookLoan>) loanRepository.findAll();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return sublishers;
//	}

//	@RequestMapping(value = "/lms/getBookLoans/", method = RequestMethod.GET, produces = "application/json")
//	public List<BookLoan> readAllBookLoans() {
//		List<BookLoan> loans = new ArrayList<>();
//		try {
//			loans = (List<BookLoan>) loanRepository.findAll();
//		} catch (Exception e) {
//			loans = (List<BookLoan>) loanRepository.findAll();
//			e.printStackTrace();
//		}
//		return loans;
//	}
//	
	
//	@Transactional
//	@RequestMapping(value = "/lms/updateBookLoan", method = RequestMethod.POST, consumes = "application/json")
//	public String saveBookLoan(@RequestBody BookLoan loan) {
//		String returnString = "";
//		try {
//			if (loan.getBookLoanId()!=null) {
//				loanRepository.save(loan);
//				returnString = "BookLoan updated sucessfully";
//			} else {
//				returnString = "Please send correct data";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			returnString = "Error... try again";
//		}
//		return returnString;
//	}
	
}




























