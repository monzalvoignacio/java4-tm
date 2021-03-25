import java.util.Date;

public class Timer {
    private static long start;
    private static long end;

    public static void start() {
        Date date = new Date();
        //This method returns the time in millis
        start = date.getTime();
    }

    public static void stop() {
        Date date = new Date();
        //This method returns the time in millis
        end = date.getTime();
    }

    public static long ellapsedTime() {
        return end - start;
    }
}
