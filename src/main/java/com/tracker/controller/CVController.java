package com.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tracker.modal.CVModel;
import com.tracker.service.CVService;

@Controller
//@EnableScheduling // To indicate that service has schedule running method
public class CVController 
{
	@Autowired
	private CVService service ;

	@GetMapping("/")
	public String getHome(Model m) throws Exception
	{		
		List<CVModel> status = service.getVirusData();

		if ( status != null )
		{
			m.addAttribute("TotalCases", status.stream().mapToInt( stat -> stat.getTotalCases()).sum() );
			m.addAttribute("TodayCases", status.stream().mapToInt( stat -> stat.getTodayRecordedCases() ).sum() );
			m.addAttribute("Records", status);
		}
		return "home";
	}
}
