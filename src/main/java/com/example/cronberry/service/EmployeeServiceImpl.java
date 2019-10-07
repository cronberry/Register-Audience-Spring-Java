package com.example.cronberry.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.alcodes.cronberry.impl.ISaveAudienceData;


/*******************************************************************************
 * Copyright (c) Maaruji Technologies. All rights reserved.
 *
 * Contributors:
 * 
 * @author Sourav Gupta (s.gupta@maaruji.com)
 * @version 0.0.1
 * 
 *******************************************************************************/

/*
 * Simply in spring web mvc without AOP 
 * Register the data in cronberry through cronberry.jar 
 */

@Controller
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	public ISaveAudienceData iSaveAudienceData;

	@Override
	public String getEmployeeData() {
		String phoneNo = "7889044497";
		String name = "Raghav Verma";
		String response = addEmployeeData(phoneNo,name);
		return response;
	}

	private String addEmployeeData(String phoneNo, String name) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("paramKey", "phone_no");
		jsonObject.put("paramValue", phoneNo);
		jsonObject.put("paramKey", "name");
		jsonObject.put("paramValue", name);
	 	JSONArray paramList = new JSONArray();
	 	paramList.put(jsonObject);
	 	JSONObject object = new JSONObject();
	 	object.put("apiKey", "c2c0ODQxNEBnbWFpbC5jb20=");
	 	object.put("audienceId", "988841");
	 	object.put("paramList", paramList);
	 	String data =  object.toString();
	 	String response =  iSaveAudienceData.saveAudienceDataString(data);
	 	return response;
	}

}
