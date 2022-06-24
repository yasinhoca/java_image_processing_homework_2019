package pixo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class px extends JFrame {

	private JPanel contentPane;
	BufferedImage img = null; 
	File f = null; 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					px frame = new px();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public px() {
		setTitle("Image Processing \u00D6devi - Mart 2020");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 13, 300, 300);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("G\u00FCr\u00FClt\u00FC Ekle");

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(324, 261, 133, 52);
		contentPane.add(btnNewButton);

		Image imgl = new ImageIcon(this.getClass().getResource("/b.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgl));

		JButton btnNewButton_1 = new JButton("Siyah-Beyaz");		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(324, 13, 133, 43);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(489, 13, 300, 300);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_2 = new JButton("Negatif");

		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(324, 69, 133, 43);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sepia");

		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(324, 125, 133, 43);
		contentPane.add(btnNewButton_3);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(10, 10, 50, 10));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setBounds(345, 219, 83, 32);
		contentPane.add(spinner);

		JLabel lblPixelMatris = new JLabel("Oran");
		lblPixelMatris.setBounds(365, 191, 36, 27);
		contentPane.add(lblPixelMatris);




		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try
				{ 
					f = new File("img/b.jpg"); 
					img = ImageIO.read(f); 
				} 
				catch(IOException e) 
				{ 
					System.out.println(e); 
				} 

				int width = img.getWidth(); 
				int height = img.getHeight();

				for (int y = 0; y < height; y++) 
				{ 
					for (int x = 0; x < width; x++) 
					{ 
						// Here (x,y)denotes the coordinate of image  
						// for modifying the pixel value. 
						int p = img.getRGB(x,y); 

						int a = (p>>24)&0xff; 
						int r = (p>>16)&0xff; 
						int g = (p>>8)&0xff; 
						int b = p&0xff; 

						// calculate average 
						int avg = (r+g+b)/3; 

						// replace RGB value with avg 
						p = (a<<24) | (avg<<16) | (avg<<8) | avg; 

						img.setRGB(x, y, p); 
					} 
				} 

				// write image 
				try
				{ 
					f = new File("img/bsb.jpg"); 
					ImageIO.write(img, "jpg", f);
					Image imgl = new ImageIcon(this.getClass().getResource("/bsb.jpg")).getImage();
					lblNewLabel_1.setIcon(new ImageIcon(imgl));
				} 
				catch(IOException e) 
				{ 
					System.out.println(e); 
				} 

			}
		});



		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try
				{ 
					f = new File("img/b.jpg"); 
					img = ImageIO.read(f); 
				} 
				catch(IOException e0) 
				{ 
					System.out.println(e0); 
				} 

				int width = img.getWidth(); 
				int height = img.getHeight(); 

				// Convert to negative 
				for (int y = 0; y < height; y++) 
				{ 
					for (int x = 0; x < width; x++) 
					{ 
						int p = img.getRGB(x,y); 
						int a = (p>>24)&0xff; 
						int r = (p>>16)&0xff; 
						int g = (p>>8)&0xff; 
						int b = p&0xff; 

						//subtract RGB from 255 
						r = 255 - r; 
						g = 255 - g; 
						b = 255 - b; 

						//set new RGB value 
						p = (a<<24) | (r<<16) | (g<<8) | b; 
						img.setRGB(x, y, p); 
					} 
				} 

				// write image 
				try
				{ 
					f = new File("img/bn.jpg"); 
					ImageIO.write(img, "jpg", f); 
					Image imgl = new ImageIcon(this.getClass().getResource("/bn.jpg")).getImage();
					lblNewLabel_1.setIcon(new ImageIcon(imgl));
				} 
				catch(IOException e2) 
				{ 
					System.out.println(e2); 
				} 
			}
		});



		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{ 
					f = new File("img/b.jpg"); 
					img = ImageIO.read(f); 
				} 
				catch(IOException e3) 
				{ 
					System.out.println(e3); 
				} 

				// get width and height of the image 
				int width = img.getWidth(); 
				int height = img.getHeight(); 

				//convert to sepia 
				for(int y = 0; y < height; y++) 
				{ 
					for(int x = 0; x < width; x++) 
					{ 
						int p = img.getRGB(x,y); 

						int a = (p>>24)&0xff; 
						int R = (p>>16)&0xff; 
						int G = (p>>8)&0xff; 
						int B = p&0xff; 

						//calculate newRed, newGreen, newBlue 
						int newRed = (int)(0.393*R + 0.769*G + 0.189*B); 
						int newGreen = (int)(0.349*R + 0.686*G + 0.168*B); 
						int newBlue = (int)(0.272*R + 0.534*G + 0.131*B); 

						//check condition 
						if (newRed > 255) 
							R = 255; 
						else
							R = newRed; 

						if (newGreen > 255) 
							G = 255; 
						else
							G = newGreen; 

						if (newBlue > 255) 
							B = 255; 
						else
							B = newBlue; 

						//set new RGB value 
						p = (a<<24) | (R<<16) | (G<<8) | B; 

						img.setRGB(x, y, p); 
					} 
				} 

				//write image 
				try
				{ 
					f = new File("img/bs.jpg"); 
					ImageIO.write(img, "jpg", f); 
					Image imgl = new ImageIcon(this.getClass().getResource("/bs.jpg")).getImage();
					lblNewLabel_1.setIcon(new ImageIcon(imgl));
				} 
				catch(IOException e3) 
				{ 
					System.out.println(e3); 
				} 
			}
		});



		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{ 
					f = new File("img/b.jpg"); 
					img = ImageIO.read(f); 
				} 
				catch(IOException e3) 
				{ 
					System.out.println(e3); 
				} 

				// get width and height of the image 
				int width = img.getWidth(); 
				int height = img.getHeight(); 
				Random r = new Random();
				int oran = (int) spinner.getValue();

				//convert to sepia 
				for(int y = 0; y < height; y++) 
				{ 
					for(int x = 0; x < width; x++) 
					{ 
						int p = img.getRGB(x,y); 

						int a = (p>>24)&0xff; 
						int R = (p>>16)&0xff; 
						int G = (p>>8)&0xff; 
						int B = p&0xff; 

						int rst = r.nextInt(100);
						if(rst>=100-oran) {
						R = r.nextInt(255);
						G = r.nextInt(255); 
						B = r.nextInt(255);
						}
						
						

						//set new RGB value 
						p = (a<<24) | (R<<16) | (G<<8) | B; 

						img.setRGB(x, y, p); 
					} 
				} 

				//write image 
				try
				{ 
					f = new File("img/bp"+ oran +".jpg"); 
					ImageIO.write(img, "jpg", f); 					
					Image imgl = new ImageIcon(this.getClass().getResource("/bp"+ oran +".jpg")).getImage();
					lblNewLabel_1.setIcon(new ImageIcon(imgl));
					lblNewLabel_1.repaint();
					
				} 
				catch(IOException e3) 
				{ 
					System.out.println(e3); 
				} 
				
				
			}
		});


	}
}
