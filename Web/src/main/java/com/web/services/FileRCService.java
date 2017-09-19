package com.web.services;

import org.springframework.web.multipart.MultipartFile;

import com.data.entities.User;

public interface FileRCService {
	Object saveFile(User user, MultipartFile file);
}
