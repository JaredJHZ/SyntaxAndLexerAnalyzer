package sample;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URISyntaxException;
import java.net.URL;


public class ProfileController {
    @FXML
    ImageView imagen;

    @FXML void initialize() {


        try {
            URL url = getClass().getResource("me.jpg");
            Image image = new Image(String.valueOf(url.toURI()));
            this.imagen.setImage(image);
        }catch (URISyntaxException ex){
            System.out.println(ex.getMessage());
        }
    }
}
