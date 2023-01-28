import java.util.Objects;

public class Square {

	private String type;
	private int healthEffect;
	private int movesEffect;
	private boolean steppedOn;
	private int x;
	private int y;

	public Square(String type, int healthEffect, int movesEffect) {
		super();
		this.type = type;
		this.healthEffect = healthEffect;
		this.movesEffect = movesEffect;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHealthEffect() {
		return healthEffect;
	}

	public void setHealthEffect(int healthEffect) {
		this.healthEffect = healthEffect;
	}

	public int getMovesEffect() {
		return movesEffect;
	}

	public void setMovesEffect(int movesEffect) {
		this.movesEffect = movesEffect;
	}

	public boolean isSteppedOn() {
		return steppedOn;
	}

	public void setSteppedOn(boolean steppedOn) {
		this.steppedOn = steppedOn;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
		return Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Square [type=" + type + ", healthEffect=" + healthEffect + ", movesEffect=" + movesEffect + "]";
	}

}
