import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class HelloJDBC{
	
	//postgreSQL 연동
    public Connection connect() {
    	String url = "jdbc:postgresql://localhost:5432/JDBC";
    	String user = "postgres";
        String password = "tjrghks96";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
    
    //테이블 생성
    public void CreateTable(Connection conn) {
    	String CREATE_TABLE_SQL_CUSTOMER="create table Customer("
                + "CustomerID text PRIMARY key,"
                + "CustomerName TEXT,"
                + "Country TEXT)";
    	String CREATE_TABLE_SQL_ORDERS="create table Orders("
                + "OrderId text,"
                + "CustomerID TEXT,"
                + "OrderDate DATE,"
                + "Amount INTEGER)";
    	Statement stmt = null;
        try {
			stmt = conn.createStatement();
			stmt.executeUpdate(CREATE_TABLE_SQL_CUSTOMER);
			stmt.executeUpdate(CREATE_TABLE_SQL_ORDERS);	
			System.out.println("New tables are created successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    // 테이블 삭제
    public void DropTable(Connection conn) {
    	String DROP_TABLE_SQL_CUSTOMER="DROP TABLE customer";
    	String CREATE_TABLE_SQL_ORDERS="DROP TABLE orders";
    	Statement stmt = null;
        try {
			stmt = conn.createStatement();
			stmt.executeUpdate(DROP_TABLE_SQL_CUSTOMER);
			stmt.executeUpdate(CREATE_TABLE_SQL_ORDERS);	
			System.out.println("Tables are droped successfully.");
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //테이블에 데이터 입력
    public void InsertValues(Connection conn) {
    	String INSERT_VALUES_CUSTOMER = "INSERT INTO customer VALUES" + 
    			"    ('CutomerID1', 'Jacob','India')," + 
    			"    ('CutomerID2', 'Michael', 'USA')," + 
    			"    ('CutomerID3', 'Joshuna', 'India')," + 
    			"    ('CutomerID4', 'Matthew', 'USA')," + 
    			"    ('CutomerID5', 'Suhee', 'Korea')," + 
    			"    ('CutomerID6', 'Youngbok', 'Korea')," + 
    			"    ('CutomerID7', 'Lucas', 'India')," + 
    			"    ('CutomerID8', 'Mane', 'UK')," + 
    			"    ('CutomerID9', 'Alexander', 'USA')," + 
    			"    ('CutomerID10', 'James', 'Germany');";
    	String INSERT_VALUES_ORDERS = "INSERT INTO Orders VALUES" + 
    			"    ('OrderID1', 'CutomerID1', CURRENT_DATE, 1000)," + 
    			"    ('OrderID2', 'CutomerID1', CURRENT_DATE, 1100)," + 
    			"    ('OrderID3', 'CutomerID1', CURRENT_DATE, 1200)," + 
    			"    ('OrderID4', 'CutomerID7', CURRENT_DATE, 1300)," + 
    			"    ('OrderID5', 'CutomerID7', CURRENT_DATE, 1400)," + 
    			"    ('OrderID6', 'CutomerID3', CURRENT_DATE, 1500)," + 
    			"    ('OrderID7', 'CutomerID2', CURRENT_DATE, 1600)," + 
    			"    ('OrderID8', 'CutomerID5', CURRENT_DATE, 1700)," + 
    			"    ('OrderID9', 'CutomerID5', CURRENT_DATE, 1800)," + 
    			"    ('OrderID10', 'CutomerID4', CURRENT_DATE, 1900)," + 
    			"    ('OrderID11', 'CutomerID9', CURRENT_DATE, 2000);";
    	Statement stmt = null;
        try {
			stmt = conn.createStatement();
			stmt.executeUpdate(INSERT_VALUES_CUSTOMER);
			stmt.executeUpdate(INSERT_VALUES_ORDERS);
			System.out.println("New values are inserted successfully.");
	    	stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //간단한 select query 실행
    public void selectAllCustomer(Connection conn){
    	Statement stmt = null;
    	try {
			stmt = conn.createStatement();
	    	ResultSet rs = stmt.executeQuery("Select * from customer;");
	    	while(rs.next()) {
	    		System.out.println("---------------------------------------------------");
	    		System.out.println("CustomerID: "+rs.getString("CustomerID"));
	    		System.out.println("CustomerName: "+rs.getString("CustomerName"));
	    		System.out.println("Country: "+rs.getString("Country"));
	    	}
	    	rs.close();
	    	stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //간단한 select query 실행
    public void selectAllOrders(Connection conn){
    	Statement stmt = null;
    	try {
			stmt = conn.createStatement();
	    	ResultSet rs = stmt.executeQuery("Select * from orders;");
	    	while(rs.next()) {
	    		System.out.println("---------------------------------------------------");
	    		System.out.println("OrderId: "+rs.getString("OrderId"));
	    		System.out.println("CustomerID: "+rs.getString("CustomerID"));
	    		System.out.println("OrderDate: "+rs.getDate("OrderDate"));
	    		System.out.println("Amount: "+rs.getInt("Amount"));
	    	}
	    	rs.close();
	    	stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void selectCustomerFromIndia(Connection conn, String country){
    	PreparedStatement pstmt = null;
    	try {
    		pstmt = conn.prepareStatement("Select * from customer where country = ?");
    		pstmt.setString(1,country);
	    	ResultSet rs = pstmt.executeQuery();
	    	while(rs.next()) {
	    		System.out.println("---------------------------------------------------");
	    		System.out.println("CustomerID: "+rs.getString("CustomerID"));
	    		System.out.println("CustomerName: "+rs.getString("CustomerName"));
	    		System.out.println("Country: "+rs.getString("Country"));
	    	}
	    	rs.close();
	    	pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void SelectCustomeNamerMoreThanOneOrther(Connection conn) {
    	Statement stmt = null;
    	try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT DISTINCT cus.CustomerName FROM Customer"
					+ " as cus WHERE EXISTS (Select cus From Customer," + 
					" Orders where cus.CustomerID = Orders.CustomerID);");
			while(rs.next()){
				System.out.println("---------SelectCustomerMoreThanOneOrther--------");
				System.out.println("CustmerName: " + rs.getString("CustomerName"));
			}
	    	rs.close();
	    	stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
 
    //main
    public static void main(String[] args) {
    	try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver registered.");
        } catch (ClassNotFoundException e) {
            System.out.println("You didn't register driver");
        }
        HelloJDBC practice = new HelloJDBC();
        Connection conn = practice.connect();
        practice.CreateTable(conn);
        practice.InsertValues(conn);
        practice.selectAllCustomer(conn);
        practice.selectAllOrders(conn);
        practice.selectCustomerFromIndia(conn, "India");
        practice.SelectCustomeNamerMoreThanOneOrther(conn);
        practice.DropTable(conn);
        try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}