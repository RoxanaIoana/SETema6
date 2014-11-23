package interfaces;

/**
 * Created by roxy on 11/22/2014.
 */
public interface IView {

    // Metoda pentru afisarea mesajului primit de la controller
    public void onMessage(boolean isError, String message);

}
