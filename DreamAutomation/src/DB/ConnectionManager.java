package DB;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ConnectionManager {
	private static final String username = "kakon";
	private static final String password = "abir";
	private static final String url = "jdbc:mysql://localhost/_dream";
	ResultSet resultSet = null;
	Connection connection = null;
	Statement statement = null;
	Date date = new Date();
	Date checkdate = new Date();
	Date oldDate = new Date();
/*************************************for connection************************/
	public void myconnection() {

		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, username,
						password);

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(
						null,
						"Error Code(" + e.getErrorCode() + ") : "
								+ e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	/*************************************for connection************************/
	
	
	
	
	
	
	
	/***********************************For inserting************************/
	
	public void insertdata(String name, String blood, int age, String hall,
			String gender, String contact) {
		if (name != null)
			try {
				statement = connection.createStatement();
				int row = statement
						.executeUpdate("INSERT INTO donar(donar_name,blood_group,age,hall,gender,contact_number,date)VALUES('"
								+ name
								+ "','"
								+ blood
								+ "','"
								+ age
								+ "','"
								+ hall
								+ "','"
								+ gender
								+ "','"
								+ contact
								+ "','" + currentdate() + "');");
			if (row > 0) {
				JOptionPane.showMessageDialog(null, "Data inserted");

				}

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(
						null,
						"Error Code(" + e.getErrorCode() + ") : "
								+ e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public void SizeCount() {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM donar;");
			String id, name, bloodgString, ageString, datesString, hallsString, gendersString, contaString;
			int i = 0;

			while (resultSet.next()) {
				i++;
				id = resultSet.getObject(1).toString();
				DataTransfer.vidStrings.add(resultSet.getObject(1).toString());
				name = resultSet.getObject(2).toString();
				bloodgString = resultSet.getObject(3).toString();
				ageString = resultSet.getObject(4).toString();
				hallsString = resultSet.getObject(5).toString();
				gendersString = resultSet.getObject(6).toString();
				contaString = resultSet.getObject(7).toString();
				datesString = resultSet.getObject(8).toString();
				
			}
			ShowInformation(i);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Error Code(" + e.getErrorCode() + ") : " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	public void ShowInformation(int n) {
		final int row = n;
		final JLabel idlabel[] = new JLabel[row];
		final JLabel namelabel[] = new JLabel[row];
		final JLabel bloodlabel[] = new JLabel[row];
		final JLabel name = new JLabel("Name");

		final JLabel id = new JLabel("ID");
		final JLabel group = new JLabel("Blood Group");
		final JLabel date = new JLabel("Last Donation Date");
		final JLabel hall = new JLabel("Hall");
		final JLabel age = new JLabel("Age");
		final JLabel contact = new JLabel("Contact No");
		final JLabel gender = new JLabel("Gender");
		final JDialog dialog = new JDialog();
		final JLabel agelabel[] = new JLabel[row];
		final JLabel datelabel[] = new JLabel[row];
		final JLabel halllabel[] = new JLabel[row];
		final JLabel genderlabel[] = new JLabel[row];
		final JLabel contaclabel[] = new JLabel[row];
		final JLabel show[] = new JLabel[row];
		final JDialog anotherdialog = new JDialog();
		ImageIcon ImageIconX = new ImageIcon(getClass().getResource(
				"/Icon/pic5.jpg"));
		final JButton back = new JButton("<<back",ImageIconX);
		back.setHorizontalTextPosition(JButton.CENTER);
		back.setVerticalTextPosition(JButton.CENTER);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dialog.dispose();
			}
		});
		try {
			int i = 0;
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM donar;");
			// String id, name, bloodgString, ageString, datesString,
			// hallsString, gendersString, contaString;

			while (resultSet.next()) {
				idlabel[i] = new JLabel(resultSet.getObject(1).toString());
				namelabel[i] = new JLabel(resultSet.getObject(2).toString());
				bloodlabel[i] = new JLabel(resultSet.getObject(3).toString());
				agelabel[i] = new JLabel(resultSet.getObject(4).toString());
				halllabel[i] = new JLabel(resultSet.getObject(5).toString());
				genderlabel[i] = new JLabel(resultSet.getObject(6).toString());
				contaclabel[i] = new JLabel(resultSet.getObject(7).toString());
				datelabel[i] = new JLabel(resultSet.getObject(8).toString());
				show[i] = new JLabel("show details");
				i++;
			}

			JPanel infopanel = new JPanel() {
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					int x = 20, y = 110;
					g.drawImage(
							new ImageIcon(getClass().getResource(
									"/Icon/pic2.jpg")).getImage(), 0, 0, 800,
							row * 60, null);
					id.setLocation(140, 60);
					name.setLocation(280, 60);
					group.setLocation(420, 60);
					age.setLocation(440, 60);
					hall.setLocation(485, 60);
					gender.setLocation(550, 60);
					contact.setLocation(630, 60);
					date.setLocation(750, 60);
					id.setForeground(Color.white);
					name.setForeground(Color.white);
					group.setForeground(Color.white);
					age.setForeground(Color.white);
					hall.setForeground(Color.white);
					gender.setForeground(Color.white);
					contact.setForeground(Color.white);
					date.setForeground(Color.white);
					id.setFont(new Font("nhk", Font.BOLD, 16));
					name.setFont(new Font("nhk", Font.BOLD, 16));
					group.setFont(new Font("nhk", Font.BOLD, 16));
					age.setFont(new Font("nhk", Font.BOLD, 16));
					hall.setFont(new Font("nhk", Font.BOLD, 16));
					gender.setFont(new Font("nhk", Font.BOLD, 16));
					contact.setFont(new Font("nhk", Font.BOLD, 16));
					date.setFont(new Font("nhk", Font.BOLD, 16));
					back.setLocation(20,20);
					back.setSize(100,25);
					back.setFont(new Font("nhk", Font.BOLD, 16));
					back.setForeground(Color.white);

					for (int i = 0; i < row; i++) {
						idlabel[i].setLocation(x + 100, y);
						namelabel[i].setLocation(x + 240, y);
						bloodlabel[i].setLocation(x + 440, y);
						show[i].setLocation(x + 560, y);
						show[i].setForeground(Color.white);
						show[i].setFont(new Font("nhk", Font.PLAIN, 16));
						idlabel[i].setForeground(Color.white);
						namelabel[i].setForeground(Color.white);
						bloodlabel[i].setForeground(Color.white);
						agelabel[i].setForeground(Color.white);
						halllabel[i].setForeground(Color.white);
						genderlabel[i].setForeground(Color.white);
						contaclabel[i].setForeground(Color.white);
						datelabel[i].setForeground(Color.white);
						idlabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						namelabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						bloodlabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						agelabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						halllabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						genderlabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						contaclabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						datelabel[i].setFont(new Font("nhk", Font.PLAIN, 16));

						y += 50;

					}

				}
			};
			infopanel.setPreferredSize(new Dimension(800, row * 60));
			infopanel.add(back);
			int j;
			for (j = 0; j < row; j++) {
				final int k = j;
				infopanel.add(idlabel[k]);
				infopanel.add(namelabel[k]);
				infopanel.add(bloodlabel[k]);
				infopanel.add(show[k]);

				show[k].addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						show[k].setCursor(new Cursor(Cursor.HAND_CURSOR));

					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						show[k].setForeground(Color.BLACK);
					}

					@Override
					public void mouseEntered(MouseEvent event) {
						// TODO Auto-generated method stub

						show[k].setForeground(Color.blue);
						show[k].setCursor(new Cursor(Cursor.HAND_CURSOR));
					}

					@Override
					public void mouseClicked(MouseEvent arg0) {
						dialog.dispose();
						final JLabel labelname = new JLabel();
						final JDialog anotherdialog = new JDialog();
						ImageIcon ImageIconX = new ImageIcon(getClass().getResource(
								"/Icon/pic5.jpg"));
						final JButton back = new JButton("<<back",ImageIconX);
						String name = namelabel[k].getText();
						String ageString = agelabel[k].getText();
						String hall = halllabel[k].getText();
						String gender = genderlabel[k].getText();
						String contactString = contaclabel[k].getText();
						String date = datelabel[k].getText();
						String bloodString = bloodlabel[k].getText();
						labelname.setText(name);
						final JLabel labelage = new JLabel(ageString);
						final JLabel labelhalLabel = new JLabel(hall);
						final JLabel labelgenderJLabel = new JLabel(gender);
						final JLabel labelconJLabel = new JLabel(contactString);
						final JLabel labeldate = new JLabel(date);
						final JLabel labelblood = new JLabel(bloodString);
						final JLabel nLabel = new JLabel("Name :");
						final JLabel aLabel = new JLabel("Age  :");
						final JLabel hLabel = new JLabel("Hall :");
						final JLabel dLabel = new JLabel("Last Donation Date:");
						final JLabel cLabel = new JLabel("Contact no:");
						final JLabel bLabel = new JLabel("Blood group:");
						final JLabel gLabel = new JLabel("Gender:");
						back.setHorizontalTextPosition(JButton.CENTER);
						back.setVerticalTextPosition(JButton.CENTER);
						back.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								anotherdialog.dispose();
								dialog.setVisible(true);
								
								
							}
						});
						JPanel panel = new JPanel() {
							
							protected void paintComponent(Graphics g) {
								g.drawImage(
										new ImageIcon(getClass().getResource(
												"/Icon/pic2.jpg")).getImage(), 0, 0,
										900, 600, null);
								nLabel.setLocation(300,100);
								nLabel.setForeground(Color.white);
								nLabel.setFont(new Font("nhk",Font.PLAIN,16));
								labelname.setLocation(370,100);
								labelname.setForeground(Color.white);
								labelname.setFont(new Font("nhk",Font.PLAIN,16));
								aLabel.setLocation(300,150);
								aLabel.setForeground(Color.white);
								aLabel.setFont(new Font("nhk",Font.PLAIN,16));
								labelage.setLocation(370,150);
								labelage.setForeground(Color.white);
								labelage.setFont(new Font("nhk",Font.PLAIN,16));
								hLabel.setLocation(300,200);
								hLabel.setFont(new Font("nhk",Font.PLAIN,16));
								hLabel.setForeground(Color.white);
								labelhalLabel.setLocation(370,200);
								labelhalLabel.setFont(new Font("nhk",Font.PLAIN,16));
								labelhalLabel.setForeground(Color.white);
								gLabel.setLocation(300,250);
								gLabel.setFont(new Font("nhk",Font.PLAIN,16));
								gLabel.setForeground(Color.white);
								labelgenderJLabel.setLocation(370,250);
								labelgenderJLabel.setFont(new Font("nhk",Font.PLAIN,16));
								labelgenderJLabel.setForeground(Color.white);
								bLabel.setLocation(300,300);
								bLabel.setFont(new Font("nhk",Font.PLAIN,16));
								bLabel.setForeground(Color.white);
								labelblood.setLocation(400,300);
								labelblood.setFont(new Font("nhk",Font.PLAIN,16));
								labelblood.setForeground(Color.white);
								cLabel.setLocation(300,350);
								cLabel.setFont(new Font("nhk",Font.PLAIN,16));
								cLabel.setForeground(Color.white);
								labelconJLabel.setLocation(400,350);
								labelconJLabel.setFont(new Font("nhk",Font.PLAIN,16));
								labelconJLabel.setForeground(Color.white);
								dLabel.setLocation(300,400);
								dLabel.setFont(new Font("nhk",Font.PLAIN,16));
								dLabel.setForeground(Color.white);
								labeldate.setLocation(450,400);
								labeldate.setFont(new Font("nhk",Font.PLAIN,16));
								labeldate.setForeground(Color.white);
								back.setLocation(50,50);
								back.setFont(new Font("nhk",Font.PLAIN,16));
								back.setForeground(Color.white);
								back.setSize(100,25);
								}
						};
						panel.add(back);
						panel.add(labelname);
						panel.add(labelage);
						panel.add(labelblood);
						panel.add(labeldate);
						panel.add(labelconJLabel);
						panel.add(labelgenderJLabel);
						panel.add(labelhalLabel);
						panel.add(nLabel);
						panel.add(aLabel);
						panel.add(gLabel);
						panel.add(hLabel);
						panel.add(dLabel);
						panel.add(cLabel);
						panel.add(bLabel);
						
						anotherdialog.add(panel);
						anotherdialog.setSize(900, 600);
						anotherdialog.setVisible(true);
						anotherdialog.setModal(true);
						anotherdialog.setLocationRelativeTo(null);

					}

				});
			}
			infopanel.add(id);
			infopanel.add(name);
			infopanel.add(group);
			
			JScrollPane scrollPane = new JScrollPane(infopanel,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			dialog.add(scrollPane);
			dialog.setSize(800, 600);
			dialog.setVisible(true);
			dialog.setModal(true);
			dialog.setLocationRelativeTo(null);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
/*****************************************For inserting******************************************/
	
	
	
	
	
	
	
	
	
/****************************************For updating******************************************/	
	

	public void updateInformation(int id) {
		final int donar_id = id;

		boolean b = (id != 0);
		if (b) {
			try {
				statement = connection.createStatement();
				resultSet = statement
						.executeQuery("SELECT * FROM donar WHERE donar_id='"
								+ id + "';");
				String ide;
				String name = null;
				String bloodgString = null, gendersString = null;
				String ageString = null, datesString = null, hallsString = null, contaString = null;
				if (resultSet.next()) {
					ide = resultSet.getObject(1).toString();
					name = resultSet.getObject(2).toString();
					bloodgString = resultSet.getObject(3).toString();
					ageString = resultSet.getObject(4).toString();
					hallsString = resultSet.getObject(5).toString();
					gendersString = resultSet.getObject(6).toString();
					contaString = resultSet.getObject(7).toString();
					datesString = resultSet.getObject(8).toString();

				}
				final String nstring = name;
				final String gString = gendersString;
				final String bString = bloodgString;
				final JDialog dialog = new JDialog();
				final JLabel ageJLabel = new JLabel();
				ageJLabel.setText("Age :");
				final JLabel halLabel = new JLabel("Hall :");
				final JLabel contactJLabel = new JLabel("Contact no :");
				final JLabel datesJLabel = new JLabel("Date : ");
				final JTextField ageField = new JTextField(10);
				ageField.setEnabled(false);
				final JTextField hallfField = new JTextField("" + hallsString,
						10);
				hallfField.setEnabled(false);
				final JTextField datefField = new JTextField("" + datesString,
						10);
				datefField.setEnabled(false);
				final JTextField contacField = new JTextField("" + contaString,
						10);
				contacField.setEnabled(false);
				ageField.setText("  " + ageString);
				ImageIcon ImageIconX1 = new ImageIcon(getClass().getResource(
						"/Icon/pic2.jpg"));

				final JButton ageButton = new JButton("Edit", ImageIconX1);
				final JButton contacButton = new JButton("Edit", ImageIconX1);
				final JButton hallButton = new JButton("Edit", ImageIconX1);
				final JButton dateButton = new JButton("Edit", ImageIconX1);
				final JButton saveButton = new JButton("save", ImageIconX1);

				JPanel panel = new JPanel() {
					protected void paintComponent(Graphics g) {

						super.paintComponent(g);
						ageButton.setHorizontalTextPosition(JButton.CENTER);
						ageButton.setVerticalTextPosition(JButton.CENTER);
						ageButton.setSize(70, 20);
						ageButton.setForeground(Color.white);
						ageButton.setLocation(590, 154);
						hallButton.setHorizontalTextPosition(JButton.CENTER);
						hallButton.setVerticalTextPosition(JButton.CENTER);
						hallButton.setSize(70, 20);
						hallButton.setForeground(Color.white);
						hallButton.setLocation(590, 204);
						contacButton.setHorizontalTextPosition(JButton.CENTER);
						contacButton.setVerticalTextPosition(JButton.CENTER);
						contacButton.setSize(70, 20);
						contacButton.setForeground(Color.white);
						contacButton.setLocation(590, 254);
						dateButton.setHorizontalTextPosition(JButton.CENTER);
						dateButton.setVerticalTextPosition(JButton.CENTER);
						dateButton.setSize(70, 20);
						dateButton.setForeground(Color.white);
						dateButton.setLocation(590, 304);
						saveButton.setHorizontalTextPosition(JButton.CENTER);
						saveButton.setVerticalTextPosition(JButton.CENTER);
						saveButton.setSize(70, 30);
						saveButton.setForeground(Color.white);
						saveButton.setLocation(590, 400);
						saveButton.setFont(new Font("nhk", Font.BOLD, 16));
						g.drawImage(
								new ImageIcon(getClass().getResource(
										"/Icon/pic2.jpg")).getImage(), 0, 0,
								900, 600, null);
						ageJLabel.setLocation(350, 150);
						ageJLabel.setForeground(Color.white);
						ageJLabel.setFont(new Font("nhk", Font.ITALIC, 20));
						ageField.setLocation(470, 155);
						halLabel.setLocation(350, 200);
						halLabel.setForeground(Color.white);
						halLabel.setFont(new Font("nhk", Font.ITALIC, 20));
						hallfField.setLocation(470, 205);
						contactJLabel.setLocation(350, 250);
						contactJLabel.setForeground(Color.white);
						contactJLabel.setFont(new Font("nhk", Font.ITALIC, 20));
						contacField.setLocation(470, 255);
						datesJLabel.setLocation(350, 300);
						datesJLabel.setForeground(Color.white);
						datesJLabel.setFont(new Font("nhk", Font.ITALIC, 20));
						datefField.setLocation(470, 305);

					}
				};
				ageButton.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent arg0) {
						ageField.setEnabled(true);
					}
				});
				hallButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						hallfField.setEnabled(true);

					}
				});
				contacButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						contacField.setEnabled(true);

					}
				});
				dateButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						datefField.setEnabled(true);
						Date mydate = currentdate();
						Format format = new SimpleDateFormat("yyyy-MM-dd");
						String string = format.format(mydate);
						datefField.setText("" + string);
						dateupdate(donar_id);

					}
				});
				saveButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {

						dialog.dispose();
						String ageString = ageField.getText();
						ageupdate(ageString, donar_id);
						String hallString = hallfField.getText();
						hallupdate(hallString, donar_id);
						String contacString = contacField.getText();
						contactupdate(contacString, donar_id);
						String datesString = datefField.getText();
						JDialog updateDialog = new JDialog();
						final JLabel nameLabel = new JLabel("Name :");
						final JLabel nameJLabel = new JLabel(nstring);
						final JLabel genderJLabel = new JLabel(gString);
						final JLabel bloodJLabel = new JLabel(bString);
						final JLabel ageLabel = new JLabel("Age  :");
						final JLabel halLabel = new JLabel("Hall :");
						final JLabel dateLabel = new JLabel(
								"Last Doantion date:");
						final JLabel contacLabel = new JLabel("Contact no :");
						final JLabel genderLabel = new JLabel("Gender :");
						final JLabel bloodLabel = new JLabel("Blood group :");
						final JLabel ageJLabel = new JLabel(ageString);
						final JLabel halJLabel = new JLabel(hallString);
						final JLabel datJLabel = new JLabel(datesString);
						final JLabel contacJLabel = new JLabel(contacString);
						JPanel updatePanel = new JPanel() {
							protected void paintComponent(Graphics g) {
								super.paintComponent(g);
								g.drawImage(
										new ImageIcon(getClass().getResource(
												"/Icon/pic2.jpg")).getImage(),
										0, 0, 900, 600, null);
								nameLabel.setLocation(200, 100);
								nameLabel.setForeground(Color.white);
								nameLabel
										.setFont(new Font("nhk", Font.BOLD, 20));
								nameJLabel.setLocation(270, 100);
								nameJLabel.setForeground(Color.white);
								nameJLabel.setFont(new Font("nhk", Font.BOLD,
										20));
								ageLabel.setLocation(200, 150);
								ageLabel.setForeground(Color.white);
								ageLabel.setFont(new Font("nhk", Font.BOLD, 20));
								ageJLabel.setLocation(250, 150);
								ageJLabel.setForeground(Color.white);
								ageJLabel
										.setFont(new Font("nhk", Font.BOLD, 20));
								halLabel.setLocation(200, 200);
								halLabel.setForeground(Color.white);
								halLabel.setFont(new Font("nhk", Font.BOLD, 20));
								halJLabel.setLocation(260, 200);
								halJLabel.setForeground(Color.white);
								halJLabel
										.setFont(new Font("nhk", Font.BOLD, 20));
								genderLabel.setLocation(200, 250);
								genderLabel.setForeground(Color.white);
								genderLabel.setFont(new Font("nhk", Font.BOLD,
										20));
								genderJLabel.setLocation(290, 250);
								genderJLabel.setForeground(Color.white);
								genderJLabel.setFont(new Font("nhk", Font.BOLD,
										20));

								bloodLabel.setLocation(200, 300);
								bloodLabel.setForeground(Color.white);
								bloodLabel.setFont(new Font("nhk", Font.BOLD,
										20));
								bloodJLabel.setLocation(340, 300);
								bloodJLabel.setForeground(Color.white);
								bloodJLabel.setFont(new Font("nhk", Font.BOLD,
										20));
								contacLabel.setLocation(200, 350);
								contacLabel.setForeground(Color.white);
								contacLabel.setFont(new Font("nhk", Font.BOLD,
										20));
								contacJLabel.setLocation(320, 350);
								contacJLabel.setForeground(Color.white);
								contacJLabel.setFont(new Font("nhk", Font.BOLD,
										20));
								dateLabel.setLocation(200, 400);
								dateLabel.setForeground(Color.white);
								dateLabel
										.setFont(new Font("nhk", Font.BOLD, 20));
								datJLabel.setLocation(390, 400);
								datJLabel.setForeground(Color.white);
								datJLabel
										.setFont(new Font("nhk", Font.BOLD, 20));

							}
						};
						updatePanel.add(nameJLabel);
						updatePanel.add(bloodJLabel);
						updatePanel.add(genderJLabel);
						updatePanel.add(ageJLabel);
						updatePanel.add(halJLabel);
						updatePanel.add(contacJLabel);
						updatePanel.add(datJLabel);
						updatePanel.add(nameLabel);
						updatePanel.add(ageLabel);
						updatePanel.add(halLabel);
						updatePanel.add(bloodLabel);
						updatePanel.add(genderLabel);
						updatePanel.add(contacLabel);
						updatePanel.add(dateLabel);
						updateDialog.add(updatePanel);
						updateDialog.setVisible(true);
						updateDialog.setSize(900, 600);
						updateDialog.setLocationRelativeTo(null);
						updateDialog.setModal(true);
					}
				});
				panel.add(datesJLabel);
				panel.add(contactJLabel);
				panel.add(ageJLabel);
				panel.add(halLabel);
				panel.add(ageField);
				panel.add(hallfField);
				panel.add(contacField);
				panel.add(datefField);
				panel.add(ageButton);
				panel.add(hallButton);
				panel.add(contacButton);
				panel.add(dateButton);
				panel.add(saveButton);
				dialog.add(panel);
				dialog.setSize(900, 600);
				dialog.setLocationRelativeTo(null);
				dialog.setModal(true);
				dialog.setVisible(true);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void ageupdate(String age, int id) {
		try {
			statement = connection.createStatement();
			int row = statement.executeUpdate("UPDATE donar SET age = '" + age
					+ "'WHERE donar_id = '" + id + "';");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public void hallupdate(String hall, int id) {
		try {
			statement = connection.createStatement();
			int row = statement.executeUpdate("UPDATE donar SET hall = '"
					+ hall + "'WHERE donar_id = '" + id + "';");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

	public void contactupdate(String contac, int id) {
		try {
			statement = connection.createStatement();
			int row = statement
					.executeUpdate("UPDATE donar SET contact_number = '"
							+ contac + "'WHERE donar_id = '" + id + "';");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public void dateupdate(int id) {
		try {
			statement = connection.createStatement();
			int row = statement.executeUpdate("UPDATE donar SET date = '"
					+ currentdate() + "'WHERE donar_id = '" + id + "';");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	private Date currentdate() {
		// int i = 203;
		//Date newDate = subtractdays(date, i);
		java.sql.Date sDate = new java.sql.Date(date.getTime());
		return sDate;
	}

	public static Date subtractdays(Date d, int days) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(d);
		calendar.add(calendar.DATE, -days);
		return calendar.getTime();

	}

	
	/***********************************************For Searching**********************************/
	
	
	
	
	
	public void  searchCount(String bloodString) {
		 String blood = bloodString;
	     int i = 0;
		try {
			boolean value = false;
			Vector<Vector> rowData = new Vector<Vector>();
			checkdate = check();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT donar_id,donar_name,blood_group,age,hall,gender,contact_number,date FROM donar WHERE blood_group ='"
							+ bloodString + "';");
			String id, name, bloodgString, ageString, datesString, hallsString, gendersString, contaString;
			while (resultSet.next()) {

				id = resultSet.getObject(1).toString();
				name = resultSet.getObject(2).toString();
				bloodgString = resultSet.getObject(3).toString();
				ageString = resultSet.getObject(4).toString();
				hallsString = resultSet.getObject(5).toString();
				gendersString = resultSet.getObject(6).toString();
				contaString = resultSet.getObject(7).toString();
				datesString = resultSet.getObject(8).toString();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date jDate = format.parse(datesString);
					if (checkdate.after(jDate) || checkdate.equals(jDate)) {
						i++;
						
						
					}

				} catch (ParseException e) {

					e.printStackTrace();
				}

			}
			search(i,blood);


		} catch (SQLException e) {

		}
		
		
	}
	
	
	public void search(int n,String bloodString) {
        boolean flag = false;
		final int row = n;
		final JLabel idlabel[] = new JLabel[row];
		final JLabel namelabel[] = new JLabel[row];
		final JLabel bloodlabel[] = new JLabel[row];
		final JLabel name = new JLabel("Name");

		final JLabel id = new JLabel("ID");
		final JLabel group = new JLabel("Blood Group");
		final JLabel date = new JLabel("Last Donation Date");
		final JLabel hall = new JLabel("Hall");
		final JLabel age = new JLabel("Age");
		final JLabel contact = new JLabel("Contact No");
		final JLabel gender = new JLabel("Gender");
		final JDialog dialog = new JDialog();
		final JLabel agelabel[] = new JLabel[row];
		final JLabel datelabel[] = new JLabel[row];
		final JLabel halllabel[] = new JLabel[row];
		final JLabel genderlabel[] = new JLabel[row];
		final JLabel contaclabel[] = new JLabel[row];
		final JLabel show[] = new JLabel[row];
		final JDialog anotherdialog = new JDialog();
		ImageIcon ImageIconX = new ImageIcon(getClass().getResource(
				"/Icon/pic5.jpg"));
		final JButton back = new JButton("<<back",ImageIconX);
		back.setHorizontalTextPosition(JButton.CENTER);
		back.setVerticalTextPosition(JButton.CENTER);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dialog.dispose();
			}
		});
		try {
			int i = 0;
			checkdate = check();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT donar_id,donar_name,blood_group,age,hall,gender,contact_number,date FROM donar WHERE blood_group ='"
							+ bloodString + "';");
           String iid,nam,blod,ages,hal,geender,coontact,dates;
			while (resultSet.next()) {
				iid = resultSet.getObject(1).toString();
				nam = resultSet.getObject(2).toString();
				blod = resultSet.getObject(3).toString();
				ages = resultSet.getObject(4).toString();
				hal = resultSet.getObject(5).toString();
				geender =resultSet.getObject(6).toString();
				coontact = resultSet.getObject(7).toString();
				dates = resultSet.getObject(8).toString();
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date jDate = format.parse(resultSet.getObject(8).toString());
					if (checkdate.after(jDate) || checkdate.equals(jDate)) {
						idlabel[i] = new JLabel(iid);
						namelabel[i] = new JLabel(nam);
						bloodlabel[i] = new JLabel(blod);
						agelabel[i] = new JLabel(ages);
						halllabel[i] = new JLabel(hal);
						genderlabel[i] = new JLabel(geender);
						contaclabel[i] = new JLabel(coontact);
						datelabel[i] = new JLabel(dates);
						show[i] = new JLabel("show details");
						flag = true;
						i++;
						
						
					}

				} catch (ParseException e) {

					e.printStackTrace();
				}
				
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(null,"Blood is not available");
				return;
			}

			JPanel infopanel = new JPanel() {
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					int x = 20, y = 110;
					g.drawImage(
							new ImageIcon(getClass().getResource(
									"/Icon/pic2.jpg")).getImage(), 0, 0, 900,
							row * 2000, null);
					id.setLocation(140, 60);
					name.setLocation(280, 60);
					group.setLocation(420, 60);
					age.setLocation(440, 60);
					hall.setLocation(485, 60);
					gender.setLocation(550, 60);
					contact.setLocation(630, 60);
					date.setLocation(750, 60);
					id.setForeground(Color.white);
					name.setForeground(Color.white);
					group.setForeground(Color.white);
					age.setForeground(Color.white);
					hall.setForeground(Color.white);
					gender.setForeground(Color.white);
					contact.setForeground(Color.white);
					date.setForeground(Color.white);
					id.setFont(new Font("nhk", Font.BOLD, 16));
					name.setFont(new Font("nhk", Font.BOLD, 16));
					group.setFont(new Font("nhk", Font.BOLD, 16));
					age.setFont(new Font("nhk", Font.BOLD, 16));
					hall.setFont(new Font("nhk", Font.BOLD, 16));
					gender.setFont(new Font("nhk", Font.BOLD, 16));
					contact.setFont(new Font("nhk", Font.BOLD, 16));
					date.setFont(new Font("nhk", Font.BOLD, 16));
					back.setLocation(20,20);
					back.setSize(100,25);
					back.setFont(new Font("nhk", Font.BOLD, 16));
					back.setForeground(Color.white);

					for (int i = 0; i < row; i++) {
						idlabel[i].setLocation(x + 100, y);
						namelabel[i].setLocation(x + 240, y);
						bloodlabel[i].setLocation(x + 440, y);
						show[i].setLocation(x + 560, y);
						show[i].setForeground(Color.white);
						show[i].setFont(new Font("nhk", Font.PLAIN, 16));
						idlabel[i].setForeground(Color.white);
						namelabel[i].setForeground(Color.white);
						bloodlabel[i].setForeground(Color.white);
						agelabel[i].setForeground(Color.white);
						halllabel[i].setForeground(Color.white);
						genderlabel[i].setForeground(Color.white);
						contaclabel[i].setForeground(Color.white);
						datelabel[i].setForeground(Color.white);
						idlabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						namelabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						bloodlabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						agelabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						halllabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						genderlabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						contaclabel[i].setFont(new Font("nhk", Font.PLAIN, 16));
						datelabel[i].setFont(new Font("nhk", Font.PLAIN, 16));

						y += 50;

					}

				}
			};
			infopanel.setPreferredSize(new Dimension(800, row*2000));
			infopanel.add(back);
			int j;
			for (j = 0; j < row; j++) {
				final int k = j;
				infopanel.add(idlabel[k]);
				infopanel.add(namelabel[k]);
				infopanel.add(bloodlabel[k]);
				infopanel.add(show[k]);

				show[k].addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						show[k].setCursor(new Cursor(Cursor.HAND_CURSOR));

					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						show[k].setForeground(Color.BLACK);
					}

					@Override
					public void mouseEntered(MouseEvent event) {
						// TODO Auto-generated method stub

						show[k].setForeground(Color.blue);
						show[k].setCursor(new Cursor(Cursor.HAND_CURSOR));
					}

					@Override
					public void mouseClicked(MouseEvent arg0) {
						dialog.dispose();
						final JLabel labelname = new JLabel();
						final JDialog anotherdialog = new JDialog();
						ImageIcon ImageIconX = new ImageIcon(getClass().getResource(
								"/Icon/pic5.jpg"));
						final JButton back = new JButton("<<Back",ImageIconX);
						String name = namelabel[k].getText();
						String ageString = agelabel[k].getText();
						String hall = halllabel[k].getText();
						String gender = genderlabel[k].getText();
						String contactString = contaclabel[k].getText();
						String date = datelabel[k].getText();
						String bloodString = bloodlabel[k].getText();
						labelname.setText(name);
						final JLabel labelage = new JLabel(ageString);
						final JLabel labelhalLabel = new JLabel(hall);
						final JLabel labelgenderJLabel = new JLabel(gender);
						final JLabel labelconJLabel = new JLabel(contactString);
						final JLabel labeldate = new JLabel(date);
						final JLabel labelblood = new JLabel(bloodString);
						final JLabel nLabel = new JLabel("Name :");
						final JLabel aLabel = new JLabel("Age  :");
						final JLabel hLabel = new JLabel("Hall :");
						final JLabel dLabel = new JLabel("Last Donation Date:");
						final JLabel cLabel = new JLabel("Contact no:");
						final JLabel bLabel = new JLabel("Blood group:");
						final JLabel gLabel = new JLabel("Gender:");
						back.setHorizontalTextPosition(JButton.CENTER);
						back.setVerticalTextPosition(JButton.CENTER);
						back.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								anotherdialog.dispose();
								dialog.setVisible(true);
								
								
							}
						});
						JPanel panel = new JPanel() {
							
							protected void paintComponent(Graphics g) {
								g.drawImage(
										new ImageIcon(getClass().getResource(
												"/Icon/pic2.jpg")).getImage(), 0, 0,
										900, 600, null);
								nLabel.setLocation(300,100);
								nLabel.setForeground(Color.white);
								nLabel.setFont(new Font("nhk",Font.PLAIN,16));
								labelname.setLocation(370,100);
								labelname.setForeground(Color.white);
								labelname.setFont(new Font("nhk",Font.PLAIN,16));
								aLabel.setLocation(300,150);
								aLabel.setForeground(Color.white);
								aLabel.setFont(new Font("nhk",Font.PLAIN,16));
								labelage.setLocation(370,150);
								labelage.setForeground(Color.white);
								labelage.setFont(new Font("nhk",Font.PLAIN,16));
								hLabel.setLocation(300,200);
								hLabel.setFont(new Font("nhk",Font.PLAIN,16));
								hLabel.setForeground(Color.white);
								labelhalLabel.setLocation(370,200);
								labelhalLabel.setFont(new Font("nhk",Font.PLAIN,16));
								labelhalLabel.setForeground(Color.white);
								gLabel.setLocation(300,250);
								gLabel.setFont(new Font("nhk",Font.PLAIN,16));
								gLabel.setForeground(Color.white);
								labelgenderJLabel.setLocation(370,250);
								labelgenderJLabel.setFont(new Font("nhk",Font.PLAIN,16));
								labelgenderJLabel.setForeground(Color.white);
								bLabel.setLocation(300,300);
								bLabel.setFont(new Font("nhk",Font.PLAIN,16));
								bLabel.setForeground(Color.white);
								labelblood.setLocation(400,300);
								labelblood.setFont(new Font("nhk",Font.PLAIN,16));
								labelblood.setForeground(Color.white);
								cLabel.setLocation(300,350);
								cLabel.setFont(new Font("nhk",Font.PLAIN,16));
								cLabel.setForeground(Color.white);
								labelconJLabel.setLocation(400,350);
								labelconJLabel.setFont(new Font("nhk",Font.PLAIN,16));
								labelconJLabel.setForeground(Color.white);
								dLabel.setLocation(300,400);
								dLabel.setFont(new Font("nhk",Font.PLAIN,16));
								dLabel.setForeground(Color.white);
								labeldate.setLocation(450,400);
								labeldate.setFont(new Font("nhk",Font.PLAIN,16));
								labeldate.setForeground(Color.white);
								back.setLocation(50,50);
								back.setFont(new Font("nhk",Font.PLAIN,16));
								back.setForeground(Color.white);
								back.setSize(100,25);
								


								
								

							}
						};
						panel.add(back);
						panel.add(labelname);
						panel.add(labelage);
						panel.add(labelblood);
						panel.add(labeldate);
						panel.add(labelconJLabel);
						panel.add(labelgenderJLabel);
						panel.add(labelhalLabel);
						panel.add(nLabel);
						panel.add(aLabel);
						panel.add(gLabel);
						panel.add(hLabel);
						panel.add(dLabel);
						panel.add(cLabel);
						panel.add(bLabel);
						
						anotherdialog.add(panel);
						anotherdialog.setSize(900, 600);
						anotherdialog.setVisible(true);
						anotherdialog.setModal(true);
						anotherdialog.setLocationRelativeTo(null);

					}

				});
				// infopanel.add(agelabel[j]);
				// infopanel.add(halllabel[j]);
				// infopanel.add(genderlabel[j]);
				// infopanel.add(contaclabel[j]);
				// infopanel.add(datelabel[j]);
			}
			infopanel.add(id);
			infopanel.add(name);
			infopanel.add(group);
			
			JScrollPane scrollPane = new JScrollPane(infopanel,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			dialog.add(scrollPane);
			dialog.setSize(900, 600);
			dialog.setVisible(true);
			dialog.setModal(true);
			dialog.setLocationRelativeTo(null);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	

	public Date check() {
		int i = 120;
		oldDate = subtractdays(date, i);
		return oldDate;
	}
	
	
	/***********************************For deleting data*************************************/
	
	
	public void  deleteInfo(int id) {
		
		try {
			statement = connection.createStatement();
			int effectedRow = statement.executeUpdate("DELETE  FROM donar WHERE donar_id='"+id+"';");
			JOptionPane.showMessageDialog(null,"Data deleted");
			SizeCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
