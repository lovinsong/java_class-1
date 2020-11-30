package swing;

import javax.swing.JFrame;

public class SwingTools {

	public static void initTestFrame(JFrame frame) {
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocation(3000, 100);
		frame.setVisible(true);		
	}
	
}
