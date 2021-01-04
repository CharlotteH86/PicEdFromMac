package pictureEditor;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Interface implements Runnable{
	static JFrame frameOne;
	static JButton btnBlackNWhite, btnBright, btnDarker;
	//private JFrame frame;
	static JLabel labelOne;
	
	public BufferedImage pictureOne;
	public String apple;

	
	public int[][] picArr;
	public int width, height;
	
	public Interface() {
		
	}
	
	@Override
	public void run() {
		/*frame = new JFrame("Picture Editor");
		frame.setPreferredSize(new Dimension(500,500));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createComponents(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);*/
		
		
		frameOne = new JFrame("PicEditor");
		labelOne = new JLabel("Panel");
		
		btnBlackNWhite = new JButton("Black & White");
		btnBright = new JButton("Brighter");
		btnDarker = new JButton("Darker");
		
		JPanel panel = new JPanel();
		
		panel.add(btnBlackNWhite);
		panel.add(btnBright);
		panel.add(btnDarker);
		panel.add(labelOne);
		
		panel.setBackground(Color.white);
		frameOne.add(panel);
		
		frameOne.setSize(500,500);
		
		frameOne.show();
		frameOne.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		thePicture(frameOne.getContentPane());
		
		//createComponents(frameOne.getContentPane());

		
		
	}
	
	
	private void thePicture(Container labelOne) {
		BufferedImage image= null;
		try {
		image = ImageIO.read(new File("apple1.jpg"));
		}catch(IOException e){
			e.printStackTrace();
		};
		
		//labelOne.setIcon(new ImageIcon(image));
		//super("Black & white");
		this.apple = apple;
		try {
			File file= new File("apple1.jpg");
			if(file.isFile()) {
				image = ImageIO.read(file);
			}
			else {
				URL url = getClass().getResource(apple);
				if(url == null) { url = new URL(apple);}
				image = ImageIO.read(url);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not Open");
			
		}
		if (image == null) {
			throw new RuntimeException("Invalid file");
			
		}
		
		/*ImageIcon icon = new ImageIcon(image);
		labelOne.setIcon(icon);
		width = image.getWidth();
		height = image.getHeight();
		
		picArr = new int[width][height];
		for(int i = 0; i<width; i++) {
			for(int j = 0; j<height; j++);
			{
				picArr[i][j]= pictureOne.getRGB(i, j);
			}
		}*/
		JPanel panel = new JPanel();
		panel.add(labelOne);
		btnBlackNWhite.addActionListener((ActionListener) this);
		panel.add(btnBlackNWhite);
		panel.add(panel);
		panel.setSize(300,300);
		panel.setVisible(true);
		
	}
	

	
	

	/*private void createComponents(Container labelOne) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("apple1.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		JLabel labelWithImg = new JLabel(new ImageIcon(image));
		labelOne.add(labelWithImg);
		
		
	}*/
	

	public JFrame getFrame() {
	return frameOne;
	}

	

}
