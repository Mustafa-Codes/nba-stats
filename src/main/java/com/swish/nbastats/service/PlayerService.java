package com.swish.nbastats.service;

import com.swish.nbastats.model.Player;
import com.swish.nbastats.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();  // Fetch all players from the database
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);  // Fetch player by ID from the database
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);  // Save or update player in the database
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);  // Delete player by ID from the database
    }
}
