import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Minesweeper {

	private JFrame base;
	private JPanel bg;
	private JPanel buttons;
	private JPanel grid;
	private JTextField score;
	private Cell[][] cells = new Cell[15][15];

	public Minesweeper() {
		base = new JFrame();
		bg = new JPanel(new BorderLayout());
		buttons = new JPanel(new FlowLayout());
		grid = new JPanel(new GridLayout(15, 15));

		base.add(bg);
		bg.add(buttons, BorderLayout.NORTH);
		bg.add(grid, BorderLayout.CENTER);

		score = new JTextField();
		score.setText("Score");
		buttons.add(score);

		JButton tryAgain = new JButton("Try Again");
		tryAgain.addActionListener(new RestartListener(this));
		buttons.add(tryAgain);

		base.setSize(720, 800);
	}

	public void init() {
		grid.removeAll();
		populateGrid();
		addBombs();
		getButtonValue();

		base.setVisible(true);
	}

	public void populateGrid() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				Cell cell = new Cell(i, j, false, new ClickListener(this));
				cells[i][j] = cell;
				cell.setBackground(Color.WHITE);
				grid.add(cell);
			}
		}
	}

	public void addBombs() {

		refresh();

		int mines = 30;
		Random rand = new Random();

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				int randInt = rand.nextInt();
				if (mines != 0 && randInt % 7 == 0) {
					cells[i][j].setIsBomb(true);
					mines--;

				}
			}
		}

	}

	public void revealNextCell(int x, int y) {

		if (x < 0 || y < 0 || x >= 15 || y >= 15) {
			return;
		}
		if (cells[x][y].getRevealed() == false) {
			if (cells[x][y].getBombCount() == 0) {
				cells[x][y].setRevealed(true);
				cells[x][y].setBackground(Color.GREEN);
				reveal(x, y);

			} else {
				cells[x][y].setRevealed(true);
				cells[x][y].setBackground(Color.BLUE);
			}
		}
	}

	private void reveal(int x, int y) {
		revealNextCell(x - 1, y - 1);
		revealNextCell(x - 1, y);
		revealNextCell(x - 1, y + 1);
		revealNextCell(x + 1, y);

		revealNextCell(x, y - 1);
		revealNextCell(x, y + 1);
		revealNextCell(x + 1, y - 1);
		revealNextCell(x + 1, y + 1);
	}

	public void fail(Cell cell) {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[i][j].setEnabled(false);
				if (cells[i][j].IsBomb()) {
					cells[i][j].setBackground(Color.RED);
				}
			}
		}

	}

	public void getButtonValue() {

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {

				if (cells[i][j].IsBomb() == false) {
					int bombCounter = 0;
					for (int x = i - 1; x <= i + 1; x++) {
						for (int y = j - 1; y <= j + 1; y++) {
							if (x >= 0 && x < cells.length && y >= 0
									&& y < cells[0].length) {
								if (cells[x][y].IsBomb()) {
									bombCounter++;
								}
							}

						}
					}
					cells[i][j].setBombCount(bombCounter);
					cells[i][j].setButtonValue(bombCounter);
				}
			}
		}
	}

	public JPanel getGrid() {
		return grid;
	}

	public void refresh() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				cells[i][j].setIsBomb(false);
				cells[i][j].setText("");
			}
		}
	}

}
