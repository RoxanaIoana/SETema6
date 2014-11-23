package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import model.ValueModel;
import interfaces.IView;
import exceptions.InputException;
import interfaces.IController;

/**
 * Created by roxy on 11/22/2014.
 */
public class ValueController implements IController {

    // Declar modelele pentru a putea comunica
    private ValueModel model,model1,model2;
    // Declar o lista de vizualizari
    private List<IView> views;


    // Metoda pentru adaugarea unei vizualizari
    public void addView(IView view) {
        if (views == null) {
            views = new ArrayList<IView>();
        }
        views.add(view);
    }


    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(ACTION_CALCULATE)) {
            try {
                    String userInput="ACTION_CALCULATE";
                    makeOperation(userInput);

            } catch (InputException e) {
                notifyViews(true, e.getMessage());
            } catch (ClassCastException ec) {
                notifyViews(true, ec.getMessage());
            }
        }
    }

    // Adaug modelul pentru a interactiona
    public void addModel(ValueModel m,ValueModel m1,ValueModel m2) {
        model = m;
        model1 = m1;
        model2 = m2;
    }

    // Afisez mesajul
    private void notifyViews(boolean isError, String message) {
        if (views != null && !views.isEmpty()) {
            for (IView view : views) {
                view.onMessage(isError, message);
            }
        }
    }

    // Setez valorile
    private void makeOperation(String operand) throws InputException {
       if (model != null && model1 != null & model2 != null) {

            try {
                    model.setTemperature();
                    model1.setWind();
                    model2.setPressure();

                } catch (NumberFormatException e) {
                throw new InputException(operand, e.getMessage());
               }
          }
     }


}
