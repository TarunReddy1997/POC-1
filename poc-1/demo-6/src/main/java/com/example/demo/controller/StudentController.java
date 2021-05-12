package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;


@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return service.create(student);
	}
	
	 @GetMapping("/getAllStudents")
	    public Iterable<Student> getAllStudents(){
	    return service.getallStudent();
	        
	    }
	 
	 @GetMapping("/getAllStudentsBypage")
	 public ResponseEntity<List<Student>> getallStudentsPages(@RequestParam(defaultValue = "0") Integer pageNo,@RequestParam(defaultValue = "2") Integer pageSize) {
		 List<Student> list = service.getAllStudentsPage(pageNo, pageSize);
		 return new ResponseEntity<List<Student>>(list, new HttpHeaders(),HttpStatus.OK);
	 }
}
