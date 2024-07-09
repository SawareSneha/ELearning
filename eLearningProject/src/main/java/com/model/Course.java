package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
    private long cid;
    private String cname;
    private int duration;
    
	public Course() {
		super();
	}

	public Course(long cid, String cname, int duration) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.duration = duration;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
    
    

}
