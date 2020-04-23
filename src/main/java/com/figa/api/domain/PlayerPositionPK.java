package com.figa.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
class PlayerPositionPK implements Serializable {

	private static final long serialVersionUID = -3575292530720616258L;

	@Column(name = "player_id")
	Long playerId;

	@Column(name = "position_id")
	Long positionId;

}