package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserEntity;

public interface UserService {

	public UserEntity addUser(UserEntity user);

	public List<UserEntity> getAllUser();

	public UserEntity getUserById(long id);

	public UserEntity updateUser(UserEntity user, long id);

	public void deleteUser(long id);
}
