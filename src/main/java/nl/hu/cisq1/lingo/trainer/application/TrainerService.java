package nl.hu.cisq1.lingo.trainer.application;

import nl.hu.cisq1.lingo.trainer.domain.Game;
import nl.hu.cisq1.lingo.trainer.data.SpringGameRepository;
import nl.hu.cisq1.lingo.trainer.domain.exception.GameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TrainerService {

    private final SpringGameRepository gameRepository;

    public TrainerService(SpringGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return this.gameRepository
                .findAll();
    }

    public Game getGameById(UUID id) {
        return this.gameRepository
                .findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
    }

    public Game startGame() {
        return this.gameRepository.save(new Game());
    }

}
