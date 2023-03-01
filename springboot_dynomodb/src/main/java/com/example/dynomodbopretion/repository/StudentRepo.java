package com.example.dynomodbopretion.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.dynomodbopretion.entities.Student;

@Repository
public class StudentRepo {

	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	// create
	public Student save(Student student) {
		dynamoDBMapper.save(student);
		return student;
	}

	// getAll
	public List<Student> getAll() {
		List<Student> list = dynamoDBMapper.scan(Student.class, new DynamoDBScanExpression());
		return list;
	}

	// get
	public Student getStudentById(String studentId) {
		Student student = dynamoDBMapper.load(Student.class, studentId);
		return student;
	}

	// delete
	public String deleteStudent(String studentId) {
		Student student = dynamoDBMapper.load(Student.class, studentId);
		dynamoDBMapper.delete(student);
		return "Student deleted";
	}

	// update
	public String updateStudent(String studentId, Student student) {
		dynamoDBMapper.save(student, new DynamoDBSaveExpression().withExpectedEntry("studentId",
				new ExpectedAttributeValue(new AttributeValue().withS(studentId))));
		return studentId;
	}

}
