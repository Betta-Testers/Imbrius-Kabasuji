package leveltypeslector;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import levelbuilder.BuilderWindow;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.Dimension;

import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class SelectionScreen {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		
		Dimension levelPreviewSize = new Dimension(96, 72);
		
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
		
		JPanel createBtnPanel = new JPanel();
		levelSelectorAndCreator.setRightComponent(createBtnPanel);
				
		JButton btnCreateLevel = new JButton("Create Level");
		btnCreateLevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
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
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.65);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		levelSelectorAndCreator.setLeftComponent(splitPane);
		
		final JTextArea txtrTextAboutLevel = new JTextArea();
		txtrTextAboutLevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txtrTextAboutLevel.setText("Puzzle");
		splitPane.setRightComponent(txtrTextAboutLevel);
		
		JPanel levelTypesPanel = new JPanel();
		splitPane.setLeftComponent(levelTypesPanel);
		levelTypesPanel.setLayout(new GridLayout(1, 3, 5, 5));
		
		ButtonGroup levelTypeGroup = new ButtonGroup();
		
		JToggleButton tglbtnPuzzle = new JToggleButton("");
		tglbtnPuzzle.setSelected(true);
		tglbtnPuzzle.setIcon(new ImageIcon(SelectionScreen.class.getResource("/Icons/Puzzle.png")));
		levelTypesPanel.add(tglbtnPuzzle);
		levelTypeGroup.add(tglbtnPuzzle);
		tglbtnPuzzle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JToggleButton tBtn = (JToggleButton)arg0.getSource();
	            if (tBtn.isSelected()) {
	            	txtrTextAboutLevel.setText("Puzzle");
	            }
			}
		});
		
		JToggleButton tglbtnLightning = new JToggleButton("");
		tglbtnLightning.setIcon(new ImageIcon(SelectionScreen.class.getResource("/Icons/Lightning.png")));
		levelTypesPanel.add(tglbtnLightning);
		levelTypeGroup.add(tglbtnLightning);
		tglbtnLightning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JToggleButton tBtn = (JToggleButton)arg0.getSource();
	            if (tBtn.isSelected()) {
	            	txtrTextAboutLevel.setText("Lightning");
	            }
			}
		});
		
		JToggleButton tglbtnRelease = new JToggleButton("");
		tglbtnRelease.setIcon(new ImageIcon(SelectionScreen.class.getResource("/Icons/Release.png")));
		levelTypesPanel.add(tglbtnRelease);
		levelTypeGroup.add(tglbtnRelease);
		tglbtnRelease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JToggleButton tBtn = (JToggleButton)arg0.getSource();
	            if (tBtn.isSelected()) {
	            	txtrTextAboutLevel.setText("Release");
	            }
			}
		});
		
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
