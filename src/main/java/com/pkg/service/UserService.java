package com.pkg.service;

import java.util.List;

import com.pkg.dto.UserDTO;

public interface UserService {
	UserDTO addUser(UserDTO dto);

	void deleteUser(int userId);

	UserDTO updateUser(UserDTO dto);

	UserDTO getUser(int userId);

	List<UserDTO> getAllUser();
}
