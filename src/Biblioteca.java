public class Biblioteca {

    private Libro [] catalogo;
    private final int CANT_MAX_LIBROS;


    public Biblioteca(int cantidad_maxima_libros) {
        CANT_MAX_LIBROS = cantidad_maxima_libros;
        catalogo = new Libro[cantidad_maxima_libros];
    }


    /**
     * Busca el primer libro que encuentre con el id recibido
     * @param idLibro identificador del libro
     * @return devuelve el libro encontrado
     */
    public Libro findLibro(int idLibro) {
        boolean seguirBuscando = true;
        Libro libroEncontrado = null;

        for (int i = 0; i < CANT_MAX_LIBROS && seguirBuscando; i++) {
            if (catalogo[i] != null && catalogo[i].getId() == idLibro) {
                seguirBuscando = false;
                libroEncontrado = catalogo[i];
            }
        }
        return libroEncontrado;
    }


    /**
     * Busca el primer hueco libre en el catálogo
     * @return -1 si no hay hueco libre o la posicion libe
     */
    private int buscarHuecoLibre(){
        int posicionLibre = -1;
        boolean seguirBuscando = true;

        for (int i = 0; i < CANT_MAX_LIBROS && seguirBuscando; i++) {
            if (catalogo[i] != null) {
                posicionLibre = i;
                seguirBuscando = false;
            }
        }
        return posicionLibre;
    }

    /**
     *Recibe y añade el libro no duplicado siempre qu ehaya hueco
     * @param libro libro recibido
     * @return true si se añadio, flase si no se ha podido añadir
     */
    public boolean addLibro(Libro libro) {
        boolean libroAnadido = false;
        int posicion;

        //Buscar si hay hueco
                // no hay - false
                // si hay
                    // añadimos
                    //libroAñadido = true

        if (findLibro(libro.getId()) == null) { // no lo ha encontrado no esta duplicado
            posicion = buscarHuecoLibre();
            if (posicion >= 0) {
                catalogo[posicion] = libro;
                libroAnadido = true;
            }
        }
        return libroAnadido;
    }


    /**
     * Recibe un id de un libre
     * @param id identificador de libro
     * @return el libro eliminado o null en caso no encontrarlo
     */
    public Libro deleteLibro(int id) {
        Libro libroEncontrado = null;
        boolean seguirBuscando = true;

        //Comprobar de que el libro exista. Necesitamos el libro y la posicion
        for (int i = 0; i < CANT_MAX_LIBROS && seguirBuscando; i++) {
            if (catalogo[i] != null && catalogo[i].getId() == id) {
                libroEncontrado = catalogo[i];
                catalogo[i] = null; //Vaciamos la posicion
                seguirBuscando = false;

            }
        }
        return libroEncontrado;
    }

    /**
     * Actualiza el numero de paginas del libro con el id recibido
     * @param idLibro id del libro a actualizar
     * @param numPaginas paginas que tiene el libro
     * @return
     */
    public boolean updateNumPaginas(int idLibro, int numPaginas) {
        boolean numPaginasActualizado = false;
        Libro libro;

        libro = findLibro(idLibro);

        if (libro != null) {
            numPaginasActualizado =  libro.updatePaginas(numPaginas);

        }
        return numPaginasActualizado;
    }

    /**
     * Devueve un String con el catalogo de libros
     * @return String para catalogo de libros
     */
    public String obtaincatalogo(){
        StringBuilder sb = new StringBuilder("Catalogo { ");

        for (int i = 0; i < CANT_MAX_LIBROS; i++) {
            if (catalogo[i] != null) {
                sb.append(catalogo[i].toString());
            }
            sb.append("\n");

        }
        sb.append("}");
        return sb.toString();
    }



}
