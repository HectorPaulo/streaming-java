// _____________________________________________-Definición clase Streaming-___________________________________________________
abstract class Streaming {
    String nombre;
    double calificacion;

    public Streaming(String nombre, double calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    // _____________________________________________-Métodos abstractos-________________________________________________________
    abstract String duracion(); // <------ METODO ABSTRACTO DURACIÓN
    abstract String genero(); // <------ METODO ABSTRACTO GENERO

    // _______________________________________________-Método concreto-__________________________________________________________
    String informacion() {
        return "Nombre: " + nombre + ", Calificación: " + calificacion;
    }
}
// ___________________-Definición de la clase Pelicula que hereda de Streaming e implementa la interfaz Artista-_________________
class Pelicula extends Streaming implements Artista {
    int tiempo;
    String pais;
    String trama;

    public Pelicula(String nombre, double calificacion, int tiempo, String pais, String trama) {
        super(nombre, calificacion);
        this.tiempo = tiempo;
        this.pais = pais;
        this.trama = trama;
    }
    //__________________________________________________________-Duración-______________________________________________________
    @Override
    String duracion() {
        return tiempo + " minutos";
    }
    //___________________________________________________________-Genero-________________________________________________________
    @Override
    String genero() {
        return "Película";
    }

    // _______________________________________________-Métodos de la interfaz Artista-____________________________________________
    @Override
    public String actores() {
        return "Lista de actores";
    }

    @Override
    public String premiosONominaciones() {
        return "Lista de premios o nominaciones";
    }
}

// ___________________________________________________-Definición de la interfaz Artista-__________________________________________
interface Artista {
    String actores();
    String premiosONominaciones();
}

// __________________________________________________-Definición de la interfaz Presentador-_______________________________________
interface Presentador {
    String conductor();
    String recomendarPodcast();
}

// _________________________________-Definición de la clase Podcast que hereda de Streaming y la interfaz Presentador-______________
class Podcast extends Streaming implements Presentador {
    int numeroProgramas;
    String formato;

    public Podcast(String nombre, double calificacion, int numeroProgramas, String formato) {
        super(nombre, calificacion);
        this.numeroProgramas = numeroProgramas;
        this.formato = formato;
    }

    @Override
    String duracion() {
        return "Variable";
    }

    @Override
    String genero() {
        return "Podcast";
    }

    // _____________________________________________________-Métodos de la interfaz Presentador-____________________________________
    @Override
    public String conductor() {
        return "Nombre del conductor";
    }

    @Override
    public String recomendarPodcast() {
        return "Recomendación de podcast";
    }
}
public class App {
    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula("Titanic", 9.5, 180, "Estados Unidos", "Romance");
        System.out.println(pelicula1.informacion());
        System.out.println(pelicula1.actores());
        System.out.println(pelicula1.premiosONominaciones());

        Podcast podcast1 = new Podcast("Mi Podcast", 8.0, 50, "Entrevistas");
        System.out.println(podcast1.informacion());
        System.out.println(podcast1.conductor());
        System.out.println(podcast1.recomendarPodcast());
    }
}