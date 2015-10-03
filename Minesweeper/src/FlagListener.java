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
			if(cell.IsBomb()){
				game.setBombs(game.getBombs() - 1);
			}
		}
		else{	
			cell.unFlag();
		}
		game.win();
		game.getGrid().repaint();
		
	}

}
