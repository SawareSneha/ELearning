package com.model;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private double amount;
	    private LocalDateTime paymentDate;
	    private String status;  
	   

	    @OneToOne(fetch = FetchType.EAGER)
	    //@JoinColumn(name = "user_id")
	    private User user;

	    
	    @OneToOne(fetch = FetchType.EAGER)
	    //@JoinColumn(name = "course_id")
	    private Course course;


		public Payment() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Payment(Long id, double amount, LocalDateTime paymentDate, String status, User user, Course course) {
			super();
			this.id = id;
			this.amount = amount;
			this.paymentDate = paymentDate;
			this.status = status;
			this.user = user;
			this.course = course;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public double getAmount() {
			return amount;
		}


		public void setAmount(double amount) {
			this.amount = amount;
		}


		public LocalDateTime getPaymentDate() {
			return paymentDate;
		}


		public void setPaymentDate(LocalDateTime paymentDate) {
			this.paymentDate = paymentDate;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		public Course getCourse() {
			return course;
		}


		public void setCourse(Course course) {
			this.course = course;
		}

	    
}
