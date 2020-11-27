package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_JButton extends JFrame {

	
	
	public S02_JButton() {		
		JButton button1 = new JButton("눌러보세요!");		
		JButton button2 = new JButton("CLICK ME!");
		JButton button3 = new JButton(
			new ImageIcon("D:\\자바SW개발자 양성과정 10월 권혁준\\assets\\image\\kakao1.png")
		);
		
		// setBounds : 위치와 크기 설정을 한번에 한다
		button1.setBounds(100, 100, 100, 50);
		button2.setBounds(100, 250, 100, 50);
		button3.setBounds(200, 100, 200, 200);
		
		// setText : 컴포넌트의 텍스트를 변경한다
		button1.setText("ABCDEFG!");
		button2.setText("눌러보세요!");
		
		// setEnable : 버튼을 활성화/비활성화 한다
		button1.setEnabled(true);
		button2.setEnabled(true);		
		
		// 버튼의 기본 동작 액션리스너를 정의
		ActionListener basic_btn_action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 이벤트가 발생했을 때 해당 이벤트의 정보를 넘겨받게 된다
				System.out.println("버튼이 눌렸습니다!");
				
				System.out.println("눌린 버튼의 전체 정보 : " + e.getSource());
				System.out.println("cmd: " + e.getActionCommand());
				
				JButton clicked_btn = (JButton)e.getSource();				
				System.out.println("버튼의 이름 : " + clicked_btn.getText());
			}
		};
		
		// 버튼에 액션리스너 추가 (누르면 발동)
		//	- ActionListener 인터페이스의 구현체를 버튼에 추가할 수 있다
		button1.addActionListener(basic_btn_action);		
		button2.addActionListener(basic_btn_action);
		
		add(button1);
		add(button2);
		add(button3);
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(3000, 100);
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {		
		new S02_JButton();		
	}
	
}
