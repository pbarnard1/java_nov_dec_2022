package com.adrianbarnard.manytomanystartercode.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianbarnard.manytomanystartercode.models.Chain;
import com.adrianbarnard.manytomanystartercode.models.City;
import com.adrianbarnard.manytomanystartercode.repositories.ChainRepository;

@Service
public class ChainService {
	@Autowired
	private ChainRepository chainRepo;
	
	public Chain createChain(Chain chain) {
		return chainRepo.save(chain);
	}
	
	public Chain findChainById(Long id) {
		Optional<Chain> optionalChain = chainRepo.findById(id);
		return optionalChain.orElseGet(() -> null);
	}
	
	public List<Chain> findAll() {
		return chainRepo.findAll();
	}
	
	public List<Chain> findChainsNotInCity(City city) {
		return chainRepo.findByCitiesNotContains(city);
	}
	
	public Chain updateChain(Chain chain) {
		return chainRepo.save(chain);
	}
	
	public void deleteChain(Long id) {
		chainRepo.deleteById(id);
	}
}
