package specificClasses;

import java.util.Objects;

public class Game {
    private String gameName;
    private int totalPoints;

    public Game(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game game)) return false;
        return getTotalPoints() == game.getTotalPoints();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameName(), getTotalPoints());
    }

    @Override
    public String toString() {
        return "totalPoints: " + totalPoints;
    }
}
