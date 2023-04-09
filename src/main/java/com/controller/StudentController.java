package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Student.Entity.Students;
import com.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository sr;

	@PostMapping("/savestud")
	public String save(@RequestBody Students s) {
		sr.save(s);
		return "data Saved";
	}

	@GetMapping("/getstud")
	public Students fetchStudById(@RequestParam int id) {
		Optional<Students> o = sr.findById(id);
		Students students = o.get();
		return students;
	}

	@GetMapping("/getUs")
	public List<Students> getStudByEmail(@RequestParam String name) {
		List<Students> students = sr.findByName(name);
		return students;
	}

	@GetMapping("/fetchStudAll")
	public List<Students> fetchAllDetails() {
		List<Students> students = sr.findAll();
		return students;
	}

	@PutMapping("/updatestud")
	public String updateStud(@RequestBody Students s) {
		sr.save(s);
		return "dataupdated";
	}

	@DeleteMapping("/deletestud")
	public String delete(@RequestParam int id) {
		sr.deleteById(id);
		return "deleted";
	}

	@GetMapping("/loginStud")
	public Students loginValidate(@RequestBody Students s) {
		return sr.findByIdAndEmail(s.getId(), s.getEmail());
	}

	@GetMapping("/greaterByPrice")
	public List<Students> findByFeesGreaterThan(@RequestParam double fees) {
		return sr.findByFeesGreaterThan(fees);
	}

	@GetMapping("/lessByPrice")
	public List<Students> findByFeesLessThan(@RequestParam double fees) {
		return sr.findByFeesLessThan(fees);
	}

}
