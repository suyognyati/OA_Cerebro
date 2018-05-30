package com.data.services;

import java.util.Date;
import java.util.List;

import com.data.entities.Vendor;
import com.data.entities.VendorTransaction;

public interface VendorTransactionDao {
	/**
	 * This function will give complete transaction history within date range.
	 * @param vendor
	 * @param from date
	 * @param to date
	 * @return List<VendorTransaction>
	 */
	List<VendorTransaction> getTransactionHistory(Vendor vendor, Date from, Date to);
	/**
	 * This will debit the given amount from vendor account
	 * @param vendor
	 * @param amount to be debited
	 * @return
	 */
	VendorTransaction debit(Vendor vendor, Float amount);
	/**
	 * This will credit the given amount in vendor account
	 * @param vendor
	 * @param amount
	 * @return
	 */
	VendorTransaction credit(Vendor vendor, Float amount);
}
