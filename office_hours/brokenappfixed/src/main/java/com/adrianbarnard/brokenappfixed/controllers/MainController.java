package com.adrianbarnard.brokenappfixed.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.adrianbarnard.brokenappfixed.models.City;
import com.adrianbarnard.brokenappfixed.models.Store;
import com.adrianbarnard.brokenappfixed.services.CityService;
import com.adrianbarnard.brokenappfixed.services.StoreService;

@Controller
public class MainController {
	@Autowired
	private CityService cityServ;
	@Autowired
	private StoreService storeServ;
	
	@GetMapping("/")
	public String citiesPage(Model viewModel) {
		// Fixed attribute name to match what's in JSP file
		viewModel.addAttribute("cities", cityServ.findAll());
		viewModel.addAttribute("stores", storeServ.findAll());
		viewModel.addAttribute("newCity", new City());
		viewModel.addAttribute("newStore", new Store());
		
		return "mainpage.jsp";
	}
	
	@PostMapping("/cities/new") // Bug fix below: forgot @Valid annotation
	public String addCity(@Valid @ModelAttribute("newCity") City newCity, BindingResult result,
			Model viewModel) {
		if (result.hasErrors()) {
			// NOTE: Don't forget to pass in attributes again as needed!!!!
			
			viewModel.addAttribute("cities", cityServ.findAll());
			viewModel.addAttribute("stores", storeServ.findAll());
			viewModel.addAttribute("newStore", new Store());
			return "mainpage.jsp";
		}
		cityServ.createCity(newCity);
		return "redirect:/";
	}
	
	@PostMapping("/stores/new") // Bug fix below: forgot @Valid annotation
	public String addStore(@Valid @ModelAttribute("newStore") Store newStore, BindingResult result,
			Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("cities", cityServ.findAll());
			viewModel.addAttribute("stores", storeServ.findAll());
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
		// You don't need to add on both sides - just once is enough: 
		// so you don't need to do thisStore.getCities().add(thisCity); - just one or the other
		cityServ.updateCity(thisCity); // Bug fix: forgot to save the changes to our City - we're adding a Store
		return "redirect:/stores/" + storeId;
	}
	
	@PostMapping("/cities/{cityId}/addStore/{storeId}")
	public String linkStoreToCity(@PathVariable Long cityId, @PathVariable Long storeId) {
		City thisCity = cityServ.findCityById(cityId);
		Store thisStore = storeServ.findStoreById(storeId);
		System.out.println("City id: " + thisCity.getId());
		System.out.println("Store id: " + thisStore.getId());
		thisCity.getStores().add(thisStore);
		cityServ.updateCity(thisCity); // Bug fix: forgot to save the changes to our City - we're adding a Store
		return "redirect:/cities/" + cityId;
	}
	
	@DeleteMapping("/stores/{storeId}/removeCity/{cityId}")
	public String removeCityFromStore(@PathVariable Long storeId, @PathVariable Long cityId) {
		City thisCity = cityServ.findCityById(cityId);
		Store thisStore = storeServ.findStoreById(storeId);
		thisCity.getStores().remove(thisStore);
		cityServ.updateCity(thisCity); // Bug fix: forgot to save the changes to our City - we're removing a Store
		return "redirect:/stores/" + storeId;
	}
	
	@DeleteMapping("/cities/{cityId}/removeStore/{storeId}")
	public String removeStoreFromCity(@PathVariable Long cityId, @PathVariable Long storeId) {
		City thisCity = cityServ.findCityById(cityId);
		Store thisStore = storeServ.findStoreById(storeId);
		thisCity.getStores().remove(thisStore);
		cityServ.updateCity(thisCity); // Bug fix: forgot to save the changes to our City - we're removing a Store
		return "redirect:/cities/" + cityId;
	}
	
	@GetMapping("/cities/{id}/delete")
	public String removeCity(@PathVariable Long id) {
		/* While it worked at the time as is, you might have to remove all the stores from the city first before deleting the city. */
		cityServ.deleteCity(id);
		return "redirect:/";
	}
	
	@GetMapping("/stores/{id}/delete")
	public String removeStore(@PathVariable Long id) {
		/* While it worked at the time as is, you might have to remove all the cities from the store first before deleting the store. */
		storeServ.deleteStore(id);
		return "redirect:/";
	}
}


