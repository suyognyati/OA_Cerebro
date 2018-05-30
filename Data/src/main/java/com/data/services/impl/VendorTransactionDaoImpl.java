package com.data.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.Vendor;
import com.data.entities.VendorTransaction;
import com.data.repository.VendorTransactionJpaRepository;
import com.data.services.VendorTransactionDao;

@Service("vendorTransactionDao")
public class VendorTransactionDaoImpl implements VendorTransactionDao {

	@Autowired
	VendorTransactionJpaRepository vendorTransactionJpaRepository;
	
	@Override
	public List<VendorTransaction> getTransactionHistory(Vendor vendor, Date from, Date to) {
		List<VendorTransaction> transactions = vendorTransactionJpaRepository.findByVendorAndTransactionDateTimeIsBetween(vendor, from, to);
		return transactions;
	}

	@Override
	public VendorTransaction debit(Vendor vendor, Float amount) {
		VendorTransaction lastTransaction = null;
		VendorTransaction debitTransaction = new VendorTransaction();
		
		Integer transactionNo = vendorTransactionJpaRepository.findMaxTransactionNoByVendor(vendor);
		
		Integer newTransactionNo = transactionNo + 1;
		Float balance = 0f;
		
		if(transactionNo > 0) {
			lastTransaction = vendorTransactionJpaRepository.findByVendorAndTransactionNo(vendor, transactionNo);
			if(lastTransaction == null)
				return null;
			
			balance = lastTransaction.getBalance();
		}		
		
		debitTransaction.setDebit(amount);
		debitTransaction.setTransactionDateTime(new Date());
		debitTransaction.setTransactionNo(newTransactionNo);
		debitTransaction.setVendor(vendor);
		Boolean success = debitTransaction.updateBalanceFromAvailableBalance(balance);
		
		if(!success)
			return null;
		
		return vendorTransactionJpaRepository.save(debitTransaction);
	}

	@Override
	public VendorTransaction credit(Vendor vendor, Float amount) {
		VendorTransaction lastTransaction = null;
		VendorTransaction creditTransaction = new VendorTransaction();
		
		Integer transactionNo = vendorTransactionJpaRepository.findMaxTransactionNoByVendor(vendor);
		
		Integer newTransactionNo = transactionNo + 1;
		Float balance = 0f;
		
		if(transactionNo > 0) {
			lastTransaction = vendorTransactionJpaRepository.findByVendorAndTransactionNo(vendor, transactionNo);
			if(lastTransaction == null)
				return null;
			
			balance = lastTransaction.getBalance();
		}
		
		creditTransaction.setCredit(amount);
		creditTransaction.setTransactionDateTime(new Date());
		creditTransaction.setTransactionNo(newTransactionNo);
		creditTransaction.setVendor(vendor);
		Boolean success = creditTransaction.updateBalanceFromAvailableBalance(balance);
		
		if(!success)
			return null;
		
		return vendorTransactionJpaRepository.save(creditTransaction);
	}

}
