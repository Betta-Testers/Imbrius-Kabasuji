package typeselectionscreen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

public class SelectionScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectionScreen window = new SelectionScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectionScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 640, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane_1.setLeftComponent(tabbedPane);
		
		JTextArea txtrRelease = new JTextArea();
		txtrRelease.setText("Stuff describing Release level");
		tabbedPane.addTab("Release", null, txtrRelease, null);
		
		JTextArea txtrLightning = new JTextArea();
		txtrLightning.setText("Stuff describing lightning level");
		tabbedPane.addTab("Lightning", null, txtrLightning, null);
		
		JTextArea txtrRelease = new JTextArea();
		txtrRelease.setText("Stuff describing release level");
		tabbedPane.addTab("Release level", null, txtrRelease, null);
		
		JButton btnCreateLevel = new JButton("Create Level");
		btnCreateLevel.setMaximumSize(new Dimension(120, 48));
		btnCreateLevel.setMinimumSize(new Dimension(120, 48));
		btnCreateLevel.setPreferredSize(new Dimension(120, 48));
		splitPane_1.setRightComponent(btnCreateLevel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		splitPane.setLeftComponent(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(720, 48));
		panel.setMaximumSize(new Dimension(720, 48));
		panel.setMinimumSize(new Dimension(720, 48));
		scrollPane.setViewportView(panel);
		
		JLabel lblPuzzle = new JLabel("Puzzle 1");
		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setPreferredSize(new Dimension(48, 48));
		lblPuzzle.setMaximumSize(new Dimension(48, 48));
		lblPuzzle.setMinimumSize(new Dimension(48, 48));
		JLabel lblPuzzle2 = new JLabel("Puzzle 2");
		lblPuzzle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle2.setPreferredSize(new Dimension(48, 48));
		lblPuzzle2.setMaximumSize(new Dimension(48, 48));
		lblPuzzle2.setMinimumSize(new Dimension(48, 48));
		JLabel lblPuzzle3 = new JLabel("Puzzle 3");
		lblPuzzle3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle3.setPreferredSize(new Dimension(48, 48));
		lblPuzzle3.setMaximumSize(new Dimension(48, 48));
		lblPuzzle3.setMinimumSize(new Dimension(48, 48));
		JLabel lblPuzzle4 = new JLabel("Puzzle 4");
		lblPuzzle4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle4.setPreferredSize(new Dimension(48, 48));
		lblPuzzle4.setMaximumSize(new Dimension(48, 48));
		lblPuzzle4.setMinimumSize(new Dimension(48, 48));
		JLabel lblPuzzle5 = new JLabel("Puzzle 5");
		lblPuzzle5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle5.setPreferredSize(new Dimension(48, 48));
		lblPuzzle5.setMaximumSize(new Dimension(48, 48));
		lblPuzzle5.setMinimumSize(new Dimension(48, 48));
		JLabel lblLightning = new JLabel("Lightning 1");
		lblLightning.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning.setPreferredSize(new Dimension(48, 48));
		lblLightning.setMaximumSize(new Dimension(48, 48));
		lblLightning.setMinimumSize(new Dimension(48, 48));
		JLabel lblLightning2 = new JLabel("Lightning 2");
		lblLightning2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning2.setPreferredSize(new Dimension(48, 48));
		lblLightning2.setMaximumSize(new Dimension(48, 48));
		lblLightning2.setMinimumSize(new Dimension(48, 48));
		JLabel lblLightning3 = new JLabel("Lightning 3");
		lblLightning3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning3.setPreferredSize(new Dimension(48, 48));
		lblLightning3.setMaximumSize(new Dimension(48, 48));
		lblLightning3.setMinimumSize(new Dimension(48, 48));
		JLabel lblLightning4 = new JLabel("Lightning 4");
		lblLightning4.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning4.setPreferredSize(new Dimension(48, 48));
		lblLightning4.setMaximumSize(new Dimension(48, 48));
		lblLightning4.setMinimumSize(new Dimension(48, 48));
		JLabel lblLightning5 = new JLabel("Lightning 5");
		lblLightning5.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning5.setPreferredSize(new Dimension(48, 48));
		lblLightning5.setMaximumSize(new Dimension(48, 48));
		lblLightning5.setMinimumSize(new Dimension(48, 48));
		JLabel lblRelease = new JLabel("Release 1");
		lblRelease.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease.setPreferredSize(new Dimension(48, 48));
		lblRelease.setMaximumSize(new Dimension(48, 48));
		lblRelease.setMinimumSize(new Dimension(48, 48));
		JLabel lblRelease2 = new JLabel("Release 2");
		lblRelease2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease2.setPreferredSize(new Dimension(48, 48));
		lblRelease2.setMaximumSize(new Dimension(48, 48));
		lblRelease2.setMinimumSize(new Dimension(48, 48));
		JLabel lblRelease3 = new JLabel("Release 3");
		lblRelease3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease3.setPreferredSize(new Dimension(48, 48));
		lblRelease3.setMaximumSize(new Dimension(48, 48));
		lblRelease3.setMinimumSize(new Dimension(48, 48));
		JLabel lblRelease4 = new JLabel("Release 4");
		lblRelease4.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease4.setPreferredSize(new Dimension(48, 48));
		lblRelease4.setMaximumSize(new Dimension(48, 48));
		lblRelease4.setMinimumSize(new Dimension(48, 48));
		JLabel lblRelease5 = new JLabel("Release 5");
		lblRelease5.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease5.setPreferredSize(new Dimension(48, 48));
		lblRelease5.setMaximumSize(new Dimension(48, 48));
		lblRelease5.setMinimumSize(new Dimension(48, 48));
		panel.add(lblPuzzle);
		panel.add(lblPuzzle2);
		panel.add(lblPuzzle3);
		panel.add(lblPuzzle4);
		panel.add(lblPuzzle5);
		panel.add(lblLightning);
		panel.add(lblLightning2);
		panel.add(lblLightning3);
		panel.add(lblLightning4);
		panel.add(lblLightning5);
		panel.add(lblRelease);
		panel.add(lblRelease2);
		panel.add(lblRelease3);
		panel.add(lblRelease4);
		panel.add(lblRelease5);
		
	}
}
