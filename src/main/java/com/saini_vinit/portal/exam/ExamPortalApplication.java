package com.saini_vinit.portal.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.saini_vinit.portal.exam.service.UserService;

@SpringBootApplication
public class ExamPortalApplication{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * System.out.println("starting code");
	 * 
	 * 
	 * for(int i=0;i<1000;i++) { User user=new User();
	 * 
	 * user.setFirstName("vinit"); user.setLastName("saini");
	 * user.setEmail("vinitsaini357@gmail.com"); user.setPassword("asjkdkasd");
	 * user.setProfile("default.png"); user.setPhone("+91-9759561482803");
	 * user.setUsername(new Date().getTime()+"");
	 * 
	 * 
	 * Role role=new Role();
	 * 
	 * role.setRoleName("Admin");
	 * 
	 * List<UserRole> userRoleSet=new ArrayList<>();
	 * 
	 * UserRole userRole=new UserRole();
	 * 
	 * userRole.setRole(role); userRole.setUser(user);
	 * 
	 * userRoleSet.add(userRole);
	 * 
	 * 
	 * this.userService.createUser(user, userRoleSet);
	 * 
	 * 
	 * } }
	 * 
	 * 
	 * 
	 */
}
