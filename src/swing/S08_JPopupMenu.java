package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class S08_JPopupMenu {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();

		JPopupMenu popup = new JPopupMenu("Edit");
		
		JMenuItem copy = new JMenuItem("����");
		JMenuItem cut = new JMenuItem("�߶󳻱�");
		JMenuItem paste = new JMenuItem("�ٿ��ֱ�");
		
		popup.add(copy);
		popup.add(cut);
		popup.add(paste);
		
		copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("���縦 �����߽��ϴ�.");
			}			
		});
		
		cut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�߶󳻱⸦ �����߽��ϴ�.");				
			}			
		});
		
		// Ű���� �̺�Ʈ ó�� (KeyListener, KeyAdapter)
		// ���콺 �̺�Ʈ ó�� (MouseListener, MouseAdapter)
		f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("MBTN NUMBER: "+ e.getButton());
				
				// e.getButton() : ��� ���콺 ��ư�� ���ȴ��� ��ȣ�� �˷��ش�
				if (e.getButton() == MouseEvent.BUTTON3) {				
					int x = e.getX();
					int y = e.getY();				
					// System.out.printf("(%d, %d) ����\n", x, y);
					popup.show(f, x, y);
				}
			}
		});
		
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(3000, 100);
		f.setSize(300, 300);		
		f.setVisible(true);
	}
	
}






