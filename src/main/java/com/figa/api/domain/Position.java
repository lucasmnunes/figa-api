package com.figa.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "position")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Position implements Serializable {

	private static final long serialVersionUID = 7655177028331749171L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_sequence")
	@SequenceGenerator(name = "position_sequence", sequenceName = "position_seq")
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "code", nullable = false)
	private String code;

}