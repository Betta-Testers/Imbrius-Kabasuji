package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.LineBorder;

import java.awt.Color;

public class AvailableLevelView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GroupLayout layout;
	StarView starView;
	JButton btnSelectLevel;
	String lvlname;
	//AbstractLevelModel modelLevel;
	//#TODO: add to constructor
	
	public AvailableLevelView(String s) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setPreferredSize(new Dimension(148, 100));
		btnSelectLevel = new JButton("");
		btnSelectLevel.setEnabled(false);
		btnSelectLevel.setIcon(new ImageIcon(AvailableLevelView.class.getResource("/icons/LockIcon.png")));
		btnSelectLevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lvlname = s;
		starView = new StarView();
		
		setupLayout();
	}
	
	void setupLayout(){
		layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(1)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSelectLevel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(starView, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(btnSelectLevel, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(starView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		this.setLayout(layout);
	}
	
	void unlockLevel(int i){
		btnSelectLevel.setText(lvlname);
		btnSelectLevel.setIcon(null);
		btnSelectLevel.setEnabled(true);
		if(i==1){
			starView.lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
		}
		if(i==2){
			starView.lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
			starView.lblStar2.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
		}
		if(i==3){
			starView.lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
			starView.lblStar2.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
			starView.lblStar3.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
		}
	}
	
	public JButton getPlayButton(){
		return btnSelectLevel;
	}

}
