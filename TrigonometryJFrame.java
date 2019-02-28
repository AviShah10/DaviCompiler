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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class TrigonometryJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField expression;
	private JRadioButton rdbtnDegrees;
	private JButton btnCompile;
	private JLabel lblOutput;
	private JButton btnCopy;
	private HashMap<String, String> map = new HashMap<>();
	private boolean degrees;
	private String code = "";
	private JButton btnGoBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrigonometryJFrame frame = new TrigonometryJFrame();
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
	public TrigonometryJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblMakeATrigonometric = new JLabel("Evaluate Trigonometry in Mathematica");
		lblMakeATrigonometric.setFont(new Font("Cambria", Font.BOLD, 20));
		GridBagConstraints gbc_lblMakeATrigonometric = new GridBagConstraints();
		gbc_lblMakeATrigonometric.insets = new Insets(0, 0, 5, 0);
		gbc_lblMakeATrigonometric.gridx = 0;
		gbc_lblMakeATrigonometric.gridy = 0;
		contentPane.add(lblMakeATrigonometric, gbc_lblMakeATrigonometric);
		
		expression = new JTextField();
		expression.setText("Expression");
		GridBagConstraints gbc_expression = new GridBagConstraints();
		gbc_expression.insets = new Insets(0, 0, 5, 0);
		gbc_expression.fill = GridBagConstraints.HORIZONTAL;
		gbc_expression.gridx = 0;
		gbc_expression.gridy = 1;
		contentPane.add(expression, gbc_expression);
		expression.setColumns(10);
		
		rdbtnDegrees = new JRadioButton("Degrees");
		GridBagConstraints gbc_rdbtnDegrees = new GridBagConstraints();
		gbc_rdbtnDegrees.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnDegrees.gridx = 0;
		gbc_rdbtnDegrees.gridy = 2;
		contentPane.add(rdbtnDegrees, gbc_rdbtnDegrees);
		
		btnCompile = new JButton("Compile");
		btnCompile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String expression1 = expression.getText();
				map.put("S", "Sin[");
				map.put("C", "Cos[");
				map.put("T", "Tan[");
				map.put("A", "Sec[");
				map.put("B", "Cot[");
				map.put("D", "Csc[");
				code = "";
				code += "N[";
				for (int i = 0; i < expression1.length(); i++) {
					if (map.containsKey(Character.toString(expression1.charAt(i)))) {
						code += map.get(Character.toString(expression1.charAt(i)));
					} else {
						code += expression1.charAt(i);
					}
					if(i < expression1.length()-1 && expression1.charAt(i+1)==']' && rdbtnDegrees.isSelected()) {
						code=code+" Degree";
					}
				}
				
				code += "]";
				lblOutput.setText(code);
			}
		});
		GridBagConstraints gbc_btnCompile = new GridBagConstraints();
		gbc_btnCompile.insets = new Insets(0, 0, 5, 0);
		gbc_btnCompile.gridx = 0;
		gbc_btnCompile.gridy = 3;
		contentPane.add(btnCompile, gbc_btnCompile);
		
		lblOutput = new JLabel("Output");
		GridBagConstraints gbc_lblOutput = new GridBagConstraints();
		gbc_lblOutput.insets = new Insets(0, 0, 5, 0);
		gbc_lblOutput.gridx = 0;
		gbc_lblOutput.gridy = 4;
		contentPane.add(lblOutput, gbc_lblOutput);
		
		btnCopy = new JButton("Copy");
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
		gbc_btnCopy.insets = new Insets(0, 0, 5, 0);
		gbc_btnCopy.gridx = 0;
		gbc_btnCopy.gridy = 5;
		contentPane.add(btnCopy, gbc_btnCopy);
		
		btnGoBack = new JButton("Go Back");
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
		gbc_btnGoBack.gridy = 8;
		contentPane.add(btnGoBack, gbc_btnGoBack);
	}

}
