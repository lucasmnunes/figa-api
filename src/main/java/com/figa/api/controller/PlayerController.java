package com.figa.api.controller;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.figa.api.dto.PlayerDTO;
import com.figa.api.service.PlayerService;

@RestController
@RequestMapping("/api/v1/players")
class PlayerController {
	
	private final PlayerService service;

	@Autowired
	PlayerController(PlayerService service) {
		this.service = service;
	}

	@GetMapping
	ResponseEntity<List<PlayerDTO>> findAll() {
		return new ResponseEntity<>(service.findAll()
				.stream()
				.map(PlayerDTO::valueOf)
				.collect(toList()), HttpStatus.OK);
	}
	
	@GetMapping("/club/name/{clubName}")
	ResponseEntity<List<PlayerDTO>> findByClubName(@PathVariable(value = "clubName") String clubName) {
		return new ResponseEntity<>(service.findByClubName(clubName)
				.stream()
				.map(PlayerDTO::valueOf)
				.collect(toList()), HttpStatus.OK);		
	}
	
}
