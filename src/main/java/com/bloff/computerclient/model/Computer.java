package com.bloff.computerclient.model;

public class Computer {

	private String ddrType;
	
	private Long mhz;
	
	private Integer memorySize;

	public Computer() {
	}

	public Computer(String ddrType, Long mhz, Integer memorySize) {
		this.ddrType = ddrType;
		this.mhz = mhz;
		this.memorySize = memorySize;
	}

	public String getDdrType() {
		return ddrType;
	}

	public void setDdrType(String ddrType) {
		this.ddrType = ddrType;
	}

	public Long getMhz() {
		return mhz;
	}

	public void setMhz(Long mhz) {
		this.mhz = mhz;
	}

	public Integer getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(Integer memorySize) {
		this.memorySize = memorySize;
	}

	@Override
	public String toString() {
		return "Computer [ddrType=" + ddrType + ", mhz=" + mhz + ", memorySize=" + memorySize + "]";
	}
	
	
	
	
}
