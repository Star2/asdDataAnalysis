package com.aisidi.analysis.core.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aisidi.analysis.core.service.GearService;

@Controller
@RequestMapping(value = "/gear/")
public class GearController {

	@Autowired
	@Qualifier("gearService")
	private GearService gearService;
	
	@RequestMapping("rise")
	public void rise(@DateTimeFormat String month) throws ParseException {
		gearService.rise(month);
	
	}
}
