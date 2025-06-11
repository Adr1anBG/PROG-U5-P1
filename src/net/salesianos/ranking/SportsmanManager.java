package net.salesianos.ranking;

import java.util.ArrayList;

public class SportsmanManager {

    private ArrayList<Sportsman> sportsmen;

    public SportsmanManager() {
        this.sportsmen = new ArrayList<>();
    }

    // Añadir un nuevo deportista
    public void addSportsman(Sportsman s) {
        sportsmen.add(s);
    }

    // Editar un deportista por nombre
    public boolean editSportsman(String name, int newAge, String newSport, int newRating) {
        for (int i = 0; i < sportsmen.size(); i++) {
            Sportsman s = sportsmen.get(i);
            if (s.getName().equalsIgnoreCase(name)) {
                s.setAge(newAge);
                s.setSport(newSport);
                s.setRating(newRating);
                return true;
            }
        }
        return false;
    }

    // Eliminar un deportista por nombre
    public boolean removeSportsman(String name) {
        for (int i = 0; i < sportsmen.size(); i++) {
            if (sportsmen.get(i).getName().equalsIgnoreCase(name)) {
                sportsmen.remove(i);
                return true;
            }
        }
        return false;
    }

    // Obtener lista ordenada manualmente por rating (mayor a menor)
    public ArrayList<Sportsman> getAllSportsmenOrderedByRating() {
        ArrayList<Sportsman> sortedList = new ArrayList<>(sportsmen);

        // Ordenamiento burbuja descendente (por rating)
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - 1 - i; j++) {
                if (sortedList.get(j).getRating() < sortedList.get(j + 1).getRating()) {
                    Sportsman temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }

        return sortedList;
    }

    // Mostrar por consola
    public void showAllSportsmen() {
        ArrayList<Sportsman> sortedList = getAllSportsmenOrderedByRating();
        if (sortedList.isEmpty()) {
            System.out.println("No hay deportistas registrados.");
        } else {
            for (Sportsman s : sortedList) {
                System.out.println(s);
                System.out.println("--------------------");
            }
        }
    }
}

