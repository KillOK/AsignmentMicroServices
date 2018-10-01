package com.killok.library;

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

import com.killok.library.entity.Borrower;
import com.killok.library.entity.Borrower;
import com.killok.library.repositories.BorrowerRepository;
import com.killok.library.repositories.BorrowerRepository;

public class NewClass {

//	@Autowired
//	BorrowerRepository borrowerRepo;
//
//
//	@RequestMapping(value = "/lms/getBorrowers", method = RequestMethod.GET, produces = "application/json")
//	public List<Borrower> readAllBorrowers(@RequestParam(required = false) Integer borrowerId) {
//		List<Borrower> borrowers = new ArrayList<>();
//		try {
//			if (borrowerId!=null&&borrowerId!=0) {
//				borrowers = borrowerRepo.getBorrowerByCardNo(borrowerId);
//			} else {
//				borrowers = borrowerRepo.findAll();
//			}
//		} catch (Exception e) {
//			borrowers = (List<Borrower>) borrowerRepo.findAll();
//			e.printStackTrace();
//		}
//		return borrowers;
//	}
//
//	@RequestMapping(value = "/lms/getBorrowers/{borrowerId}", method = RequestMethod.GET, produces = "application/json")
//	@ResponseBody
//	public List<Borrower> readBorrowers(@PathVariable(value="borrowerId", required = false) Integer borrowerId) {
//		List<Borrower> sublishers = new ArrayList<>();
//		try {
//			if (borrowerId!=null&&borrowerId!=0) {
//				sublishers = borrowerRepo.getBorrowerByCardNo(borrowerId);
//			} else {
//				sublishers = (List<Borrower>) borrowerRepo.findAll();
//			}
//		} catch (Exception e) {
//			sublishers = (List<Borrower>) borrowerRepo.findAll();
//			e.printStackTrace();
//		}
//		return sublishers;
//	}
//
//	@Transactional
//	@RequestMapping(value = "/lms/updateBorrower", method = RequestMethod.POST, consumes = "application/json")
//	public String saveBorrower(@RequestBody Borrower borrower) {
//		String returnString = "";
//		try {
//			if (borrower.getCardNo() != 0 && (borrower.getName()!=null||borrower.getAdress()!=null||borrower.getPhone()!=null)) {
//				borrowerRepo.save(borrower);
//				returnString = "Borrower updated sucessfully";
//			} else if(borrower.getName()!=null||borrower.getAdress()!=null||borrower.getPhone()!=null&&(borrower.getCardNo()==0||new Integer(borrower.getCardNo())==null)){
//				borrowerRepo.save(borrower);
//				returnString = "Borrower saved sucessfully";
//			}else if(borrower.getCardNo()!=0){
//				borrowerRepo.delete(borrower);
//				returnString = "Borrower deleted sucessfully";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			returnString = "Error... try again";
//		}
//		return returnString;
//	}
//	
}
