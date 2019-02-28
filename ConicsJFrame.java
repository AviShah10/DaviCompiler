import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConicsJFrame extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConicsJFrame frame = new ConicsJFrame();
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
	public ConicsJFrame() {
		getContentPane().setFont(new Font("Cambria", Font.PLAIN, 11));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 17, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblSelectTheType = new JLabel("Select The Type Of Conic");
		lblSelectTheType.setFont(new Font("Cambria", Font.BOLD, 20));
		GridBagConstraints gbc_lblSelectTheType = new GridBagConstraints();
		gbc_lblSelectTheType.insets = new Insets(0, 0, 5, 0);
		gbc_lblSelectTheType.gridx = 0;
		gbc_lblSelectTheType.gridy = 0;
		getContentPane().add(lblSelectTheType, gbc_lblSelectTheType);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.VERTICAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		getContentPane().add(separator, gbc_separator);
		
		JButton btnParabola = new JButton("Parabola");
		btnParabola.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				ParabolaJFrame parabola = new ParabolaJFrame();
				parabola.setVisible(true);
			}
		});
		btnParabola.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_btnParabola = new GridBagConstraints();
		gbc_btnParabola.insets = new Insets(0, 0, 5, 0);
		gbc_btnParabola.gridx = 0;
		gbc_btnParabola.gridy = 2;
		getContentPane().add(btnParabola, gbc_btnParabola);
		
		JButton btnHyperbola = new JButton("Hyperbola");
		btnHyperbola.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				HyperbolaJFrame hyperbola = new HyperbolaJFrame();
				hyperbola.setSize(new Dimension(500,400));
				hyperbola.setVisible(true);
			}
		});
		btnHyperbola.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_btnHyperbola = new GridBagConstraints();
		gbc_btnHyperbola.insets = new Insets(0, 0, 5, 0);
		gbc_btnHyperbola.gridx = 0;
		gbc_btnHyperbola.gridy = 3;
		getContentPane().add(btnHyperbola, gbc_btnHyperbola);
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				CircleJFrame line = new CircleJFrame();
				line.setSize(new Dimension(500,400));
				line.setVisible(true);
			}
		});
		btnCircle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_btnCircle = new GridBagConstraints();
		gbc_btnCircle.insets = new Insets(0, 0, 5, 0);
		gbc_btnCircle.gridx = 0;
		gbc_btnCircle.gridy = 4;
		getContentPane().add(btnCircle, gbc_btnCircle);
		
		JButton btnEllipse = new JButton("Ellipse");
		btnEllipse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				EllipseJFrame ellipse = new EllipseJFrame();
				ellipse.setSize(new Dimension(500,400));
				ellipse.setVisible(true);
			}
		});
		btnEllipse.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_btnEllipse = new GridBagConstraints();
		gbc_btnEllipse.insets = new Insets(0, 0, 5, 0);
		gbc_btnEllipse.gridx = 0;
		gbc_btnEllipse.gridy = 5;
		getContentPane().add(btnEllipse, gbc_btnEllipse);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				DaviCompiler frame = new DaviCompiler();
				frame.setSize(new Dimension(500,400));
				frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnGoBack = new GridBagConstraints();
		gbc_btnGoBack.gridx = 0;
		gbc_btnGoBack.gridy = 8;
		getContentPane().add(btnGoBack, gbc_btnGoBack);
	}

}
