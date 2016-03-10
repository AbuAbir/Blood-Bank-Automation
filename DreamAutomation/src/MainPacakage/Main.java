package MainPacakage;

import javax.swing.JFrame;

import GUI.*;
import DB.*;
public class Main {
	
	public static void main(String[] args) {
	Mainframe ob =	new Mainframe();
	JFrame frame = new JFrame();
	frame.setTitle("Dream Automation");
	frame.add(ob);
	frame.setSize(900, 600);
	frame.setVisible(true);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);

	}

}
