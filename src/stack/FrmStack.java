package stack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class FrmStack extends JFrame {

	private JPanel contentPane;
	private JButton btnAdd;
	private JButton btnRemove;
	private JScrollPane scrlRect;
	JList lstRect = new JList();
	DefaultListModel dlm = new DefaultListModel();
	public int brojac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
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
	public FrmStack() {
		
		
		initComponents();
		
		createEvents();
		
		
	}
	
	///////////////////////////////////////////////////
	// Deklarisanje/inicijalizacija svih komponenti iz forme
	//////////////////////////////////////////////////
	private void initComponents() {
		
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmStack.class.getResource("/resources/Rect_icon.png")));
		setTitle("Ivan Stefanovic IM 179 - 2015");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 800, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		scrlRect = new JScrollPane();
		scrlRect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrlRect.setBackground(Color.GRAY);
		scrlRect.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Rectangles list", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		
		btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrlRect, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrlRect, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
					.addGap(38))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(99)
					.addComponent(btnAdd)
					.addGap(18)
					.addComponent(btnRemove)
					.addContainerGap(228, Short.MAX_VALUE))
		);
		lstRect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lstRect.setModel(dlm);
		scrlRect.setViewportView(lstRect);
		
		contentPane.setLayout(gl_contentPane);
		
	}
	
	///////////////////////////////////////////////////
	// Kreiranje svih događaja iz forme
	//////////////////////////////////////////////////
	private void createEvents() {
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStack dlgStack = new DlgStack();
				dlgStack.setVisible(true);
				if (dlgStack.isOK == true) {
					brojac++;
					dlm.insertElementAt("Rectangle " + brojac + ": " + dlgStack.getR().toString(),0);
					/*dlm.insertElementAt("X Coordinate: " + dlgStack.getTxtXC().getText() +
							"; Y coordinate: " + dlgStack.getTxtYC().getText() + 
							"; Height: " + dlgStack.getTxtHeight().getText() + 
							"; Width: " + dlgStack.getTxtWidth().getText(), 0);	*/
					
				}
			
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(dlm.isEmpty())) {
					DlgStack dlgStackMod = new DlgStack();
					String[] split = dlm.getElementAt(0).toString().split(" ");
					//StringBuilder build = new StringBuilder(split[6]);
					dlgStackMod.getTxtXC().setText(split[6].substring(1, split[6].length()-1));
					dlgStackMod.getTxtXC().setEnabled(false);
					
					dlgStackMod.getTxtYC().setText(split[7].substring(0, split[7].length()-2));
					dlgStackMod.getTxtYC().setEnabled(false);
					
					dlgStackMod.getTxtHeight().setText(split[10].substring(0, split[10].length()-1));
					dlgStackMod.getTxtHeight().setEnabled(false);
					
					dlgStackMod.getTxtWidth().setText(split[13]);
					dlgStackMod.getTxtWidth().setEnabled(false);
					
					dlgStackMod.getBtnOK().setVisible(false);
					dlgStackMod.getBtnDelete().setVisible(true);
					dlgStackMod.setVisible(true);
					if (dlgStackMod.isOK == true) {
						dlm.removeElementAt(0);
						brojac--;
					}
				}
				else {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "The list is empty!", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
	
		
	
}}
