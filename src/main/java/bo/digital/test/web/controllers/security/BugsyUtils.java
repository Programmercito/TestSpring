package bo.digital.test.web.controllers.security;

/**
 *
 * @author hered
 */
public class BugsyUtils {

    public static String getUser() {
        int x = 1 + (int) (Math.random() * 10);
        return "user" + x;
    }
}
