package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="UserDocuments")
public class UserDocument {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UserDocumentId")
	private Integer userDocumentId;
	
	@Column(name="DocumentDescription")
	private String documentDescription;
	
	@Column(name="LocalPath")
	private String localPath;
	
	@Column(name="State")
	private Integer state;
	
	@JoinColumn(name="FK_Document", nullable = false)
	@ManyToOne
	private DocumentList document;
	
	@OneToOne
	@JoinColumn(name="FK_Student", nullable = false)
	private Student student;

		public Integer getUserDocumentId() {
			return userDocumentId;
		}	
		public void setUserDocumentId(Integer userDocumentId) {
			this.userDocumentId = userDocumentId;
		}
	
		public String getDocumentDescription() {
			return documentDescription;
		}	
		public void setDocumentDescription(String documentDescription) {
			this.documentDescription = documentDescription;
		}
	
		public String getLocalPath() {
			return localPath;
		}	
		public void setLocalPath(String localPath) {
			this.localPath = localPath;
		}
	
		public Integer getState() {
			if(state == null)
				state = Enums.DocumentState.Deleted.getId();
			return state;
		}
		public void setState(Integer state) {
			this.state = state;
		}
		
		public DocumentList getDocument() {
			return document;
		}	
		public void setDocument(DocumentList document) {
			this.document = document;
		}
	
		public Student getStudent() {
			return student;
		}	
		public void setStudent(Student student) {
			this.student = student;
		}		
}
