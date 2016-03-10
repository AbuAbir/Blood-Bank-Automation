package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import GUI.Mainframe.Buttonlistener;

public class AddClass extends JPanel {
	private JDialog dialog = new JDialog();
	String groupString;
	String[] s = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" };
	String[] s1={"F","M"};
	private JComboBox comboBox2 = new JComboBox<>(s1);
	private JComboBox comboBox = new JComboBox(s);
	private JLabel donar_name = new JLabel("Donar Name : ");
	private JLabel blood_group = new JLabel("Blood Group :");
	private JLabel age = new JLabel("Age : ");
	private JLabel hall = new JLabel("Hall :");
	private JLabel gender = new JLabel("Gender : ");
	private JLabel contact_no = new JLabel("Contact No :");
	private JTextField donarTextField = new JTextField(20);
	private JTextField bloodTextField = new JTextField(20);
	private JTextField ageTextField = new JTextField(20);
	private JTextField hallTextField = new JTextField(20);
	private JTextField gendertTextField = new JTextField(20);
	private JTextField contacTextField = new JTextField(20);
	
    boolean flag;
	ImageIcon ImageIconX1 = new ImageIcon(getClass().getResource(
			"/Icon/pic2.jpg"));

	private JButton ok = new JButton("save", ImageIconX1);
	private JButton back = new JButton("<<back",ImageIconX1);
	Image Imagex1;
	String donarnameString;
	String bloodgroup;
	String ageString;
	String hallname;
	String genderString;
	String contactnoString;
	int ages;

	public void Add() {
		Imagex1 = ImageIconX1.getImage();
		ok.setHorizontalTextPosition(JButton.CENTER);
		ok.setVerticalTextPosition(JButton.CENTER);
		back.setHorizontalTextPosition(JButton.CENTER);
		back.setVerticalTextPosition(JButton.CENTER);
        back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.dispose();
				
			}
		});
		this.add(donar_name);
		this.add(age);
		this.add(contact_no);
		this.add(gender);
		this.add(hall);
		this.add(blood_group);
		this.add(ageTextField);
		//this.add(bloodTextField);
		this.add(contacTextField);
		this.add(donarTextField);
		this.add(comboBox2);
		this.add(hallTextField);
		this.add(ok);
		this.add(back);
		this.add(comboBox);
		Buttonlistener listener = new Buttonlistener();
		ok.addActionListener(listener);
		dialog.setTitle("Add");
		dialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				flag = true;
				dialog.dispose();
				
			}
		});
		dialog.setModal(true);
		dialog.setSize(900, 600);
		dialog.setLocationRelativeTo(null);
		dialog.add(this);
		dialog.setVisible(true);

	}

	class Buttonlistener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
            flag = false;
			donarnameString = donarTextField.getText();
            String string = (String)comboBox.getSelectedItem();
            bloodgroup = string;
			ageString = ageTextField.getText();

			ages = Integer.parseInt(ageString);

			hallname = hallTextField.getText();
            String string2 = (String)comboBox2.getSelectedItem();
			genderString = string2;

			contactnoString = contacTextField.getText();

			//bloodgroup = bloodTextField.getText();
			dialog.dispose();
			

		}
	}
	public void clear() {
		donarTextField.setText("");
		ageTextField.setText("");
		hallTextField.setText("");
		gendertTextField.setText("");
		contacTextField.setText("");
		bloodTextField.setText("");
		
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		donar_name.setLocation(200, 100);
		donarTextField.setLocation(310, 105);
		age.setLocation(200, 150);
		ageTextField.setLocation(310, 155);
		hall.setLocation(200, 200);
		hallTextField.setLocation(310, 205);
		gender.setLocation(380, 300);
		//gendertTextField.setLocation(310, 303);
		contact_no.setLocation(200, 250);
		contacTextField.setLocation(310, 255);
		blood_group.setLocation(200,300);
		comboBox.setLocation(310,300);
		comboBox.setFont(new Font("nhk", Font.BOLD, 16));
		comboBox2.setFont(new Font("nhk", Font.BOLD, 16));
		comboBox2.setLocation(450,300);
		donar_name.setFont(new Font("nhk", Font.ITALIC, 16));
		blood_group.setFont(new Font("nhk", Font.ITALIC, 16));
		age.setFont(new Font("nhk", Font.ITALIC, 16));
		hall.setFont(new Font("nhk", Font.ITALIC, 16));
		gender.setFont(new Font("nhk", Font.ITALIC, 16));
		contact_no.setFont(new Font("nhk", Font.ITALIC, 16));
		g.drawImage(Imagex1, 0, 0, 900, 600, Color.red, null);
		donar_name.setForeground(Color.white);
		blood_group.setForeground(Color.white);
		age.setForeground(Color.white);
		hall.setForeground(Color.white);
		gender.setForeground(Color.white);
		contact_no.setForeground(Color.white);
		ok.setLocation(350, 400);
		ok.setForeground(Color.white);
		ok.setSize(110, 35);
		ok.setFont(new Font("nhk", Font.ITALIC, 16));
		back.setLocation(20, 20);
		back.setForeground(Color.white);
		back.setSize(110, 35);
		back.setFont(new Font("nhk", Font.ITALIC, 16));
	}

}
