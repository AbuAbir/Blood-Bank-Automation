package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import DB.*;

public class Mainframe extends JPanel {

	ImageIcon ImageIconX = new ImageIcon(getClass().getResource(
			"/Icon/Background.jpg"));
	Image Imagex;
	private JButton find = new JButton("SEARCH", ImageIconX);
	private JButton add = new JButton("ADD", ImageIconX);
	private JButton update = new JButton("UPDATE", ImageIconX);
	private JButton exit = new JButton("EXIT", ImageIconX);
	private JButton delete = new JButton("DELETE", ImageIconX);
	FindClass findClass = new FindClass();
	AddClass addClass = new AddClass();
	UpdateClass updateClass = new UpdateClass();
	DeleteClass deleteClass = new DeleteClass();
	ConnectionManager connectionManager = new ConnectionManager();

	public Mainframe() {
		find.setHorizontalTextPosition(JButton.CENTER);
		find.setVerticalTextPosition(JButton.CENTER);
		add.setHorizontalTextPosition(JButton.CENTER);
		add.setVerticalTextPosition(JButton.CENTER);
		update.setHorizontalTextPosition(JButton.CENTER);
		update.setVerticalTextPosition(JButton.CENTER);
		exit.setHorizontalTextPosition(JButton.CENTER);
		exit.setVerticalTextPosition(JButton.CENTER);
		delete.setHorizontalTextPosition(JButton.CENTER);
		delete.setVerticalTextPosition(JButton.CENTER);
		Imagex = ImageIconX.getImage();
		this.add(find);
		this.add(add);
		this.add(update);
		this.add(exit);
		this.add(delete);
		Buttonlistener button = new Buttonlistener();
		find.addActionListener(button);
		add.addActionListener(button);
		update.addActionListener(button);
		exit.addActionListener(button);
		delete.addActionListener(button);

	}

	class Buttonlistener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == find) {
				findClass.Find();
				if (findClass.flag) {

				} else if (findClass.groupString != "Group") {
					if (findClass.groupString != null) {
						connectionManager.myconnection();
						connectionManager.searchCount(findClass.groupString);
					}
				}

			} else if (e.getSource() == add) {
				addClass.Add();
				if (addClass.flag) {

				} else if (addClass.donarnameString != null
						&& addClass.ages > 0) {
					connectionManager.myconnection();
					connectionManager.insertdata(addClass.donarnameString,
							addClass.bloodgroup, addClass.ages,
							addClass.hallname, addClass.genderString,
							addClass.contactnoString);

					connectionManager.SizeCount();
				}
				addClass.donarnameString = null;
				addClass.clear();

			} else if (e.getSource() == update) {
				updateClass.update();
				connectionManager.myconnection();
				connectionManager.updateInformation(updateClass.id);

			} else if (e.getSource() == exit) {
				System.exit(0);
			} else if (e.getSource() == delete) {
				deleteClass.delete();
				if (deleteClass.flag) {

				} else {
					connectionManager.myconnection();

					connectionManager.deleteInfo(deleteClass.id);
				}
			}
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Imagex, 0, 0, 900, 600, this);
		find.setLocation(400, 250);
		update.setLocation(400, 350);
		exit.setLocation(400, 450);

		update.setBackground(Color.black);
		exit.setBackground(Color.black);
		add.setForeground(Color.white);
		find.setForeground(Color.white);
		update.setForeground(Color.white);
		exit.setForeground(Color.white);
		add.setBounds(400, 300, 110, 25);
		update.setSize(110, 25);
		find.setSize(110, 25);
		delete.setSize(110, 25);
		delete.setFont(new Font("FONT", Font.BOLD, 18));
		delete.setForeground(Color.white);
		delete.setLocation(400, 400);
		exit.setSize(110, 25);
		add.setFont(new Font("FONT", Font.BOLD, 18));
		find.setFont(new Font("FONT", Font.BOLD, 18));
		update.setFont(new Font("FONT", Font.BOLD, 18));
		exit.setFont(new Font("FONT", Font.BOLD, 18));

	}

}
