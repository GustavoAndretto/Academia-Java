import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BibliotecaDB {
    private Connection conn;

    BibliotecaDB(String uri, String driver) throws SQLException {
        try {
            Class.forName(driver);

            this.conn = DriverManager.getConnection(uri);
        }
        catch(SQLException e) {
            throw e;
        }
        catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
    }

    public boolean insereLivro(Livro livro) throws SQLException {
        String query = "INSERT INTO `livro` (`isbn`, `titulo`, `ano`, `Categoria_id`, `Editora_id`) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pst = conn.prepareStatement(query);

        // Se o Isbn de livro for 0, define o PK como null, a inserção utilizará o Auto Increment
        if(livro.getIsbn() == 0) {
            pst.setString(1, "null");
        }
        else {
            pst.setInt(1, livro.getIsbn());
        }

        pst.setString(2, livro.getTitulo());
        pst.setInt(3, livro.getAno());
        pst.setInt(4, livro.getCategoria());
        pst.setInt(5, livro.getEditora());

        return pst.execute();
    }

    //public List<Livro> listarLivros() throws SQLException {
    //    return selectLivros("SELECT * FROM `livro` ORDER BY `titulo` ASC");
    //}

    //public List<Livro> listarLivrosEditora(Editora editora) throws SQLException {
    //    return selectLivros("SELECT * FROM `livro` WHERE `editora.id`=? AND `editora.nome`=? ORDER BY `titulo` ASC");
    //}

    public List<Livro> listarLivrosCategoria(Categoria categoria) throws SQLException {
        String query = "SELECT * FROM `livro`,`categoria` WHERE categoria.id=livro.Categoria_id AND categoria.nome=? ORDER BY `titulo` ASC";

        List<Livro> livros = new ArrayList<Livro>();
        
        PreparedStatement pst = conn.prepareStatement(query);

        pst.setString(1, categoria.getNome());

        ResultSet rs = pst.executeQuery();

        while(rs.next()) {
            int isbn = rs.getInt("isbn");
            String titulo = rs.getString("titulo");
            int ano = rs.getInt("ano");
            int cat = rs.getInt("Categoria_id");
            int editora = rs.getInt("Editora_id");

            livros.add(new Livro(isbn, titulo, ano, cat, editora));
        }

        return livros;
    }

    public boolean atualizaLivro(Livro livro) throws SQLException {
        String query = "UPDATE `livro` SET `titulo`=?, `ano`=?, `Categoria_id`=?, `Editora_id`=? WHERE `isbn`= ?";

        var pst = conn.prepareStatement(query);
        pst.setString(1, livro.getTitulo());
        pst.setInt(2, livro.getAno());
        pst.setInt(3, livro.getCategoria());
        pst.setInt(4, livro.getEditora());
        pst.setInt(5, livro.getIsbn());

        return pst.execute();
    }

    public boolean deletaLivro(int isbn) throws SQLException {
        String query = "DELETE FROM `livro` WHERE `isbn`=?";

        var pst = conn.prepareStatement(query);
        pst.setInt(1, isbn);

        return pst.execute();
    }

    public boolean deletaLivro(String titulo) throws SQLException {
        String query = "DELETE FROM `livro` WHERE `titulo`=?";

        var pst = conn.prepareStatement(query);
        pst.setString(1, titulo);

        return pst.execute();
    }
}

