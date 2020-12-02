package swing;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class S06_JTextField extends JFrame {
	
	public S06_JTextField() {
		JTextField input01;
		JLabel label01 = new JLabel();
		
		input01 = new JTextField("여기에 아무거나 입력하세요.");		
		input01.setBounds(20, 20, 200, 50);
		label01.setBounds(20, 100, 300, 300);
		
		// KeyAdapter : KeyListener를 전부 구현하지 않도록 추상클래스로 바꿔놓은 클래스
		input01.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("input01 key released!");
				
				System.out.println("keyChar: " + e.getKeyChar());
				System.out.println("keyCode: " + e.getKeyCode());
				
				switch (e.getKeyCode()) {
				case 38:
					label01.setText(label01.getText() + '↑');
					break;
				case 40:
					label01.setText(label01.getText() + '↓');
					break;
				case 37:
					label01.setText(label01.getText() + '←');
					break;
				case 39:
					label01.setText(label01.getText() + '→');
					break;
				}
			}
		});
		
//		input01.addKeyListener(new KeyListener() {
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// System.out.println("input01 key typed!");
//			}
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				System.out.println("input01 key pressed! (오래 누르고 있는 중)");
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				System.out.println("input01 key released! (키에서 손을 뗌)");				
//			}
//			
//		});
		
//		input01.addActionListener(new ActionListener() {			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("방금 입력한 값 : " + e.getActionCommand());	
//				input01.setText("");
//			}
//		});
		
		
		add(input01);
		add(label01);
		
		// setVisible 시점에 우리에게 보이는 화면을 그린다.
		SwingTools.initTestFrame(this);
	}

	public static void main(String[] args) {
		
		new S06_JTextField();
		
	}
	
}
