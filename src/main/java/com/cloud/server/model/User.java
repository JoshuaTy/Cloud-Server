package com.cloud.server.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="user")
@DynamicInsert(true)
@DynamicUpdate(true)

public class User{
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstname;
    private String lastname;
    private String userName;
    private String password;
	
	public User(){}

	public User(String fname, String lname, String uName, String pass){
		this.firstname=fname;
		this.lastname=lname;
		this.userName=uName;
		this.password=pass;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
    }
    
    public void setUserName(String userName){
        this.userName= userName;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setPassword(String password){
        this.password= password;
    }

    public String getPassword(){
        return this.password;
    }
}