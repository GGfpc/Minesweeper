import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {

	Minesweeper game;

	public ClickListener(Minesweeper game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Cell cell = (Cell) e.getSource();
		
		if(!cell.IsBomb()){
			game.revealNextCell(cell.getxPos(), cell.getyPos());
			cell.setEnabled(false);
		
		}
		else{
			game.fail(cell);
			
		}
		
		game.getGrid().repaint();

	}

}
