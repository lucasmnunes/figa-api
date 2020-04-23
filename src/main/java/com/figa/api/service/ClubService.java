package com.figa.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.figa.api.domain.Club;
import com.figa.api.repository.ClubRepository;

@Service
public class ClubService {

	private final ClubRepository repository;

	@Autowired
	public ClubService(ClubRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	public List<Club> findAll() {
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Club findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public Club findByName(String name) {
		return repository.findByName(name);
	}

}
