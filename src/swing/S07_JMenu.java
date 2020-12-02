package swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import swing.btn.actions.ShowCardAction;

public class S07_JMenu extends JFrame {

	public S07_JMenu() {		
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		
		SwingTools.initTestFrame(this);
		
		setLayout(new BorderLayout());
		
		JPanel center_panel = new JPanel();
		JLabel pic_label = new JLabel("NO PICTURE");
		
		center_panel.setLayout(new CardLayout(20, 20));
		
		for (PictureEnum picname : PictureEnum.values()) {
			center_panel.add(picname.kName , new PictureLabel(picname));			
			
			JMenuItem item = new JMenuItem(picname.kName);		
			item.addActionListener(new ShowCardAction(
					center_panel, 
					pic_label, 
					picname.kName));			
			menu.add(item);
		}
		
		bar.add(menu);
		setJMenuBar(bar);
		add(center_panel, BorderLayout.CENTER);
		add(pic_label, BorderLayout.SOUTH);
		
		setVisible(true);
	}	
	
	public static void main(String[] args) {
		new S07_JMenu();		
	}
	
}




