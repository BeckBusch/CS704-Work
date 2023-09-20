import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConveyorVisual implements ActionListener {
	// Declear frame and button objects
	JFrame f;
	JLabel cogFront;
	JLabel bottle1;
	JLabel bottle5;
	JLabel cogBack;
	JLabel con1On;
	JLabel con1Off;
	JLabel con5On;
	JLabel con5Off;

	// Event listener for button press.
	// This implementation of event listener can only provide a single responce for
	// all buttons,
	// but this is ok since there is only one button in this GUI
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO: Respond to Rotate button
		// Send whatever via sockets
	}

	// GUI constructor
	ConveyorVisual() {
		// Create frame
		f = new JFrame();

		// Create button
		JButton b = new JButton("Rotate");
		b.setBounds(550 - 40, 80, 80, 40);
		b.addActionListener(this);
		f.add(b);

		// Create images with default visibility
		// both cogs visible, both bottles hidden, both "Conveyor Off" visible, both
		// "Conveyor On" hidden

		// Front cog first for z order
		cogFront = new JLabel(new ImageIcon(getClass().getResource("cogFrontHalf.png")));
		cogFront.setBounds(0, 0, cogFront.getPreferredSize().width, cogFront.getPreferredSize().height);
		f.add(cogFront);
		cogFront.setVisible(true);
		// both bottles
		bottle1 = new JLabel(new ImageIcon(getClass().getResource("bottle1.png")));
		bottle1.setBounds(0, 0, bottle1.getPreferredSize().width, bottle1.getPreferredSize().height);
		f.add(bottle1);
		bottle1.setVisible(true);
		bottle5 = new JLabel(new ImageIcon(getClass().getResource("bottle5.png")));
		bottle5.setBounds(0, 0, bottle5.getPreferredSize().width, bottle5.getPreferredSize().height);
		f.add(bottle5);
		bottle5.setVisible(true);
		// back hlaf of cog
		cogBack = new JLabel(new ImageIcon(getClass().getResource("cogBackHalf.png")));
		cogBack.setBounds(0, 0, cogBack.getPreferredSize().width, cogBack.getPreferredSize().height);
		f.add(cogBack);
		cogBack.setVisible(true);
		// left conveyor belt
		con1On = new JLabel(new ImageIcon(getClass().getResource("con1On.png")));
		con1On.setBounds(0, 0, con1On.getPreferredSize().width, con1On.getPreferredSize().height);
		f.add(con1On);
		con1On.setVisible(true);
		con1Off = new JLabel(new ImageIcon(getClass().getResource("con1Off.png")));
		con1Off.setBounds(0, 0, con1Off.getPreferredSize().width, con1Off.getPreferredSize().height);
		f.add(con1Off);
		con1Off.setVisible(true);
		// right conveyor belt
		con5On = new JLabel(new ImageIcon(getClass().getResource("con5On.png")));
		con5On.setBounds(0, 0, con5On.getPreferredSize().width, con5On.getPreferredSize().height);
		f.add(con5On);
		con5On.setVisible(false);
		con5Off = new JLabel(new ImageIcon(getClass().getResource("con5Off.png")));
		con5Off.setBounds(0, 0, con5Off.getPreferredSize().width, con5Off.getPreferredSize().height);
		f.add(con5Off);
		con5Off.setVisible(true);

		// Configure frame
		f.setSize(1200, 700);
		f.setLayout(null);
		f.setVisible(true);
	}

	// Main method
	public static void main(String[] args) {
		ConveyorVisual conGUI = new ConveyorVisual();
		Integer socketReturn;
		boolean socketVisStatus;

		// Await socket or something
		// receive object and return int for which part we change and bool for how we change it
		socketReturn = 1;
		socketVisStatus = false;

		switch (socketReturn) {
			case 1: // 1 for bottle 1
				conGUI.bottle1.setVisible(socketVisStatus);
				break;

			case 2: // 2 for bottle 5
				conGUI.bottle5.setVisible(socketVisStatus);
				break;

			case 3: // 3 for conveyor left
				conGUI.con1On.setVisible(socketVisStatus);
				break;

			case 4: // 4 for conveyor right
				conGUI.con5On.setVisible(socketVisStatus);
				break;
		}
	}

}

// cogBack.getPreferredSize().width, cogBack.getPreferredSize().height
