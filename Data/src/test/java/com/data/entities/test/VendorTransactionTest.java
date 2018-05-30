package com.data.entities.test;


import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.data.entities.Vendor;
import com.data.entities.VendorTransaction;
import com.data.repository.VendorJpaRepository;
import com.data.repository.VendorTransactionJpaRepository;
import com.data.services.VendorTransactionDao;

import config.data.PersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class VendorTransactionTest {
	@Autowired
	VendorTransactionJpaRepository vendorTransactionJpaRepository;
	
	@Autowired
	VendorJpaRepository vendorJpaRepository;
	
	@Autowired
	VendorTransactionDao vendorTransactionDao;
	
	@Test
	public void testGetMaxTransactionNo() {
		Vendor vendor = vendorJpaRepository.findOne(1);
		Integer maxTransaction = vendorTransactionJpaRepository.findMaxTransactionNoByVendor(vendor);
		assertNotNull(maxTransaction);
	}
	
	@Test
	public void testTransactionHistory() {
		
		Vendor vendor = vendorJpaRepository.findOne(1);
		
		Date from = null;				
		Calendar calender = Calendar.getInstance();
		calender.set(2018, 04, 28, 00, 00, 00);
		from = calender.getTime();
		
		Date to = null;				
		calender = Calendar.getInstance();
		calender.set(2018, 04, 30, 00, 00, 00);
		to = calender.getTime();
		
		List<VendorTransaction> transactionHistory = vendorTransactionDao.getTransactionHistory(vendor, from, to);
		
		assertNotNull(transactionHistory);
	}
	
	@Test
	public void testCreditAndDebit() {
		
		//assertNotNull(testCredit());
		//assertNotNull(testDebit());
	}
	
	public VendorTransaction testCredit() {
		Float creditAmount = 10000f;
		Vendor vendor = vendorJpaRepository.findOne(1);
		VendorTransaction credit = vendorTransactionDao.credit(vendor, creditAmount);
		return credit;
	}
	
	public VendorTransaction testDebit() {
		Float debitAmount = 100f;
		Vendor vendor = vendorJpaRepository.findOne(1);
		VendorTransaction debit = vendorTransactionDao.debit(vendor, debitAmount);
		return debit;
	}
}
