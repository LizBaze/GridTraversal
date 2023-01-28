import java.awt.Point;
import java.util.Objects;

public class Player {
	
	private int health;
	
	private int moves;
	
	private Point position;
	
	
	
	public Player(int health, int moves) {
		this.moves = moves;
		this.health = health;
	}
	
	public Player() {
		
		
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(health, moves);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return health == other.health && moves == other.moves;
	}

	@Override
	public String toString() {
		return "Player [health=" + health + ", moves=" + moves + "]";
	}
	
	
}
