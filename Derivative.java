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

public class Derivative extends JFrame {

	private JPanel contentPane;
	private JTextField x1;
	private JTextField y1;
	private JTextField x2;

	private JButton copy;
	private String code;
	private JButton btnGoBack;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Derivative frame = new Derivative();
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
	public Derivative() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblMakeALine = new JLabel("Derivative");
		lblMakeALine.setForeground(Color.BLACK);
		lblMakeALine.setFont(new Font("Cambria", Font.BOLD, 20));
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
				CalculusSelection line = new CalculusSelection();
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
		x1.setText("expression");
		GridBagConstraints gbc_x1 = new GridBagConstraints();
		gbc_x1.insets = new Insets(0, 0, 5, 0);
		gbc_x1.fill = GridBagConstraints.HORIZONTAL;
		gbc_x1.gridx = 0;
		gbc_x1.gridy = 2;
		contentPane.add(x1, gbc_x1);
		x1.setColumns(10);
		
		y1 = new JTextField();
		y1.setText("variable");
		GridBagConstraints gbc_y1 = new GridBagConstraints();
		gbc_y1.insets = new Insets(0, 0, 5, 0);
		gbc_y1.fill = GridBagConstraints.HORIZONTAL;
		gbc_y1.gridx = 0;
		gbc_y1.gridy = 3;
		contentPane.add(y1, gbc_y1);
		y1.setColumns(10);
		
		x2 = new JTextField();
		x2.setText("number of derivatives");
		GridBagConstraints gbc_x2 = new GridBagConstraints();
		gbc_x2.insets = new Insets(0, 0, 5, 0);
		gbc_x2.fill = GridBagConstraints.HORIZONTAL;
		gbc_x2.gridx = 0;
		gbc_x2.gridy = 4;
		contentPane.add(x2, gbc_x2);
		x2.setColumns(10);
		
		
		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 6;
		contentPane.add(separator, gbc_separator);
		
		JLabel lblOutput = new JLabel("Output");
		GridBagConstraints gbc_lblOutput = new GridBagConstraints();
		gbc_lblOutput.ipadx = 1;
		gbc_lblOutput.insets = new Insets(0, 0, 5, 0);
		gbc_lblOutput.gridx = 0;
		gbc_lblOutput.gridy = 8;
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
		gbc_copy.insets = new Insets(0, 0, 5, 0);
		gbc_copy.gridx = 0;
		gbc_copy.gridy = 9;
		contentPane.add(copy, gbc_copy);
		
		JButton btnCompile = new JButton("Compile");
		btnCompile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				code="f["+y1.getText()+"_]:="+x1.getText()+"\n\tf";
				for(int i=1; i<=Integer.parseInt(x2.getText()); i++) {
					code=code+"'";
				}
				
				code=code+"["+y1.getText()+"]";
				
				
				lblOutput.setText(code);
				
				StringSelection stringSelection = new StringSelection(code);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				
				
			}
		});
		GridBagConstraints gbc_btnCompile = new GridBagConstraints();
		gbc_btnCompile.insets = new Insets(0, 0, 5, 0);
		gbc_btnCompile.gridx = 0;
		gbc_btnCompile.gridy = 7;
		contentPane.add(btnCompile, gbc_btnCompile);
		
	}

}

