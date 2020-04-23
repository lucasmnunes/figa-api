package com.figa.api.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player implements Serializable {

	private static final long serialVersionUID = 3459502803169942489L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence")
	@SequenceGenerator(name = "player_sequence", sequenceName = "player_seq")
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@OneToMany(mappedBy = "player")
	private List<PlayerPosition> positions;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "overall", nullable = false)
	private Integer overall;

	@Column(name = "jersey_number", nullable = false)
	private Integer jerseyNumber;
	
	@ManyToOne
	@JoinColumn(name = "club_id", nullable = false)
	private Club club;

}
