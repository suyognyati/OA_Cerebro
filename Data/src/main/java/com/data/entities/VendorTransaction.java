package com.data.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the VendorTransactions table.
 */

@Entity
@Table(name="VendorTransactions")
public class VendorTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Integer id;
	
	@Column(name="TransactionNo")
	private Integer transactionNo;
	
	@Column(name="Debit")
	private Float debit;
	
	@Column(name="Credit")
	private Float credit;
	
	@Column(name="Balance")
	private Float balance;
	
	@Column(name="TransactionDateTime")
	private Date transactionDateTime;
	
	@ManyToOne
	@JoinColumn(name="FK_Vendor")
	Vendor vendor;
	
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getTransactionNo() {
			return transactionNo;
		}
		public void setTransactionNo(Integer transactionNo) {
			this.transactionNo = transactionNo;
		}
		public Float getDebit() {
			return debit;
		}
		public void setDebit(Float debit) {
			this.debit = debit;
		}
		public Float getCredit() {
			return credit;
		}
		public void setCredit(Float credit) {
			this.credit = credit;
		}
		public Float getBalance() {
			return balance;
		}
		public Date getTransactionDateTime() {
			return transactionDateTime;
		}
		public void setTransactionDateTime(Date transactionDateTime) {
			this.transactionDateTime = transactionDateTime;
		}
		public Vendor getVendor() {
			return vendor;
		}
		public void setVendor(Vendor vendor) {
			this.vendor = vendor;
		}
		
		public Boolean updateBalanceFromAvailableBalance(Float availableBalance) {
			if(this.credit == null && this.debit == null)
				return false;
			else if(this.credit != null && this.debit != null)
				return false;			
			else if(this.credit != null) {
				this.balance = availableBalance + this.credit;
				return true;
			}
			else if(this.debit != null) {
				this.balance = availableBalance - this.debit;
				return true;
			}
			
			return false;
		}
	
}
