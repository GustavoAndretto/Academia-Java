import java.sql.SQLException;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            var conn = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca?user=root&password=Atos@2022");

            String query = "SELECT * FROM livro";

            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                int isbn = rs.getInt("isbn");
                String titulo = rs.getString("titulo");
                int ano = rs.getInt("ano");
                int categoria = rs.getInt("Categoria_id");
                int editora = rs.getInt("Editora_id");

                System.out.printf("%d %s %d %d %d\n", isbn, titulo, ano, categoria, editora);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
