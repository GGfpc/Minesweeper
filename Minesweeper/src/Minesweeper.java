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
	private ArrayList<JButton> cells = new ArrayList<>();
	
	public Minesweeper() {
		base = new JFrame();
		bg = new JPanel(new BorderLayout());
		buttons = new JPanel(new FlowLayout());
		grid = new JPanel(new GridLayout(15,16));
		
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
	
	public void init(){
		base.setVisible(true);
	}
	
	public void populateGrid(){
		for(int i = 0; i < 225; i++){
			JButton button = new JButton();
			cells.add(button);
			grid.add(button);
		}
	}
	
	public void addBombs(){
		
		for(JButton button : cells){
			button.setName(null);
			button.setText(null);
		}
		
		
		int mines = 30;
		Random rand = new Random();
		for(JButton button : cells){
			int randInt =  rand.nextInt();
			if (mines != 0 && randInt % 7 == 0){
				button.setName("Bomb");
				button.setText("Bomb");
				mines--;
			}
		}
	}
	
	public JFrame getBase() {
		return base;
	}
	
	

}
