package swing;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KakaoButton extends JButton {

	static BufferedImage source = null;
	static HashMap<KakaoBtnEnum, Image> images;
	
	final static int SOURCE_IMAGE_COLS = 6;
	final static int SOURCE_IMAGE_ROWS = 2;
	
	final static String img_path = "D:\\자바SW개발자 양성과정 10월 권혁준\\assets\\image\\kakao1.png";
	
	static int SOURCE_IMAGE_WIDTH;
	static int SOURCE_IMAGE_HEIGHT;
	
	static {
		images = new HashMap<>();
		
		try {
			source = ImageIO.read(new File(img_path));
			
			SOURCE_IMAGE_WIDTH = source.getWidth() / SOURCE_IMAGE_COLS;
			SOURCE_IMAGE_HEIGHT = source.getHeight() / SOURCE_IMAGE_ROWS;
			
			KakaoBtnEnum[] enums = KakaoBtnEnum.values();
			
			int i = 0;
							
			for (int row = 0; row < SOURCE_IMAGE_ROWS; ++row) {
				for (int col = 0; col < SOURCE_IMAGE_COLS; ++col) {
					images.put(enums[i++], source.getSubimage(
							col * SOURCE_IMAGE_WIDTH, 
							row * SOURCE_IMAGE_HEIGHT, 
							SOURCE_IMAGE_WIDTH, 
							SOURCE_IMAGE_HEIGHT));					
				}				
			}
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	KakaoBtnEnum type;
	
	// KakaoButton의 생성자가 실행되고나면 
	// JButton 인스턴스를 포함하고 있는 KakaoButton 인스턴스가 생성된다
	public KakaoButton(KakaoBtnEnum type) {
		this.type = type;
		setSize(100);
	}
	
	public KakaoButton(KakaoBtnEnum type, int size) {
		this.type = type;
		setSize(size);
	}	
	
	private void setSize(int size) {
		super.setSize(size, size);
		
		// Enum에 설정된 타입에 따라 이미지를 고르고 사이즈를 재설정하여 아이콘으로 설정
		super.setIcon(new ImageIcon(
				images.get(type).getScaledInstance(
						size, 
						size,
						Image.SCALE_SMOOTH)
				)
		);
	}	
}

















