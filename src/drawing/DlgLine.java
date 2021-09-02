package drawing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Line;

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

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JLabel lblXCoordinateSP;
	private JLabel lblYCoordinateSP;
	private JLabel lblXCoordinateEP;
	private JLabel lblYCoordinateEP;
	private JTextField txtXCSP;
	private JTextField txtYCSP;
	private JTextField txtXCEP;
	private JTextField txtYCEP;
	private JTextField txtColor;
	public boolean isOK;
	private JButton btnOK;
	private JButton btnCancel;
	private Line l;
	private Color color;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setModal(true);
		setResizable(false);
		setTitle("Modify Line");
		
		initComponents();
		
		createEvents();
		
		
	}
	
	///////////////////////////////////////////////////
	// Initializing all components
	//////////////////////////////////////////////////
	
	private void initComponents() {
		
		setBounds(800, 250, 264, 299);
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		lblXCoordinateSP = new JLabel("X coordinate (SP):");
		lblXCoordinateSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYCoordinateSP = new JLabel("Y coordinate (SP):");
		lblYCoordinateSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtXCSP = new JTextField();
		txtXCSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtXCSP.setColumns(10);
		
		txtYCSP = new JTextField();
		txtYCSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtYCSP.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setEnabled(false);
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtColor.setColumns(10);
		
		lblXCoordinateEP = new JLabel("X coordinate (EP):");
		lblXCoordinateEP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblYCoordinateEP = new JLabel("Y coordinate (EP):");
		lblYCoordinateEP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtXCEP = new JTextField();
		txtXCEP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtXCEP.setColumns(10);
		
		txtYCEP = new JTextField();
		txtYCEP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtYCEP.setColumns(10);
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblXCoordinateSP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblYCoordinateSP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtXCSP, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYCSP, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblYCoordinateEP, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblXCoordinateEP, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtXCEP, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYCEP, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinateSP)
						.addComponent(txtXCSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoordinateSP)
						.addComponent(txtYCSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinateEP, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtXCEP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblYCoordinateEP, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYCEP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
	}

	///////////////////////////////////////////////////
	// Creating all events
	//////////////////////////////////////////////////
	
	private void createEvents() {
		
		txtXCSP.addKeyListener(new KeyAdapter() {
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
		
		txtYCSP.addKeyListener(new KeyAdapter() {
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
		
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (txtXCSP.getText().trim().isEmpty() ||
						txtYCSP.getText().trim().isEmpty() ||
						txtXCEP.getText().trim().isEmpty() ||
						txtYCEP.getText().trim().isEmpty()) {
					isOK = false;
					setVisible(true);
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Not all fields have entered values!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					isOK = true;
					dispose();
					l = new Line(new Point(Integer.parseInt(txtXCSP.getText()), Integer.parseInt(txtYCSP.getText())),
							new Point(Integer.parseInt(txtXCEP.getText()), Integer.parseInt(txtYCEP.getText())), getColor());
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
	
	public JTextField getTxtXCSP() {
		return txtXCSP;
	}

	public void setTxtXCSP(JTextField txtXCSP) {
		this.txtXCSP = txtXCSP;
	}

	public JTextField getTxtYCSP() {
		return txtYCSP;
	}

	public void setTxtYCSP(JTextField txtYCSP) {
		this.txtYCSP = txtYCSP;
	}

	public JTextField getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(JTextField txtColor) {
		this.txtColor = txtColor;
	}
	
	public JTextField getTxtXCEP() {
		return txtXCEP;
	}

	public void setTxtXCEP(JTextField txtXCEP) {
		this.txtXCEP = txtXCEP;
	}

	public JTextField getTxtYCEP() {
		return txtYCEP;
	}

	public void setTxtYCEP(JTextField txtYCEP) {
		this.txtYCEP = txtYCEP;
	}


	
	public Line getL() {
		return l;
	}
	
	public void setL(Line l) {
		this.l = l;
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
}
