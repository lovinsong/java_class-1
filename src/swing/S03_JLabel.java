package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class S03_JLabel extends JFrame {

	// ��������
	//	��ư�� �ϳ� �߰� �ϰ�, �� ��ư�� ������ ��� �׸��� �ٳ��� �׸����� ���ϵ���
	// 	��������. (�ٽ� ������ �ٽ� ����� �˴ϴ�)
	
	// ��θ� �̿��� ArrayList�� �̸� ImageIcon���� ����� ���´�.
	final static String[] paths = {
			"D:\\�ڹ�SW������ �缺���� 10�� ������\\assets\\image\\apple.jpeg",
			"D:\\�ڹ�SW������ �缺���� 10�� ������\\assets\\image\\banana.jpg"
	};  
	
	final static ArrayList<ImageIcon> images = new ArrayList<>();
	
	static {
		for (String path : paths) {
			setImageIcon(path);
		}
	}
	
	private static void setImageIcon(String path) {
		try {
			images.add(new ImageIcon(
					ImageIO
						.read(new File(path))
						.getScaledInstance(100, 100, Image.SCALE_FAST)
					));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int curr_image = 0;
	
	public S03_JLabel() {
		// JLabel : �ؽ�Ʈ, �׸����� ���� �� �ִ� ������Ʈ 
		JLabel label01 = new JLabel("Hello, java gui!!");		
		JLabel label02 = new JLabel(images.get(curr_image));
		JButton change_btn = new JButton("Change!");
		
		label01.setBounds(50, 50, 400, 50);
		label02.setBounds(50, 120, 100, 100);
		
		// label02�� �׵θ� �߰�
		label02.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
		change_btn.setBounds(50, 250, 100, 50);
		
		// ������Ʈ��(JFrame ��)�� �۲� ����
		label01.setFont(new Font("Courier", Font.PLAIN, 35));
		
		
		JFrame myframe = this;
		
		change_btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				label02.setIcon(images.get(++curr_image % images.size()));
				myframe.getContentPane().setBackground(Color.BLACK);
			}
		});
		
		add(label01);
		add(label02);		
		add(change_btn);		
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocation(3000, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S03_JLabel();
	}
	
}
