
package Proiect;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class helpBox {

	public static ImageIcon getImageIcon(String name) {
		return new ImageIcon(ClassLoader.getSystemResource(name));
	}

	public helpBox() throws IOException {
		final JFrame helpbox = new JFrame("Help");

		ComponentMover cm = new ComponentMover();
		cm.registerComponent(helpbox);

		JLabel label = new JLabel("");
		JButton exit = new JButton("");
		JTextArea text = new JTextArea(26, 33);
		JScrollPane scrol = new JScrollPane(text);

		helpbox.setSize(420, 500);
		helpbox.setLocationRelativeTo(Encrypter.Center);
		helpbox.setResizable(false);
		helpbox.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("assets/ico.png")));
		helpbox.setUndecorated(true);
		helpbox.getRootPane().setBorder(
				BorderFactory.createLineBorder(Encrypter.color_black, 2));
		helpbox.setVisible(true);
		helpbox.getContentPane().setBackground(Encrypter.color_light);

		helpbox.setLayout(new FlowLayout());
		helpbox.add(label);
		helpbox.add(Box.createHorizontalStrut(330));
		helpbox.add(exit);
		helpbox.add(scrol);

		ImageIcon label_Icon = getImageIcon("assets/icons/help.png");
		label.setIcon(label_Icon);
		label.setForeground(Encrypter.color_blue);
		label.setFont(Encrypter.font16);

		text.setEditable(false);
		text.setSelectionColor(Encrypter.color_black);
		text.setSelectedTextColor(Encrypter.color_white);
		text.setBackground(Encrypter.color_light);

		scrol.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrol.setViewportBorder(BorderFactory.createLineBorder(
				Encrypter.color_black, 0));

		ImageIcon exit_icon = getImageIcon("assets/icons/exit.png");
		exit.setBackground(Encrypter.color_light);
		exit.setBorder(BorderFactory.createLineBorder(Encrypter.color_dark, 0));
		exit.setForeground(Encrypter.color_black);
		exit.setFont(Encrypter.font16);
		exit.setIcon(exit_icon);
		exit.setToolTipText("Exit");

		try {
			FileReader file = new FileReader(ClassLoader.getSystemResource(
					"assets/helpBox.txt").getPath());
			BufferedReader buff = new BufferedReader(file);
			String line = null;
			while ((line = buff.readLine()) != null) {
				text.append(line);
				text.append("\n");
			}
			buff.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				helpbox.dispose();
			}
		});
	}
}
