package com.dhakre.rohit.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhakre.rohit.entities.BookEntity;

@Repository
@Transactional
public interface IBookRepository extends CrudRepository<BookEntity, Integer> {

	@Query("select b from BookEntity b where categoryId = ?")
	public List<BookEntity> findById(int id);

}
