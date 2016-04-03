package builderMockups;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class SelectedPieceView extends JPanel{
	GroupLayout groupLayout;
	JLabel lblSelectedPieceImage;
	
	public SelectedPieceView(){
		setPreferredSize(new Dimension(384, 224));
		
		//TODO: Comment the setIcon line to remove the image from the viewer for Mockups
		//TODO: remove lblSelectedPieceImage from the class once mockups are done
		lblSelectedPieceImage = new JLabel("");
		lblSelectedPieceImage.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/board/selectedPieceArea.png")));
		
		setupLayout();
	}

	private void setupLayout(){
		lblSelectedPieceImage.setHorizontalAlignment(SwingConstants.CENTER);
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(96)
					.addComponent(lblSelectedPieceImage)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelectedPieceImage)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
