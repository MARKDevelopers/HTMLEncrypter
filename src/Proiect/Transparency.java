
package Proiect;

import java.awt.*;
import javax.swing.*;


public class Transparency extends JComponent {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private JFrame frame;
	private Image background;

	public Transparency(JFrame frame) {
		this.frame = frame;
		updateBackground();
	}

	public void updateBackground() {
		try {
			Robot rbt = new Robot();
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension dim = tk.getScreenSize();
			background = rbt.createScreenCapture(new Rectangle(0, 0, (int) dim
					.getWidth(), (int) dim.getHeight()));
		} catch (Exception ex) {
			p(ex.toString());
			ex.printStackTrace();
		}
	}

	private void p(String string) {
	}

	public void paintComponent(Graphics g) {
		Point pos = this.getLocationOnScreen();
		Point offset = new Point(-pos.x, -pos.y);
		g.drawImage(background, offset.x, offset.y, null);
	}
}