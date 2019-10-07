package com.example.cronberry.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cronberry.DTO.TallyDTO;
import com.example.cronberry.service.IEmployeeService;
import com.example.cronberry.service.ITallyService;

/*******************************************************************************
 * Copyright (c) Maaruji Technologies. All rights reserved.
 *
 * Contributors:
 * 
 * @author Sourav Gupta (s.gupta@maaruji.com)
 * @version 0.0.1
 * 
 *******************************************************************************/

@RestController
@RequestMapping(value = "/api/tally")
public class TallyController {
	
	@Autowired
	public ITallyService iTallyService;
	
	@Autowired
	public IEmployeeService iEmployeeService;
	
	@GetMapping(value = "/get-tally-data", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getTallyData() {
		return iTallyService.getTallyData();
	}
	
	@GetMapping(value = "/fetch-tally-data", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TallyDTO> fetchTallyData() {
		return iTallyService.fetchTallyData();
	}
	
	@GetMapping(value = "/get-employee-data", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getEmployeeData() {
		return iEmployeeService.getEmployeeData();
	}
	
}
