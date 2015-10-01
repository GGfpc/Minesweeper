import java.awt.BorderLayout;
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
	private JButton[][] cells = new JButton[15][15];

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

		populateGrid();
		addBombs();

		base.setSize(360, 400);
	}

	public void init() {
		base.setVisible(true);
	}

	public void populateGrid() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				JButton button = new JButton();
				cells[i][j] = button;

				grid.add(button);
			}
		}
	}

	public void addBombs() {

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				
					cells[i][j].setName(null);
					cells[i][j].setText(null);
				
			}
		}

		int mines = 25;
		Random rand = new Random();

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				int randInt = rand.nextInt();
				if (mines != 0 && randInt % 7 == 0) {
					cells[i][j].setName("Bomb");
					cells[i][j].setText("Bomb");

					mines--;

				}
			}
		}

	}

	public JFrame getBase() {
		return base;
	}
	
	

}
