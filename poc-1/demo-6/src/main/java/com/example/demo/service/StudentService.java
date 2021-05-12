package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.example.demo.dao.Studentdao;
import com.example.demo.model.Student;

@Service
public class StudentService {
	@Autowired
	private Studentdao studentdao;

	public Student create(Student student) {
		
		return studentdao.save(student);
	}
	
	public Iterable<Student> getallStudent() {
		return studentdao.findAll();
	}
	
	public List<Student> getAllStudentsPage(Integer pageNo,Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Student> list = studentdao.findAll(pageable);
		if(list.hasContent()) {
			return list.getContent();
		}
		else {
			return new ArrayList<Student>();
		}
	}
}
