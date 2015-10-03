import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClickButtonListener implements ActionListener{
	
	Minesweeper game;
	
	public ClickButtonListener(Minesweeper game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.setClickMode(true);
		game.setClickListener();
		
	}

}
