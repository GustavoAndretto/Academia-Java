import java.sql.SQLException;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BibliotecaDB {
    private Connection conn;

    // Driver e Conexão e Driver
    BibliotecaDB(String uri, String driver) throws SQLException, ClassNotFoundException {
        try {
            Class.forName(driver);

            this.conn = DriverManager.getConnection(uri);
        }
        catch(SQLException e) {
            throw e;
        }
        catch (ClassNotFoundException e) {
            throw new SQLException("SQL Exception: Não foi possível encontrar o driver " + driver);
        }
    }

    // CREATE(INSET)
    boolean insereLivro(Livro livro) throws SQLException {
        String query = String.format(
            "INSERT INTO livro (`isbn`, `titulo`, `ano`, `Categoria_id`, `Editora_id`) " +
            "VALUES (?, ?, ?, ?, ?)");

        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, livro.isbn);
        pst.setString(2, livro.titulo);
        pst.setInt(3, livro.ano);
        pst.setInt(4, livro.categoria);
        pst.setInt(5, livro.editora);

        return pst.execute();
    }

    // READ(SELECT)
    void imprimeLivros() throws SQLException {
        String query = "SELECT * FROM livro ORDER BY titulo ASC";
        
        ResultSet rs = conn.createStatement().executeQuery(query);

        while(rs.next()) {
            int isbn = rs.getInt("isbn");
            String titulo = rs.getString("titulo");
            int ano = rs.getInt("ano");
            int categoria = rs.getInt("Categoria_id");
            int editora = rs.getInt("Editora_id");

            System.out.printf("%d %s %d %d %d\n", isbn, titulo, ano, categoria, editora);
        }
    }

    // UPDATE(UPDATE)
    boolean atualizaLivro(int isbn, String titulo, int ano, int categoria, int editora) throws SQLException {
        String query = String.format("UPDATE `livro` SET `titulo`=?, `ano`=?, `Categoria_id`=?, `Editora_id`=? WHERE `isbn`= ?");

        var pst = conn.prepareStatement(query);
        pst.setString(1, titulo);
        pst.setInt(2, ano);
        pst.setInt(3, categoria);
        pst.setInt(4, editora);
        pst.setInt(5, isbn);

        return pst.execute();
    }

    // DELETE(DELETE)
    boolean deletaLivro(int isbn) throws SQLException {
        String query = String.format("DELETE FROM livro WHERE isbn=?");

        var pst = conn.prepareStatement(query);
        pst.setInt(1, isbn);

        return pst.execute();
    }
}