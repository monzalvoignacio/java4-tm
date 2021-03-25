import java.io.FileInputStream;
import java.util.Comparator;
import java.util.Properties;
import java.util.stream.IntStream;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws  Exception
    {

        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "MiFactory.properties";

        Properties sorterProperties = new Properties();
        sorterProperties.load(new FileInputStream(appConfigPath));

        String sorter = sorterProperties.getProperty("sorter");

        Sorter s = (Sorter)MiFactory.getInstance(sorter);

        Comparator<Integer> c1 = (a, b) -> a - b;
        Comparator<String> c2 = (a, b) -> a.compareTo(b);

        Integer [] myIntArray = {1,3,4,6,2,543,5,4,542,654};
        String [] myStringArray = {"hola", "chau", "nacho", "stringLargo", "loremipsum"};

        s.sort(myIntArray, c1);
        s.sort(myStringArray, c2);

        for (Integer i:myIntArray) {
            System.out.println(i);
        }

        for (String str:myStringArray) {
            System.out.println(str);
        }

        Random random = new Random();

        int[] bigIntegerArray = random.ints(100000, 10,100000).toArray();
        Integer[] newRandomArray = new Integer[bigIntegerArray.length];
        int cont = 0;
        for (int value : bigIntegerArray) {
            newRandomArray[cont++] = Integer.valueOf(value);
        }

        Timer.start();
        s.sort(newRandomArray, c1);
        Timer.stop();

        for (Integer i:newRandomArray) {
            System.out.println(i);
        }

        System.out.println(Timer.ellapsedTime());
    }
}
