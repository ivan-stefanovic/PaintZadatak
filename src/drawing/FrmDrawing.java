package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Component;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private JPanel pnlNorth;
	private JLabel lblShapes;
	public PnlDrawing pnlDrawing;
	private final ButtonGroup buttonGroupShapes = new ButtonGroup();
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnDonut;
	private JButton btnDelete;
	private JLabel lblOptions;
	private JButton btnClearCanvas;
	private JButton btnModify;
	private JPanel pnlWest;
	private JButton btnColor;
	private static Color color1 = Color.BLACK;
	private static Color color2 = Color.WHITE;
	private JTextField txtColor;
	private Point firstPointSelected;
	private Point p1;
	private JButton btnSelect;
	private Shape shapeSelected;
	private ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
	private JTextField txtFillColor;
	private JButton btnFillColor;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
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
	public FrmDrawing() {
		setTitle("Ivan Stefanovic IM 179-2015");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		initComponents();
		
		createEvents();
		
		
	}
	
	///////////////////////////////////////////////////
	// Initializing all components
	//////////////////////////////////////////////////

	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pnlDrawing = new PnlDrawing();
		pnlDrawing.setBackground(Color.WHITE);
		pnlDrawing.setVisible(true);
		
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
		pnlNorth = new JPanel();
		pnlNorth.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlNorth.setPreferredSize(new Dimension(10000, 55));
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		lblShapes = new JLabel("Shapes:");
		lblShapes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tglbtnPoint = new JToggleButton("Point");
		buttonGroupShapes.add(tglbtnPoint);
		tglbtnPoint.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tglbtnPoint.setToolTipText("Clik anywhere on the canvas to draw a point");
		
		tglbtnLine = new JToggleButton("Line");
		buttonGroupShapes.add(tglbtnLine);
		tglbtnLine.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tglbtnLine.setToolTipText("Click anywhere on the canvas to set the start point of a line, "
				+ "then click again to set the end point of a line");
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		buttonGroupShapes.add(tglbtnRectangle);
		tglbtnRectangle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tglbtnRectangle.setToolTipText("Click anywhere on the canvas to set the coordinates of the upper left point"
				+ " of the rectangle, then enter the desired height and width in the pop-up screen");
		
		tglbtnCircle = new JToggleButton("Circle");
		buttonGroupShapes.add(tglbtnCircle);
		tglbtnCircle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tglbtnCircle.setToolTipText("Click anywhere on the canvas to set the coordinates of the center"
				+ " of the circle, then enter the desired radius in the pop-up screen");
		
		tglbtnDonut = new JToggleButton("Donut");
		buttonGroupShapes.add(tglbtnDonut);
		tglbtnDonut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tglbtnDonut.setToolTipText("Click anywhere on the canvas to set the coordinates of the center"
				+ " of the donut, then enter the desired outter and inner radius in the pop-up screen");
		
		lblOptions = new JLabel("Options:");
		lblOptions.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnDelete.setToolTipText("Remove the selected object from the canvas");
		
		btnClearCanvas = new JButton("Clear canvas");
		btnClearCanvas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnClearCanvas.setToolTipText("Delete all the objects from the canvas");
		
		btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnModify.setToolTipText("Modify the properties of the selected object");
		
		btnSelect = new JButton("Select");
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnSelect.setToolTipText("Select an object on the canvas");
		
		GroupLayout gl_pnlNorth = new GroupLayout(pnlNorth);
		gl_pnlNorth.setHorizontalGroup(
			gl_pnlNorth.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlNorth.createSequentialGroup()
					.addGap(49)
					.addComponent(lblShapes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnPoint)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tglbtnLine)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tglbtnRectangle)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tglbtnCircle)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tglbtnDonut)
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addComponent(lblOptions)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSelect)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModify)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnClearCanvas)
					.addContainerGap())
		);
		gl_pnlNorth.setVerticalGroup(
			gl_pnlNorth.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNorth.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_pnlNorth.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNorth.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlNorth.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDelete)
								.addComponent(btnClearCanvas)
								.addComponent(btnModify)))
						.addGroup(gl_pnlNorth.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblShapes)
							.addComponent(lblOptions)
							.addComponent(btnSelect)
							.addComponent(tglbtnPoint)
							.addComponent(tglbtnLine)
							.addComponent(tglbtnRectangle)
							.addComponent(tglbtnCircle)
							.addComponent(tglbtnDonut)))
					.addGap(14))
		);
		gl_pnlNorth.linkSize(SwingConstants.VERTICAL, new Component[] {lblShapes, tglbtnPoint, tglbtnLine, tglbtnRectangle, tglbtnCircle, tglbtnDonut, lblOptions, btnDelete, btnClearCanvas, btnModify, btnSelect});
		gl_pnlNorth.linkSize(SwingConstants.HORIZONTAL, new Component[] {tglbtnPoint, tglbtnLine, tglbtnRectangle, tglbtnCircle, tglbtnDonut, btnDelete, btnClearCanvas, btnModify, btnSelect});
		pnlNorth.setLayout(gl_pnlNorth);
		
		pnlWest = new JPanel();
		pnlWest.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnlWest.setPreferredSize(new Dimension(90, 1000));
		contentPane.add(pnlWest, BorderLayout.WEST);
		
		btnColor = new JButton();
		btnColor.setText("<html><center>"+"Line"+"<br>"+"color"+"</center></html>");
		btnColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtColor = new JTextField();
		txtColor.setBorder(null);
		txtColor.setBackground(Color.BLACK);
		txtColor.setEditable(false);
		txtColor.setEnabled(false);
		txtColor.setColumns(10);
		
		txtFillColor = new JTextField();
		txtFillColor.setEnabled(false);
		txtFillColor.setEditable(false);
		txtFillColor.setColumns(10);
		txtFillColor.setBorder(null);
		txtFillColor.setBackground(Color.WHITE);
		
		btnFillColor = new JButton();
		btnFillColor.setText("<html><center>Fill<br>color</center></html>");
		btnFillColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_pnlWest = new GroupLayout(pnlWest);
		gl_pnlWest.setHorizontalGroup(
			gl_pnlWest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlWest.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_pnlWest.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFillColor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
						.addComponent(txtFillColor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
						.addComponent(btnColor, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
						.addComponent(txtColor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlWest.setVerticalGroup(
			gl_pnlWest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlWest.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnColor, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtFillColor, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(186, Short.MAX_VALUE))
		);
		pnlWest.setLayout(gl_pnlWest);
		
	}

	
	///////////////////////////////////////////////////
	// Creating all events
	//////////////////////////////////////////////////
	
	private void createEvents() {
		
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color1 = JColorChooser.showDialog(null, "Choose your color", color1);
				if (color1 == null) {
					color1 = Color.BLACK;
				}
				
				txtColor.setBackground(color1);
			}
		});
		
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color2 = JColorChooser.showDialog(null, "Choose your color", color2);
				if (color2 == null) {
					color2 = Color.WHITE;
				}
				
				txtFillColor.setBackground(color2);
			}
		});
		
		
		pnlNorth.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				buttonGroupShapes.clearSelection();
			}
		});
		
		pnlDrawing.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				
				for(Shape s : pnlDrawing.shapes) {
					s.setSelected(false);
				}
				selectedShapes.clear();
				shapeSelected = null;
				
				
				if(tglbtnPoint.isSelected()) {
					int x = e.getX();
					int y = e.getY();
					p1 = new Point(x, y, color1);
					Point p = p1;
					pnlDrawing.shapes.add(0, p);
					
					buttonGroupShapes.clearSelection();
					
				} else if (tglbtnLine.isSelected())  {
					
					if(getFirstPointSelected() == null)  {
						firstPointSelected = new Point(e.getX(), e.getY());
					}
					else  {
						Point secondPointSelected = new Point (e.getX(), e.getY());
						Line l = new Line (firstPointSelected, secondPointSelected, color1);
						pnlDrawing.shapes.add(0, l);
						firstPointSelected = null;
						buttonGroupShapes.clearSelection();
					}
					
				} else if(tglbtnRectangle.isSelected()) {
					int x = e.getX();
					int y = e.getY();
					p1 = new Point(x, y);
					DlgRect dlgRect = new DlgRect();
					dlgRect.getTxtXC().setText(Integer.toString(p1.getX()));
					dlgRect.getTxtYC().setText(Integer.toString(p1.getY()));
					dlgRect.setVisible(true);
					
					if(dlgRect.isOK) {
						pnlDrawing.shapes.add(0, dlgRect.getR());
						
						buttonGroupShapes.clearSelection();
					}
					
				} else if(tglbtnCircle.isSelected()) {
					int x = e.getX();
					int y = e.getY();
					p1 = new Point(x, y);
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.getTxtXC().setText(Integer.toString(p1.getX()));
					dlgCircle.getTxtYC().setText(Integer.toString(p1.getY()));
					dlgCircle.setVisible(true);
					
					if(dlgCircle.isOK) {
						pnlDrawing.shapes.add(0, dlgCircle.getC());
						
						buttonGroupShapes.clearSelection();
					}
					
				} else if(tglbtnDonut.isSelected()) {
					int x = e.getX();
					int y = e.getY();
					p1 = new Point(x, y);
					DlgDonut dlgDonut = new DlgDonut();
					dlgDonut.getTxtXC().setText(Integer.toString(p1.getX()));
					dlgDonut.getTxtYC().setText(Integer.toString(p1.getY()));
					dlgDonut.setVisible(true);
					
					if(dlgDonut.isOK) {
						pnlDrawing.shapes.add(0, dlgDonut.getD());
						
						buttonGroupShapes.clearSelection();
					}
					
				} else if (btnSelect.isSelected()) {
					for (Shape s : pnlDrawing.shapes) {
						if(s.contains(e.getX(), e.getY())) {
							selectedShapes.add(0, s);
						}
					}
					if (selectedShapes.size() == 1) {
							selectedShapes.get(0).setSelected(true);
							shapeSelected = selectedShapes.get(0);
					} else if (selectedShapes.size() > 1) {
						selectedShapes.get(selectedShapes.size()-1).setSelected(true);
						shapeSelected = selectedShapes.get(selectedShapes.size()-1);
					}
					btnSelect.setSelected(false);
				}
				
			}
		});
		
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlDrawing.shapes.isEmpty()) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "There are no objects on the canvas!", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(shapeSelected == null) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "You need to select an object first!", "Error", JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (shapeSelected instanceof Point) {
						Point pSelected = (Point) shapeSelected;
						DlgPoint dlgModPoint = new DlgPoint();
						dlgModPoint.getTxtColor().setBackground(pSelected.getColor());
						
						dlgModPoint.getTxtXC().setText(Integer.toString(pSelected.getX()));
						dlgModPoint.getTxtYC().setText(Integer.toString(pSelected.getY()));
						dlgModPoint.setVisible(true);
						
						if (dlgModPoint.isOK) {
							pnlDrawing.shapes.remove(shapeSelected);
							dlgModPoint.getP().setSelected(true);
							dlgModPoint.getP().setColor(dlgModPoint.getColor());
							shapeSelected = dlgModPoint.getP();
							selectedShapes.add(0, dlgModPoint.getP());
							pnlDrawing.shapes.add(0, dlgModPoint.getP());
						}
						
					} else if (shapeSelected instanceof Line) {
						Line lSelected = (Line) shapeSelected;
						DlgLine dlgModLine = new DlgLine();
						
						dlgModLine.getTxtColor().setBackground(lSelected.getColor());
						dlgModLine.getTxtXCSP().setText(Integer.toString(lSelected.getStartPoint().getX()));
						dlgModLine.getTxtYCSP().setText(Integer.toString(lSelected.getStartPoint().getY()));
						dlgModLine.getTxtXCEP().setText(Integer.toString(lSelected.getEndPoint().getX()));
						dlgModLine.getTxtYCEP().setText(Integer.toString(lSelected.getEndPoint().getY()));
						dlgModLine.getTxtColor().setVisible(true);
						
						dlgModLine.setVisible(true);
						
						if (dlgModLine.isOK) {
							pnlDrawing.shapes.remove(shapeSelected);
							dlgModLine.getL().setSelected(true);
							dlgModLine.getL().setColor(dlgModLine.getColor());
							shapeSelected = dlgModLine.getL();
							selectedShapes.add(0, dlgModLine.getL());
							pnlDrawing.shapes.add(0,dlgModLine.getL());
						} 
						
					} else if (shapeSelected instanceof Rectangle) {
						Rectangle rSelected = (Rectangle) shapeSelected;
						DlgRect dlgModRect = new DlgRect();
						dlgModRect.setColor(rSelected.getColor());
						dlgModRect.setFill(rSelected.getFillColor());
						dlgModRect.setTitle("Modify rectangle");
						dlgModRect.getTxtXC().setEnabled(true);
						dlgModRect.getTxtYC().setEnabled(true);
						dlgModRect.getTxtColor().setBackground(rSelected.getColor());
						dlgModRect.getTxtFill().setBackground(rSelected.getFillColor());
						dlgModRect.getTxtColor().setVisible(true);
						dlgModRect.getTxtFill().setVisible(true);
						
						
						dlgModRect.getTxtXC().setText(Integer.toString(rSelected.getUpperLeftPoint().getX()));
						dlgModRect.getTxtYC().setText(Integer.toString(rSelected.getUpperLeftPoint().getY()));
						dlgModRect.getTxtHeight().setText(Integer.toString(rSelected.getHeight()));
						dlgModRect.getTxtWidth().setText(Integer.toString(rSelected.getWidth()));
						
						dlgModRect.setVisible(true);
						
						if (dlgModRect.isOK) {
							pnlDrawing.shapes.remove(shapeSelected);
							dlgModRect.getR().setSelected(true);
							dlgModRect.getR().setColor(dlgModRect.getColor());
							dlgModRect.getR().setFillColor(dlgModRect.getFill());
							shapeSelected = dlgModRect.getR();
							selectedShapes.add(0, dlgModRect.getR());
							pnlDrawing.shapes.add(0, dlgModRect.getR());
						}
					} else if (shapeSelected instanceof Circle) {
						if (shapeSelected instanceof Donut) {
							Donut dSelected = (Donut) shapeSelected;
							DlgDonut dlgModDonut = new DlgDonut();
							dlgModDonut.setColor(dSelected.getColor());
							dlgModDonut.setFill(dSelected.getFillColor());
							dlgModDonut.setTitle("Modify donut");
							dlgModDonut.getTxtXC().setEnabled(true);
							dlgModDonut.getTxtYC().setEnabled(true);
							dlgModDonut.getTxtColor().setBackground(dSelected.getColor());
							dlgModDonut.getTxtFill().setBackground(dSelected.getFillColor());
							dlgModDonut.getTxtColor().setVisible(true);
							dlgModDonut.getTxtFill().setVisible(true);
							
							dlgModDonut.getTxtXC().setText(Integer.toString(dSelected.getCenter().getX()));
							dlgModDonut.getTxtYC().setText(Integer.toString(dSelected.getCenter().getY()));
							dlgModDonut.getTxtRadius().setText(Integer.toString(dSelected.getRadius()));
							dlgModDonut.getTxtInnerRadius().setText(Integer.toString(dSelected.getInnerRadius()));
							
							
							dlgModDonut.setVisible(true);
							
							if (dlgModDonut.isOK) {
								pnlDrawing.shapes.remove(shapeSelected);
								dlgModDonut.getD().setSelected(true);
								dlgModDonut.getD().setColor(dlgModDonut.getColor());
								dlgModDonut.getD().setFillColor((dlgModDonut.getFill()));
								shapeSelected = dlgModDonut.getD();
								selectedShapes.add(0, dlgModDonut.getD());
								pnlDrawing.shapes.add(0, dlgModDonut.getD());
							}
						} else {
							Circle cSelected = (Circle) shapeSelected;
							DlgCircle dlgModCircle = new DlgCircle();
							dlgModCircle.setColor(cSelected.getColor());
							dlgModCircle.setFill(cSelected.getFillColor());
							dlgModCircle.setTitle("Modify circle");
							dlgModCircle.getTxtXC().setEnabled(true);
							dlgModCircle.getTxtYC().setEnabled(true);
							dlgModCircle.getTxtColor().setBackground(cSelected.getColor());
							dlgModCircle.getTxtFill().setBackground(cSelected.getFillColor());
							dlgModCircle.getTxtColor().setVisible(true);
							dlgModCircle.getTxtFill().setVisible(true);
							
							dlgModCircle.getTxtXC().setText(Integer.toString(cSelected.getCenter().getX()));
							dlgModCircle.getTxtYC().setText(Integer.toString(cSelected.getCenter().getY()));
							dlgModCircle.getTxtRadius().setText(Integer.toString(cSelected.getRadius()));
							
							
							dlgModCircle.setVisible(true);
							
								if (dlgModCircle.isOK) {
									pnlDrawing.shapes.remove(shapeSelected);
									dlgModCircle.getC().setSelected(true);
									dlgModCircle.getC().setColor(dlgModCircle.getColor());
									dlgModCircle.getC().setFillColor(dlgModCircle.getFill());
									shapeSelected = dlgModCircle.getC();
									selectedShapes.add(0, dlgModCircle.getC());
									pnlDrawing.shapes.add(0, dlgModCircle.getC());
								}
						}
					} 
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlDrawing.shapes.isEmpty()) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "There are no objects on the canvas!", "Error", JOptionPane.INFORMATION_MESSAGE);
				} else if(shapeSelected == null) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "You need to select an object first!", "Error", JOptionPane.INFORMATION_MESSAGE);
				} else {
					int confirm = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete"
							+ " the selected object?","Warning", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						pnlDrawing.shapes.remove(shapeSelected);
						shapeSelected = null;
					}
					
				}
			}
		});
		
		
		btnClearCanvas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlDrawing.shapes.clear();
			}
		});
		
		btnSelect.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(pnlDrawing.shapes.isEmpty()) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "There are no objects on the canvas!", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					btnSelect.setSelected(true);
				}
			}
		});
	}
	
	public Point getFirstPointSelected() {
		return firstPointSelected;
	}

	public void setFirstPointSelected(Point firstPointSelected) {
		this.firstPointSelected = firstPointSelected;
	}
	
	public void setShapeSelected(Shape s)
	{
		shapeSelected = s;
	}
	public static Color getColor1() {
		return color1;
	}

	public static void setColor1(Color color1) {
		FrmDrawing.color1 = color1;
	}
	public static Color getColor2() {
		return color2;
	}

	public static void setColor2(Color color2) {
		FrmDrawing.color2 = color2;
	}
}
