package org.shahul.coronatracker.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.shahul.coronatracker.model.LocationResponseModel;
import org.shahul.coronatracker.model.LocationStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class AppService {

	@Autowired
	WebClient webClient;
	List<LocationStats> appList=new ArrayList<>();
	
	@PostConstruct
	public void fetchData() throws IOException{
		List<LocationStats> locList=new ArrayList<>();
		String csvData= webClient.get().retrieve().bodyToMono(String.class).block();
		StringReader reader=new StringReader(csvData);
		
			List<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader).getRecords();
			for (CSVRecord csvRecord : records) {
				LocationStats model=new LocationStats();
				model.setState(csvRecord.get("Province/State"));
				model.setCountry(csvRecord.get("Country/Region"));
				int currentDayCases = Integer.parseInt(csvRecord.get(csvRecord.size()-1));
				int previousDayCases = Integer.parseInt(csvRecord.get(csvRecord.size()-2));
				model.setLatestCases(currentDayCases);
				model.setIncreaseFromPreviousDay(currentDayCases-previousDayCases);
				locList.add(model);
			}
		this.appList=locList;
		
	}

	public List<LocationStats> getLocStats() {
		return appList;
	}
	
	
}
