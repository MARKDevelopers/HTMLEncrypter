package Proiect;

import java.awt.*;
import javax.swing.*;


public class loadSpinner extends JWindow {

	private static final long serialVersionUID = 1L;

	private int duration;

	Image bi = Toolkit.getDefaultToolkit().getImage(
			getClass().getClassLoader().getResource("assets/loader.gif"));
	ImageIcon ii = new ImageIcon(bi);

	public loadSpinner(int d) {
		duration = d;
	}

	public void showLoader() {

		int width = 31;
		int height = 31;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);
		setBackground(new Color(255, 255, 255, 0));
		setVisible(true);

		try {
			Thread.sleep(duration);
		} catch (Exception e) {
		}

		setVisible(false);

	}

	public void showLoaderAndExit() {
		showLoader();
		dispose();
	}

	public void paint(Graphics g) {
		g.drawImage(bi, 0, 0, this);
	}
}