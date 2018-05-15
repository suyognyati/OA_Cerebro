package com.data.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.DocumentList;
import com.data.entities.Enums;
import com.data.entities.UserDetail;
import com.data.entities.UserDocument;
import com.data.repository.UserDocumentJpaRepository;
import com.data.services.DocumentListService;
import com.data.services.UserDocumentService;

@Service("userDocumentService")
public class UserDocumentServiceImpl implements UserDocumentService{
	
	@Autowired
	UserDocumentJpaRepository userDocumentJPARepository;
	
	@Autowired
	DocumentListService documentListService;

	@Override
	public UserDocument getById(Integer userDocumentId) {
		return userDocumentJPARepository.findOne(userDocumentId);
	}
	
	@Override
	public List<UserDocument> getByUserDetail(UserDetail userDetail) {
		List<Integer> stateIn = new ArrayList<Integer>();
		stateIn.add(Enums.DocumentState.Deleted.getId());
		return userDocumentJPARepository.findByUserDetailAndStateNotIn(userDetail, stateIn);
	}

	@Override
	public List<UserDocument> getByDocumentFor(UserDetail userDetail, Integer documentFor) {
		return userDocumentJPARepository.findByUserDetailAndDocumentDocumentFor(userDetail, documentFor);
	}

	@Override
	public List<UserDocument> getByDocuments(UserDetail userDetail, List<DocumentList> documentList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addByDocumentFor(UserDetail userDetail, Integer documentFor) {
		List<DocumentList> documentList = documentListService.getByDocumentFor(documentFor);
		if(documentList.size() > 0) {
			List<UserDocument> userDocuments = new ArrayList<UserDocument>();
			for(DocumentList document : documentList) {
				List<UserDocument> existingDocuments = userDocumentJPARepository.findByUserDetailAndDocument(userDetail, document);
				if(existingDocuments != null && existingDocuments.size() > 0) {
					Boolean needUpdate = false;
					for(UserDocument userDocument : existingDocuments) {
						if(userDocument.getState() == Enums.DocumentState.Deleted.getId()) {
							userDocument.setState(Enums.DocumentState.Created.getId());
							needUpdate = true;
						}
					}
					if(needUpdate) {
						saveDocument(existingDocuments);
					}
				} else {
					UserDocument userDocument = new UserDocument();
					userDocument.setUserDetail(userDetail);
					userDocument.setDocument(document);
					userDocuments.add(userDocument);
				}
			}
			saveDocument(userDocuments);
		}
		return true;
	}

	@Override
	public Boolean deleteByDocumentFor(UserDetail userDetail, Integer documentFor) {
		List<UserDocument> userDocuments = getByDocumentFor(userDetail, documentFor);
		if(userDocuments.size() > 0) {
			for(UserDocument userDocument : userDocuments) {
				userDocument.setState(Enums.DocumentState.Deleted.getId());
			}
			saveDocument(userDocuments);
		}
		return true;
	}

	@Override
	public Boolean deleteByUserDocument(List<UserDocument> userDocuments) {
		userDocumentJPARepository.delete(userDocuments);
		return true;
	}

	@Override
	public Boolean deleteByUserDocument(UserDocument userDocument) {
		userDocumentJPARepository.delete(userDocument);
		return true;
	}

	@Override
	public Boolean saveDocument(UserDocument userDocument) {
		userDocumentJPARepository.save(userDocument);
		return true;
	}

	@Override
	public Boolean saveDocument(List<UserDocument> userDocuments) {
		userDocumentJPARepository.save(userDocuments);
		return true;
	}
	
	
}
