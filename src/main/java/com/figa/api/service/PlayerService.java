package com.figa.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.figa.api.domain.Player;
import com.figa.api.repository.PlayerRepository;

@Service
public class PlayerService {

	private final PlayerRepository repository;

	@Autowired
	public PlayerService(PlayerRepository repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly = true)
	public List<Player> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Player> findByClubName(String clubName) {
		return repository.findByClubName(clubName);
	}

}
