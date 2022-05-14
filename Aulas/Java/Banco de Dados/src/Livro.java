public class Livro {
    private int isbn, ano, categoria, editora;
    private String titulo;

    Livro(int isbn, String titulo, int ano, int categoria, int editora) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.ano = ano;
        this.categoria = categoria;
        this.editora = editora;
    }

    Livro(String titulo, int ano, int categoria, int editora) {
        this.isbn = 0;
        this.titulo = titulo;
        this.ano = ano;
        this.categoria = categoria;
        this.editora = editora;       
    }

    public int getAno() {
        return ano;
    }

    public int getEditora() {
        return editora;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }
}
