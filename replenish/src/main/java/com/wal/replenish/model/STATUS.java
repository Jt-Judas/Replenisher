package com.wal.replenish.model;

public enum STATUS {

	PENDING("Pending"), ASSIGNED("Assigned"), INPROGRESS("Inprogress"), COMPLETED("Completed");

	private String name;

	STATUS(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
}
