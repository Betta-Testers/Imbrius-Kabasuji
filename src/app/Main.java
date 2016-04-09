package app;

import java.awt.EventQueue;

import javax.swing.UIManager;

import view.BuilderView;
import view.LevelTypeSelectView;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Builder builder = new Builder();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
