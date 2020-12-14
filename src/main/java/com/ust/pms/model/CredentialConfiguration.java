package com.ust.pms.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("credentials")
public class CredentialConfiguration {
	private String username;
	private String password;
	private String secretquestion;
	private String secretanswer;
	private String description;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecretquestion() {
		return secretquestion;
	}

	public void setSecretquestion(String secretquestion) {
		this.secretquestion = secretquestion;
	}

	public String getSecretanswer() {
		return secretanswer;
	}

	public void setSecretanswer(String secretanswer) {
		this.secretanswer = secretanswer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
