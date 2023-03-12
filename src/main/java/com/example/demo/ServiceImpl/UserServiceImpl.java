package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository dao;

	@Override
	public UserEntity addUser(UserEntity user) {
		System.out.println("Movie added successfully" + user);
		user.setUserName(user.getUserName());
		user.setMobile(user.getMobile());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		return dao.save(user);
	}

	@Override
	public List<UserEntity> getAllUser() {
		return dao.findAll();
	}

	@Override
	public UserEntity getUserById(long id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public UserEntity updateUser(UserEntity user, long id) {
		UserEntity existingUser = dao.findById(id).orElseThrow(()->new ResourceNotFoundException("User id does not exist!!"));
		

		existingUser.setUserName(user.getUserName());
		existingUser.setMobile(user.getMobile());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		return dao.save(existingUser);
	}

	@Override
	public void deleteUser(long id) {
		UserEntity existsID = dao.findById(id).orElseThrow(()->new ResourceNotFoundException("User id does not exist!!"));
		dao.deleteById(id);
	}

}
