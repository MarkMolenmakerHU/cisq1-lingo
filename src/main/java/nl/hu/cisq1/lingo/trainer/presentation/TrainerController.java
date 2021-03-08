package nl.hu.cisq1.lingo.trainer.presentation;

import nl.hu.cisq1.lingo.trainer.application.TrainerService;
import nl.hu.cisq1.lingo.trainer.domain.Game;
import nl.hu.cisq1.lingo.trainer.domain.exception.GameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("trainer")
public class TrainerController {

    private final TrainerService service;
    public TrainerController(TrainerService service) { this.service = service; }

    @GetMapping
    public List<Game> getAllGames() {
        return this.service.getAllGames();
    }

    @GetMapping("game")
    public Game getGame(@RequestParam UUID id) {
        try {
            return this.service.getGameById(id);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        } catch (GameNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @PostMapping
    public Game startGame() {
        return this.service.startGame();
    }

}
