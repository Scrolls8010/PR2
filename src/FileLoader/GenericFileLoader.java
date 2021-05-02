package FileLoader;

public abstract class GenericFileLoader {

    protected String path;
    public static int CountBytes;

    public GenericFileLoader(String path) {
        this.path = path;
    }

    public abstract void loadFile() throws GenericFileLoadException;

    public static int getCountBytes() {
        return CountBytes;
    }

}
