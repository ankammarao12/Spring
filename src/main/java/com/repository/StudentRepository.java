package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
	
	Student findBySname(String sname);	
	 
    @Query("Select s from Student s order by s.sname")
	List<Student> findByTechSorted(String tech);

	

}