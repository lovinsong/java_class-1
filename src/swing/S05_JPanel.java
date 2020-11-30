package swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import swing.btn.actions.NextCardBtnAction;

public class S05_JPanel extends JFrame {
	
	public S05_JPanel() {
		SwingTools.initTestFrame(this);
		
		// # JPanel
		//	- 프레임 위에 추가로 붙일 수 있는 컨테이너
		//	- 컨테이너 역할을 하는 컴포넌트 
		Container c = this.getContentPane();
		
		JPanel south_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		JPanel center_panel = new JPanel(new CardLayout(10, 10));
		
		center_panel.setBackground(Color.BLACK);
		south_panel.setBackground(Color.ORANGE);
		
		// MVC패턴 적용 : View와 Controller를 분리
		JButton next_btn = new JButton("next");
		next_btn.addActionListener(new NextCardBtnAction(center_panel));
		
		JButton last_btn = new JButton("last");
		last_btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) center_panel.getLayout()).last(center_panel);
			}
		});
		
		JButton prev_btn = new JButton("prev");
		prev_btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) center_panel.getLayout()).previous(center_panel);
			}
		});
		
		JButton first_btn = new JButton("first");
		first_btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) center_panel.getLayout()).first(center_panel);
			}
		});
		
		// # MVC 패턴
		
		//	1. Model
		//		데이터를 꺼내거나 저장할 때 사용하는 클래스들을 따로 지칭하는 말.
		//		주로, 데이터의 형태를 정의하는 클래스를 말한다.
		//	2. View
		//		사용자에게 제공할 화면을 구성하는 클래스들을 따로 지칭하는 말.
		//	3. Controller
		//		사용자의 입력을 처리하는데 필요한 클래스들을 따로 지칭하는 말.
		//		(1) 비즈니스 로직 
		//			- 비즈니스마다 달라지는 처리들을 비즈니스 로직이라고 한다.
		//		(2) DAO(Data Access Object) 
		//			- 데이터베이스(또는 파일 시스템)의 데이터에 접근하는 기능들 
		
		
		// 사용자 -> View -> Controller -> Model -> 데이터베이스 		
		/* 
		 	1. 현재 소스에서는 lastAction, firstAction, prevAction들이 컨트롤러로 분류 될 수 있다
		 	2. 현재 소스에는 화면을 표현하는 코드(View)와 로직을 담당하는 코드(Controller)가 섞여있다.
		 	3. 만약 여러 화면에 lastAction과 기능이 똑같은 버튼을 추가하는데
		 	   Controller에 해당하는 익명 구현체가 분할되어있지 않다면 복붙을 할것이다.
		 	4. 똑같은 소스가 여러군데에 존재하게 되므로 코드 수정시에 문제가 발생한다  		 	   
		 */
		
		
		this.setLayout(new BorderLayout(0, 0));
		this.add(center_panel, BorderLayout.CENTER);
		this.add(south_panel, BorderLayout.SOUTH);
		
		// System.out.println(new File("assets/image/apple.jpeg").exists());
		
		// center_panel은 cardlayout
		center_panel.add("apple", new JLabel(new ImageIcon("assets/image/apple.jpeg")));
		center_panel.add("banana", new JLabel(new ImageIcon("assets/image/banana.jpg")));
		
		// south_panel은 flowlayout
		south_panel.add(next_btn);
		south_panel.add(last_btn);
		south_panel.add(prev_btn);
		south_panel.add(first_btn);		
	}
	
	public static void main(String[] args) {
		new S05_JPanel();
	}	
}











