
import java.io.Serializable;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Objeto implements Serializable {

    String user;
    String pass;

    public Objeto(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

}
