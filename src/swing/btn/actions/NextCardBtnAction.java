package swing.btn.actions;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextCardBtnAction implements ActionListener {

	Container card_panel;
	
	public NextCardBtnAction(Container card_panel) {
		this.card_panel = card_panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("어떤 버튼으로 실행했나? " + e.getActionCommand());
		((CardLayout) card_panel.getLayout()).next(card_panel);
		
	}
}
