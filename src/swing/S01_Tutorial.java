package swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S01_Tutorial {

	// # Swing
	//	- JAVA�� ������ ���α׷��� ���� �� �ִ� API
	
	// # �����̳�
	//	- ������Ʈ�� �߰��ϴ� ��
	//	- JFrame, JPanel, JDialog ..�� 
	//	- �����̳� ���� ���̾ƿ��� ������ �� �ִ�
	
	// # ������Ʈ
	//	- �����̳ʿ� �߰��ϴ� ��ǰ��
	//	- JButton, JTable, JSlider, JMenu ..�� 
	
	public static void main(String[] args) {
		
		// # JFrame
		//	- �پ��� ������Ʈ���� �߰��� �� �ִ� �����̳� �� �ϳ�		
		
		// # JButton
		//	- ��ư ������Ʈ
		//	- ������ �����Ѵ�
		
		JFrame frame = new JFrame("����!");		
		// JButton b = new JButton("CLICK!");
		
		JButton b = new KakaoButton(KakaoBtnEnum.CAMERA, 80);	
		
		b.setLocation(100, 100);		
		
		// JButton���� setSize(int, int)�ۿ� ���
		// JButton�� ��ӹ��� �ڽ� Ŭ�������� setSize(int)�� �߰��ϴ���
		// ��ĳ�����ؼ� ����ϸ� �� �� ���� �ȴ�
		// b.setSize(150);
		
		// b.setBounds(100, 100, 100, 50);
		
		frame.add(b);
		
		// frame�� �⺻������ �����Ǿ��ִ� ���̾ƿ��� �����Ѵ�
		frame.setLayout(null);
		
		// �ش� �������� X��ư�� ������ ���� ������ �����Ѵ� 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		// ������ũ�� ����
		frame.setSize(500, 500);
		
		// �������� ���̰� ���� (ȭ�鿡 �׸���)
		//  �� GUIȯ�濡���� ȭ�鿡 ��ȭ�� ������� ���� ���� ȭ���� �ٽ� �׷��� �Ѵ�.
		frame.setVisible(true);
	}
	
}







