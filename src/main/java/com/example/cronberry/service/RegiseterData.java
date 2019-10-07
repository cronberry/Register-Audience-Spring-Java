package com.example.cronberry.service;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alcodes.cronberry.impl.ISaveAudienceData;
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

/*
 * Register the data in cronberry through cronberry.jar
 * Through AOP . 
 */

@Aspect
@Component

public class RegiseterData {

	@Autowired
	public ISaveAudienceData iSaveAudienceData;
	
	@AfterReturning(pointcut="execution(* com.example.cronberry.service.TallyServiceImpl.getTallyData())", returning="retVal")
	public String addTallyData(String retVal) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("paramKey", "phone_no");
		jsonObject.put("paramValue", retVal);
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
	
	@AfterReturning(pointcut="execution(* com.example.cronberry.service.TallyServiceImpl.fetchTallyData())", returning="retVal")
	public String insertTallyData(Object retVal) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("paramKey", "name");
		jsonObject.put("paramKey", ((TallyDTO)retVal).getName());
		jsonObject.put("paramKey", "phone_no");
		jsonObject.put("paramKey", ((TallyDTO)retVal).getPhoneNo());
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

