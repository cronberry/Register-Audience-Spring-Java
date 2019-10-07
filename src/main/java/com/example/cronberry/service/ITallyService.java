package com.example.cronberry.service;

import java.util.List;
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

public interface ITallyService {
	
	public String getTallyData();
	
	public List<TallyDTO> fetchTallyData();

}
