package com.wal.replenish.model;

public enum PRIORITY {
	LOW(1), MID(2), HIGH(3);

	private int value;

	PRIORITY(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
