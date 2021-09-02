package drawing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
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

public class DlgPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JLabel lblXCoordinate;
	private JLabel lblYCoordinate;
	private JTextField txtXC;
	private JTextField txtYC;
	private JTextField txtColor;
	public boolean isOK;
	private JButton btnOK;
	private JButton btnCancel;
	private Point p;
	private Color color;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setModal(true);
		setResizable(false);
		setTitle("Modify Point\r\n");
		
		initComponents();
		
		createEvents();
		
		
	}
	
	///////////////////////////////////////////////////
	// Initializing all components
	//////////////////////////////////////////////////
	
	private void initComponents() {
		
		setBounds(800, 250, 262, 243);
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
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addGap(76))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		lblXCoordinate = new JLabel("X coordinate:");
		lblXCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYCoordinate = new JLabel("Y coordinate:");
		lblYCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtXC = new JTextField();
		txtXC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtXC.setColumns(10);
		
		txtYC = new JTextField();
		txtYC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtYC.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setEnabled(false);
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtColor.setColumns(10);
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblXCoordinate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblYCoordinate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtXC, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYC, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(61, Short.MAX_VALUE))
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
					.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
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
			if (txtXC.getText().trim().isEmpty() ||
						txtYC.getText().trim().isEmpty()) {
					isOK = false;
					setVisible(true);
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Not all fields have entered values!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					isOK = true;
					dispose();
					p = new Point(Integer.parseInt(txtXC.getText()), Integer.parseInt(txtYC.getText()), getColor());
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

	public JTextField getTxtColor() {
		return txtColor;
	}

	public void setTxtColor(JTextField txtColor) {
		this.txtColor = txtColor;
	}

	
	public Point getP() {
		return p;
	}
	
	public void setP(Point p) {
		this.p = p;
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
