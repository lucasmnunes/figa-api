package com.figa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.figa.api.domain.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

	Club findByName(String name);

}
