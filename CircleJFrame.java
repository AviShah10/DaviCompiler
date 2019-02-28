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

public class CircleJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField h;
	private JTextField k;
	private JTextField r;
	private JLabel lblOutput;
	String code = "";
	private JSeparator separator;
	private JTextField xRange;
	private JTextField yRange;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircleJFrame frame = new CircleJFrame();
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
	public CircleJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblMakeACircle = new JLabel("Make A Circle In Mathematica");
		lblMakeACircle.setFont(new Font("Cambria", Font.BOLD, 20));
		GridBagConstraints gbc_lblMakeACircle = new GridBagConstraints();
		gbc_lblMakeACircle.insets = new Insets(0, 0, 5, 0);
		gbc_lblMakeACircle.gridx = 0;
		gbc_lblMakeACircle.gridy = 0;
		contentPane.add(lblMakeACircle, gbc_lblMakeACircle);
		
		h = new JTextField();
		h.setText("h");
		GridBagConstraints gbc_h = new GridBagConstraints();
		gbc_h.insets = new Insets(0, 0, 5, 0);
		gbc_h.fill = GridBagConstraints.HORIZONTAL;
		gbc_h.gridx = 0;
		gbc_h.gridy = 1;
		contentPane.add(h, gbc_h);
		h.setColumns(10);
		
		k = new JTextField();
		k.setText("k");
		GridBagConstraints gbc_k = new GridBagConstraints();
		gbc_k.insets = new Insets(0, 0, 5, 0);
		gbc_k.fill = GridBagConstraints.HORIZONTAL;
		gbc_k.gridx = 0;
		gbc_k.gridy = 2;
		contentPane.add(k, gbc_k);
		k.setColumns(10);
		
		r = new JTextField();
		r.setText("r");
		GridBagConstraints gbc_r = new GridBagConstraints();
		gbc_r.insets = new Insets(0, 0, 5, 0);
		gbc_r.fill = GridBagConstraints.HORIZONTAL;
		gbc_r.gridx = 0;
		gbc_r.gridy = 3;
		contentPane.add(r, gbc_r);
		r.setColumns(10);
		
		JButton btnCompile = new JButton("Compile");
		btnCompile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int h1 = Integer.parseInt(h.getText());
				int k1 = Integer.parseInt(k.getText());
				int r1 = Integer.parseInt(r.getText());

				double xRange1=-10;
				double yRange1=10;
				
				if(!xRange.getText().equals("x-minimum (if you are using defaults, leave this as is)")) {
					xRange1=Double.parseDouble(xRange.getText());
				}
				if(!yRange.getText().equals("x-maximum (if you are using defaults, leave this as is)")) {
					yRange1=Double.parseDouble(yRange.getText());
				}
				code = "x^2 + y^2 +" + (-2 * h1) + "x +" + (-2 * k1) + "y == " + (r1*r1) + " - " + (h1*h1) + " - " + (k1*k1);
				code = "Plot[y /. Solve[" + code + "], {x, " + xRange1 + ", " + yRange1 + "}, AspectRatio -> Automatic]";
				lblOutput.setText(code);
			}
		});
		
		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 4;
		contentPane.add(separator, gbc_separator);
		
		xRange = new JTextField();
		xRange.setText("x-minimum (if you are using defaults, leave this as is)");
		GridBagConstraints gbc_xRange = new GridBagConstraints();
		gbc_xRange.insets = new Insets(0, 0, 5, 0);
		gbc_xRange.fill = GridBagConstraints.HORIZONTAL;
		gbc_xRange.gridx = 0;
		gbc_xRange.gridy = 5;
		contentPane.add(xRange, gbc_xRange);
		xRange.setColumns(10);
		
		yRange = new JTextField();
		yRange.setText("x-maximum (if you are using defaults, leave this as is)");
		GridBagConstraints gbc_yRange = new GridBagConstraints();
		gbc_yRange.insets = new Insets(0, 0, 5, 0);
		gbc_yRange.fill = GridBagConstraints.HORIZONTAL;
		gbc_yRange.gridx = 0;
		gbc_yRange.gridy = 6;
		contentPane.add(yRange, gbc_yRange);
		yRange.setColumns(10);
		GridBagConstraints gbc_btnCompile = new GridBagConstraints();
		gbc_btnCompile.insets = new Insets(0, 0, 5, 0);
		gbc_btnCompile.gridx = 0;
		gbc_btnCompile.gridy = 7;
		contentPane.add(btnCompile, gbc_btnCompile);
		
		lblOutput = new JLabel("Output");
		GridBagConstraints gbc_lblOutput = new GridBagConstraints();
		gbc_lblOutput.insets = new Insets(0, 0, 5, 0);
		gbc_lblOutput.gridx = 0;
		gbc_lblOutput.gridy = 8;
		contentPane.add(lblOutput, gbc_lblOutput);
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StringSelection stringSelection = new StringSelection(code);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				btnCopy.setText("Copied");
			}
		});
		GridBagConstraints gbc_btnCopy = new GridBagConstraints();
		gbc_btnCopy.gridx = 0;
		gbc_btnCopy.gridy = 9;
		contentPane.add(btnCopy, gbc_btnCopy);
	}

}
