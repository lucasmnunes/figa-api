package com.figa.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "club")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Club implements Serializable {

	private static final long serialVersionUID = -7547790383219752279L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_sequence")
	@SequenceGenerator(name = "club_sequence", sequenceName = "club_seq")
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@OneToOne
	@JoinColumn(name = "owner_id", nullable = false)
	private Owner owner;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "cash", nullable = false)
	private BigDecimal cash;

}
