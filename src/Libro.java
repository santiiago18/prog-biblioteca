public class Libro {

    //atributos de la clase
    private int id;
    private String titulo;
    private String autor;
    private int numPaginas;


    /**
     * Metodo de constructor de Libros
     * @param id identificador del ibro
     * @param titulo titulo del libro
     * @param autor autor del libro
     * @param numPaginas cantidad de páginas del libro
     */

    public Libro (int id, String titulo, String autor, int numPaginas) { //parametros del metodo
        int numHojas; //variable del metodo

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;

        numHojas = numPaginas / 2;
    }


    /**
     * Devuelve el, id del libro
     * @return id del libro
     */

    public int getId() {
            return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Libro: {");

        sb.append(String.format("\n id: %d", id));
        sb.append(String.format("\n titulo: %s", titulo));
        sb.append(String.format("\n autor: %s", autor));
        sb.append(String.format("\n numPaginas: %d", numPaginas));
        sb.append("}");


        return sb.toString();
    }





}
