package com.ssadhukhan.springboot.springbootrestcrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssadhukhan.springboot.springbootrestcrud.model.Hospital;
import com.ssadhukhan.springboot.springbootrestcrud.repository.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;

	public List<Hospital> getAllHospitals() {
		Iterable<Hospital> iterableHospital = hospitalRepository.findAll();
		ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
		iterableHospital.forEach(e -> hospitalList.add(e));
		return hospitalList;
	}

	public Hospital getHospital(int id) {
		return hospitalRepository.findById(id).get();
	}

	public void addHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	public void updateHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	public void deleteHospital(Hospital hospital) {
		hospitalRepository.delete(hospital);
	}
}
