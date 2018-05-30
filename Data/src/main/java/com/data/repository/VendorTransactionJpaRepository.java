package com.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.data.entities.Vendor;
import com.data.entities.VendorTransaction;

@Repository("vendorTransactionJpaRepository")
public interface VendorTransactionJpaRepository extends JpaRepository<VendorTransaction, Integer> {
	
	
	/**
	 * To get transaction detail by TransactionNo and vendor
	 * @param vendor
	 * @param transactionNo
	 * @return VendorTransaction
	 */
	VendorTransaction findByVendorAndTransactionNo(Vendor vendor, Integer transactionNo);
	
	/**
	 * To get Transaction History of vendor in given date range
	 * @param vendor
	 * @param from
	 * @param to
	 * @return List<VendorTransaction>
	 */
	List<VendorTransaction> findByVendorAndTransactionDateTimeIsBetween(Vendor vendor, Date from, Date to);
	
	/**
	 * To get largest transaction no of vendor. It will return 0 if there are no transactions.
	 * @param vendor
	 * @return Integer
	 */
	@Query("SELECT coalesce(max(vt.transactionNo), 0) FROM VendorTransaction vt WHERE vt.vendor = :vendor")
	Integer findMaxTransactionNoByVendor(@Param("vendor") Vendor vendor);
}
