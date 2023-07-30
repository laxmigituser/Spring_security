package com.pkg.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.dto.UserDTO;
import com.pkg.entities.User;
import com.pkg.repository.UserRepository;
import com.pkg.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO addUser(UserDTO dto) {
		// TODO Auto-generated method stub
		User map = this.modelMapper.map(dto, User.class);
		User save = this.userRepository.save(map);
		return this.modelMapper.map(save, UserDTO.class);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(userId);
	}

	@Override
	public UserDTO updateUser(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUser(int userId) {
		// TODO Auto-generated method stub
		Optional<User> findById = this.userRepository.findById(userId);
		return this.modelMapper.map(findById.get(), UserDTO.class);
	}

	@Override
	public List<UserDTO> getAllUser() {
		// TODO Auto-generated method stub
		List<User> findAll = this.userRepository.findAll();
		List<UserDTO> collect = findAll.stream().map(u->this.modelMapper.map(u, UserDTO.class)).collect(Collectors.toList());
		return collect;
	}

}
