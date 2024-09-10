package com.joseeduardo.todoist.entity.enums;

public enum Status {

	CRIADA((long) 0), INICIADA((long) 1), CONCLUIDA((long) 2);
	private Long id;

	private Status(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
