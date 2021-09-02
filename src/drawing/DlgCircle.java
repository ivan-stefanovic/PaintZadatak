package drawing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Circle;

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

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JLabel lblXCoordinate;
	private JLabel lblYCoordinate;
	private JLabel lblRadius;
	private JTextField txtXC;
	private JTextField txtYC;
	private JTextField txtRadius;
	public boolean isOK;
	private JButton btnOK;
	private JButton btnCancel;
	private Circle c;
	private Color color;
	private Color fill;
	private JTextField txtColor;
	private JTextField txtFill;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setModal(true);
		setResizable(false);
		setTitle("Circle");
		
		initComponents();
		
		createEvents();
		
		
	}
	
	///////////////////////////////////////////////////
	// Initializing all Components
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
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
					.addGap(76))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		lblXCoordinate = new JLabel("X coordinate (Center):");
		lblXCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYCoordinate = new JLabel("Y coordinate \n"
				+ "(Center):");
		lblYCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRadius = new JLabel("Radius:");
		lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtXC = new JTextField();
		txtXC.setEnabled(false);
		txtXC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtXC.setColumns(10);
		
		txtYC = new JTextField();
		txtYC.setEnabled(false);
		txtYC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtYC.setColumns(10);
		
		txtRadius = new JTextField();
		txtRadius.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRadius.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setVisible(false);
		txtColor.setEditable(false);
		txtColor.setColumns(10);
		
		txtFill = new JTextField();
		txtFill.setEditable(false);
		txtFill.setVisible(false);
		txtFill.setColumns(10);
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblXCoordinate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblYCoordinate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtXC, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYC, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(56)
							.addComponent(lblRadius)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(163, Short.MAX_VALUE)
					.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtFill, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
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
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtColor, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
						.addComponent(txtFill, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)))
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
		
		txtRadius.addKeyListener(new KeyAdapter() {
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
			public void mouseClicked(MouseEvent e) {
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
						txtRadius.getText().trim().isEmpty()) {
					isOK = false;
					setVisible(true);
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Not all fields have entered values!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (Integer.parseInt(txtRadius.getText()) > 999) {
					
					isOK = false;
					setVisible(true);
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Values entered must be between 0 and 999! \nPlease try again", "Error",
							JOptionPane.ERROR_MESSAGE);
						if (Integer.parseInt(txtRadius.getText()) > 999) {
							txtRadius.setText("");
							}
				} else {
					isOK = true;
					dispose();
					c = new Circle(new Point (Integer.parseInt(txtXC.getText()), Integer.parseInt(txtYC.getText())),
					Integer.parseInt(txtRadius.getText()), FrmDrawing.getColor1(), FrmDrawing.getColor2());
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

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	
	public Circle getC() {
		return c;
	}
	
	public void setC(Circle c) {
		this.c = c;
	}
	
	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public JTextField getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(JTextField txtColor) {
		this.txtColor = txtColor;
	}
	
	
	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}

	public JTextField getTxtFill() {
		return txtFill;
	}

	public void setTxtFill(JTextField txtFill) {
		this.txtFill = txtFill;
	}
}
