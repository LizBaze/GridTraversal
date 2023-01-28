import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class App {

	public static void main(String[] args) {
		App app = new App();
		app.run();
	}

	private void run() {

		Board board = boardGenerator(100);
		Player player = new Player(100, 150);

		boardPrinter(board);

		traverse(board, player);

	}

	private void traverse(Board board, Player player) {
		
		Point current = new Point(0, board.getStart());
		Point goal = new Point(board.getGrid().size(), board.getEnd());
		List<List<Square>> grid = board.getGrid();
		
		List<Square> neighbors = new ArrayList<>();
		
		if( current.getX() != 0 ) {
			neighbors.add(grid.get( (int)current.getX() - 1) .get( (int)current.getY()   ));
		}
		if (current.getX() != grid.size() ) {
			neighbors.add(grid.get( (int) current.getX() + 1) .get( (int) current.getY() ));
		}
		
		if ( current.getY() != 0) {
			neighbors.add(grid.get( (int) current.getX()).get( (int) current.getY() - 1) );
		}
		if (current.getY() != grid.size() ) {
			neighbors.add(grid.get( (int) current.getX()).get( (int) current.getY() + 1) );
		}
		
		for (Square p : neighbors) {
			System.out.println(p + "" + p.getX() + " " + p.getY());
		}
		
	}

	private void boardPrinter(Board board) {
		List<List<Square>> rows = board.getGrid();
		for (int i = 0; i < rows.size(); i++) {
			List<Square> row = rows.get(i);

			for (int j = 0; j < row.size(); j++) {
				Square square = row.get(j);
				if (j == 0 && i == board.getStart()) {
					System.out.print("S ");
				} else if (j == row.size() - 1 && i ==board.getEnd()) {
					System.out.print("E ");
				} else {
					switch (square.getType()) {
					case "Blank":
						System.out.print("_ "); //0 H, -1 M
						break;
					case "Speeder":
						System.out.print("/ "); // -5 H, 0 M
						break;
					case "Lava":
						System.out.print("~ "); // -50 H, -10 M
						break;
					case "Mud":
						System.out.print("= "); //-10 H, -5 M
						break;
					}
				}
			}
			System.out.println();
		}
	}

	private Board boardGenerator(int size) {
		Board board = new Board();
		List<List<Square>> columns = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			List<Square> squares = new ArrayList<>();
			for (int j = 0; j < size ; j++) {

				Square square = squareGenerator();
				square.setY(i);
				square.setX(j);

				squares.add(square);

			}
			columns.add(squares);
		}
		board.setStart(ThreadLocalRandom.current().nextInt(1, size));
		board.setEnd(ThreadLocalRandom.current().nextInt(1, size));
		System.out.println(board.getStart());
		System.out.println(board.getEnd());
		board.setGrid(columns);
		return board;
	}

	private Square squareGenerator() {
		int squareType = ThreadLocalRandom.current().nextInt(1, 5);
		Square square = null;
		switch (squareType) {
		case 1:
			square = new Square("Blank", 0, -1);
			break;

		case 2:
			square = new Square("Speeder", -5, 0);
			break;
		case 3:
			square = new Square("Lava", -50, -10);
			break;
		case 4:
			square = new Square("Mud", -10, -5);
			break;

		}
		return square;
	}

}
