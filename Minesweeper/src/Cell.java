import java.awt.Color;

import javax.swing.JButton;

public class Cell extends JButton {

	private int xPos;
	private int yPos;
	private int bombCount;
	private boolean isBomb;
	private boolean revealed;
	private boolean flagged;
	private Minesweeper game;

	public Cell(int xPos, int yPos, boolean isBomb, ClickListener listener, Minesweeper game) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.isBomb = isBomb;
		flagged = false;
		addActionListener(listener);
		this.game = game;
	}
	
	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
		if(revealed){
			setButtonValue();
			if(isBomb){
				setText("B");
				setForeground(Color.BLACK);
				validate();
				repaint();
			}
		}
	}
	
	
	public boolean isFlagged() {
		return flagged;
	}

	public void flag() {
		this.flagged = true;
		this.setText("F");
		this.setBackground(Color.CYAN);
		game.setFlags(game.getFlags() + 1);
		
	}
	
	public void unFlag() {
		this.flagged = false;
		setButtonValue();
		this.setBackground(Color.WHITE);
		game.setFlags(game.getFlags() - 1);
	}

	public void setIsBomb(Boolean b) {
		isBomb = b;

	}
	
	public int getxPos() {
		return xPos;
	}
	
	public boolean getRevealed(){
		return revealed;
	}
	
	public int getyPos() {
		return yPos;
	}

	public boolean IsBomb() {
		return isBomb;
	}

	public void setBombCount(int bombCount) {
		this.bombCount = bombCount;
	}

	public int getBombCount() {
		return bombCount;
	}

	public void setButtonValue() {

		Color[] values = {new Color(0x32CD32), new Color(0xDAA520),
			               new Color(0x8B0000), new Color(0x990000)};

		for (int i = 0; i < values.length; i++) {
			if (i + 1 == getBombCount() && bombCount > 0) {
				setForeground(values[i]);
				setText("" + getBombCount());
			}

		}

	}
	
	

}
