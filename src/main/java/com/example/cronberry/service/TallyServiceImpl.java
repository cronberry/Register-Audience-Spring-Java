package com.example.cronberry.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.example.cronberry.DTO.TallyDTO;

/*******************************************************************************
 * Copyright (c) Maaruji Technologies. All rights reserved.
 *
 * Contributors:
 * 
 * @author Sourav Gupta (s.gupta@maaruji.com)
 * @version 0.0.1
 * 
 *******************************************************************************/

@Component
public class TallyServiceImpl implements ITallyService {

	@Override
	public String getTallyData() {
		return "7889044489";
	}

	@Override
	public List<TallyDTO> fetchTallyData() {
		return new ArrayList<TallyDTO>();
	}
	
}
