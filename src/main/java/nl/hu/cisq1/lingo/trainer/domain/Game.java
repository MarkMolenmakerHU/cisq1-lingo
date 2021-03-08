package nl.hu.cisq1.lingo.trainer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "games")
public class Game {

    @Id
    @Column(name = "game")
    private final UUID id;

    public Game() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
