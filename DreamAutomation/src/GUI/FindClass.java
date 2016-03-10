package GUI;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FindClass extends JPanel {
	JDialog dialog = new JDialog();
	boolean flag;
	JLabel bloodlabel = new JLabel("Blood Group : ");
    JLabel label = new JLabel("Choose Desired Blood Group : ");
	
	ImageIcon ImageIconX1 = new ImageIcon(getClass().getResource(
			"/Icon/pic2.jpg"));
	JButton ok = new JButton("OK",ImageIconX1);
	Image Imagex1;
	String groupString;
	String[] s = { "Group", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" };
	JComboBox com = new JComboBox(s);

	public void Find() {
         ok.setVerticalTextPosition(JButton.CENTER);
         ok.setHorizontalTextPosition(JButton.CENTER);
		this.add(bloodlabel);
		this.add(com);
		this.add(ok);
		this.add(label);
		Imagex1 = ImageIconX1.getImage();
		ItemListener item = new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				int state = e.getStateChange();
				if (state == e.SELECTED) {
					String string = (String) com.getSelectedItem();
					groupString = string;
				}

			}
		};

		com.addItemListener(item);
		buttonlistener button = new buttonlistener();
		ok.addActionListener(button);
		dialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) 
			{
				flag = true;
				dialog.dispose();
				
			}
		});
		dialog.setTitle("Search");
		dialog.setModal(true);
		dialog.add(this);
		dialog.setSize(900, 600);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);

	}

	class buttonlistener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ok) {
                flag = false;
				dialog.dispose();

			}
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		label.setLocation(200, 100);
		label.setForeground(Color.white);
		label.setFont(new Font("abir", Font.ITALIC, 26));
		bloodlabel.setLocation(200, 200);
		com.setLocation(370, 205);
		bloodlabel.setForeground(Color.white);
		bloodlabel.setFont(new Font("abir", Font.ITALIC, 26));
		com.setFont(new Font("abir", Font.ITALIC, 16));
		ok.setLocation(380, 280);
		ok.setFont(new Font("abir", Font.ITALIC, 13));
		g.drawImage(Imagex1, 0, 0, 900, 600, Color.red, null);
		ok.setForeground(Color.white);
		
		ok.setSize(100, 25);
		

	}

}
