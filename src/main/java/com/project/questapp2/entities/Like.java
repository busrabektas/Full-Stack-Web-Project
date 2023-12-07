package com.project.questapp2.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="p_like")
@Data

public class Like {
	@Id
	Long id;
	//hybernate mapping: mapp like and post 
	@ManyToOne(fetch=FetchType.LAZY) // Determines how to fetch the associated object. lazy: ensures the associated object is loaded when needed
	@JoinColumn(name="post_id", nullable=false) //This annotation is used to match this field with the corresponding column in the database
	@OnDelete(action = OnDeleteAction.CASCADE)//This annotation specifies what happens when the associated object is deleted. OnDeleteAction.CASCADE indicates that when this object is deleted, its associated objects will also be deleted.
	@JsonIgnore //This annotation ensures that this field is ignored during JSON serialization. That is, the value of this field is not exported when converting to JSON format.
	Post post;  //This line shows the field where the associated object is defined. In this example, it indicates that an object of class "User" is held in this field.
	
	//hybernate mapping: mapp user and like 
	@ManyToOne(fetch=FetchType.LAZY) // Determines how to fetch the associated object. lazy: ensures the associated object is loaded when needed
	@JoinColumn(name="user_id", nullable=false) //This annotation is used to match this field with the corresponding column in the database
	@OnDelete(action = OnDeleteAction.CASCADE)//This annotation specifies what happens when the associated object is deleted. OnDeleteAction.CASCADE indicates that when this object is deleted, its associated objects will also be deleted.
	@JsonIgnore //This annotation ensures that this field is ignored during JSON serialization. That is, the value of this field is not exported when converting to JSON format.
	User user;  //This line shows the field where the associated object is defined. In this example, it indicates that an object of class "User" is held in this field.
		

}
