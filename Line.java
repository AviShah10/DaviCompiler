import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.datatransfer.*;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Line extends JFrame {

	private JPanel contentPane;
	private JTextField x1;
	private JTextField y1;
	private JTextField x2;
	private JTextField y2;
	private JButton copy;
	private String code;
	private JTextField xrange;
	private JTextField yrange;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnGoBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Line frame = new Line();
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
	public Line() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblMakeALine = new JLabel("Make a Line in Mathematica");
		lblMakeALine.setForeground(new Color(0, 0, 128));
		lblMakeALine.setFont(new Font("Yu Gothic Medium", Font.BOLD, 26));
		GridBagConstraints gbc_lblMakeALine = new GridBagConstraints();
		gbc_lblMakeALine.insets = new Insets(0, 0, 5, 0);
		gbc_lblMakeALine.gridx = 0;
		gbc_lblMakeALine.gridy = 0;
		contentPane.add(lblMakeALine, gbc_lblMakeALine);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				dispose();
				LineSelection line = new LineSelection();
				line.setSize(new Dimension(500,400));
				line.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnGoBack = new GridBagConstraints();
		gbc_btnGoBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnGoBack.gridx = 0;
		gbc_btnGoBack.gridy = 1;
		contentPane.add(btnGoBack, gbc_btnGoBack);
		
		x1 = new JTextField();
		x1.setText("x1");
		GridBagConstraints gbc_x1 = new GridBagConstraints();
		gbc_x1.insets = new Insets(0, 0, 5, 0);
		gbc_x1.fill = GridBagConstraints.HORIZONTAL;
		gbc_x1.gridx = 0;
		gbc_x1.gridy = 2;
		contentPane.add(x1, gbc_x1);
		x1.setColumns(10);
		
		y1 = new JTextField();
		y1.setText("y1");
		GridBagConstraints gbc_y1 = new GridBagConstraints();
		gbc_y1.insets = new Insets(0, 0, 5, 0);
		gbc_y1.fill = GridBagConstraints.HORIZONTAL;
		gbc_y1.gridx = 0;
		gbc_y1.gridy = 3;
		contentPane.add(y1, gbc_y1);
		y1.setColumns(10);
		
		x2 = new JTextField();
		x2.setText("x2");
		GridBagConstraints gbc_x2 = new GridBagConstraints();
		gbc_x2.insets = new Insets(0, 0, 5, 0);
		gbc_x2.fill = GridBagConstraints.HORIZONTAL;
		gbc_x2.gridx = 0;
		gbc_x2.gridy = 4;
		contentPane.add(x2, gbc_x2);
		x2.setColumns(10);
		
		y2 = new JTextField();
		y2.setText("y2");
		GridBagConstraints gbc_y2 = new GridBagConstraints();
		gbc_y2.insets = new Insets(0, 0, 5, 0);
		gbc_y2.fill = GridBagConstraints.HORIZONTAL;
		gbc_y2.gridx = 0;
		gbc_y2.gridy = 5;
		contentPane.add(y2, gbc_y2);
		y2.setColumns(10);
		
		separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 6;
		contentPane.add(separator_1, gbc_separator_1);
		
		xrange = new JTextField();
		xrange.setText("x-minimum (if you are using defaults, leave this as is)");
		GridBagConstraints gbc_xrange = new GridBagConstraints();
		gbc_xrange.insets = new Insets(0, 0, 5, 0);
		gbc_xrange.fill = GridBagConstraints.HORIZONTAL;
		gbc_xrange.gridx = 0;
		gbc_xrange.gridy = 7;
		contentPane.add(xrange, gbc_xrange);
		xrange.setColumns(10);
		
		yrange = new JTextField();
		yrange.setText("x-maximum (if you are using defaults, leave this as is)");
		GridBagConstraints gbc_yrange = new GridBagConstraints();
		gbc_yrange.insets = new Insets(0, 0, 5, 0);
		gbc_yrange.fill = GridBagConstraints.HORIZONTAL;
		gbc_yrange.gridx = 0;
		gbc_yrange.gridy = 8;
		contentPane.add(yrange, gbc_yrange);
		yrange.setColumns(10);
		
		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 9;
		contentPane.add(separator, gbc_separator);
		
		JLabel lblOutput = new JLabel("Output");
		GridBagConstraints gbc_lblOutput = new GridBagConstraints();
		gbc_lblOutput.ipadx = 1;
		gbc_lblOutput.insets = new Insets(0, 0, 5, 0);
		gbc_lblOutput.gridx = 0;
		gbc_lblOutput.gridy = 11;
		contentPane.add(lblOutput, gbc_lblOutput);
		
		copy = new JButton("Copy");
		copy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StringSelection stringSelection = new StringSelection(code);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				
				copy.setText("Copied!");
			}
		});
		GridBagConstraints gbc_copy = new GridBagConstraints();
		gbc_copy.gridx = 0;
		gbc_copy.gridy = 12;
		contentPane.add(copy, gbc_copy);
		
		JButton btnCompile = new JButton("Compile");
		btnCompile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int y22 = Integer.parseInt(y2.getText());
				int y11 = Integer.parseInt(y1.getText());
				int x22 = Integer.parseInt(x2.getText());
				int x11 = Integer.parseInt(x1.getText());
				
				double slope = ((double)y22-y11)/(x22-x11);
				double yInt = (slope*x11*-1)+y11;
				
				double xRange=-10;
				double yRange=10;
				
				if(!xrange.getText().equals("x-minimum (if you are using defaults, leave this as is)")) {
					xRange=Double.parseDouble(xrange.getText());
				}
				if(!yrange.getText().equals("x-maximum (if you are using defaults, leave this as is)")) {
					yRange=Double.parseDouble(yrange.getText());
				}
				
				code= "Plot[y="+(y22-y11)+"/"+(x22-x11)+"x + "+ yInt+", {x, " + xRange + ", " + yRange + "}]";
				
				lblOutput.setText(code);
				
				StringSelection stringSelection = new StringSelection(code);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				
				
			}
		});
		GridBagConstraints gbc_btnCompile = new GridBagConstraints();
		gbc_btnCompile.insets = new Insets(0, 0, 5, 0);
		gbc_btnCompile.gridx = 0;
		gbc_btnCompile.gridy = 10;
		contentPane.add(btnCompile, gbc_btnCompile);
		
	}

}
