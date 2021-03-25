public class MiFactory {
    public static Object getInstance(String objName) throws Exception {
        Sorter s;
        s = (Sorter) Class.forName(objName).getDeclaredConstructor().newInstance();
        return s;
    }
}
