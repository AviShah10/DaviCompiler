import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DaviCompiler extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DaviCompiler frame = new DaviCompiler();
					frame.setSize(new Dimension(500,400));
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
	public DaviCompiler() {
		setDefaultCloseOperation(3);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Davi Compiler");
		lblWelcomeToThe.setFont(new Font("Cambria", Font.BOLD, 20));
		GridBagConstraints gbc_lblWelcomeToThe = new GridBagConstraints();
		gbc_lblWelcomeToThe.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcomeToThe.gridx = 0;
		gbc_lblWelcomeToThe.gridy = 0;
		contentPane.add(lblWelcomeToThe, gbc_lblWelcomeToThe);
		
		JLabel lblWelcomePleaseSelect = new JLabel("Welcome, please select one of the options below to get Mathematica code");
		GridBagConstraints gbc_lblWelcomePleaseSelect = new GridBagConstraints();
		gbc_lblWelcomePleaseSelect.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcomePleaseSelect.gridx = 0;
		gbc_lblWelcomePleaseSelect.gridy = 1;
		contentPane.add(lblWelcomePleaseSelect, gbc_lblWelcomePleaseSelect);
		
		JButton btnCalculus = new JButton("Calculus");
		btnCalculus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				CalculusSelection frame = new CalculusSelection();
				frame.setSize(new Dimension(500,400));
				frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCalculus = new GridBagConstraints();
		gbc_btnCalculus.insets = new Insets(0, 0, 5, 0);
		gbc_btnCalculus.gridx = 0;
		gbc_btnCalculus.gridy = 2;
		contentPane.add(btnCalculus, gbc_btnCalculus);
		
		JButton btnTrigonometry = new JButton("Trigonometry");
		btnTrigonometry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				TrigonometryJFrame frame = new TrigonometryJFrame();
				frame.setSize(new Dimension(500,400));
				frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnTrigonometry = new GridBagConstraints();
		gbc_btnTrigonometry.insets = new Insets(0, 0, 5, 0);
		gbc_btnTrigonometry.gridx = 0;
		gbc_btnTrigonometry.gridy = 3;
		contentPane.add(btnTrigonometry, gbc_btnTrigonometry);
		
		JButton btnConics = new JButton("Conics");
		btnConics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				ConicsJFrame line = new ConicsJFrame();
				line.setSize(new Dimension(500,400));
				line.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnConics = new GridBagConstraints();
		gbc_btnConics.insets = new Insets(0, 0, 5, 0);
		gbc_btnConics.gridx = 0;
		gbc_btnConics.gridy = 4;
		contentPane.add(btnConics, gbc_btnConics);
		
		JButton btnLines = new JButton("Lines");
		btnLines.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				LineSelection line = new LineSelection();
				line.setSize(new Dimension(500,400));
				line.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnLines = new GridBagConstraints();
		gbc_btnLines.insets = new Insets(0, 0, 5, 0);
		gbc_btnLines.gridx = 0;
		gbc_btnLines.gridy = 5;
		contentPane.add(btnLines, gbc_btnLines);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				StatisticsJFrame line = new StatisticsJFrame();
				line.setSize(new Dimension(500,400));
				line.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnStatistics = new GridBagConstraints();
		gbc_btnStatistics.insets = new Insets(0, 0, 5, 0);
		gbc_btnStatistics.gridx = 0;
		gbc_btnStatistics.gridy = 6;
		contentPane.add(btnStatistics, gbc_btnStatistics);
		
		JLabel lblCreatedByAvi = new JLabel("Created by Avi Shah and Danush Chelladurai");
		GridBagConstraints gbc_lblCreatedByAvi = new GridBagConstraints();
		gbc_lblCreatedByAvi.gridx = 0;
		gbc_lblCreatedByAvi.gridy = 8;
		contentPane.add(lblCreatedByAvi, gbc_lblCreatedByAvi);
	}

}
