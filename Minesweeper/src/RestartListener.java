import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RestartListener implements ActionListener {

	Minesweeper game;
	
	public RestartListener(Minesweeper game) {
		this.game = game;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		game.init();
	}

}
