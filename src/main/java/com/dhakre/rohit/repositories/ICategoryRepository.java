package com.dhakre.rohit.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhakre.rohit.entities.CategoryEntity;

@Repository
@Transactional
public interface ICategoryRepository extends CrudRepository<CategoryEntity, Integer> {

}
