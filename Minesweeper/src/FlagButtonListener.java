import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class FlagButtonListener implements ActionListener {
	
	Minesweeper game;
	
	public FlagButtonListener(Minesweeper game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.setClickMode(false);
		game.setFlagListener();
		
		
	}

}
