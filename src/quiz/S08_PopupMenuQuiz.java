package quiz;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import swing.SwingTools;
import swing.btn.actions.ShowRandomCardBtnAction;

public class S08_PopupMenuQuiz extends JFrame {
	final static String[] paths = {
			"assets/image/1.jpg",
			"assets/image/2.jpg",
			"assets/image/3.jpg",
			"assets/image/4.jpg",
			"assets/image/5.jpg",
			"assets/image/6.jpg",
	};  
	final static Map<String,ImageIcon> images = new TreeMap<>();
	
	static {
	     for (String path : paths) {
	             setImageIcon(path);
	     }
	}
	
	private static void setImageIcon(String path) {
		
		int first = path.lastIndexOf("/");
		int last = path.indexOf(".");
		String name = path.substring(first+1,last);
	        try {
	                images.put(name,new ImageIcon(
	                                ImageIO
	                                        .read(new File(path))
	                                        .getScaledInstance(70, 70, Image.SCALE_FAST)
	                                ));
	        } catch (IOException e) {
	                e.printStackTrace();
	        }
	}
	
	
	public S08_PopupMenuQuiz() {
		
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem i1 =  new JMenuItem("Suffle");
		JPopupMenu popup = new JPopupMenu("DICE_MENU");
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING,0,0));
		JMenuItem suffle = new JMenuItem("Suffle");
		
		JPanel[] dice_zones = {new JPanel(new CardLayout(6,6)), new JPanel(new CardLayout(6,6)), new JPanel(new CardLayout(6,6)), new JPanel(new CardLayout(6,6)), new JPanel(new CardLayout(6,6))};
		
		JPanel dice_zone1 = new JPanel(new CardLayout(6,6));
		JPanel dice_zone2 = new JPanel(new CardLayout(6,6));
		JPanel dice_zone3 = new JPanel(new CardLayout(6,6));
		JPanel dice_zone4 = new JPanel(new CardLayout(6,6));
		JPanel dice_zone5 = new JPanel(new CardLayout(6,6));
		
		SwingTools.initTestFrame(this);
		
		
		this.add(panel);
		panel.add(dice_zones[0]);
		panel.add(dice_zones[1]);
		panel.add(dice_zones[2]);
		panel.add(dice_zones[3]);
		panel.add(dice_zones[4]);
		popup.add(suffle);
		menu.add(i1);
		
		bar.add(menu);
		
		this.setLayout(new BorderLayout(0,0));
		this.add(panel, BorderLayout.CENTER);
		
		i1.addActionListener(new ShowRandomCardBtnAction(dice_zones));
	
		
		suffle.addActionListener(new ShowRandomCardBtnAction(dice_zones));

		
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// e.getButton() : 어느 마우스 버튼이 눌렸는지 번호로 알려준다
				// System.out.println("MBTN NUMBER: " + e.getButton());
				
				if (e.getButton() == MouseEvent.BUTTON3) {
					int x = e.getX();
					int y = e.getY();
					popup.show(panel,x,y);
				}
			}
		});
		
		this.setJMenuBar(bar);
		
		for (String name : images.keySet()) {
			dice_zones[0].add(name,new JLabel(images.get(name)));
			dice_zones[1].add(name,new JLabel(images.get(name)));
			dice_zones[2].add(name,new JLabel(images.get(name)));
			dice_zones[3].add(name,new JLabel(images.get(name)));
			dice_zones[4].add(name,new JLabel(images.get(name)));
		}
		
		
	}
	
	public static void main(String[] args) {
		new S08_PopupMenuQuiz();
	}
}