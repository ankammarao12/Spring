package com.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;
import com.service.StudentService;

@RestController
//@RequestMapping(path="/api")
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	@RequestMapping("/Hello")
	public String HelloStudent()
	{
		String msg="Welcome to Spring Data Jpa";
		return msg;
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addCoder(@RequestBody Student s)
	{
		Student c1=studentservice.addStudent(s);
		ResponseEntity re=new ResponseEntity<Student>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getStudents")
	public ResponseEntity<List<Student>> getCoders()
	{
		List<Student> lc1=studentservice.getStudents();
		ResponseEntity re=new ResponseEntity<List<Student>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getStudent/{sid}")
	public ResponseEntity<Student> getStudentById(@PathVariable int sid) throws Throwable
	{
		Student c1=studentservice.getStudentById(sid);
		
		ResponseEntity re=new ResponseEntity<Student>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addStudents")
	public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> ls)
	{
		List<Student> le=studentservice.addStudents(ls);
		
		ResponseEntity re=new ResponseEntity<List<Student>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student e) throws Throwable
	{
		Student e1=studentservice.updateStudent(e);
		
		ResponseEntity re=new ResponseEntity<Student>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteStudent")
	public ResponseEntity<String> deleteStudent(@RequestBody Student e)
	{
		studentservice.deleteStudent(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteStudent/{eid}")
	public ResponseEntity<String> deleteStudentById(@PathVariable int eid)
	{
		studentservice.deleteStudentById(eid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getStudentname/{sname}")
	public ResponseEntity<Student> getStudentBySname(@PathVariable String sname) 
	{
		Student c=studentservice.getStudentBySname(sname);
		ResponseEntity re=new ResponseEntity<Student>(c,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getStudentstech/{tech}")
	public ResponseEntity<List<Student>> findByTechSorted(@PathVariable String tech) 
	{
		List<Student> lc=studentservice.findByTechSorted(tech);
		ResponseEntity re=new ResponseEntity<List<Student>>(lc,HttpStatus.OK);
		return re;
	}

}