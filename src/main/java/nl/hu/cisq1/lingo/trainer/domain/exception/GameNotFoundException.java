package nl.hu.cisq1.lingo.trainer.domain.exception;

import java.util.UUID;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(UUID id) {
        super("Could not find game with id " + id);
    }
}
