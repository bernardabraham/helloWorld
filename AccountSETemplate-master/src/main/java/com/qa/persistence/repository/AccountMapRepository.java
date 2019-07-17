package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.persistence.domain.Account;

public class AccountMapRepository implements AccountRepository {
	private int i = 0;
	private int nameCounter = 0;

	Map<Integer, Account> accountMap = new HashMap<Integer, Account>();

	public String getAllAccounts() {
		for (Map.Entry<Integer, Account> account : this.accountMap.entrySet()) {
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr;
			try {
				jsonStr = mapper.writeValueAsString(account);
				System.out.println(jsonStr);
			} catch (JsonProcessingException e) {
				e.printStackTrace();

			}
		}
		return null;
	}

	public String createAccount(Account account) {
		accountMap.put(i, account);
		i++;
		return null;
	}

	public String deleteAccount(int id) {
		accountMap.remove(id);
		return null;
	}

	public String updateAccount(int id, Account account) {
		accountMap.replace(id, account);
		return null;  
	}

	public void lookUpAccounts(String input) {
		for(Map.Entry<Integer, Account> account: this.accountMap.entrySet()) {
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				mapper.writeValueAsString(account);
				if (account.getValue().getFirstName().equals(input)) {
					nameCounter++;
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} 
		}
		System.out.println("The number of times " + input + " appears is " + nameCounter);
	}

}
