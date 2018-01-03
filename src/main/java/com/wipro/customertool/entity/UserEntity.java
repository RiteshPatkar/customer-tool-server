package com.wipro.customertool.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserEntity {
	
	@Id
	private String userId;
	

}
