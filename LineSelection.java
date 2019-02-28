import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LineSelection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LineSelection frame = new LineSelection();
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
	public LineSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 19, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSelectTheType = new JLabel("Select The Type of Line");
		lblSelectTheType.setFont(new Font("Cambria", Font.BOLD, 20));
		GridBagConstraints gbc_lblSelectTheType = new GridBagConstraints();
		gbc_lblSelectTheType.insets = new Insets(0, 0, 5, 0);
		gbc_lblSelectTheType.gridx = 0;
		gbc_lblSelectTheType.gridy = 0;
		contentPane.add(lblSelectTheType, gbc_lblSelectTheType);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.anchor = GridBagConstraints.SOUTH;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		contentPane.add(separator, gbc_separator);
		
		JButton twoPt = new JButton("Two-Point Line");
		twoPt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				dispose();
				Line line = new Line();
				line.setSize(new Dimension(500,400));
				line.setVisible(true);
			}
		});
		
		JButton stdForm = new JButton("Standard Form Line");
		stdForm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				dispose();
				StandardForm line = new StandardForm();
				line.setSize(new Dimension(500,400));
				line.setVisible(true);
			}
		});
		
		
		GridBagConstraints gbc_twoPt = new GridBagConstraints();
		gbc_twoPt.insets = new Insets(0, 0, 5, 0);
		gbc_twoPt.gridx = 0;
		gbc_twoPt.gridy = 2;
		contentPane.add(twoPt, gbc_twoPt);
		
		
		GridBagConstraints gbc_stdForm = new GridBagConstraints();
		gbc_stdForm.insets = new Insets(0, 0, 5, 0);
		gbc_stdForm.gridx = 0;
		gbc_stdForm.gridy = 3;
		contentPane.add(stdForm, gbc_stdForm);
		
		JButton ptSlope = new JButton("Point-Slope Line");
		ptSlope.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				dispose();
				PointSlope line = new PointSlope();
				line.setSize(new Dimension(500,400));
				line.setVisible(true);
			}
		});
		GridBagConstraints gbc_ptSlope = new GridBagConstraints();
		gbc_ptSlope.insets = new Insets(0, 0, 5, 0);
		gbc_ptSlope.gridx = 0;
		gbc_ptSlope.gridy = 4;
		contentPane.add(ptSlope, gbc_ptSlope);
		
		JButton btnSlopeInterceptLine = new JButton("Slope Intercept Line");
		btnSlopeInterceptLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				dispose();
				SlopeInterceptLine line = new SlopeInterceptLine();
				line.setSize(new Dimension(500,400));
				line.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnSlopeInterceptLine = new GridBagConstraints();
		gbc_btnSlopeInterceptLine.insets = new Insets(0, 0, 5, 0);
		gbc_btnSlopeInterceptLine.gridx = 0;
		gbc_btnSlopeInterceptLine.gridy = 5;
		contentPane.add(btnSlopeInterceptLine, gbc_btnSlopeInterceptLine);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				DaviCompiler line = new DaviCompiler();
				line.setSize(new Dimension(500,400));
				line.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnGoBack = new GridBagConstraints();
		gbc_btnGoBack.gridx = 0;
		gbc_btnGoBack.gridy = 7;
		contentPane.add(btnGoBack, gbc_btnGoBack);
		
		
	}

}
