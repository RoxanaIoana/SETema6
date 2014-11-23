import controller.ValueController;
import model.ValueModel;
import view.ValueView;

/**
 * Created by roxy on 11/22/2014.
 */
public class Main {
    public static void main(String[] args) {

        ValueModel model = new ValueModel();
        ValueModel model1 = new ValueModel();
        ValueModel model2 = new ValueModel();
        ValueView view = new ValueView();
        ValueController controller = new ValueController();

        // Adaug un view
        model.addModelListener(view);

        // Adaug modelele si controller-ul la view
        view.addModel(model,model1,model2);
        view.addController(controller);

        // Adaug modelele si un view la controller
        controller.addModel(model,model1,model2);
        controller.addView(view);

        // Afisez view-ul
        view.setVisible(true);
    }


}
