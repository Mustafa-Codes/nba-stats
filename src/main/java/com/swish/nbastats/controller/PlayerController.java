package com.swish.nbastats.controller;

import com.swish.nbastats.model.Player;
import com.swish.nbastats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players") // Base URL for all endpoints in this controller
public class PlayerController {

    private final PlayerService playerService;

    @Autowired  // Ensure that the service is injected correctly
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // POST method to add new players to playerList
    @PostMapping()
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player savedPlayer = playerService.savePlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
    }

    // PUT method to update existing players details
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        Optional<Player> player = playerService.getPlayerById(id);
        if(player.isPresent()) {
            updatedPlayer.setId(id);
            return ResponseEntity.ok(playerService.savePlayer(updatedPlayer));
        }
        // If player doesn't exist return a 404 not found
        return ResponseEntity.notFound().build();
    }

    // Delete method to delete existing player from list
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Player> deletePlayer(@PathVariable Long id) {
        Optional<Player> player = playerService.getPlayerById(id);
        if(player.isPresent()) {
            playerService.deletePlayer(id);
            return ResponseEntity.noContent().build(); // Return 204 no content
        }
        // If player doesn't exist return a 404 not found
        return ResponseEntity.notFound().build();
    }

    // Method that will handle GET requests to the /players endpoint and also return the entire list of players
    @GetMapping()
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    // Method that returns specific player based on a given id
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
