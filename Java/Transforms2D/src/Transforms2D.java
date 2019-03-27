import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Transforms2D extends JPanel {

	private class Display extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.translate(300,300);  // Moves (0,0) to the center of the display.
			int whichTransform = transformSelect.getSelectedIndex();

			// TODO Apply transforms here, depending on the value of whichTransform!
			Polygon p = new Polygon();
			for (int i=0;i<13;i++)
				p.addPoint((int) (50*Math.cos(i*2*Math.PI/13)),
						(int)(50*Math.sin(i*2*Math.PI/13)));
			
			
			if(whichTransform ==1)
			{
				g2.scale(0.5,0.5);
				
				
			}
			if(whichTransform ==2)
			{
				g2.rotate(0.785);
				
	
			}
			if(whichTransform ==3)
			{
				
				g2.rotate(3.14);
				g2.scale(-0.5, 1);
	
			}
			if(whichTransform ==4)
			{
				
				g2.shear(0.2, 0);
	
			}
			if(whichTransform ==5)
			{
				
				g2.translate(0, -250);
				g2.scale(1,0.3);
	
			}
			if(whichTransform ==6)
			{
				
				g2.rotate(3.14/2);
				g2.shear(0.2, 0);
	
			}
			if(whichTransform ==7)
			{
				
				g2.rotate(3.14);
				g2.scale(0.5,1);
	
			}
			if(whichTransform ==8)
			{
				
				g2.translate(-50,100);
				g2.rotate(3.14*1.25);
				g2.scale(1,-0.5);
	
			}
			if(whichTransform ==9)
			{
				g2.translate(100, 0);
				g2.shear(0.3,0);
				g2.rotate(3.14*1.10);
	
			}
			
			
			g.drawPolygon(p);
			g2.setColor(Color.black);
			g.fillPolygon(p);
			
			
			
		}
	}

	private Display display;

	private JComboBox<String> transformSelect;

	public Transforms2D() throws IOException {
		display = new Display();
		display.setBackground(Color.YELLOW);
		display.setPreferredSize(new Dimension(600,600));
		transformSelect = new JComboBox<String>();
		transformSelect.addItem("None");
		for (int i = 1; i < 10; i++) {
			transformSelect.addItem("No. " + i);
		}
		transformSelect.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.repaint();
			}
		});
		setLayout(new BorderLayout(3,3));
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		top.add(new JLabel("Transform: "));
		top.add(transformSelect);
		add(display,BorderLayout.CENTER);
		add(top,BorderLayout.NORTH);
	}


	public static void main(String[] args) throws IOException {
		JFrame window = new JFrame("2D Transforms");
		window.setContentPane(new Transforms2D());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}