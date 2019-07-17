package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;

public class AccountApp {
	public static void main(String[] args) {
		
		
		Account steve = new Account("Steve", "Jones", 4253);
		Account bill = new Account("Bill", "Higgs", 4253);
		Account bill2 = new Account("Bill", "Biggs", 4343);
		Account fred = new Account("Fred", "Stevens", 2345);
		AccountMapRepository repo = new AccountMapRepository();
		
		
		repo.createAccount(steve);
		repo.createAccount(bill);
		repo.createAccount(bill2);
		repo.getAllAccounts();
		repo.lookUpAccounts("Bill");
//		repo.deleteAccount(0);
//		System.out.println("hi");
//		repo.getAllAccounts();
//		System.out.println("hi");
//		repo.updateAccount(1, fred);
//		repo.getAllAccounts();
		//updateAccount(Long id, String account);

	}
}
