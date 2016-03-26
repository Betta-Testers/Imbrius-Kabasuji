package typeselectionscreen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.Dimension;

import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectionScreen {

	private JFrame frame;
	Dimension tabSize = new Dimension(180, 25);
	Dimension levelPreviewSize = new Dimension(96, 72);

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
		
		JSplitPane levelViewerAndSelector = new JSplitPane();
		levelViewerAndSelector.setEnabled(false);
		levelViewerAndSelector.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(levelViewerAndSelector);
		
		JSplitPane levelSelectorAndCreator = new JSplitPane();
		levelSelectorAndCreator.setResizeWeight(1.0);
		levelSelectorAndCreator.setEnabled(false);
		levelSelectorAndCreator.setOrientation(JSplitPane.VERTICAL_SPLIT);
		levelViewerAndSelector.setRightComponent(levelSelectorAndCreator);
		
		JTabbedPane levelTypes = new JTabbedPane(JTabbedPane.BOTTOM);
		levelSelectorAndCreator.setLeftComponent(levelTypes);
		
		JTextArea txtrPuzzle = new JTextArea();
		txtrPuzzle.setText("Stuff describing Release level");
		levelTypes.addTab("Puzzle", null, txtrPuzzle, null);
		
		JTextArea txtrLightning = new JTextArea();
		txtrLightning.setText("Stuff describing lightning level");
		levelTypes.addTab("Lightning", null, txtrLightning, null);
		
		JTextArea txtrRelease = new JTextArea();
		txtrRelease.setText("Stuff describing release level");
		levelTypes.addTab("Release", null, txtrRelease, null);
		
		JPanel createBtnPanel = new JPanel();
		levelSelectorAndCreator.setRightComponent(createBtnPanel);
				
		JButton btnCreateLevel = new JButton("Create Level");
		btnCreateLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		levelSelectorAndCreator.setDividerLocation(1.0);
		
		GroupLayout gl_createBtnPanel = new GroupLayout(createBtnPanel);
		gl_createBtnPanel.setAutoCreateGaps(true);
		gl_createBtnPanel.setAutoCreateContainerGaps(true);
		gl_createBtnPanel.setHorizontalGroup(
			gl_createBtnPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_createBtnPanel.createSequentialGroup()
					.addGap(256)
					.addComponent(btnCreateLevel)
					.addContainerGap(255, Short.MAX_VALUE))
		);
		gl_createBtnPanel.setVerticalGroup(
			gl_createBtnPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_createBtnPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(btnCreateLevel)
					.addGap(10))
		);
		createBtnPanel.setLayout(gl_createBtnPanel);
		
		JScrollPane levelViewer = new JScrollPane();
		levelViewer.setEnabled(false);
		levelViewer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		levelViewerAndSelector.setLeftComponent(levelViewer);
		
		JPanel levelsList = new JPanel();
		levelViewer.setViewportView(levelsList);
		
		for (int i=1; i<=5; i++){
			JLabel lblPuzzle = new JLabel("Puzzle "+i);
			lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
			lblPuzzle.setPreferredSize(levelPreviewSize);
			lblPuzzle.setMaximumSize(levelPreviewSize);
			lblPuzzle.setMinimumSize(levelPreviewSize);
			levelsList.add(lblPuzzle);
		}
		
		for (int i=1; i<=5; i++){
			JLabel lblLightning = new JLabel("Lightning "+i);
			lblLightning.setHorizontalAlignment(SwingConstants.CENTER);
			lblLightning.setPreferredSize(levelPreviewSize);
			lblLightning.setMaximumSize(levelPreviewSize);
			lblLightning.setMinimumSize(levelPreviewSize);
			levelsList.add(lblLightning);
		}
		
		for (int i=1; i<=5; i++){
			JLabel lblRelease = new JLabel("Release "+i);
			lblRelease.setHorizontalAlignment(SwingConstants.CENTER);
			lblRelease.setPreferredSize(levelPreviewSize);
			lblRelease.setMaximumSize(levelPreviewSize);
			lblRelease.setMinimumSize(levelPreviewSize);
			levelsList.add(lblRelease);
		}
		
	}
}
