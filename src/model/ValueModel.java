package model;

import exceptions.InputException;
import interfaces.IModelListener;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
/**
 * Created by roxy on 11/22/2014.
 */
public class ValueModel {

    // Membrii clasei
    private int temperature;
    private int wind;
    private int pressure;

    private List<IModelListener> listeners;

    // Metoda pentru setarea temperaturii random
    public void setTemperature() throws InputException {
        try {

            Random rand = new Random();
            temperature = rand.nextInt(50);

            notifyListeners();
          } catch (NumberFormatException e) {
              throw new InputException("temperatura", e.getMessage());
        }

    }

    // Metoda pentru setarea vitezei vantului random
    public void setWind () throws InputException {

        try {
            Random rand1 = new Random();
            wind = rand1.nextInt(50);

            notifyListeners();
        } catch (NumberFormatException e) {
            throw new InputException("viteza vantului", e.getMessage());
        }
    }

    // Metoda pentru setarea presiunii random
    public void setPressure() throws InputException{

        try {
            Random rand2 = new Random();
            pressure = rand2.nextInt(1500);
            notifyListeners();

        } catch (NumberFormatException e) {
            throw new InputException("presiunea", e.getMessage());
        }
    }

    // Metoda care returneaza temperatura
    public String getTemperature() {

        return ((Integer.toString(temperature)));

    }

    // Metoda care returneaza viteza vantului
    public String getWind() {
        return ((Integer.toString(wind)));
    }

    // Metoda care returneaza presiunea
    public String getPressure() {
        return ((Integer.toString(pressure)));
    }

    // Adauga la lista
    public void addModelListener(IModelListener listener) {
        if (listeners == null) {

            listeners = new ArrayList<IModelListener>();
        }

        listeners.add(listener);
    }

    // Notifica utilizatorii vizualizarilor de schimbarile efectuate
    private void notifyListeners() {

        if (listeners != null && !listeners.isEmpty()) {
            for (IModelListener listener : listeners)
                 listener.onUpdate();
        }
    }
}
