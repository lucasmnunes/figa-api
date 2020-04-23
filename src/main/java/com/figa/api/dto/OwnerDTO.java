package com.figa.api.dto;

import java.io.Serializable;

import com.figa.api.domain.Owner;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OwnerDTO implements Serializable {
	
	private static final long serialVersionUID = -9186079629001947644L;

	private Long id;
	
	private String name;
	
	public static OwnerDTO valueOf(Owner owner) {
		return OwnerDTO.builder()
				.id(owner.getId())
				.name(owner.getName())
				.build();
	}
	
}
