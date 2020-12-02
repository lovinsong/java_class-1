package swing.btn.actions;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ShowRandomCardBtnAction implements ActionListener {

	Container[] card_panel;
	
	public ShowRandomCardBtnAction(Container[] card_panel) {
		this.card_panel = card_panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Random ran = new Random();
		
		System.out.println("어떤 버튼으로 실행했나? " + e.getActionCommand());
		for (int i = 0; i<card_panel.length; i++) {
			int ran_dice = ran.nextInt(6)+1;
			
			((CardLayout) card_panel[i].getLayout()).show(card_panel[i], ""+ran_dice);
		}
	}
	

}
