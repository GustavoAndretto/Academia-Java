import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            BibliotecaDB biblioteca = new BibliotecaDB(
                "jdbc:mysql://localhost/biblioteca?user=root&password=Atos@2022", 
                "com.mysql.cj.jdbc.Driver");

            //try {
                // Insere o livro no banco de dados
            //    biblioteca.insereLivro(new Livro(1928739, "Harry Potter e o Calice de Fogo", 2006, 1, 1));
            //} catch (SQLException e) {
                // Caso o livro já exista no banco de dados com a PK inserida, imprime na tela que o livro já existe
            //    System.out.println("Falha ao inserir: Livro já existe no banco de dados com este isbn\n");
            //}
           
            //biblioteca.atualizaLivro(new Livro(1928739, "Harry Potter e a Ordem da Fenix", 2007, 1, 1));
            //biblioteca.deletaLivro(1928739);

            var livros = biblioteca.listarLivrosCategoria(new Categoria(1, "Ficção Científica"));

            imprimeLivros(livros);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void imprimeLivros(List<Livro> livros) {
        for(Livro livro : livros) {
            System.out.printf("%d %s %d %d %d\n", livro.getIsbn(), livro.getTitulo(), livro.getAno(), livro.getCategoria(), livro.getEditora());
        }
    }
}
