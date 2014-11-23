package exceptions;

/**
 * Created by roxy on 11/22/2014.
 * Clasa care implementeaza exceptiile care apar
 */
public class InputException extends Exception{

    // Constructor care afiseaza un mesaj cu eroarea aparuta
    public InputException(String input, String errorMessage) {
        super("Input Format exception on \"" + input + "\" : " + errorMessage);
    }

}
