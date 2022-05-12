import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            BibliotecaDB biblioteca = new BibliotecaDB(
                "jdbc:mysql://localhost/biblioteca?user=root&password=Atos@2022", 
                "com.mysql.cj.jdbc.Driver");

            Livro livro = new Livro(1928739, "Harry Potter e o Calice de Fogo", 2006, 1, 1);

            try {
                // Insere o livro no banco de dados
                biblioteca.insereLivro(livro);
            } catch (SQLException e) {
                // Caso o livro já exista no banco de dados com a PK inserida, imprime na tela que o livro já existe
                System.out.println("Falha ao inserir: Livro já existe no banco de dados com este isbn\n");
            }

            // Imprime a lista de livros após o INSERT
            System.out.println("[biblioteca.imprimeLivros() Após INSERT]");
            biblioteca.imprimeLivros(); // Retorna a consulta: "SELECT * FROM livro"
            System.out.println("");

            
            // Atualiza o livro com o isbn 192839
            biblioteca.atualizaLivro(1928739, "Harry Potter e a Ordem da Fenix", 2007, 1, 1);

            // Imprime a lista de livros após o UPDATE
            System.out.println("[biblioteca.imprimeLivros() Após UPDATE]");
            biblioteca.imprimeLivros();
            System.out.println("");

            // DELETE
            biblioteca.deletaLivro(1928739);

            // Imprime a lista de livros após o DELETE
            System.out.println("[biblioteca.imprimeLivros() Após DELETE]");
            biblioteca.imprimeLivros();
            System.out.println("");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
