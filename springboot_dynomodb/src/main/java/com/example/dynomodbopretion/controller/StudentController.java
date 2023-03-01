 package com.example.dynomodbopretion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dynomodbopretion.entities.Student;
import com.example.dynomodbopretion.repository.StudentRepo;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	 @Autowired
	    private StudentRepo studentRepo;

	    @GetMapping("/getmessage")
	    public String getEmplyee() {
	        return "Student found";
	    }

	    @GetMapping("/all")
	    public List<Student> getAllEmployee(){
	    	return studentRepo.getAll();
	    }
	    
	    
	    
	    @PostMapping("/save")
	    public Student saveStudent(@RequestBody Student student) {
	        return studentRepo.save(student);
	    }

	    @GetMapping("/getstudent/{studentId}")
	    public Student getStudent(@PathVariable String studentId) {
	        return studentRepo.getStudentById(studentId);
	    }

	    @DeleteMapping("/deletestudent/{studentId}")
	    public String deleteStudent(@PathVariable String studentId) {
	        return studentRepo.deleteStudent(studentId);
	    }

	    @PutMapping("/updatestudent/{studentId}")
	    public String updateStudent(@PathVariable String studentId, @RequestBody Student student) {
	        return studentRepo.updateStudent(studentId, student);
	    }

}
