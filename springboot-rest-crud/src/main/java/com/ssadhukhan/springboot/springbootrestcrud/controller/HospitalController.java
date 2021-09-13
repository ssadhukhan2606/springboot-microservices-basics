package com.ssadhukhan.springboot.springbootrestcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssadhukhan.springboot.springbootrestcrud.model.Hospital;
import com.ssadhukhan.springboot.springbootrestcrud.service.HospitalService;

@RestController
@RequestMapping("/springboot-rest-crud/")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private ObjectMapper om;

	@GetMapping("/hospitals/{id}")
	public @ResponseBody Hospital getHospital(@PathVariable("id") int id) throws Exception {

		return hospitalService.getHospital(id);
	}

	@GetMapping("/hospitals/")
	public @ResponseBody List<Hospital> getAllHospitals() throws Exception {
		return hospitalService.getAllHospitals();
	}

	@PostMapping("/hospitals/")
	public ResponseEntity<String> addHospital(@RequestBody Hospital hospital) throws JsonProcessingException {

		hospitalService.addHospital(hospital);
		return new ResponseEntity<String>(om.writeValueAsString(hospital), HttpStatus.OK);
	}

	@PutMapping("/hospitals/")
	public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital) throws JsonProcessingException {
		hospitalService.updateHospital(hospital);
		return new ResponseEntity<String>(om.writeValueAsString(hospital), HttpStatus.OK);

	}

	@DeleteMapping("/hospitals/")
	public ResponseEntity<String> deleteHospital(@RequestBody Hospital hospital) throws JsonProcessingException {

		hospitalService.deleteHospital(hospital);
		return new ResponseEntity<String>(om.writeValueAsString(hospital), HttpStatus.NO_CONTENT);

	}

}
