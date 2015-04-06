package presentation;

import ifGodBless.Template;

import java.util.Date;
import java.util.List;

import dao.Book;
import dao.Loan;
import dao.Magazine;
import dao.Member;
import dao.Membership;

public class MainApp {

	public static void main(String[] args) {

		Book book = new Book();
		book.setIsbn("newISBN");
		book.setTitle("newTITLE");
		// new Template().save(book);
		// List listBooks = new Template().list(book);
		// System.out.println(listBooks);

		Magazine magazine = new Magazine();
		magazine.setIssn("kiki");
		magazine.setTitle("Filip");
		// new Template().deletePublication(magazine, "kikiiiii");
		// new Template().save(magazine);
		// new Template().update(magazine);
		// List list = new Template().list(magazine);
		// System.out.println(list);
		// new Template().UpdateDeletePublications(magazine, "kiki","newIssn" ,
		// "Naslov");

		Member member = new Member();
		 member.setName("Filip");
		 member.setEmail("filipnastevski@gmal.com");

		 //new Template().save(member);
		//new Template().deleteMember(member, "filipnastevski@gmal.com");
		//new Template().updateMember(member, "hristinanastevska@gmal.com", "Hristina Nastevska", "hristinanastevska@gmail.com");
		//List listMembers = new Template().list(member);
		//System.out.println(listMembers);
		
//		Loan loan = new Loan();
//		loan.setMember(member);
//		loan.setPublication(magazine);
		Date startdate = new Date(2015, 10, 1);
		Date enddate = new Date(2016, 10, 1);
//		loan.setStartdate(startdate);
//		loan.setEnddate(enddate);
//		//new Template().save(loan);
//		List loanList=new Template().list(loan);
	//	System.out.println(loanList);
		 Membership mb = new Membership();
		 mb.setEnddate(enddate);
		 mb.setStartdate(startdate);
		 mb.setMemebershiptype("tip");
		 mb.setMemberid(member);
		// new Template().save(mb);
		List listmb = new Template().list(mb);
		
		System.out.println(listmb);
		
		
		

	}

}
