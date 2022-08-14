package com.tracker.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.tracker.modal.CVModel;

@Service
public class CVService 
{
	
	private static String DATA_URL ="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	
//	@PostConstruct -> To run the method on run the app without a controller
	public List<CVModel> getVirusData() throws Exception
	
	{
		List<CVModel> status = new ArrayList<>();
		
		HttpRequest request = HttpRequest.newBuilder().uri( URI.create(DATA_URL) ).build();
		
		HttpResponse<String> response = HttpClient.newHttpClient().send( request, HttpResponse.BodyHandlers.ofString() ) ;
		
		StringReader in = new StringReader( response.body() );
		
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		
		
		for( CSVRecord n : records) {
			
			CVModel s = new CVModel();
			
			s.setState( n.get("Province/State") );
			s.setCountry( n.get("Country/Region") );
			s.setTotalCases( Integer.parseInt( n.get(n.size()-1) ) ) ;
			s.setTodayRecordedCases( Integer.parseInt( n.get(n.size()-1) ) - Integer.parseInt( n.get(n.size()-2) ) ) ;
			status.add(s);
		}
		  
		  return status;
 	}
}
