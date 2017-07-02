package com.dhakre.rohit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dhakre.rohit.entities.UserEntity;

@Repository
@Transactional
public interface IUserRepository extends CrudRepository<UserEntity, Integer> {

	@Query("select u from UserEntity u where u.userName = ? and u.password = ? and u.userType = ?")
	public List<UserEntity> findUser(String userName, String password, String userType);

}
