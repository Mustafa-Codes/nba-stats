package com.swish.nbastats.repository;

import com.swish.nbastats.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // JpaRepository already provides basic CRUD methods for us

}
