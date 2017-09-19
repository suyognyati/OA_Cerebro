package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DocumentList")
public class DocumentList {
	@Id
	@Column(name="DocumentId")
	private Integer documentId;
	
	@Column(name="DocumentName")
	private String documentName;
	
	@Column(name="DocumentDescription")
	private String documentDescription;
	
	@Column(name="DocumentFor", nullable = false)
	private Integer documentFor;

		public Integer getDocumentId() {
			return documentId;
		}	
		public void setDocumentId(Integer documentId) {
			this.documentId = documentId;
		}
	
		public String getDocumentName() {
			return documentName;
		}	
		public void setDocumentName(String documentName) {
			this.documentName = documentName;
		}
	
		public String getDocumentDescription() {
			return documentDescription;
		}	
		public void setDocumentDescription(String documentDescription) {
			this.documentDescription = documentDescription;
		}

		public Integer getRequiredFor() {
			return documentFor;
		}
		/**
		 *@param requiredFor Condition when document required
		 */
		public void setRequiredFor(Integer requiredFor) {
			this.documentFor = requiredFor;
		}
}
