package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exceptions.NotFoundException;

public class GameTest {
    Game tournament = new Game();

    Player player1 = new Player(10, "Alex", 5);
    Player player2 = new Player(11, "Harry", 4);
    Player player3 = new Player(12, "Kurt", 3);
    Player player4 = new Player(13, "Marta", 2);
    Player player5 = new Player(14, "Kolins", 4);
    Player player6 = new Player(15, "Klod", 7);

    @Test
    public void shouldNotFoundExceptionPlayers() {
        tournament.register(player1);
        tournament.register(player2);
        tournament.register(player3);
        tournament.register(player4);
        tournament.register(player5);
        tournament.register(player6);

        Assertions.assertThrows(NotFoundException.class, () -> {
            tournament.round("Byll", "Tom");
        });
    }

    @Test
    public void shouldNotFoundExceptionPlayer1() {
        tournament.register(player1);
        tournament.register(player2);
        tournament.register(player3);
        tournament.register(player4);
        tournament.register(player5);
        tournament.register(player6);

        Assertions.assertThrows(NotFoundException.class, () -> {
            tournament.round(player1.getName(), "Tom");
        });
    }

    @Test
    public void shouldNotFoundExceptionPlayer2() {
        tournament.register(player1);
        tournament.register(player2);
        tournament.register(player3);
        tournament.register(player4);
        tournament.register(player5);
        tournament.register(player6);

        Assertions.assertThrows(NotFoundException.class, () -> {
            tournament.round("Tom", player2.getName());
        });
    }

    @Test
    public void shouldRoundIfPlayer1Win() {
        tournament.register(player1);
        tournament.register(player2);

        int actual = tournament.round(player1.getName(), player2.getName());
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundIfPlayer2Win() {

        tournament.register(player3);
        tournament.register(player6);

        int actual = tournament.round(player3.getName(), player6.getName());
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundIfDraw() {

        tournament.register(player2);
        tournament.register(player5);

        int actual = tournament.round(player2.getName(), player5.getName());
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
}

