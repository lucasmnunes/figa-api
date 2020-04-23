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

import com.figa.api.dto.ClubDTO;
import com.figa.api.dto.PlayerDTO;
import com.figa.api.service.ClubService;
import com.figa.api.service.PlayerService;

@RestController
@RequestMapping("/api/v1/clubs")
class ClubController {

	private final ClubService service;
	private final PlayerService playerService;

	@Autowired
	ClubController(ClubService service, PlayerService playerService) {
		this.service = service;
		this.playerService = playerService;
	}

	@GetMapping
	ResponseEntity<List<ClubDTO>> findAll() {
		return new ResponseEntity<>(service.findAll()
				.stream()
				.map(ClubDTO::valueOf)
				.collect(toList()), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<ClubDTO> findById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(ClubDTO.valueOf(service.findById(id)), HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	ResponseEntity<ClubDTO> findByName(@PathVariable(value = "name") String name) {
		ClubDTO clubDTO = ClubDTO.valueOf(service.findByName(name));
		
		List<PlayerDTO> playersDTO = playerService.findByClubName(name)
				.stream()
				.map(PlayerDTO::valueOf)
				.collect(toList());
		
		clubDTO.setPlayers(playersDTO);
		
		return new ResponseEntity<>(clubDTO, HttpStatus.OK);
	}

}
