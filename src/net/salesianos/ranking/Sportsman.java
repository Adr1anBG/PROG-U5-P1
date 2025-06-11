package net.salesianos.ranking;

/**
 * Clase que representa a un deportista con su información básica
 * y su calificación dentro del ranking.
 */
public class Sportsman {

    // ======================
    // Atributos de la clase
    // ======================

    private String name;     // Nombre del deportista
    private int age;         // Edad del deportista
    private String sport;    // Deporte que practica
    private int rating;      // Puntuación o calificación (1 a 5)

    // ======================
    // Constructor
    // ======================

    /**
     * Constructor que permite crear un objeto Sportsman con todos sus atributos.
     *
     *  name   Nombre del deportista
     *  age    Edad del deportista
     *  sport  Deporte que practica
     *  rating Puntuación o calificación (1-5)
     */
    public Sportsman(String name, int age, String sport, int rating) {
        this.name = name;
        this.age = age;
        this.sport = sport;
        this.rating = rating;
    }

    // ======================
    // Métodos Getters y Setters
    // ======================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    // ======================
    // Método toString
    // ======================

    /**
     * Devuelve una cadena con la información completa del deportista
     * en formato legible para mostrar en pantalla.
     *
     * @return Detalles del objeto Sportsman como texto.
     */
    @Override
    public String toString() {
        return "Nombre: " + name +
                "\nEdad: " + age +
                "\nDeporte: " + sport +
                "\nCalificación: " + rating;
    }
}

