package model;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
    private java.sql.Connection conn;

    public DAO(String uri, String driver) throws SQLException, ClassNotFoundException {
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

    public boolean inserirAluno(Aluno aluno) throws SQLException {
        String query = "INSERT INTO `aluno` (`id`, `nome`, `email`, `telefone`) VALUES (?, ?, ?, ?)";

        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, aluno.getId());
        pst.setString(2, aluno.getNome());
        pst.setString(3, aluno.getEmail());
        pst.setString(4, aluno.getTelefone());

        return pst.execute();
    }
}
