package com.adrianbarnard.brokenapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.adrianbarnard.brokenapp.models.City;
import com.adrianbarnard.brokenapp.models.Store;
import com.adrianbarnard.brokenapp.services.CityService;
import com.adrianbarnard.brokenapp.services.StoreService;

@Controller
public class MainController {
	@Autowired
	private CityService cityServ;
	@Autowired
	private StoreService storeServ;
	
	@GetMapping("/")
	public String citiesPage(Model viewModel) {
		viewModel.addAttribute("allCities", cityServ.findAll());
		viewModel.addAttribute("allStores", storeServ.findAll());
		viewModel.addAttribute("newCity", new City());
		viewModel.addAttribute("newStore", new Store());
		
		return "mainpage.jsp";
	}
	
	@PostMapping("/cities/new")
	public String addCity(@ModelAttribute("newCity") City newCity, BindingResult result,
			Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("allCities", cityServ.findAll());
			viewModel.addAttribute("allStores", storeServ.findAll());
			viewModel.addAttribute("newStore", new Store());
			return "mainpage.jsp";
		}
		cityServ.createCity(newCity);
		return "redirect:/";
	}
	
	@PostMapping("/stores/new")
	public String addStore(@ModelAttribute("newStore") Store newStore, BindingResult result,
			Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("allCities", cityServ.findAll());
			viewModel.addAttribute("allStores", storeServ.findAll());
			viewModel.addAttribute("newCity", new City());
			return "mainpage.jsp";
		}
		storeServ.createStore(newStore);
		return "redirect:/";
	}
	
	@GetMapping("/stores/{id}")
	public String viewStore(@PathVariable("id") Long id, Model viewModel) {
		Store thisStore = storeServ.findStoreById(id);
		viewModel.addAttribute("thisStore", thisStore);
		viewModel.addAttribute("missingCities", cityServ.findCitiesNotWithStore(thisStore));
		return "viewstore.jsp";
	}
	
	@GetMapping("/cities/{id}")
	public String viewCity(@PathVariable("id") Long id, Model viewModel) {
		City thisCity = cityServ.findCityById(id);
		viewModel.addAttribute("thisCity", thisCity);
		viewModel.addAttribute("missingStores", storeServ.findStoresNotInCity(thisCity));
		return "viewcity.jsp";
	}
	
	@PostMapping("/stores/{storeId}/addCity/{cityId}")
	public String linkCityToStore(@PathVariable Long storeId, @PathVariable Long cityId) {
		City thisCity = cityServ.findCityById(cityId);
		Store thisStore = storeServ.findStoreById(storeId);
		thisCity.getStores().add(thisStore);
		return "redirect:/stores/" + storeId;
	}
	
	@PostMapping("/cities/{cityId}/addStore/{storeId}")
	public String linkStoreToCity(@PathVariable Long cityId, @PathVariable Long storeId) {
		City thisCity = cityServ.findCityById(cityId);
		Store thisStore = storeServ.findStoreById(storeId);
		thisCity.getStores().add(thisStore);
		return "redirect:/cities/" + cityId;
	}
	
	@DeleteMapping("/stores/{storeId}/removeCity/{cityId}")
	public String removeCityFromStore(@PathVariable Long storeId, @PathVariable Long cityId) {
		City thisCity = cityServ.findCityById(cityId);
		Store thisStore = storeServ.findStoreById(storeId);
		thisCity.getStores().remove(thisStore);
		return "redirect:/stores/" + storeId;
	}
	
	@DeleteMapping("/cities/{cityId}/removeStore/{storeId}")
	public String removeStoreFromCity(@PathVariable Long cityId, @PathVariable Long storeId) {
		City thisCity = cityServ.findCityById(cityId);
		Store thisStore = storeServ.findStoreById(storeId);
		thisCity.getStores().remove(thisStore);
		return "redirect:/cities/" + cityId;
	}
	
	@GetMapping("/cities/{id}/delete")
	public String removeCity(@PathVariable Long id) {
		cityServ.deleteCity(id);
		return "redirect:/";
	}
	
	@GetMapping("/stores/{id}/delete")
	public String removeStore(@PathVariable Long id) {
		storeServ.deleteStore(id);
		return "redirect:/";
	}
}
