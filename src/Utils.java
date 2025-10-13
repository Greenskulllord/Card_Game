import java.util.Arrays;

/**
   * Utils is a class that has multiple system type methods
    */
public class Utils {

    Utils() {

    }
   /**
   * use by calling Utils in the class as a variable.
   * example, utils.wait([your number to wait]
   * creates a delay in the console before a # amount of time has passed, then continues
   */
    public void Wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

        }
    }
        String[] stringYesInputs = {
                "y",
                "yes",
                "yeah",
                "yep",
                "yup",
                "sure",
                "ok",
                "okay",
                "confirm",
                "affirmative",
                "absolutely",
                "definitely",
                "certainly",
                "indeed",
                "right",
                "true"};

        String[] stringNoInputs = {
                "n",
                "no",
                "nope",
                "nah",
                "negative",
                "never",
                "decline",
                "deny",
                "refuse",
                "cancel",
                "false"};
    /**
    * list of yes inputs for easy console scanner use
     */
     public String StringYesInputs() {
        return Arrays.toString(stringYesInputs);
    }
    /**
     * list of no inputs for easy console scanner use
     */
    public String StringNoInputs() {
        return Arrays.toString(stringNoInputs);
    }

}

