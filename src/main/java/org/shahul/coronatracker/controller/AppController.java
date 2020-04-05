package org.shahul.coronatracker.controller;

import java.io.IOException;
import java.util.List;

import org.shahul.coronatracker.model.LocationResponseModel;
import org.shahul.coronatracker.model.LocationStats;
import org.shahul.coronatracker.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	AppService service;
	
	@GetMapping("/home")
	public LocationResponseModel fetchData() throws IOException {
		LocationResponseModel model=new LocationResponseModel();
		List<LocationStats> locStats = service.getLocStats();
		int totalReportedCases = locStats.stream().mapToInt(locStat->locStat.getLatestCases()).sum();
		int totalIncreaseInReportedCases = locStats.stream().mapToInt(locStat->locStat.getIncreaseFromPreviousDay()).sum();
		model.setLocStats(locStats);
		model.setTotalReportedCases(totalReportedCases);
		model.setTotalIncreaseFromPreviousDay(totalIncreaseInReportedCases);
		return model;
	}
}
