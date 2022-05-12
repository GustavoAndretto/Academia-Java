public class Livro {
    int isbn, ano, categoria, editora;
    String titulo;

    Livro(int isbn, String titulo, int ano, int categoria, int editora) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.ano = ano;
        this.categoria = categoria;
        this.editora = editora;
    }
}
