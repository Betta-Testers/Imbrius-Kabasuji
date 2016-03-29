package builderMockups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.Group;
import javax.swing.GroupLayout.ParallelGroup;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.Component;

public class BuilderWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					BuilderWindow frame = new BuilderWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuilderWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1812, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelContentArea = new JPanel();
		panelContentArea.setBackground(Color.WHITE);

		JPanel panelButtonGroup = new JPanel();

		JPanel panelTileCreation = new JPanel();

		JPanel panelLevelProperties = new JPanel();

		JScrollPane scrollpaneBullpen = new JScrollPane();
		scrollpaneBullpen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollpaneBullpen.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		// ==================== THE BULLPEN - Declarations ==================== //
		JPanel panelScrollContainer = new JPanel();
		panelScrollContainer.setBackground(Color.WHITE);
		scrollpaneBullpen.setViewportView(panelScrollContainer);

		
		/*
		gl_panelHex2.setHorizontalGroup(
				gl_panelHex2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHex2.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex2)
								.addComponent(btnHex2, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex2.setVerticalGroup(
				gl_panelHex2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex2.createSequentialGroup()
						.addComponent(btnHex2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex2.setLayout(gl_panelHex2);



		gl_panelHex3.setHorizontalGroup(
				gl_panelHex3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex3.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex3.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex3)
								.addComponent(btnHex3, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex3.setVerticalGroup(
				gl_panelHex3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex3.createSequentialGroup()
						.addComponent(btnHex3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex3.setLayout(gl_panelHex3);

		gl_panelHex4.setHorizontalGroup(
				gl_panelHex4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex4.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex4.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex4)
								.addComponent(btnHex4, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex4.setVerticalGroup(
				gl_panelHex4.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex4.createSequentialGroup()
						.addComponent(btnHex4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex4.setLayout(gl_panelHex4);

		gl_panelHex4.setHorizontalGroup(
				gl_panelHex4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex4.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex4.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex4)
								.addComponent(btnHex4, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex4.setVerticalGroup(
				gl_panelHex4.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex4.createSequentialGroup()
						.addComponent(btnHex4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex4.setLayout(gl_panelHex4);

		gl_panelHex5.setHorizontalGroup(
				gl_panelHex5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex5.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex5.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex5)
								.addComponent(btnHex5, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex5.setVerticalGroup(
				gl_panelHex5.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex5.createSequentialGroup()
						.addComponent(btnHex5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex5.setLayout(gl_panelHex5);

		gl_panelHex6.setHorizontalGroup(
				gl_panelHex6.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex6.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex6.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex6)
								.addComponent(btnHex6, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex6.setVerticalGroup(
				gl_panelHex6.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex6.createSequentialGroup()
						.addComponent(btnHex6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex6.setLayout(gl_panelHex6);

		gl_panelHex7.setHorizontalGroup(
				gl_panelHex7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex7.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex7.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex7)
								.addComponent(btnHex7, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex7.setVerticalGroup(
				gl_panelHex7.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex7.createSequentialGroup()
						.addComponent(btnHex7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex7.setLayout(gl_panelHex7);

		gl_panelHex8.setHorizontalGroup(
				gl_panelHex8.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex8.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex8.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex8)
								.addComponent(btnHex8, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex8.setVerticalGroup(
				gl_panelHex8.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex8.createSequentialGroup()
						.addComponent(btnHex8, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex8.setLayout(gl_panelHex8);

		gl_panelHex9.setHorizontalGroup(
				gl_panelHex9.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex9.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex9.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex9)
								.addComponent(btnHex9, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex9.setVerticalGroup(
				gl_panelHex9.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex9.createSequentialGroup()
						.addComponent(btnHex9, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex9.setLayout(gl_panelHex9);

		gl_panelHex10.setHorizontalGroup(
				gl_panelHex10.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex10.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex10.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex10)
								.addComponent(btnHex10, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex10.setVerticalGroup(
				gl_panelHex10.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex10.createSequentialGroup()
						.addComponent(btnHex10, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex10.setLayout(gl_panelHex10);

		gl_panelHex11.setHorizontalGroup(
				gl_panelHex11.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex11.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex11.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex11)
								.addComponent(btnHex11, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex11.setVerticalGroup(
				gl_panelHex11.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex11.createSequentialGroup()
						.addComponent(btnHex11, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex11.setLayout(gl_panelHex11);

		gl_panelHex12.setHorizontalGroup(
				gl_panelHex12.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex12.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex12.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex12)
								.addComponent(btnHex12, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex12.setVerticalGroup(
				gl_panelHex12.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex12.createSequentialGroup()
						.addComponent(btnHex12, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex12.setLayout(gl_panelHex12);

		gl_panelHex13.setHorizontalGroup(
				gl_panelHex13.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex13.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex13.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex13)
								.addComponent(btnHex13, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex13.setVerticalGroup(
				gl_panelHex13.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex13.createSequentialGroup()
						.addComponent(btnHex13, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex13.setLayout(gl_panelHex13);

		gl_panelHex14.setHorizontalGroup(
				gl_panelHex14.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex14.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex14.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex14)
								.addComponent(btnHex14, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex14.setVerticalGroup(
				gl_panelHex14.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex14.createSequentialGroup()
						.addComponent(btnHex14, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex14.setLayout(gl_panelHex14);

		gl_panelHex15.setHorizontalGroup(
				gl_panelHex15.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex15.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex15.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex15)
								.addComponent(btnHex15, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex15.setVerticalGroup(
				gl_panelHex15.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex15.createSequentialGroup()
						.addComponent(btnHex15, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex15.setLayout(gl_panelHex15);

		gl_panelHex16.setHorizontalGroup(
				gl_panelHex16.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex16.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex16.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex16)
								.addComponent(btnHex16, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex16.setVerticalGroup(
				gl_panelHex16.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex16.createSequentialGroup()
						.addComponent(btnHex16, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex16.setLayout(gl_panelHex16);

		gl_panelHex17.setHorizontalGroup(
				gl_panelHex17.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex17.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex17.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex17)
								.addComponent(btnHex17, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex17.setVerticalGroup(
				gl_panelHex17.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex17.createSequentialGroup()
						.addComponent(btnHex17, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex17.setLayout(gl_panelHex17);

		gl_panelHex18.setHorizontalGroup(
				gl_panelHex18.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex18.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex18.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex18)
								.addComponent(btnHex18, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex18.setVerticalGroup(
				gl_panelHex18.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex18.createSequentialGroup()
						.addComponent(btnHex18, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex18.setLayout(gl_panelHex18);

		gl_panelHex19.setHorizontalGroup(
				gl_panelHex19.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex19.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex19.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex19)
								.addComponent(btnHex19, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex19.setVerticalGroup(
				gl_panelHex19.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex19.createSequentialGroup()
						.addComponent(btnHex19, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex19.setLayout(gl_panelHex19);

		gl_panelHex20.setHorizontalGroup(
				gl_panelHex20.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex20.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex20.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex20)
								.addComponent(btnHex20, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex20.setVerticalGroup(
				gl_panelHex20.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex20.createSequentialGroup()
						.addComponent(btnHex20, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex20.setLayout(gl_panelHex20);

		gl_panelHex21.setHorizontalGroup(
				gl_panelHex21.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex21.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex21.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex21)
								.addComponent(btnHex21, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex21.setVerticalGroup(
				gl_panelHex21.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex21.createSequentialGroup()
						.addComponent(btnHex21, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex21.setLayout(gl_panelHex21);

		gl_panelHex22.setHorizontalGroup(
				gl_panelHex22.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex22.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex22.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex22)
								.addComponent(btnHex22, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex22.setVerticalGroup(
				gl_panelHex22.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex22.createSequentialGroup()
						.addComponent(btnHex22, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex22.setLayout(gl_panelHex22);

		gl_panelHex23.setHorizontalGroup(
				gl_panelHex23.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex23.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex23.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex23)
								.addComponent(btnHex23, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex23.setVerticalGroup(
				gl_panelHex23.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex23.createSequentialGroup()
						.addComponent(btnHex23, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex23, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex23.setLayout(gl_panelHex23);

		gl_panelHex24.setHorizontalGroup(
				gl_panelHex24.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex24.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex24.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex24)
								.addComponent(btnHex24, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex24.setVerticalGroup(
				gl_panelHex24.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex24.createSequentialGroup()
						.addComponent(btnHex24, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex24.setLayout(gl_panelHex24);

		gl_panelHex25.setHorizontalGroup(
				gl_panelHex25.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex25.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex25.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex25)
								.addComponent(btnHex25, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex25.setVerticalGroup(
				gl_panelHex25.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex25.createSequentialGroup()
						.addComponent(btnHex25, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex25.setLayout(gl_panelHex25);

		gl_panelHex26.setHorizontalGroup(
				gl_panelHex26.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex26.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex26.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex26)
								.addComponent(btnHex26, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex26.setVerticalGroup(
				gl_panelHex26.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex26.createSequentialGroup()
						.addComponent(btnHex26, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex26, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex26.setLayout(gl_panelHex26);

		gl_panelHex27.setHorizontalGroup(
				gl_panelHex27.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex27.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex27.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex27)
								.addComponent(btnHex27, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex27.setVerticalGroup(
				gl_panelHex27.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex27.createSequentialGroup()
						.addComponent(btnHex27, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex27.setLayout(gl_panelHex27);

		gl_panelHex28.setHorizontalGroup(
				gl_panelHex28.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex28.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex28.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex28)
								.addComponent(btnHex28, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex28.setVerticalGroup(
				gl_panelHex28.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex28.createSequentialGroup()
						.addComponent(btnHex28, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex28, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex28.setLayout(gl_panelHex28);

		gl_panelHex29.setHorizontalGroup(
				gl_panelHex29.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex29.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex29.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex29)
								.addComponent(btnHex29, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex29.setVerticalGroup(
				gl_panelHex29.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex29.createSequentialGroup()
						.addComponent(btnHex29, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex29.setLayout(gl_panelHex29);

		gl_panelHex30.setHorizontalGroup(
				gl_panelHex30.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex30.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex30.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex30)
								.addComponent(btnHex30, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex30.setVerticalGroup(
				gl_panelHex30.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex30.createSequentialGroup()
						.addComponent(btnHex30, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex30, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex30.setLayout(gl_panelHex30);

		gl_panelHex31.setHorizontalGroup(
				gl_panelHex31.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex31.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex31.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex31)
								.addComponent(btnHex31, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex31.setVerticalGroup(
				gl_panelHex31.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex31.createSequentialGroup()
						.addComponent(btnHex31, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex31, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex31.setLayout(gl_panelHex31);

		gl_panelHex32.setHorizontalGroup(
				gl_panelHex32.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex32.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex32.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex32)
								.addComponent(btnHex32, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex32.setVerticalGroup(
				gl_panelHex32.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex32.createSequentialGroup()
						.addComponent(btnHex32, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex32, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex32.setLayout(gl_panelHex32);

		gl_panelHex33.setHorizontalGroup(
				gl_panelHex33.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex33.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex33.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex33)
								.addComponent(btnHex33, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex33.setVerticalGroup(
				gl_panelHex33.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex33.createSequentialGroup()
						.addComponent(btnHex33, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex33, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex33.setLayout(gl_panelHex33);

		gl_panelHex34.setHorizontalGroup(
				gl_panelHex34.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex34.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex34.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex34)
								.addComponent(btnHex34, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex34.setVerticalGroup(
				gl_panelHex34.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex34.createSequentialGroup()
						.addComponent(btnHex34, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex34, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex34.setLayout(gl_panelHex34);

		gl_panelHex35.setHorizontalGroup(
				gl_panelHex35.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex35.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panelHex35.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinHex35)
								.addComponent(btnHex35, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
				);
		gl_panelHex35.setVerticalGroup(
				gl_panelHex35.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex35.createSequentialGroup()
						.addComponent(btnHex35, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(spinHex35, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		panelHex35.setLayout(gl_panelHex35);
*/
		// ==================== SCROLL CONTAINER SETTINGS ==================== //
		GroupLayout gl_panelScrollContainer = new GroupLayout(panelScrollContainer);
		
			ParallelGroup pargroup = gl_panelScrollContainer.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelScrollContainer.createParallelGroup(Alignment.LEADING));
			ParallelGroup pargroup2 = gl_panelScrollContainer.createParallelGroup(Alignment.LEADING).addGroup(gl_panelScrollContainer.createSequentialGroup());
		
		
						for(int i = 1; i <= 35; i++){
							JPanel panelHex1 = new JPanel();
							JSpinner spinHex1 = new JSpinner();
							JButton btnHex1 = new JButton(""); 
							/*btnHex1.setIcon(new ImageIcon(new ImageIcon(BuilderWindow.class.getResource("/pieces/1.png"))
									.getImage().getScaledInstance(30, 30,java.awt.Image.SCALE_SMOOTH)));*/
							btnHex1.setIcon(new ImageIcon(BuilderWindow.class.getResource("/pieces/"+i+".png")));
							GroupLayout gl_panelHex1 = new GroupLayout(panelHex1);
							gl_panelHex1.setHorizontalGroup(
								gl_panelHex1.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelHex1.createSequentialGroup()
										.addComponent(spinHex1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnHex1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							);
							gl_panelHex1.setVerticalGroup(
								gl_panelHex1.createParallelGroup(Alignment.LEADING)
									.addComponent(btnHex1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addComponent(spinHex1, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
							);
							panelHex1.setLayout(gl_panelHex1);
							pargroup.addComponent(panelHex1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
							pargroup2.addComponent(panelHex1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE);
						}
	
					
						gl_panelScrollContainer.setHorizontalGroup(pargroup);
						gl_panelScrollContainer.setVerticalGroup(pargroup2);
		
		
		panelScrollContainer.setLayout(gl_panelScrollContainer);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelLevelProperties, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelTileCreation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelButtonGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollpaneBullpen, GroupLayout.PREFERRED_SIZE, 1240, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelContentArea, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panelLevelProperties, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelTileCreation, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelButtonGroup, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
							.addGap(75)
							.addComponent(scrollpaneBullpen, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelContentArea, GroupLayout.PREFERRED_SIZE, 688, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);

		JLabel lblLevelProperties = new JLabel("Level Properties");
		lblLevelProperties.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblTileCount = new JLabel("Tile Count:");
		lblTileCount.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTuleCountVar = new JLabel("5");

		JLabel lblSetMoves = new JLabel("Set Moves:");
		lblSetMoves.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblSetTime = new JLabel("Set Time:");
		lblSetTime.setHorizontalAlignment(SwingConstants.RIGHT);

		JSpinner spinMoves = new JSpinner();
		spinMoves.setModel(new SpinnerNumberModel(1, 1, 100, 1));

		JSpinner spinTime = new JSpinner();
		spinTime.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		GroupLayout gl_panelLevelProperties = new GroupLayout(panelLevelProperties);
		gl_panelLevelProperties.setHorizontalGroup(
				gl_panelLevelProperties.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLevelProperties.createSequentialGroup()
						.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.LEADING, false)
										.addGroup(Alignment.TRAILING, gl_panelLevelProperties.createSequentialGroup()
												.addComponent(lblTileCount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(4)
												.addComponent(lblTuleCountVar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelLevelProperties.createSequentialGroup()
												.addGap(2)
												.addComponent(lblLevelProperties)))
								.addGroup(Alignment.TRAILING, gl_panelLevelProperties.createSequentialGroup()
										.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblSetTime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblSetMoves, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
										.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.LEADING, false)
												.addComponent(spinTime)
												.addComponent(spinMoves))))
						.addContainerGap())
				);
		gl_panelLevelProperties.setVerticalGroup(
				gl_panelLevelProperties.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLevelProperties.createSequentialGroup()
						.addGap(5)
						.addComponent(lblLevelProperties)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTileCount)
								.addComponent(lblTuleCountVar))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSetMoves)
								.addComponent(spinMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSetTime)
								.addComponent(spinTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(27, Short.MAX_VALUE))
				);
		panelLevelProperties.setLayout(gl_panelLevelProperties);

		JLabel lblNewLabel = new JLabel("Tile Creation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

		JButton btn1 = new JButton("1");
		btn1.setForeground(Color.BLACK);
		btn1.setBackground(Color.BLUE);


		JButton btn2 = new JButton("2");
		btn2.setForeground(Color.BLACK);
		btn2.setBackground(Color.BLUE);

		JButton btn3 = new JButton("3");
		btn3.setForeground(Color.BLACK);
		btn3.setBackground(Color.BLUE);

		JButton btn4 = new JButton("4");
		btn4.setForeground(Color.BLACK);
		btn4.setBackground(Color.BLUE);

		JButton btn5 = new JButton("5");
		btn5.setForeground(Color.BLACK);
		btn5.setBackground(Color.BLUE);

		JButton btn6 = new JButton("6");
		btn6.setForeground(Color.BLACK);
		btn6.setBackground(Color.BLUE);

		JLabel lblColor = new JLabel("Color:");

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Blue", "Yellow", "Red"}));
		GroupLayout gl_panelTileCreation = new GroupLayout(panelTileCreation);
		gl_panelTileCreation.setHorizontalGroup(
				gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTileCreation.createSequentialGroup()
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblNewLabel))
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addGap(8)
										.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelTileCreation.createSequentialGroup()
														.addComponent(btn5)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btn6))
												.addGroup(gl_panelTileCreation.createSequentialGroup()
														.addComponent(btn3)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btn4))
												.addGroup(gl_panelTileCreation.createSequentialGroup()
														.addComponent(btn1)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btn2))))
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addGap(8)
										.addComponent(lblColor)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_panelTileCreation.setVerticalGroup(
				gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTileCreation.createSequentialGroup()
						.addGap(5)
						.addComponent(lblNewLabel)
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btn1))
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addGap(6)
										.addComponent(btn2)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn3)
								.addComponent(btn4))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn5)
								.addComponent(btn6))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblColor)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		panelTileCreation.setLayout(gl_panelTileCreation);

		JButton btnRemovePieces = new JButton("Remove Pieces");

		btnRemovePieces.setToolTipText("Remove all pieces on the board");

		JToggleButton btnConvertHint = new JToggleButton("Convert to Hint");

		btnConvertHint.setToolTipText("Pieces on board are turned into a hint");

		JButton btnSave = new JButton("Save");
		btnSave.setToolTipText("Save Level");

		JButton btnUndo = new JButton("");
		btnUndo.setToolTipText("Undo");

		btnUndo.setIcon(new ImageIcon(BuilderWindow.class.getResource("/icons/Undo.png")));

		JButton btnRedo = new JButton("");
		btnRedo.setToolTipText("Redo");
		btnRedo.setIcon(new ImageIcon(BuilderWindow.class.getResource("/icons/Redo.png")));
		GroupLayout gl_panelButtonGroup = new GroupLayout(panelButtonGroup);
		gl_panelButtonGroup.setHorizontalGroup(
				gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
				.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnConvertHint)
				.addGroup(gl_panelButtonGroup.createSequentialGroup()
						.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
						.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				);
		gl_panelButtonGroup.setVerticalGroup(
				gl_panelButtonGroup.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelButtonGroup.createSequentialGroup()
						.addGroup(gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
								.addComponent(btnUndo)
								.addComponent(btnRedo))
						.addGap(12)
						.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				);
		gl_panelButtonGroup.linkSize(SwingConstants.VERTICAL, new Component[] {btnRemovePieces, btnConvertHint, btnSave});
		gl_panelButtonGroup.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnRemovePieces, btnConvertHint, btnSave});
		panelButtonGroup.setLayout(gl_panelButtonGroup);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		GroupLayout gl_panelContentArea = new GroupLayout(panelContentArea);
		gl_panelContentArea.setHorizontalGroup(
				gl_panelContentArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContentArea.createSequentialGroup()
						.addGroup(gl_panelContentArea.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
						.addGap(0))
				);
		gl_panelContentArea.setVerticalGroup(
				gl_panelContentArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContentArea.createSequentialGroup()
						.addGap(82)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
				);
		panelContentArea.setLayout(gl_panelContentArea);
		contentPane.setLayout(gl_contentPane);
	}
}
