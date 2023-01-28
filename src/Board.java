import java.util.List;
import java.util.Objects;

public class Board {
	
	private List<List<Square>> grid;
	
	private int start;
	
	private int end;

	public Board(List<List<Square>> grid, int start, int end) {
		super();
		this.grid = grid;
		this.start = start;
		this.end = end;
	}

	public Board() {
		
	}
	
	public List<List<Square>> getGrid() {
		return grid;
	}

	public void setGrid(List<List<Square>> grid) {
		this.grid = grid;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public int hashCode() {
		return Objects.hash(end, grid, start);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return end == other.end && Objects.equals(grid, other.grid) && start == other.start;
	}

	@Override
	public String toString() {
		return "Board [grid=" + grid + ", start=" + start + ", end=" + end + "]";
	}
	
	

}
