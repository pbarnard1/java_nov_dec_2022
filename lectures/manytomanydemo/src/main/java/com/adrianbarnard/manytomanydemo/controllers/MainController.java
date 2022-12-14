package com.adrianbarnard.manytomanydemo.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;

import com.adrianbarnard.manytomanydemo.models.Chain;
import com.adrianbarnard.manytomanydemo.models.City;
import com.adrianbarnard.manytomanydemo.models.Store;
import com.adrianbarnard.manytomanydemo.services.ChainService;
import com.adrianbarnard.manytomanydemo.services.CityService;
import com.adrianbarnard.manytomanydemo.services.StoreService;

@Controller
public class MainController {
	@Autowired
	private CityService cityServ;
	@Autowired
	private ChainService chainServ;
	@Autowired
	private StoreService storeServ; // ADDED
	
	@GetMapping("/")
	public String mainPageForCitiesAndChains(Model viewModel) {
		viewModel.addAttribute("cities", cityServ.findAll());
		viewModel.addAttribute("chains", chainServ.findAll());
		viewModel.addAttribute("newCity", new City());
		viewModel.addAttribute("newChain", new Chain());
		
		return "mainpage.jsp";
	}
	
	@PostMapping("/cities/new")
	public String addCity(@Valid @ModelAttribute("newCity") City newCity, BindingResult result,
			Model viewModel) {
		if (result.hasErrors()) {
			// NOTE: Don't forget to pass in attributes again as needed!!!!
			
			viewModel.addAttribute("cities", cityServ.findAll());
			viewModel.addAttribute("chains", chainServ.findAll());
			viewModel.addAttribute("newChain", new Chain());
			return "mainpage.jsp";
		}
		cityServ.createCity(newCity);
		return "redirect:/";
	}
	
	@PostMapping("/chains/new")
	public String addChain(@Valid @ModelAttribute("newChain") Chain newChain, BindingResult result,
			Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("cities", cityServ.findAll());
			viewModel.addAttribute("chains", chainServ.findAll());
			viewModel.addAttribute("newCity", new City());
			return "mainpage.jsp";
		}
		chainServ.createChain(newChain);
		return "redirect:/";
	}
	
	@GetMapping("/chains/{id}")
	public String viewChain(@PathVariable("id") Long id, Model viewModel) {
		Chain thisChain = chainServ.findChainById(id);
		viewModel.addAttribute("thisChain", thisChain);
//		viewModel.addAttribute("missingCities", cityServ.findCitiesNotWithChain(thisChain)); // NOT NEEDED
		return "viewchain.jsp";
	}
	
	@GetMapping("/cities/{id}")
	public String viewCity(@PathVariable("id") Long id, Model viewModel) {
		City thisCity = cityServ.findCityById(id);
		viewModel.addAttribute("thisCity", thisCity);
//		viewModel.addAttribute("missingChains", chainServ.findChainsNotInCity(thisCity)); // NOT NEEDED
		return "viewcity.jsp";
	}
	
	// NOT NEEDED NOW
//	@PostMapping("/chains/{chainId}/addCity/{cityId}")
//	public String linkCityToChain(@PathVariable Long chainId, @PathVariable Long cityId) {
//		City thisCity = cityServ.findCityById(cityId);
//		Chain thisChain = chainServ.findChainById(chainId);
//		thisCity.getChains().add(thisChain);
//		// You don't need to add on both sides - just once is enough: 
//		// so you don't need to do thisChain.getCities().add(thisCity); - just one or the other
//		cityServ.updateCity(thisCity); // Bug fix: forgot to save the changes to our City - we're adding a Chain
//		return "redirect:/chains/" + chainId;
//	}
//	
//	@PostMapping("/cities/{cityId}/addChain/{chainId}")
//	public String linkChainToCity(@PathVariable Long cityId, @PathVariable Long chainId) {
//		City thisCity = cityServ.findCityById(cityId);
//		Chain thisChain = chainServ.findChainById(chainId);
//		System.out.println("City id: " + thisCity.getId());
//		System.out.println("Chain id: " + thisChain.getId());
//		thisCity.getChains().add(thisChain);
//		cityServ.updateCity(thisCity); // Bug fix: forgot to save the changes to our City - we're adding a Chain
//		return "redirect:/cities/" + cityId;
//	}
//	
//	@DeleteMapping("/chains/{chainId}/removeCity/{cityId}")
//	public String removeCityFromChain(@PathVariable Long chainId, @PathVariable Long cityId) {
//		City thisCity = cityServ.findCityById(cityId);
//		Chain thisChain = chainServ.findChainById(chainId);
//		thisCity.getChains().remove(thisChain);
//		cityServ.updateCity(thisCity); // Bug fix: forgot to save the changes to our City - we're removing a Chain
//		return "redirect:/chains/" + chainId;
//	}
//	
//	@DeleteMapping("/cities/{cityId}/removeChain/{chainId}")
//	public String removeChainFromCity(@PathVariable Long cityId, @PathVariable Long chainId) {
//		City thisCity = cityServ.findCityById(cityId);
//		Chain thisChain = chainServ.findChainById(chainId);
//		thisCity.getChains().remove(thisChain);
//		cityServ.updateCity(thisCity); // Bug fix: forgot to save the changes to our City - we're removing a Chain
//		return "redirect:/cities/" + cityId;
//	}
	
	@GetMapping("/cities/{id}/delete")
	public String removeCity(@PathVariable Long id) {
		/* We must remove all the stores from the city first before deleting the city. */
		City thisCity = cityServ.findCityById(id);
		for (Store thisStore : thisCity.getStores()) {
			storeServ.deleteStore(thisStore); // Remove that store from the DB that's linked to this city
		}
		cityServ.deleteCity(thisCity);
		return "redirect:/";
	}
	
	@GetMapping("/chains/{id}/delete")
	public String removeChain(@PathVariable Long id) {
		/* We must remove all the stores from the chain first before deleting the chain. */
		Chain thisChain = chainServ.findChainById(id);
		for (Store thisStore: thisChain.getStores()) {
			storeServ.deleteStore(thisStore);
		}
		chainServ.deleteChain(id);
		return "redirect:/";
	}
	
	@GetMapping("/stores")
	public String allStoresPageWithForm(Model viewModel, @ModelAttribute("newStore") Store newStore) {
		viewModel.addAttribute("allStores", storeServ.findAllStores());
		// Needed for the dropdown menus
		viewModel.addAttribute("cities", cityServ.findAll());
		viewModel.addAttribute("chains", chainServ.findAll());
		return "stores.jsp";
	}
	
	@PostMapping("/stores/new")
	public String addStoreToDB(@Valid @ModelAttribute("newStore") Store newStore, BindingResult result,
			Model viewModel) {
		if (result.hasErrors()) {
			// Needed for dropdowns to work again
			viewModel.addAttribute("allStores", storeServ.findAllStores());
			viewModel.addAttribute("cities", cityServ.findAll());
			viewModel.addAttribute("chains", chainServ.findAll());
			return "stores.jsp";
		}
		storeServ.createStore(newStore); // Save the new store in the DB
		return "redirect:/stores";
	}
	
	@GetMapping("/stores/{id}/edit")
	public String editStorePage(Model viewModel, @PathVariable("id") Long id) {
		// For dropdowns to work properly
		viewModel.addAttribute("cities", cityServ.findAll());
		viewModel.addAttribute("chains", chainServ.findAll());
		// Actual Store object we're going to edit
		viewModel.addAttribute("editedStore", storeServ.findStoreById(id));
		return "editStore.jsp";
	}
	
	@PutMapping("/stores/{id}/edit")
	public String editStoreInDB(@Valid @ModelAttribute("editedStore") Store editedStore, BindingResult result,
			Model viewModel, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			// For dropdowns to work properly
			viewModel.addAttribute("cities", cityServ.findAll());
			viewModel.addAttribute("chains", chainServ.findAll());
			return "editStore.jsp";
		}
		storeServ.updateStore(editedStore);
		return "redirect:/stores";
	}
	
	@DeleteMapping("/stores/{id}/delete")
	public String deleteStoreFromDB(@PathVariable("id") Long id) {
		Store thisStore = storeServ.findStoreById(id);
		storeServ.deleteStore(thisStore);
		return "redirect:/stores";
	}
}
