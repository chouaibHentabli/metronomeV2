package sample;

import adapter.IAdapter;
import adapter.Adapter;
import command.Decrement;
import command.Increment;
import command.Start;
import command.Stop;
import controller.Controller;
import Materiels.IMateriel;
import Materiels.Materiel;
import ihm.IInterface;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.filechooser.FileSystemView;

public class Main extends Application {
    IMateriel materiel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/resources/metronome.fxml").openStream());
        IInterface view = loader.getController();
        materiel = new Materiel();
        Controller controller = new Controller();
        controller.setView(view);
        view.setController(controller, materiel);
        view.init();


        IAdapter adapterButton = new Adapter(materiel, controller);

        view.setStartCommand(new Start(controller));
        view.setStopCommand(new Stop(controller));
        view.setIncCommand(new Increment(controller));
        view.setDecCommand(new Decrement(controller));
        primaryStage.setTitle("Metronome");
        primaryStage.setScene(new Scene(root, 536, 333));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        //new ihmImpl(new Controller());

    }
}
