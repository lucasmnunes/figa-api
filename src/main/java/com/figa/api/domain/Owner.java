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
@Table(name = "owner")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Owner implements Serializable {

	private static final long serialVersionUID = 3583316184500887357L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_sequence")
	@SequenceGenerator(name = "owner_sequence", sequenceName = "owner_seq")
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

}
