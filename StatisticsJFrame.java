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

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.JSeparator;

public class StatisticsJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField l1;
	private JTextField l2;
	String code = "";
	private JTextField xRange;
	private JTextField yRange;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticsJFrame frame = new StatisticsJFrame();
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
	public StatisticsJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDoStatisticsIn = new JLabel("Do Statistics in Mathematica");
		lblDoStatisticsIn.setFont(new Font("Cambria", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDoStatisticsIn = new GridBagConstraints();
		gbc_lblDoStatisticsIn.insets = new Insets(0, 0, 5, 0);
		gbc_lblDoStatisticsIn.gridx = 0;
		gbc_lblDoStatisticsIn.gridy = 0;
		contentPane.add(lblDoStatisticsIn, gbc_lblDoStatisticsIn);
		
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
		gbc_btnGoBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnGoBack.gridx = 0;
		gbc_btnGoBack.gridy = 1;
		contentPane.add(btnGoBack, gbc_btnGoBack);
		
		l1 = new JTextField();
		l1.setText("List 1");
		GridBagConstraints gbc_l1 = new GridBagConstraints();
		gbc_l1.insets = new Insets(0, 0, 5, 0);
		gbc_l1.fill = GridBagConstraints.HORIZONTAL;
		gbc_l1.gridx = 0;
		gbc_l1.gridy = 2;
		contentPane.add(l1, gbc_l1);
		l1.setColumns(10);
		
		l2 = new JTextField();
		l2.setText("List 2");
		GridBagConstraints gbc_l2 = new GridBagConstraints();
		gbc_l2.insets = new Insets(0, 0, 5, 0);
		gbc_l2.fill = GridBagConstraints.HORIZONTAL;
		gbc_l2.gridx = 0;
		gbc_l2.gridy = 3;
		contentPane.add(l2, gbc_l2);
		l2.setColumns(10);
		
		JSeparator separator = new JSeparator();
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
		
		JRadioButton rdbtnMedianmedianLine = new JRadioButton("Median-Median Line");
		GridBagConstraints gbc_rdbtnMedianmedianLine = new GridBagConstraints();
		gbc_rdbtnMedianmedianLine.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnMedianmedianLine.gridx = 0;
		gbc_rdbtnMedianmedianLine.gridy = 7;
		contentPane.add(rdbtnMedianmedianLine, gbc_rdbtnMedianmedianLine);
		
		JRadioButton rdbtnLeastsquaresLine = new JRadioButton("Least-Squares Line");
		GridBagConstraints gbc_rdbtnLeastsquaresLine = new GridBagConstraints();
		gbc_rdbtnLeastsquaresLine.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnLeastsquaresLine.gridx = 0;
		gbc_rdbtnLeastsquaresLine.gridy = 8;
		contentPane.add(rdbtnLeastsquaresLine, gbc_rdbtnLeastsquaresLine);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMedianmedianLine);
		group.add(rdbtnLeastsquaresLine);
		
		JLabel lblOutput = new JLabel("Output");
		GridBagConstraints gbc_lblOutput = new GridBagConstraints();
		gbc_lblOutput.insets = new Insets(0, 0, 5, 0);
		gbc_lblOutput.gridx = 0;
		gbc_lblOutput.gridy = 10;
		contentPane.add(lblOutput, gbc_lblOutput);
		
		JButton btnCompile = new JButton("Compile");
		btnCompile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String la = l1.getText();
				String lb = l2.getText();
				la = la.substring(la.indexOf("{"),la.indexOf("}")+1);
				lb = lb.substring(lb.indexOf("{"),lb.indexOf("}")+1);
				la = la.replaceAll(" ", "");
				lb = lb.replaceAll(" ", "");
				String[] arr = la.split(",", 1000);
				double[] arr1 = new double[arr.length];
				for(int i = 0; i < arr.length; i++) {
					System.out.println(arr[i]);
				}
				double xRange1=-10;
				double yRange1=10;
				
				if(!xRange.getText().equals("x-minimum (if you are using defaults, leave this as is)")) {
					xRange1=Double.parseDouble(xRange.getText());
				}
				if(!yRange.getText().equals("x-maximum (if you are using defaults, leave this as is)")) {
					yRange1=Double.parseDouble(yRange.getText());
				}
				code = "list1 = " + la + ";\n";
				code = code + "list2 = " + lb + ";\n";
				code = code + "graphPoints = Prepend[{list2},list1];\n";
				code = code + "graphPoints = Transpose[graphPoints];\n";
				code = code + "graphPoints = Sort[graphPoints]\n";
				code = code + "listPoints = ListPlot[graphPoints, AxesLabel -> {\"List 1\", \"List 2\"}, PlotLabel -> \"List 1 vs. List 2\", PlotStyle -> Green]\n";
				if(rdbtnMedianmedianLine.isSelected()) {
					String str1 = "";
					String str2 = "";
					String str3 = "";
					for(int i = 1; i <= arr.length/3; i++) {
						str1 = str1 + i + ",";
					}
					str1 = "{" + str1.substring(0, str1.length()-1) + "}";
					for(int i = arr.length/3 + 1; i <= 2*arr.length/3; i++) {
						str2 = str2 + i + ",";
					}
					str2 = "{" + str2.substring(0, str2.length()-1) + "}";
					for(int i = 2*arr.length/3 + 1; i <= arr.length; i++) {
						str3 = str3 + i + ",";
					}
					str3 = "{" + str3.substring(0, str3.length()-1) + "}";
					code = code + "section1 = graphPoints[[" + str1 + "]];\n";
					code = code + "section2 = graphPoints[[" + str2 + "]];\n";
					code = code + "section3 = graphPoints[[" + str3 + "]];\n";
					code = code + "median1 = Median[section1];\n";
					code = code + "median2 = Median[section2];\n";
					code = code + "median3 = Median[section3];\n";
					code = code + "f1[x_] := (median3[[2]] - median1[[2]])/(median3[[1]] - median1[[1]]) * (x - median1[[1]] ) + median1[[2]];\n";
					code = code + "f2[x_] = f1[x] - 1/3*(f1[median2[[1]]] - median2[[2]])\n";
					code = code + "medianLine = Plot[f2[x], {x, " + xRange1 + ", " + yRange1 + "}];\n";
					code = code + "medianPointsGraph = ListPlot[{median1, median2, median3}, PlotStyle -> {Red, PointSize [0.025]}];\n";
					code = code + "Show[listPoints, medianPointsGraph, medianLine]";
				}
				else {
					code = code + "B1 = \\!\\(\r\n" + 
							"\\*UnderoverscriptBox[\\(\\[Sum]\\), \\(i = \r\n" + 
							"    1\\), \\(" + arr.length + "\\)]\\(list1[\\([\\)\\(i\\)\\(]\\)]*list2[\\([\\)\\(i\\)\\(]\\)]\\)\\);\n";
					code = code + "C1 = \\!\\(\r\n" + 
							"\\*UnderoverscriptBox[\\(\\[Sum]\\), \\(i = \r\n" + 
							"    1\\), \\(" + arr.length + "\\)]\\(list2[\\([\\)\\(i\\)\\(]\\)]\\)\\);\n";
					code = code + "D1 = \\!\\(\r\n" + 
							"\\*UnderoverscriptBox[\\(\\[Sum]\\), \\(i = \r\n" + 
							"    1\\), \\(" + arr.length + "\\)]\\(list1[\\([\\)\\(i\\)\\(]\\)]*list1[\\([\\)\\(i\\)\\(]\\)]\\)\\);\n";
					code = code + "E1 = \\!\\(\r\n" + 
							"\\*UnderoverscriptBox[\\(\\[Sum]\\), \\(i = \r\n" + 
							"    1\\), \\(" + arr.length + "\\)]\\(list1[\\([\\)\\(i\\)\\(]\\)]\\)\\);\n";
					code = code + "mLeastSquares = ((B1*" + arr.length + ") - (C1*E1))/((" + arr.length + "*D1) - (E1*E1));\n";
					code = code + "bLeastSquares = ((C1*D1) - (B1*E1))/((" + arr.length + "*D1) - (E1*E1));\n";
					code = code + "lsq[x_] = mLeastSquares * x + bLeastSquares\n";
					code = code + "lsqLine = Plot[lsq[x], {x, " + xRange1 + ", " + yRange1 + "}];\n";
					code = code + "Show[listPoints, lsqLine]";
				}
				lblOutput.setText(code);
			}
		});
		GridBagConstraints gbc_btnCompile = new GridBagConstraints();
		gbc_btnCompile.insets = new Insets(0, 0, 5, 0);
		gbc_btnCompile.gridx = 0;
		gbc_btnCompile.gridy = 9;
		contentPane.add(btnCompile, gbc_btnCompile);
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				StringSelection stringSelection = new StringSelection(code);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				btnCopy.setText("Copied");
			}
		});
		GridBagConstraints gbc_btnCopy = new GridBagConstraints();
		gbc_btnCopy.gridx = 0;
		gbc_btnCopy.gridy = 11;
		contentPane.add(btnCopy, gbc_btnCopy);
	
	}

}
