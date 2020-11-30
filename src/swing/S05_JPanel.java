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
		//	- ������ ���� �߰��� ���� �� �ִ� �����̳�
		//	- �����̳� ������ �ϴ� ������Ʈ 
		Container c = this.getContentPane();
		
		JPanel south_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		JPanel center_panel = new JPanel(new CardLayout(10, 10));
		
		center_panel.setBackground(Color.BLACK);
		south_panel.setBackground(Color.ORANGE);
		
		// MVC���� ���� : View�� Controller�� �и�
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
		
		// # MVC ����
		
		//	1. Model
		//		�����͸� �����ų� ������ �� ����ϴ� Ŭ�������� ���� ��Ī�ϴ� ��.
		//		�ַ�, �������� ���¸� �����ϴ� Ŭ������ ���Ѵ�.
		//	2. View
		//		����ڿ��� ������ ȭ���� �����ϴ� Ŭ�������� ���� ��Ī�ϴ� ��.
		//	3. Controller
		//		������� �Է��� ó���ϴµ� �ʿ��� Ŭ�������� ���� ��Ī�ϴ� ��.
		//		(1) ����Ͻ� ���� 
		//			- ����Ͻ����� �޶����� ó������ ����Ͻ� �����̶�� �Ѵ�.
		//		(2) DAO(Data Access Object) 
		//			- �����ͺ��̽�(�Ǵ� ���� �ý���)�� �����Ϳ� �����ϴ� ��ɵ� 
		
		
		// ����� -> View -> Controller -> Model -> �����ͺ��̽� 		
		/* 
		 	1. ���� �ҽ������� lastAction, firstAction, prevAction���� ��Ʈ�ѷ��� �з� �� �� �ִ�
		 	2. ���� �ҽ����� ȭ���� ǥ���ϴ� �ڵ�(View)�� ������ ����ϴ� �ڵ�(Controller)�� �����ִ�.
		 	3. ���� ���� ȭ�鿡 lastAction�� ����� �Ȱ��� ��ư�� �߰��ϴµ�
		 	   Controller�� �ش��ϴ� �͸� ����ü�� ���ҵǾ����� �ʴٸ� ������ �Ұ��̴�.
		 	4. �Ȱ��� �ҽ��� ���������� �����ϰ� �ǹǷ� �ڵ� �����ÿ� ������ �߻��Ѵ�  		 	   
		 */
		
		
		this.setLayout(new BorderLayout(0, 0));
		this.add(center_panel, BorderLayout.CENTER);
		this.add(south_panel, BorderLayout.SOUTH);
		
		// System.out.println(new File("assets/image/apple.jpeg").exists());
		
		// center_panel�� cardlayout
		center_panel.add("apple", new JLabel(new ImageIcon("assets/image/apple.jpeg")));
		center_panel.add("banana", new JLabel(new ImageIcon("assets/image/banana.jpg")));
		
		// south_panel�� flowlayout
		south_panel.add(next_btn);
		south_panel.add(last_btn);
		south_panel.add(prev_btn);
		south_panel.add(first_btn);		
	}
	
	public static void main(String[] args) {
		new S05_JPanel();
	}	
}











