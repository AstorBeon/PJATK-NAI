import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Enforcer enforcer = new Enforcer();
        enforcer.importerArray(new File("src/testdata.txt"));
        enforcer.analyseArray();


        //Notes:
        //> "data" containt multiple testing packs, but "testdata" is used in program
        //> program does some bulk-brute force work
        //> Arrays are used, due to better efficiency than Lists


    }


}
