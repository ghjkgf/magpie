 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
 
public class JDBCConnection {
	public static void jdbcNeo4j() throws ClassNotFoundException, SQLException{
		Class.forName("org.neo4j.driver.Driver");
		String url ="jdbc:neo4j:http://localhost:7890";
		Connection conn = DriverManager.getConnection(url, "neo4j", "neo4j");
		
		Statement stmt = conn.createStatement();
		/*ResultSet rs = stmt.executeQuery("match (n) return n.age,n.name,n");
		while(rs.next()) {
			System.out.println(rs.getString("n.name")+"\t"+rs.getString("n.age"));
			System.out.println("rs.getString(\"n\")\t"+rs.getString("n"));
			System.out.println("rs.getString(2)\t"+rs.getString(2));
			System.out.println("rs.getString(3)\t"+rs.getString(3));
		}*/
		ResultSet rs = stmt.executeQuery("match (n) return n limit 10");
		while(rs.next()) {
			System.out.println(rs.getRow());
			System.out.println(rs.getMetaData().getColumnName(0));
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		jdbcNeo4j();
	}
}