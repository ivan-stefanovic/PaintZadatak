package sort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import java.util.Collections;

import geometry.Rectangle;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.UIManager;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrlRect;
	private JList lstRectSort;
	private JScrollPane srclRectSort;
	private JList lstRect;
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnSort;
	private DefaultListModel dlmRect;
	private DefaultListModel dlmSort;
	public int brojac;
	public int brojac2;
	private ArrayList<Rectangle> arrayRect = new ArrayList<Rectangle>();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmSort.class.getResource("/resources/sort_icon.png")));
		
		
		initComponents();
		
		crateEvents();
		
		
		
	}
	

	///////////////////////////////////////////////////
	// Initializing all Components
	//////////////////////////////////////////////////
	
	private void initComponents() {
		
		setTitle("Ivan Stefanovic IM 179-2015");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrlRect = new JScrollPane();
		scrlRect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrlRect.setBackground(new Color(153, 153, 153));
		scrlRect.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rectangles list", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		srclRectSort = new JScrollPane();
		srclRectSort.setBackground(new Color(153, 153, 153));
		srclRectSort.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sorted rectangles by area", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(srclRectSort, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
						.addComponent(scrlRect, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnRemove, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addComponent(panel, Alignment.TRAILING, 0, 120, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addComponent(btnAdd)
							.addGap(18)
							.addComponent(btnRemove)
							.addGap(29))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrlRect, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(srclRectSort, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		btnSort = new JButton("Sort");
		btnSort.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnSort, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(79)
					.addComponent(btnSort)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		lstRectSort = new JList();
		lstRectSort.setFont(new Font("Tahoma", Font.PLAIN, 15));
		srclRectSort.setViewportView(lstRectSort);
		
		dlmSort = new DefaultListModel();
		lstRectSort.setModel(dlmSort);
		
		lstRect = new JList();
		lstRect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrlRect.setViewportView(lstRect);
		
		dlmRect = new DefaultListModel();
		lstRect.setModel(dlmRect);
		
		contentPane.setLayout(gl_contentPane);
		
		
	}
	
	///////////////////////////////////////////////////
	// Creating all events
	//////////////////////////////////////////////////

	private void crateEvents() {
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgSort dlgSort = new DlgSort();
				dlgSort.setVisible(true);
				if (dlgSort.isOK == true) {
					brojac++;
					dlmRect.insertElementAt("Rectangle " + brojac + ": " + dlgSort.getR().toString(),0);
					
					dlgSort.getR().setN(brojac);
					arrayRect.add(0, dlgSort.getR());
				}
				
				
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(dlmRect.isEmpty())) {
					DlgSort dlgSortMod = new DlgSort();
					String[] split = dlmRect.getElementAt(0).toString().split(" ");
					dlgSortMod.getTxtXC().setText(split[6].substring(1, split[6].length()-1));
					dlgSortMod.getTxtXC().setEnabled(false);
					
					dlgSortMod.getTxtYC().setText(split[7].substring(0, split[7].length()-2));
					dlgSortMod.getTxtYC().setEnabled(false);
					
					dlgSortMod.getTxtHeight().setText(split[10].substring(0, split[10].length()-1));
					dlgSortMod.getTxtHeight().setEnabled(false);
					
					dlgSortMod.getTxtWidth().setText(split[13]);
					dlgSortMod.getTxtWidth().setEnabled(false);
					
					dlgSortMod.getBtnOK().setVisible(false);
					dlgSortMod.getBtnDelete().setVisible(true);
					dlgSortMod.setVisible(true);
					if (dlgSortMod.isOK == true) {
						if (arrayRect.contains(dlgSortMod.getR1()))
							arrayRect.remove(dlgSortMod.getR1()) ;
						dlmRect.removeElementAt(0);
						brojac--;
					}
				}
				else {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "The list is empty! "
							+ "\nAdd an object first!", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlmRect.isEmpty()) {
					dlmSort.removeAllElements();
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "The list is empty! "
							+ "\nAdd an object first!", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else {
					dlmSort.removeAllElements();
					Collections.sort(arrayRect); //IZGUGLATI
				}
				
				
				brojac2 = 0;
				
				for (Rectangle r : arrayRect) {
					brojac2++;
					dlmSort.addElement(brojac2 + ". " + "Rectangle " + r.getN() + ": " + r.area());
				}
					
			}
		});
		
	}
}
