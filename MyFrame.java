import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	
	private Connection connection_Employees = null;
	private PreparedStatement statement_Employees = null; 
	ResultSet result_Employees = null;
	int id_Employees = -1;
	
	private Connection connection_Positions = null;
	private PreparedStatement statement_Positions = null; 
	ResultSet result_Positions = null;
	int id_Positions = -1;
	
	private Connection connection_Contracts = null;
	private PreparedStatement statement_Contracts = null; 
	ResultSet result_Contracts = null;
	int id_Contracts = -1;
	
	private Connection connection_Reference = null;
	private PreparedStatement statement_Reference = null; 
	ResultSet result_Reference = null;
	int id_Reference = -1;
	
	JTabbedPane tab = new JTabbedPane();
	
	//Табове
	JPanel Employees = new JPanel();
	JPanel Positions = new JPanel();
	JPanel Contracts = new JPanel();
	JPanel Reference = new JPanel();
	
	//Employees
	JPanel FirstPanelE = new JPanel();
	JPanel SecondPanelE = new JPanel();
	JPanel ThirdPanelE = new JPanel();
	
	JLabel nameL = new JLabel("Име и Фамилия:");
	JLabel birthdayL = new JLabel("Дата на раждане:");
	JLabel emailL = new JLabel("Имейл:");
	JLabel cityL = new JLabel("Град:");
	JLabel position_idL = new JLabel("Позиция:");
	
	JTextField nameTF = new JTextField();
	JTextField birthdayTF = new JTextField("гггг-мм-дд");
	JTextField emailTF = new JTextField();
	JTextField cityTF = new JTextField();
	
	JComboBox<String> positionCombo = new JComboBox<String>();

	JButton addBtnE = new JButton("Добавяне");
	JButton deleteBtnE = new JButton("Изтриване");
	JButton editBtnE = new JButton("Редактиране");
	JComboBox<String> searchComboE = new JComboBox<String>();
	JButton searchBtnE = new JButton("Търси");
	JButton refreshBtnE = new JButton("Обновяване");
	
	JTable table_Employees = new JTable();
	JScrollPane scroll_Employees =new JScrollPane(table_Employees);
	//end Employees
	
	//Positions
	JPanel FirstPanelP = new JPanel();
	JPanel SecondPanelP = new JPanel();
	JPanel ThirdPanelP = new JPanel();
	
	JLabel titlePL = new JLabel("Позиция:");
	
	JTextField titlePTF= new JTextField();
	
	JButton addBtnP = new JButton("Добавяне");
	JButton deleteBtnP = new JButton("Изтриване");
	JButton editBtnP = new JButton("Редактиране");
	JComboBox<String> searchComboP = new JComboBox<String>();
	JButton searchBtnP = new JButton("Търси");
	JButton refreshBtnP = new JButton("Обновяване");
	
	JTable table_Positions = new JTable();
	JScrollPane scroll_Positions =new JScrollPane(table_Positions);
	//end Positions
	
	//Contracts
	JPanel FirstPanelC = new JPanel();
	JPanel SecondPanelC = new JPanel();
	JPanel ThirdPanelC = new JPanel();
	
	JLabel employee_idL = new JLabel("Име:");
	JLabel contracttypeCL = new JLabel("Вид договор:");
	JLabel startdateL = new JLabel("Дата на постъпване:");
	
	JComboBox<String> employeeCombo = new JComboBox<String>();
	JTextField contracttypeCTF = new JTextField();
	JTextField startdateTF = new JTextField("гггг-мм-дд");
	
	JButton addBtnC = new JButton("Добавяне");
	JButton deleteBtnC = new JButton("Изтриване");
	JButton editBtnC = new JButton("Редактиране");
	JComboBox<String> searchComboC = new JComboBox<String>();
	JButton searchBtnC = new JButton("Търси");
	JButton refreshBtnC = new JButton("Обновяване");
	
	JTable table_Contracts = new JTable();
	JScrollPane scroll_Contracts =new JScrollPane(table_Contracts);
	//end Contract
	
	//Reference
	JPanel FirstPanelR = new JPanel();
	JPanel SecondPanelR = new JPanel();
	JPanel ThirdPanelR = new JPanel();
	
	JLabel ReferenceCityL = new JLabel("Град");
	JLabel ReferencePositionL = new JLabel("Позиция");
	
	JComboBox<String> searchComboReferenceCity = new JComboBox<String>();
	JComboBox<String> searchComboReferencePosition = new JComboBox<String>();
	
	JButton searchBtnR = new JButton("Търсене");
	
    JTable table_Reference = new JTable();
	JScrollPane scroll_Reference =new JScrollPane(table_Reference);
	
	
	public MyFrame() {
		
		this.setSize(560, 640);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tab.add(Employees, "Служители");
		tab.add(Positions, "Позиции");
		tab.add(Contracts, "Договори");
		tab.add(Reference, "Справка");
		
		this.add(tab);
		
		//Employees
		Employees.setLayout(new GridLayout(3, 1));
		FirstPanelE.setLayout(new GridLayout(5, 2));
		SecondPanelE.setLayout(new FlowLayout());
		
		FirstPanelE.add(nameL); FirstPanelE.add(nameTF);
		FirstPanelE.add(birthdayL); FirstPanelE.add(birthdayTF); 
		FirstPanelE.add(emailL); FirstPanelE.add(emailTF);
		FirstPanelE.add(cityL); FirstPanelE.add(cityTF);
		FirstPanelE.add(position_idL); FirstPanelE.add(positionCombo);
		
		SecondPanelE.add(addBtnE);
		SecondPanelE.add(deleteBtnE);
		SecondPanelE.add(editBtnE);
		SecondPanelE.add(searchComboE);
		SecondPanelE.add(searchBtnE);
		SecondPanelE.add(refreshBtnE);
		
		scroll_Employees.setPreferredSize(new Dimension(450,150));
		ThirdPanelE.add(scroll_Employees);
		table_Employees.setModel(DBHelper.getAllDataEmployees());
		table_Employees.addMouseListener(new TableListenerEmployees());
		
		Employees.add(FirstPanelE);
		Employees.add(SecondPanelE);
		Employees.add(ThirdPanelE);
		//end Employees
		
		//Positions
		Positions.setLayout(new GridLayout(3, 1));
		FirstPanelP.setLayout(new GridLayout(1, 2));
		SecondPanelP.setLayout(new FlowLayout());
		
		FirstPanelP.add(titlePL); FirstPanelP.add(titlePTF);
		
		SecondPanelP.add(addBtnP);
		SecondPanelP.add(deleteBtnP);
		SecondPanelP.add(editBtnP);
		SecondPanelP.add(searchComboP);
		SecondPanelP.add(searchBtnP);
		SecondPanelP.add(refreshBtnP);
		
		scroll_Positions.setPreferredSize(new Dimension(450,150));
		ThirdPanelP.add(scroll_Positions);
		table_Positions.setModel(DBHelper.getAllDataPositions());
		table_Positions.addMouseListener(new TableListenerPositions());
		
		Positions.add(FirstPanelP);
		Positions.add(SecondPanelP);
		Positions.add(ThirdPanelP);
		//end Positions
		
		//Contracts
		Contracts.setLayout(new GridLayout(3, 1));
		FirstPanelC.setLayout(new GridLayout(3, 2));
		SecondPanelC.setLayout(new FlowLayout());
		
		FirstPanelC.add(employee_idL); FirstPanelC.add(employeeCombo);
		FirstPanelC.add(contracttypeCL); FirstPanelC.add(contracttypeCTF);
		FirstPanelC.add(startdateL); FirstPanelC.add(startdateTF);
		
		SecondPanelC.add(addBtnC);
		SecondPanelC.add(deleteBtnC);
		SecondPanelC.add(editBtnC);
		SecondPanelC.add(searchComboC);
		SecondPanelC.add(searchBtnC);
		SecondPanelC.add(refreshBtnC);
		
		scroll_Contracts.setPreferredSize(new Dimension(450,150));
		ThirdPanelC.add(scroll_Contracts);
		table_Contracts.setModel(DBHelper.getAllDataContracts());
		table_Contracts.addMouseListener(new TableListenerContracts());
		
		Contracts.add(FirstPanelC);
		Contracts.add(SecondPanelC);
		Contracts.add(ThirdPanelC);
		//end Contracts
		
		//Reference
		Reference.setLayout(new GridLayout(3, 1));
		FirstPanelR.setLayout(new GridLayout(2, 2));
		SecondPanelR.setLayout(new FlowLayout());
		
		FirstPanelR.add(ReferenceCityL); FirstPanelR.add(searchComboReferenceCity);
		FirstPanelR.add(ReferencePositionL); FirstPanelR.add(searchComboReferencePosition);
		
		SecondPanelR.add(searchBtnR);
		
		scroll_Reference.setPreferredSize(new Dimension(450,150));
		ThirdPanelR.add(scroll_Reference);
		
		Reference.add(FirstPanelR);
		Reference.add(SecondPanelR);
		Reference.add(ThirdPanelR);
		//end Reference
		
		//Buttons
		addBtnE.addActionListener(new AddActionEmployees());
		deleteBtnE.addActionListener(new DeleteActionEmployees());
		DBHelper.fillComboE(searchComboE);
		searchBtnE.addActionListener(new SearchActionEmployees());
		editBtnE.addActionListener(new EditActionEmployees());
		refreshBtnE.addActionListener(new RefreshActionEmployees());
		
		addBtnP.addActionListener(new AddActionPositions());
		deleteBtnP.addActionListener(new DeleteActionPositions());
		DBHelper.fillComboP(searchComboP);
		searchBtnP.addActionListener(new SearchActionPositions());
		editBtnP.addActionListener(new EditActionPositions());
		refreshBtnP.addActionListener(new RefreshActionPositions());
		
		addBtnC.addActionListener(new AddActionContracts());
		deleteBtnC.addActionListener(new DeleteActionContracts());
		DBHelper.fillComboC(searchComboC);
		searchBtnC.addActionListener(new SearchActionContracts());
		editBtnC.addActionListener(new EditActionContracts());
		refreshBtnC.addActionListener(new RefreshActionContracts());
		
		searchBtnR.addActionListener(new SearchActionReference());
		DBHelper.fillComboReferenceCity(searchComboReferenceCity);
		DBHelper.fillComboReferencePosition(searchComboReferencePosition);
		
		refreshComboE();
		refreshComboP(); 
		
		refreshTable_Employees();
		refreshTable_Positions();
		refreshTable_Contracts();
		
		this.setVisible(true);
	}
	
	public void clearForm() {
		nameTF.setText("");
		birthdayTF.setText("");
		emailTF.setText("");
		cityTF.setText("");
	}
		
	public void refreshComboE() {
		employeeCombo.removeAllItems();
		
		String sqlEmployees="SELECT EMPLOYEE_ID, NAME, BIRTHDAY, EMAIL, POSITION_ID FROM EMPLOYEES";
		connection_Employees=DBHelper.getConnectionE();
		String item=" ";
		
		try {
			statement_Employees=connection_Employees.prepareStatement(sqlEmployees);
			result_Employees=statement_Employees.executeQuery();
			while(result_Employees.next()) {
				item=result_Employees.getObject(1).toString()+"."+result_Employees.getObject(2).toString();
				employeeCombo.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refreshComboP() {
		positionCombo.removeAllItems();
		
		String sqlPostitions="SELECT POSITION_ID, POSITION_TITLE FROM POSITIONS";
		connection_Positions=DBHelper.getConnectionP();
		String item=" ";
		
		try {
			statement_Positions=connection_Positions.prepareStatement(sqlPostitions);
			result_Positions=statement_Positions.executeQuery();
			while(result_Positions.next()) {
				item=result_Positions.getObject(1).toString()+"."+result_Positions.getObject(2).toString();
				positionCombo.addItem(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void refreshTable_Employees() {
		connection_Employees=DBHelper.getConnectionE();
		String str="SELECT EMPLOYEE_ID, NAME, BIRTHDAY, EMAIL, CITY, POSITION_ID FROM EMPLOYEES";
		
		try {
			statement_Employees=connection_Employees.prepareStatement(str);
			result_Employees=statement_Employees.executeQuery();
			table_Employees.setModel(new MyModel(result_Employees));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refreshTable_Positions() {
		connection_Positions=DBHelper.getConnectionP();
		String str="SELECT POSITION_ID, POSITION_TITLE FROM POSITIONS";
		
		try {
			statement_Positions=connection_Positions.prepareStatement(str);
			result_Positions=statement_Positions.executeQuery();
			table_Positions.setModel(new MyModel(result_Positions));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refreshTable_Contracts() {
		connection_Contracts=DBHelper.getConnectionC();
		String str="SELECT CONTRACT_ID, EMPLOYEE_ID, CONTRACT_TITLE, STARTDATE FROM CONTRACTS";
		
		try {
			statement_Contracts=connection_Contracts.prepareStatement(str);
			result_Contracts=statement_Contracts.executeQuery();
			table_Contracts.setModel(new MyModel(result_Contracts));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//Добавяне, изтриване, редактиране, обновяване, търсене на Employees
	class AddActionEmployees implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String name = nameTF.getText();
			String birthday = birthdayTF.getText();
			String email = emailTF.getText();
			String city = cityTF.getText();
			String position = positionCombo.getSelectedItem().toString();
			
			connection_Employees = DBHelper.getConnectionE();
			try {
				statement_Employees = connection_Employees.prepareStatement("INSERT INTO EMPLOYEES VALUES(NULL,?,?,?,?,?);");
				statement_Employees.setString(1, name);
				statement_Employees.setString(2, birthday);
				statement_Employees.setString(3, email);
				statement_Employees.setString(4, city);
				statement_Employees.setInt(5, Integer.parseInt(position.substring(0, position.indexOf('.'))));
				
				statement_Employees.execute();
				table_Employees.setModel(DBHelper.getAllDataEmployees());
				DBHelper.fillComboP(searchComboP);
				DBHelper.fillComboC(searchComboC);
				DBHelper.fillComboE(searchComboE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					statement_Employees.close();
					connection_Employees.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clearFormEmployees();
			}
		}
	}
	
	class TableListenerEmployees implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int rowEmployees = table_Employees.getSelectedRow();
			id_Employees = Integer.parseInt(table_Employees.getValueAt(rowEmployees, 0).toString());
			nameTF.setText(table_Employees.getValueAt(rowEmployees, 1).toString());
			birthdayTF.setText(table_Employees.getValueAt(rowEmployees, 2).toString());
			emailTF.setText(table_Employees.getValueAt(rowEmployees, 3).toString());
			cityTF.setText(table_Employees.getValueAt(rowEmployees, 4).toString());
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	class DeleteActionEmployees implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connection_Employees = DBHelper.getConnectionE();
			String sql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
			try {
				statement_Employees = connection_Employees.prepareStatement(sql);
				statement_Employees.setInt(1, id_Employees);
				statement_Employees.execute();
				table_Employees.setModel(DBHelper.getAllDataEmployees());
				id_Employees = -1;
				DBHelper.fillComboP(searchComboP);
				DBHelper.fillComboC(searchComboC);
				DBHelper.fillComboE(searchComboE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearFormEmployees();
		}
		
	}
	
	
	class SearchActionEmployees implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String item = searchComboE.getSelectedItem().toString();
			String[] content = item.split(" ");
			int employeesId = Integer.parseInt(content[0]);
			
			connection_Employees = DBHelper.getConnectionE();
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
			try {
				statement_Employees = connection_Employees.prepareStatement(sql);
				statement_Employees.setInt(1, employeesId);
				result_Employees = statement_Employees.executeQuery();
				table_Employees.setModel(new MyModel(result_Employees));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearFormEmployees();
		}
		
	}
	
	class EditActionEmployees implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			connection_Employees = DBHelper.getConnectionE();
			String sqlEmployees = "UPDATE EMPLOYEES SET NAME=?, BIRTHDAY=?, EMAIL=?, CITY=? WHERE EMPLOYEE_ID=?";
			
			try {
				statement_Employees = connection_Employees.prepareStatement(sqlEmployees);
				statement_Employees.setString(1, nameTF.getText());
				statement_Employees.setString(2, birthdayTF.getText());
				statement_Employees.setString(3, emailTF.getText());
				statement_Employees.setString(4, cityTF.getText());
				statement_Employees.setInt(5,id_Employees);
				statement_Employees.execute();
					
					table_Employees.setModel(DBHelper.getAllDataEmployees());
					DBHelper.fillComboP(searchComboP);
					DBHelper.fillComboC(searchComboC);
					DBHelper.fillComboE(searchComboE);
					refreshComboP();
					refreshTable_Employees();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearFormEmployees();
		}
					
	}
		class RefreshActionEmployees implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				table_Employees.setModel(DBHelper.getAllDataEmployees());
				clearFormEmployees();
			}
			
		}
		
		public void clearFormEmployees() {
			nameTF.setText(" ");
			birthdayTF.setText(" ");
			emailTF.setText(" ");
			cityTF.setText(" ");
		}

//Добавяне, изтриване, редактиране, обновяване, търсене на Positions
		class AddActionPositions implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String titleP = titlePTF.getText();
				
				connection_Positions = DBHelper.getConnectionP();
				try {
					statement_Positions = connection_Positions.prepareStatement("INSERT INTO POSITIONS VALUES(NULL,?);");
					statement_Positions.setString(1, titleP);
					statement_Positions.execute();
					table_Positions.setModel(DBHelper.getAllDataPositions());

					DBHelper.fillComboP(searchComboP);
					DBHelper.fillComboC(searchComboC);
					DBHelper.fillComboE(searchComboE);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						statement_Positions.close();
						connection_Positions.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				clearFormPositions();
			}
		}
		
		class TableListenerPositions implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				int rowPositions = table_Positions.getSelectedRow();
				id_Positions = Integer.parseInt(table_Positions.getValueAt(rowPositions, 0).toString());
				titlePTF.setText(table_Positions.getValueAt(rowPositions, 1).toString());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		}
		
		class DeleteActionPositions implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				connection_Positions = DBHelper.getConnectionP();
				String sqlPositions = "DELETE FROM POSITIONS WHERE POSITION_ID=?";
				try {
					statement_Positions = connection_Positions.prepareStatement(sqlPositions);
					statement_Positions.setInt(1, id_Positions);
					statement_Positions.execute();
					table_Positions.setModel(DBHelper.getAllDataPositions());
					id_Positions = -1;
					
					DBHelper.fillComboP(searchComboP);
					DBHelper.fillComboC(searchComboC);
					DBHelper.fillComboE(searchComboE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				clearFormPositions();
			}
			
		}
		
		class SearchActionPositions implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String item = searchComboP.getSelectedItem().toString();
				String[] content = item.split(" ");
				int positionsId = Integer.parseInt(content[0]);
				
				connection_Positions = DBHelper.getConnectionP();
				String sqlPositions = "SELECT * FROM POSITIONS WHERE POSITION_ID=?";
				try {
					statement_Positions = connection_Positions.prepareStatement(sqlPositions);
					statement_Positions.setInt(1, positionsId);
					result_Positions = statement_Positions.executeQuery();
					table_Positions.setModel(new MyModel(result_Positions));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				clearFormPositions();
			}
			
		}
		
		
		class EditActionPositions implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				connection_Positions = DBHelper.getConnectionP();
				String sqlPositions = "UPDATE POSITIONS SET POSITION_TITLE=? WHERE POSITION_ID=?";
				
				try {
					statement_Positions = connection_Positions.prepareStatement(sqlPositions);
					statement_Positions.setString(1, titlePTF.getText());
					statement_Positions.setInt(2,id_Positions);
					statement_Positions.execute();
						
						table_Positions.setModel(DBHelper.getAllDataPositions());
						
						DBHelper.fillComboP(searchComboP);
						DBHelper.fillComboC(searchComboC);
						DBHelper.fillComboE(searchComboE);
						refreshComboP();
						refreshTable_Employees();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				clearFormPositions();
			}
						
		}
		
		class RefreshActionPositions implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				table_Positions.setModel(DBHelper.getAllDataPositions());
				clearFormPositions();
			}
			
		}
		
		public void clearFormPositions() {
			titlePTF.setText(" ");
		}
		
//Добавяне изтриване редактиране обновяване търсене на Contracts
		class AddActionContracts implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String employee_id = employeeCombo.getSelectedItem().toString();
				String contracttypeC = contracttypeCTF.getText();
				String startdate = startdateTF.getText();
				
				connection_Contracts = DBHelper.getConnectionC();
				try {
					statement_Contracts = connection_Contracts.prepareStatement("INSERT INTO CONTRACTS VALUES(NULL,?,?,?);");
					statement_Contracts.setInt(1, Integer.parseInt(employee_id.substring(0, employee_id.indexOf('.'))));
					statement_Contracts.setString(2, contracttypeC);
					statement_Contracts.setString(3, startdate);
					
					statement_Contracts.execute();
					table_Contracts.setModel(DBHelper.getAllDataContracts());

					DBHelper.fillComboP(searchComboP);
					DBHelper.fillComboC(searchComboC);
					DBHelper.fillComboE(searchComboE);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						statement_Contracts.close();
						connection_Contracts.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				clearFormContracts();
			}
		}
		
		class TableListenerContracts implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				int rowContracts = table_Contracts.getSelectedRow();
				id_Contracts = Integer.parseInt(table_Contracts.getValueAt(rowContracts, 0).toString());
				contracttypeCTF.setText(table_Contracts.getValueAt(rowContracts, 2).toString());
				startdateTF.setText(table_Contracts.getValueAt(rowContracts, 3).toString());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
		class DeleteActionContracts implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				connection_Contracts = DBHelper.getConnectionC();
				String sqlContracts = "DELETE FROM CONTRACTS WHERE CONTRACT_ID=?";
				try {
					statement_Contracts = connection_Contracts.prepareStatement(sqlContracts);
					statement_Contracts.setInt(1, id_Contracts);
					statement_Contracts.execute();
					table_Contracts.setModel(DBHelper.getAllDataContracts());
					id_Contracts = -1;
					refreshTable_Contracts();
					
					DBHelper.fillComboP(searchComboP);
					DBHelper.fillComboC(searchComboC);
					DBHelper.fillComboE(searchComboE);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				clearFormContracts();
				
			}
			
		}
		
		class SearchActionContracts implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String itemContract = searchComboC.getSelectedItem().toString();
				String[] contentContract = itemContract.split(" ");
				int contractId = Integer.parseInt(contentContract[0]);
				
				connection_Contracts = DBHelper.getConnectionC();
				String sqlContract = "SELECT * FROM CONTRACTS WHERE CONTRACT_ID=?";
				try {
					statement_Contracts = connection_Contracts.prepareStatement(sqlContract);
					statement_Contracts.setInt(1, contractId);
					result_Contracts = statement_Contracts.executeQuery();
				
					table_Contracts.setModel(new MyModel(result_Contracts));
								
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				clearFormContracts();
			}
			
		}
		
		
		class EditActionContracts implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				String sqlContract = "update contracts set employee_id=?, contract_title=?, startdate=? where contract_id=?";
				String employee_id =employeeCombo.getSelectedItem().toString();
				String contracttypeC = contracttypeCTF.getText();
				String startdate = startdateTF.getText();
				
				
				connection_Contracts = DBHelper.getConnectionC();
				try {
					statement_Contracts = connection_Contracts.prepareStatement(sqlContract);
					statement_Contracts.setString(1, contracttypeCTF.getText());
					statement_Contracts.setString(2, startdateTF.getText());
					statement_Contracts.setInt(3, Integer.parseInt(employee_id.substring(0, employee_id.indexOf('.'))));
				
					refreshTable_Contracts();
					DBHelper.fillComboP(searchComboP);
					DBHelper.fillComboC(searchComboC);
					DBHelper.fillComboE(searchComboE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						statement_Contracts.close();
						connection_Contracts.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				clearFormContracts();
			}
			
		}
		
		class RefreshActionContracts implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				table_Contracts.setModel(DBHelper.getAllDataContracts());
				clearFormContracts();
			}
			
		}
		
		public void clearFormContracts() {
			contracttypeCTF.setText(" ");
			startdateTF.setText(" ");
		}
		
		
		class SearchActionReference implements ActionListener{

	        @Override
	        public void actionPerformed(ActionEvent e) {

	            String itemReferenceCity = searchComboReferenceCity.getSelectedItem().toString();
	            String[] contentReferenceCity = itemReferenceCity.split(" ");
	            int employeeId = Integer.parseInt(contentReferenceCity[0]);

	            String itemReferencePosition = searchComboReferencePosition.getSelectedItem().toString();
	            String[] contentReferencePosition = itemReferencePosition.split(" ");
	            int positionId = Integer.parseInt(contentReferencePosition[0]);
	            
	            connection_Reference = DBHelper.getConnectionR();
	            
                String sql_Reference = "";
	            try {
	               
	                statement_Reference = connection_Reference.prepareStatement(sql_Reference);
	                statement_Reference.setInt(1, employeeId );
	                statement_Reference.setInt(2, positionId);
	                result_Reference = statement_Reference.executeQuery();
	                table_Reference.setModel(new MyModel(result_Reference));
	                
	                DBHelper.fillComboE(searchComboE);
					DBHelper.fillComboP(searchComboP);
	                
	            } catch (SQLException e1) {
	                // TODO Auto-generated catch block
	                e1.printStackTrace();
	            } catch (Exception e1) {
	                // TODO Auto-generated catch block
	                e1.printStackTrace();
	            }


	        }

	    }
		
		
	}

		
	

	


