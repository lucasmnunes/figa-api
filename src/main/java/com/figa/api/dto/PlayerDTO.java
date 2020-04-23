package com.figa.api.dto;

import java.io.Serializable;

import com.figa.api.domain.Player;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerDTO implements Serializable {
	
	private static final long serialVersionUID = -9186079629001947644L;

	private Long id;
	
	private String name;
	
	private Integer jerseyNumber;

	private String position;
	
	private Integer overall;
	
	public static PlayerDTO valueOf(Player player) {
		return PlayerDTO.builder()
				.id(player.getId())
				.name(player.getName())
				.jerseyNumber(player.getJerseyNumber())
				.position("TO DO")
				.overall(player.getOverall())
				.build();
	}
	
}
