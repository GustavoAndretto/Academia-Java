package model;

import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public List<Aluno> listarAlunos() throws SQLException {    
        String query = "SELECT * FROM `aluno`";

        List<Aluno> alunos = new ArrayList<Aluno>();
        
        PreparedStatement pst = conn.prepareStatement(query);

        ResultSet rs = pst.executeQuery();

        while(rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String telefone = rs.getString("telefone");

            alunos.add(new Aluno(id, nome, email, telefone));
        }

        return alunos;
    }
}