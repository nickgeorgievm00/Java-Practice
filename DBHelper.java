import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JComboBox;

public class DBHelper {
	
		public static Connection connection_Employees = null;
		public static MyModel model_Employees = null;
		public static PreparedStatement statement_Employees = null;
		public static ResultSet result_Employees = null;

		public static Connection connection_Positions = null;
		public static MyModel model_Positions = null;
		public static PreparedStatement statement_Positions = null;
		public static ResultSet result_Positions = null;
		
		public static Connection connection_Contracts = null;
		public static MyModel model_Contracts = null;
		public static PreparedStatement statement_Contracts = null;
		public static ResultSet result_Contracts = null;
			
		public static Connection connection_Reference = null;
		public static MyModel model_Reference = null;
		public static PreparedStatement statement_Reference = null;
		public static ResultSet result_Reference = null;
	
		
	static void fillComboE(JComboBox<String> comboE) {
		
		connection_Employees = getConnectionE();
		String sqlEmployees = "SELECT EMPLOYEE_ID, NAME FROM EMPLOYEES";
		try {
			statement_Employees = connection_Employees.prepareStatement(sqlEmployees);
			result_Employees = statement_Employees.executeQuery();
			comboE.removeAllItems(); 
			while(result_Employees.next()) {
				String itemEmployees = result_Employees.getObject(1).toString() + " " + result_Employees.getObject(2).toString();
				comboE.addItem(itemEmployees);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	static void fillComboP(JComboBox<String> comboP) {
		
		connection_Positions = getConnectionP();
		String sqlPositions = "SELECT POSITION_ID, POSITION_TITLE FROM POSITIONS";
		try {
			statement_Positions = connection_Positions.prepareStatement(sqlPositions);
			result_Positions = statement_Positions.executeQuery();
			comboP.removeAllItems(); 
			while(result_Positions.next()) {
				String itemPositions = result_Positions.getObject(1).toString() + " " + result_Positions.getObject(2).toString();
				comboP.addItem(itemPositions);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	static void fillComboC(JComboBox<String> comboC) {
		
		connection_Contracts = getConnectionC();
		String sqlContracts = "SELECT CONTRACT_ID, CONTRACT_TITLE FROM CONTRACTS";
		try {
			statement_Contracts = connection_Contracts.prepareStatement(sqlContracts);
			result_Contracts = statement_Contracts.executeQuery();
			comboC.removeAllItems(); 
			while(result_Contracts.next()) {
				String itemContracts = result_Contracts.getObject(1).toString() + " " + result_Contracts.getObject(2).toString();
				comboC.addItem(itemContracts);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void fillComboReferenceCity(JComboBox<String> comboReferenceCity) {
		
		connection_Reference = getConnectionR();
		String sqlReference = "SELECT EMPLOYEE_ID, CITY FROM EMPLOYEES";
		try {
			statement_Reference = connection_Reference.prepareStatement(sqlReference);
			result_Reference = statement_Reference.executeQuery();
			comboReferenceCity.removeAllItems(); 
			while(result_Reference.next()) {
				String itemReference = result_Reference.getObject(1).toString() + " " + result_Reference.getObject(2).toString();
				comboReferenceCity.addItem(itemReference);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	static void fillComboReferencePosition(JComboBox<String> comboReferencePosition) {
		
		connection_Reference = getConnectionR();
		String sqlReference = "SELECT POSITION_ID, POSITION_TITLE FROM POSITIONS";
		try {
			statement_Reference = connection_Reference.prepareStatement(sqlReference);
			result_Reference = statement_Reference.executeQuery();
			comboReferencePosition.removeAllItems(); 
			while(result_Reference.next()) {
				String itemReference = result_Reference.getObject(1).toString() + " " + result_Reference.getObject(2).toString();
				comboReferencePosition.addItem(itemReference);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

static Connection getConnectionE() {
	
	try {
		Class.forName("org.h2.Driver");
		connection_Employees=DriverManager.getConnection("jdbc:h2:C:\\\\Users\\\\user\\\\Desktop\\\\UniWork\\\\Практикум\\\\КурсовПроект\\\\HRDB;AUTO_SERVER=TRUE", "nick.ngm", "631200");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	return connection_Employees;
}

static Connection getConnectionP() {
	
	try {
		Class.forName("org.h2.Driver");
		connection_Positions=DriverManager.getConnection("jdbc:h2:C:\\\\Users\\\\user\\\\Desktop\\\\UniWork\\\\Практикум\\\\КурсовПроект\\\\HRDB;AUTO_SERVER=TRUE", "nick.ngm", "631200");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	return connection_Positions;
}

static Connection getConnectionC() {
	
	try {
		Class.forName("org.h2.Driver");
		connection_Contracts=DriverManager.getConnection("jdbc:h2:C:\\\\Users\\\\user\\\\Desktop\\\\UniWork\\\\Практикум\\\\КурсовПроект\\\\HRDB;AUTO_SERVER=TRUE", "nick.ngm", "631200");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	return connection_Contracts;
}

static Connection getConnectionR() {
	
	try {
		Class.forName("org.h2.Driver");
		connection_Reference=DriverManager.getConnection("jdbc:h2:C:\\\\Users\\\\user\\\\Desktop\\\\UniWork\\\\Практикум\\\\КурсовПроект\\\\HRDB;AUTO_SERVER=TRUE", "nick.ngm", "631200");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	return connection_Reference;
}
	/*public static Connection getConnection() {
		
		try {
			String driver = "";
			String url = "";
			String user = "";
			String password = "";
			
			File configuration = new File("C:\\Users\\user\\Desktop\\Configuration.txt");
			Scanner scan = new Scanner(configuration);
			
			while (scan.hasNextLine()) {
				driver = scan.nextLine().trim();
				url = scan.nextLine().trim();
				user = scan.nextLine().trim();
				password = scan.nextLine().trim();
				break;
			}
			
			Class.forName(driver);
			connection_Employees = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection_Employees;
	}*/
	
	
	public static MyModel getAllDataEmployees() {
	
	connection_Employees = getConnectionE();
	try {
		statement_Employees = connection_Employees.prepareStatement("SELECT * FROM EMPLOYEES");
		result_Employees = statement_Employees.executeQuery();
		model_Employees = new MyModel(result_Employees);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return model_Employees;		
	}
	
	
	public static MyModel getAllDataPositions() {
		
		connection_Positions = getConnectionP();
		try {
			statement_Positions = connection_Positions.prepareStatement("SELECT * FROM POSITIONS");
			result_Positions = statement_Positions.executeQuery();
			model_Positions = new MyModel(result_Positions);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model_Positions;		
		}
	

	public static MyModel getAllDataContracts() {
		
		connection_Contracts = getConnectionC();
		try {
			statement_Contracts = connection_Contracts.prepareStatement("SELECT * FROM CONTRACTS");
			result_Contracts = statement_Contracts.executeQuery();
			model_Contracts = new MyModel(result_Contracts);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model_Contracts;		
		}
}
