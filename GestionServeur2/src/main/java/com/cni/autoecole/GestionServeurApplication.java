package com.cni.autoecole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cni.autoecole.entities.Admin;
import com.cni.autoecole.services.AdminService;

@SpringBootApplication
//@EnableAutoConfiguration
//(exclude= {SecurityAutoConfiguration.class})
//configuration automatique de tomacat
public class GestionServeurApplication implements CommandLineRunner {
	@Autowired
	private AdminService adminService;

	public static void main(String[] args) {
		SpringApplication.run(GestionServeurApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Admin admin = new Admin();
//		admin.setCin("2222");
//		admin.setUsername("admin");
//		admin.setPassword("admin");
//		
//		adminService.save(admin);
	}
}
