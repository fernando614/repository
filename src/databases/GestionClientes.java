package databases;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
public class GestionClientes {
	/*
	 * En este pequeño ejemplo creamos una conexión sencilla a nuestra bd llamada gestion_clientes
	 */
	public static void main(String[] args){
		//url para mi conexión a mi bd gestion_clientes
		String url = "jdbc:mysql://localhost:3306/gestion_clientes";	
		//establezco mi conexión
		String username = "root";
		String password = "12345678";
		//usar un try with resources
		try (Connection conn = DriverManager.getConnection(url,username,password);
				Statement state = conn.createStatement(); Statement state1 = conn.createStatement(); ){//ahora creo los statementes
			
			System.out.println("conexion completed!");
			
			//esto es para agregar un fila a mi tabla customers
			//String insertRow = "INSERT INTO customers VALUES(6,'beto@gmail.com','Beto','Olivera')";
			//state.executeUpdate(insertRow);
			//y guardo la consulta que hago en un un resulset
			ResultSet rs = state.executeQuery("SELECT * FROM Customers");
			//ahora solo quiero obtener un registro
			ResultSet rs1 = state1.executeQuery("SELECT count(*) FROM customers");
			while(rs1.next()) {
				System.out.println(rs1.getInt(1));
			}
			//ahora un while para iterar sobre el resultset rs para obtener los valores
			//voy hacer un map para guardar el id y el nombre del cliente 
			Map<Integer,String> data = new HashMap<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				data.put(id, name);
				//System.out.println(rs.getInt("id") + " " + rs.getString("name"));
			}
			//imprimo mi mapa
			System.out.println(data);

		}catch(SQLException e) {
			System.out.println("conexion not completed!");
			e.printStackTrace();
			 
		}
	}

}
