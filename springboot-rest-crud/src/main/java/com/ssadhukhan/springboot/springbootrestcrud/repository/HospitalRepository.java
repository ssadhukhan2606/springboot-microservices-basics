package com.ssadhukhan.springboot.springbootrestcrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssadhukhan.springboot.springbootrestcrud.model.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Integer> {

}