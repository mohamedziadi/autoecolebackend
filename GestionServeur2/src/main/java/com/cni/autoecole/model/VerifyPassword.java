package com.cni.autoecole.model;

import lombok.Data;

@Data
public class VerifyPassword {
	
	private String oldPassword;
	private String newPassword;
	private String cin;
}
