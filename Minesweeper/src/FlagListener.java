import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FlagListener implements ActionListener {

	Minesweeper game;
	

	public FlagListener(Minesweeper game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Cell cell = (Cell) e.getSource();
		if(!cell.isFlagged()){
			cell.flag();
		}
		else{	
			cell.unFlag();
		}
		game.checkWinStatus();
		game.getGrid().repaint();
		
	}

}
