package com.figa.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.figa.api.domain.Club;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClubDTO implements Serializable {
	
	private static final long serialVersionUID = -9186079629001947644L;

	private Long id;
	
	private String name;
	
	private BigDecimal cash;
	
	private OwnerDTO owner;
	
	private List<PlayerDTO> players;
	
	public static ClubDTO valueOf(Club club) {
		return ClubDTO.builder()
				.id(club.getId())
				.name(club.getName())
				.cash(club.getCash())
				.owner(OwnerDTO.valueOf(club.getOwner()))
				.players(null)
				.build();
	}

}
