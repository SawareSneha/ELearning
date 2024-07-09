package com.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    private String name;
	    private String adminPassword;
	    private String adminEmail;
	    private String userName;
	    private String userPassword;
	    
	    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    private List<User> users;

		public Admin() {
			super();
		}

		public Admin(long id, String name, String adminPassword, String adminEmail, String userName,
				String userPassword, List<User> users) {
			super();
			this.id = id;
			this.name = name;
			this.adminPassword = adminPassword;
			this.adminEmail = adminEmail;
			this.userName = userName;
			this.userPassword = userPassword;
			this.users = users;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAdminPassword() {
			return adminPassword;
		}

		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}

		public String getAdminEmail() {
			return adminEmail;
		}

		public void setAdminEmail(String adminEmail) {
			this.adminEmail = adminEmail;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}
	    
		
	    
}
