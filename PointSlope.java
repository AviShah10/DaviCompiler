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
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

public class PointSlope extends JFrame {

	private JPanel contentPane;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JButton btnCompile;
	private JLabel lblOutput;
	private JButton btnCopy;
	private JTextField xrange;
	private JTextField yrange;
	private String code;
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
					PointSlope frame = new PointSlope();
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
	public PointSlope() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblMakeALine = new JLabel("Make a Line in Mathematica");
		lblMakeALine.setFont(new Font("Cambria", Font.BOLD, 20));
		GridBagConstraints gbc_lblMakeALine = new GridBagConstraints();
		gbc_lblMakeALine.insets = new Insets(0, 0, 5, 0);
		gbc_lblMakeALine.gridx = 0;
		gbc_lblMakeALine.gridy = 0;
		contentPane.add(lblMakeALine, gbc_lblMakeALine);
		
		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 5;
		contentPane.add(separator, gbc_separator);
		
		xrange = new JTextField();
		xrange.setText("x-minimum (if you are using defaults, leave this as is)");
		GridBagConstraints gbc_xrange = new GridBagConstraints();
		gbc_xrange.insets = new Insets(0, 0, 5, 0);
		gbc_xrange.fill = GridBagConstraints.HORIZONTAL;
		gbc_xrange.gridx = 0;
		gbc_xrange.gridy = 6;
		contentPane.add(xrange, gbc_xrange);
		xrange.setColumns(10);
		
		yrange = new JTextField();
		yrange.setText("x-maximum (if you are using defaults, leave this as is)");
		GridBagConstraints gbc_yrange = new GridBagConstraints();
		gbc_yrange.insets = new Insets(0, 0, 5, 0);
		gbc_yrange.fill = GridBagConstraints.HORIZONTAL;
		gbc_yrange.gridx = 0;
		gbc_yrange.gridy = 7;
		contentPane.add(yrange, gbc_yrange);
		yrange.setColumns(10);
		
		txtA = new JTextField();
		txtA.setText("x");
		GridBagConstraints gbc_txtA = new GridBagConstraints();
		gbc_txtA.insets = new Insets(0, 0, 5, 0);
		gbc_txtA.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtA.gridx = 0;
		gbc_txtA.gridy = 2;
		contentPane.add(txtA, gbc_txtA);
		txtA.setColumns(10);
		
		txtB = new JTextField();
		txtB.setText("y");
		GridBagConstraints gbc_txtB = new GridBagConstraints();
		gbc_txtB.insets = new Insets(0, 0, 5, 0);
		gbc_txtB.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtB.gridx = 0;
		gbc_txtB.gridy = 3;
		contentPane.add(txtB, gbc_txtB);
		txtB.setColumns(10);
		
		txtC = new JTextField();
		txtC.setText("slope");
		GridBagConstraints gbc_txtC = new GridBagConstraints();
		gbc_txtC.insets = new Insets(0, 0, 5, 0);
		gbc_txtC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtC.gridx = 0;
		gbc_txtC.gridy = 4;
		contentPane.add(txtC, gbc_txtC);
		txtC.setColumns(10);
		
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
		
		btnCompile = new JButton("Compile");
		btnCompile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double x = Double.parseDouble(txtA.getText());
				double y = Double.parseDouble(txtB.getText());
				double slope = Double.parseDouble(txtC.getText());
				
				
				double xRange=-10;
				double yRange=10;
				
				if(!xrange.getText().equals("x-minimum (if you are using defaults, leave this as is)")) {
					xRange=Double.parseDouble(xrange.getText());
				}
				if(!yrange.getText().equals("x-maximum (if you are using defaults, leave this as is)")) {
					yRange=Double.parseDouble(yrange.getText());
				}
				
				//code="Plot[y /. Solve["+a+"x+"+b+"y"+"=="+c+ "], {x, " + xRange + ", " + yRange + "}, AspectRatio -> Automatic]";
				code="Plot["+slope+"x"+((slope*x*-1)+y)+", {x, " + xRange + ", " + yRange + "}, AspectRatio -> Automatic]";
				lblOutput.setText(code);
				
				StringSelection stringSelection = new StringSelection(code);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);	
			}
		});
		
		separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 8;
		contentPane.add(separator_1, gbc_separator_1);
		
		GridBagConstraints gbc_btnCompile = new GridBagConstraints();
		gbc_btnCompile.insets = new Insets(0, 0, 5, 0);
		gbc_btnCompile.gridx = 0;
		gbc_btnCompile.gridy = 9;
		contentPane.add(btnCompile, gbc_btnCompile);
		
		lblOutput = new JLabel("Output");
		GridBagConstraints gbc_lblOutput = new GridBagConstraints();
		gbc_lblOutput.insets = new Insets(0, 0, 5, 0);
		gbc_lblOutput.gridx = 0;
		gbc_lblOutput.gridy = 10;
		contentPane.add(lblOutput, gbc_lblOutput);
		
		btnCopy = new JButton("Copy");
		btnCopy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StringSelection stringSelection = new StringSelection(code);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				
				btnCopy.setText("Copied!");
			}
		});
		GridBagConstraints gbc_btnCopy = new GridBagConstraints();
		gbc_btnCopy.gridx = 0;
		gbc_btnCopy.gridy = 11;
		contentPane.add(btnCopy, gbc_btnCopy);
	}

}
