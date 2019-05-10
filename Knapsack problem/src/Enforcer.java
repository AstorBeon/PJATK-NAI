import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Enforcer {

    int capacity;
    int upToNumber;
    String bestComb ="";
    int valueOfBestComb=0;




    Item itemsPackArray[];  //contains all items



    public void importerArray(File f) throws FileNotFoundException {    //imports basic setup from file
        Scanner scanner = new Scanner(f);

        //setting basic data
        String templine = scanner.nextLine();
        capacity=Integer.parseInt(templine.split("capacity ")[1]);
        upToNumber =Integer.parseInt( templine.split("length - ")[1].split(",")[0]);

        itemsPackArray = new Item[upToNumber];


        creatorArray(scanner);

    }
    public void creatorArray(Scanner scanner){  //fills itemsPackArray with Items (from file)

        scanner.nextLine(); //ignores line with "sizesX"
        String itemsSizes = scanner.nextLine();
        scanner.nextLine(); //ignores line with "valuesX"
        String itemsValues = scanner.nextLine();


        for(int i=0;i<itemsSizes.split(" ").length;i++){
            itemsPackArray[i]=new Item(Integer.parseInt(itemsSizes.split(" ")[i]),Integer.parseInt(itemsValues.split(" ")[i]));

        }
    }
    public void analyseArray(){
        int numberOfCombinations =(int) Math.pow(2.0,upToNumber);
        int tempsize=0;
        int tempVal =0;
        long start = System.currentTimeMillis();
        String binnumber;

        System.out.println("Begin of analyse...");

        for(long i=0;i<numberOfCombinations;i++){
            binnumber = Long.toBinaryString(i);  //generating binary number from i (to create combination of items based on it)

            for(int j=0;j<binnumber.length();j++){  //loop analysing combination (based on binnumber)
//

                if(binnumber.charAt(j)=='1') {

                    //Checking if adding new item won't exceede capacity
                    if(tempsize+itemsPackArray[(26-(binnumber.length()-j))].size>capacity){
                        break;
                    }
                    //...if it won't, adding new values
                    tempsize += itemsPackArray[(26-(binnumber.length()-j))].size;
                    tempVal += itemsPackArray[(26-(binnumber.length()-j))].value;
                }
            }   //end of sub loop

            if(tempVal>valueOfBestComb){    //Checking if this items combination is better than last saved best combination
                valueOfBestComb=tempVal;
                bestComb=binnumber;

            }

            //clearing temporary data
            tempVal=0;
            tempsize=0;


        }//End of main loop


        long end = System.currentTimeMillis();

        System.out.println();
        System.out.println("\nFINAL INFO:\n" +
                "Best combination:" + bestComb + " w/Value:" + valueOfBestComb +
                " \nNumber of checked combinations: " + numberOfCombinations + "\n" +
                "Time: "+ ((end-start)/1000) +"s \n" +
                "Average time per combination" + (end-start)/numberOfCombinations + "ms");


    }


}
