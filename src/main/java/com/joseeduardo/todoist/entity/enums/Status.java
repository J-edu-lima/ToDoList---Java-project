package com.joseeduardo.todoist.entity.enums;

public enum Status {

	CRIADA("CRIADA"), INICIADA("INICIADA"), CONCLUIDA("CONCLUIDA");

	private String status;

	Status() {
	}

	Status(String status) {
		this.setStatus(status);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
