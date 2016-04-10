package view;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LevelTypeSelectView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ViewAndEditLevels viewerAndEditor;
	LevelTypesAndText levelTypesAndText;
	JButton createLevelBtn;

	/**
	 * Create the application.
	 */
	public LevelTypeSelectView() {
		super();
		viewerAndEditor = new ViewAndEditLevels();
		levelTypesAndText = new LevelTypesAndText();
		createLevelBtn = new JButton("Create Level");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		this.setResizable(false);
		this.setBounds(100, 100, 576, 688);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		
		JSplitPane levelViewerAndSelector = new JSplitPane();
		levelViewerAndSelector.setEnabled(false);
		levelViewerAndSelector.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JSplitPane levelSelectorAndCreator = new JSplitPane();
		levelSelectorAndCreator.setResizeWeight(1.0);
		levelSelectorAndCreator.setEnabled(false);
		levelSelectorAndCreator.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JPanel createBtnPanel = new JPanel();
		
		createLevelBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		createLevelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		
		GroupLayout gl_createBtnPanel = new GroupLayout(createBtnPanel);
		gl_createBtnPanel.setAutoCreateGaps(true);
		gl_createBtnPanel.setAutoCreateContainerGaps(true);
		gl_createBtnPanel.setHorizontalGroup(
			gl_createBtnPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_createBtnPanel.createSequentialGroup()
					.addGap(256)
					.addComponent(createLevelBtn)
					.addContainerGap(255, Short.MAX_VALUE))
		);
		gl_createBtnPanel.setVerticalGroup(
			gl_createBtnPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_createBtnPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(createLevelBtn)
					.addGap(10))
		);
		createBtnPanel.setLayout(gl_createBtnPanel);
		
		levelViewerAndSelector.setLeftComponent(viewerAndEditor);
		levelViewerAndSelector.setRightComponent(levelSelectorAndCreator);
		
		levelSelectorAndCreator.setLeftComponent(levelTypesAndText);
		levelSelectorAndCreator.setRightComponent(createBtnPanel);
		
		this.getContentPane().add(levelViewerAndSelector);
	}
	
	void setupLayout() {
		
	}
}


