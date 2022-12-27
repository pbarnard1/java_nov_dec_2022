package com.adrianbarnard.apidemo.controllers;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
public class MainController {
	// You may have to right click on Project -> "Maven" -> "update project..." -> click OK.
	@Value("${nasa_api_key:TEST}") // Default value of "TEST" if not found
	private String thisApiKey;
	
	@GetMapping("/")
	public String mainPage(Model viewModel, HttpSession session) throws UnirestException {
//		System.out.println(thisApiKey);
		HttpResponse<JsonNode> jsonResponse; // Placeholder for HttpResponse
		// Link to grab picture of day from NASA: https://api.nasa.gov/planetary/apod?api_key=???&____ (add other search parameters here)
		
		// If date was NOT searched for, grab today's image
		if (session.getAttribute("searchDate") == null) {
			jsonResponse = Unirest.get("https://api.nasa.gov/planetary/apod?api_key="+thisApiKey).asJson();
		} else { // Otherwise, grab the image specified by the date searched
			String searchDate = (String) session.getAttribute("searchDate");
			String searchUrl = "https://api.nasa.gov/planetary/apod?api_key="+thisApiKey+"&date="+searchDate;
			System.out.println(searchUrl);
			jsonResponse = Unirest.get(searchUrl).asJson();
		}
		JsonNode jsonNodeBody = jsonResponse.getBody();
		JSONObject jsonObj = jsonNodeBody.getObject();
//		System.out.println(jsonObj);
		// Pass values from the JSON object to the JSP file
		viewModel.addAttribute("date",jsonObj.getString("date"));
		viewModel.addAttribute("imageUrl",jsonObj.getString("url"));
		viewModel.addAttribute("explanation",jsonObj.getString("explanation"));
//		viewModel.addAttribute("copyrightHolder",jsonObj.getString("copyright"));
		// JSONArray jArray = jsonObj.getJSONArray("some_key");
		// ArrayList<JSONObject> 
		return "home.jsp";

	}
	
	@PostMapping("/findImage")
	public String grabImageByDate(@RequestParam("search_date") String date, HttpSession session) {
		session.setAttribute("searchDate", date);
		return "redirect:/";
	}
}
