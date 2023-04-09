package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.Entity.Students;

public interface StudentRepository extends JpaRepository<Students, Integer> {
	public List<Students> findByName(String name);

	public Students findByIdAndEmail(int id, String email);

	public List<Students> findByFeesGreaterThan(double fees);

	public List<Students> findByFeesLessThan(double fees);
}
