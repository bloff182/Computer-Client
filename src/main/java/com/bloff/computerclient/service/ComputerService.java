package com.bloff.computerclient.service;

import java.util.Map;

import com.bloff.computerclient.model.Computer;

public interface ComputerService {

	public Map<Integer, Computer> getData();

	public Computer getData(Integer id);

	public Computer addData(Computer computer);
	
	
}
