package gameMockups;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					LevelView frame = new LevelView("Puzzle");
					LevelView frame1 = new LevelView("Lightning");
					LevelView frame2 = new LevelView("Release");
					frame.setVisible(true);
					frame1.setVisible(true);
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


/**
 * Launch the application.
 */

/*public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}*/