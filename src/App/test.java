package App;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Game gTest = new Game();
					gTest.initialize();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
