package builderMockups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.Dimension;

import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.Color;

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
		
		Dimension levelPreviewSize = new Dimension(96, 96);
		
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
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		levelSelectorAndCreator.setLeftComponent(splitPane);
		
		final JTextArea txtrTextAboutLevel = new JTextArea();
		txtrTextAboutLevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txtrTextAboutLevel.setText("Puzzle");
		splitPane.setRightComponent(txtrTextAboutLevel);
		
		ButtonGroup levelTypeGroup = new ButtonGroup();
		
		JToggleButton tglbtnPuzzle = new JToggleButton("");
		tglbtnPuzzle.setBackground(Color.WHITE);
		tglbtnPuzzle.setSelected(true);
		tglbtnPuzzle.setIcon(new ImageIcon(SelectionScreen.class.getResource("/icons/Puzzle.png")));
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
		tglbtnLightning.setBackground(Color.WHITE);
		tglbtnLightning.setIcon(new ImageIcon(SelectionScreen.class.getResource("/icons/Lightning.png")));
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
		tglbtnRelease.setBackground(Color.WHITE);
		tglbtnRelease.setIcon(new ImageIcon(SelectionScreen.class.getResource("/icons/Release.png")));
		levelTypeGroup.add(tglbtnRelease);
		tglbtnRelease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JToggleButton tBtn = (JToggleButton)arg0.getSource();
	            if (tBtn.isSelected()) {
	            	txtrTextAboutLevel.setText("Release");
	            }
			}
		});
		
		JPanel levelTypesPanel = new JPanel();
		splitPane.setLeftComponent(levelTypesPanel);
		GroupLayout gl_levelTypesPanel = new GroupLayout(levelTypesPanel);
		gl_levelTypesPanel.setAutoCreateGaps(true);
		gl_levelTypesPanel.setAutoCreateContainerGaps(true);
		gl_levelTypesPanel.setHorizontalGroup(
			gl_levelTypesPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_levelTypesPanel.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(tglbtnPuzzle)
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(tglbtnLightning)
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(tglbtnRelease)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_levelTypesPanel.setVerticalGroup(
			gl_levelTypesPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_levelTypesPanel.createSequentialGroup()
						.addContainerGap(5, Short.MAX_VALUE)
						.addGroup(gl_levelTypesPanel.createParallelGroup()
							.addComponent(tglbtnPuzzle)
							.addComponent(tglbtnLightning)
							.addComponent(tglbtnRelease))
						.addContainerGap(5, Short.MAX_VALUE))
		);
		levelTypesPanel.setLayout(gl_levelTypesPanel);
		
		
		
		JScrollPane levelViewer = new JScrollPane();
		levelViewer.setEnabled(false);
		levelViewer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		levelViewerAndSelector.setLeftComponent(levelViewer);
		
		JPanel levelsList = new JPanel();
		levelViewer.setViewportView(levelsList);
		
		for (int i=1; i<=5; i++){
			JLabel lblPuzzle = new JLabel("Puzzle "+i);
			lblPuzzle.setIcon(new ImageIcon(SelectionScreen.class.getResource("/icons/PuzzleSm.png")));
			lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
			lblPuzzle.setHorizontalTextPosition(SwingConstants.CENTER);
			lblPuzzle.setVerticalTextPosition(SwingConstants.BOTTOM);
			lblPuzzle.setPreferredSize(levelPreviewSize);
			lblPuzzle.setMaximumSize(levelPreviewSize);
			lblPuzzle.setMinimumSize(levelPreviewSize);
			lblPuzzle.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			levelsList.add(lblPuzzle);
		}
		
		for (int i=1; i<=5; i++){
			JLabel lblLightning = new JLabel("Lightning "+i);
			lblLightning.setIcon(new ImageIcon(SelectionScreen.class.getResource("/icons/LightningSm.png")));
			lblLightning.setHorizontalAlignment(SwingConstants.CENTER);
			lblLightning.setHorizontalTextPosition(SwingConstants.CENTER);
			lblLightning.setVerticalTextPosition(SwingConstants.BOTTOM);
			lblLightning.setPreferredSize(levelPreviewSize);
			lblLightning.setMaximumSize(levelPreviewSize);
			lblLightning.setMinimumSize(levelPreviewSize);
			lblLightning.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			levelsList.add(lblLightning);
		}
		
		for (int i=1; i<=5; i++){
			JLabel lblRelease = new JLabel("Release "+i);
			lblRelease.setIcon(new ImageIcon(SelectionScreen.class.getResource("/icons/ReleaseSm.png")));
			lblRelease.setHorizontalAlignment(SwingConstants.CENTER);
			lblRelease.setHorizontalTextPosition(SwingConstants.CENTER);
			lblRelease.setVerticalTextPosition(SwingConstants.BOTTOM);
			lblRelease.setPreferredSize(levelPreviewSize);
			lblRelease.setMaximumSize(levelPreviewSize);
			lblRelease.setMinimumSize(levelPreviewSize);
			lblRelease.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			levelsList.add(lblRelease);
		}
		
	}
}


