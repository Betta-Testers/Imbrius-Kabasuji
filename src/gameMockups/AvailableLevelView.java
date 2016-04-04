package gameMockups;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JToggleButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class AvailableLevelView extends JFrame {

	public AvailableLevelView() {
		JPanel lvl1Panel = new JPanel();
		
		JToggleButton lvl1Toggle = new JToggleButton("Level 1");
		
		JLabel lvl1Stars = new JLabel("");
		lvl1Stars.setIcon(new ImageIcon("C:\\Users\\Brendan\\Desktop\\Star image2.png"));
		GroupLayout gl_lvl1Panel = new GroupLayout(lvl1Panel);
		gl_lvl1Panel.setHorizontalGroup(
			gl_lvl1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lvl1Panel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_lvl1Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lvl1Stars)
						.addComponent(lvl1Toggle))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_lvl1Panel.setVerticalGroup(
			gl_lvl1Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_lvl1Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lvl1Toggle)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lvl1Stars)
					.addContainerGap())
		);
		lvl1Panel.setLayout(gl_lvl1Panel);
	}

}
