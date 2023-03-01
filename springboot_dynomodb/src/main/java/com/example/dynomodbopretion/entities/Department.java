package com.example.dynomodbopretion.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamoDBDocument
public class Department {

	@DynamoDBAttribute
	private String departmentName;
	@DynamoDBAttribute
	private String departmentNumber;
	
	
}
