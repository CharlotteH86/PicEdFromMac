package pictureEditor;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		Interface ui = new Interface();
		SwingUtilities.invokeLater(ui);

	}

}
