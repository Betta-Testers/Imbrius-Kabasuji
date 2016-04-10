package view;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class LevelTypeSelectMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					LevelTypeSelectView window = new LevelTypeSelectView(15);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
