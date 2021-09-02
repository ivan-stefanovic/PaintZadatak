package drawing;


import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

public class DlgRect extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JLabel lblXCoordinate;
	private JLabel lblYCoordinate;
	private JLabel lblHeight;
	private JLabel lblWidth;
	private JTextField txtXC;
	private JTextField txtYC;
	private JTextField txtHeight;
	private JTextField txtWidth;
	public boolean isOK;
	private JButton btnOK;
	private JButton btnCancel;
	private Rectangle r;
	private JTextField txtColor;
	private Color color;
	private JTextField txtFill;
	private Color fill;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRect dialog = new DlgRect();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRect() {
		setModal(true);
		setResizable(false);
		setTitle("Rectangle");
		
		initComponents();
		
		createEvents();
		
		
	}
	
	///////////////////////////////////////////////////
	// Initializing all components
	//////////////////////////////////////////////////
	
	private void initComponents() {
		
		setBounds(800, 250, 320, 250);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				btnOK = new JButton("OK");
				btnOK.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnOK.setIcon(null);
				btnOK.setActionCommand("OK");
				
				
				buttonPane.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(buttonPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
					.addGap(76))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		lblXCoordinate = new JLabel("X coordinate (ULP):");
		lblXCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYCoordinate = new JLabel("Y coordinate (ULP):");
		lblYCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWidth = new JLabel("Width:");
		lblWidth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtXC = new JTextField();
		txtXC.setEnabled(false);
		txtXC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtXC.setColumns(10);
		
		txtYC = new JTextField();
		txtYC.setEnabled(false);
		txtYC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtYC.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHeight.setColumns(10);
		
		txtWidth = new JTextField();
		txtWidth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtWidth.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setMaximumSize(new Dimension(6, 22));
		txtColor.setEnabled(false);
		txtColor.setVisible(false);
		txtColor.setColumns(10);
		
		txtFill = new JTextField();
		txtFill.setMaximumSize(new Dimension(6, 22));
		txtFill.setVisible(false);
		txtFill.setEnabled(false);
		txtFill.setColumns(10);
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblXCoordinate, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
						.addComponent(lblYCoordinate)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtFill, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHeight, Alignment.TRAILING)
								.addComponent(lblWidth, Alignment.TRAILING))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtYC, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(txtXC, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinate)
						.addComponent(txtXC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoordinate)
						.addComponent(txtYC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtColor, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
							.addComponent(txtFill, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHeight)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWidth)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(29))
		);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
	}

	///////////////////////////////////////////////////
	// Creating all events
	//////////////////////////////////////////////////

	private void createEvents() {
		
		txtXC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
						(c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}	
			}
		});
		
		txtYC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
						(c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}	
			}
		});
		
		txtHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
						(c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}	
			}
		});
		
		txtWidth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
						(c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}	
			}
		});
		
		txtColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				color = JColorChooser.showDialog(null, "Choose your color", color);
				if (color == null) {
					color = Color.BLACK;
				}
				txtColor.setBackground(color);
			}
		});
		
		txtFill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fill = JColorChooser.showDialog(null, "Choose your color", fill);
				if (fill == null) {
					fill = Color.WHITE;
				}
				txtFill.setBackground(fill);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (txtXC.getText().trim().isEmpty() ||
						txtYC.getText().trim().isEmpty() ||
						txtHeight.getText().trim().isEmpty() ||
						txtWidth.getText().trim().isEmpty()) {
					isOK = false;
					setVisible(true);
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Not all fields have entered values!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (
						Integer.parseInt(txtHeight.getText()) > 999 ||
						Integer.parseInt(txtWidth.getText()) > 999) {
					
					isOK = false;
					setVisible(true);
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Values entered must be between 0 and 999! \nPlease try again", "Error",
							JOptionPane.ERROR_MESSAGE);
						if (Integer.parseInt(txtHeight.getText()) > 999) {
							txtHeight.setText("");
							}
						if (Integer.parseInt(txtWidth.getText()) > 999) {
							txtWidth.setText("");
							}
				} else {
					isOK = true;
					dispose();
					r = new Rectangle(new Point (Integer.parseInt(txtXC.getText()), Integer.parseInt(txtYC.getText())),
					Integer.parseInt(txtHeight.getText()), Integer.parseInt(txtWidth.getText()),
					FrmDrawing.getColor1(), FrmDrawing.getColor2());
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog (null, "Are you sure you want to cancel your actions?","Warning", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					isOK = false;
					dispose();
				}
			}
		});
	}
	
	
	//////////// Getters and setters ////////////
	
	public JTextField getTxtXC() {
		return txtXC;
	}

	public void setTxtXC(JTextField txtXC) {
		this.txtXC = txtXC;
	}

	public JTextField getTxtYC() {
		return txtYC;
	}

	public void setTxtYC(JTextField txtYC) {
		this.txtYC = txtYC;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}
	
	public Rectangle getR() {
		return r;
	}
	
	public void setR(Rectangle r) {
		this.r = r;
	}
	
	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}
	public JTextField getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(JTextField txtColor) {
		this.txtColor = txtColor;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public JTextField getTxtFill() {
		return txtFill;
	}

	public void setTxtFill(JTextField txtFill) {
		this.txtFill = txtFill;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}
}
