package com.figa.api.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player_position")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerPosition implements Serializable {

	private static final long serialVersionUID = 3495378870545948750L;

	@EmbeddedId
	PlayerPositionPK id;

	@ManyToOne
	@MapsId("player_id")
	@JoinColumn(name = "player_id")
	Player player;

	@ManyToOne
	@MapsId("position_id")
	@JoinColumn(name = "position_id")
	Position position;

}