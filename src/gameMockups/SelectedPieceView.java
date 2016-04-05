package gameMockups;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SelectedPieceView extends JPanel{
	GroupLayout groupLayout;
	JLabel lblSelectedPieceImage;
	JButton btnRotateLeft;
	JButton btnRotateRight;
	JButton btnFlipX;
	JButton btnFlipY;
	
	public SelectedPieceView(ImageIcon image){
		setPreferredSize(new Dimension(384, 224));
		
		btnRotateLeft = new JButton("");
		btnRotateLeft.setToolTipText("Rotate Left");
		btnRotateRight = new JButton("");
		btnRotateRight.setToolTipText("Rotate Right");
		btnFlipX = new JButton("");
		btnFlipX.setToolTipText("Flip X");
		btnFlipY = new JButton("");
		btnFlipY.setToolTipText("Flip Y");
		
		
		//TODO: Comment the setIcon line to remove the image from the viewer for Mockups
		//TODO: remove lblSelectedPieceImage from the class once mockups are done
		//TODO: remove constructor argument
		lblSelectedPieceImage = new JLabel("");
		lblSelectedPieceImage.setIcon(image);
		
		
		setupLayout();
	}

	private void setupLayout(){
		lblSelectedPieceImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnRotateLeft.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/icons/RotateLeft.png")));
		btnRotateRight.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/icons/RotateRight.png")));
		btnFlipX.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/icons/FlipX.png")));
		btnFlipY.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/icons/FlipY.png")));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/board/selectedPieceArea.png")));
		
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(88, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSelectedPieceImage)
							.addGap(9))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnFlipX, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnFlipY, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnRotateLeft, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRotateRight, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnRotateLeft)
								.addComponent(btnRotateRight))
							.addPreferredGap(ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnFlipX)
								.addComponent(btnFlipY)))
						.addComponent(lblSelectedPieceImage))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
