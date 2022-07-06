package fraudDetector;

import java.util.Arrays;
import java.util.Scanner;

public class Assessment  {

    private static int numOfNotifications = 0;

    public static void main(String[] args) {

        inputs(9,5);

    }

    public static void inputs(int numberOfDays, int priorDays) {

        ma(populateArray(numberOfDays), priorDays);


    }


    public static int[] populateArray(int size) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[size];
        System.out.println("Enter Transaction Data for each day");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        return arr;

    }



    public static int[] getTransactionData(int counter, int priorDays, int[] amountSpent) {
        int[] arr = new int[priorDays];

        int c = counter;

        for (int i = 0; i < priorDays; i++) {
            arr[i] = amountSpent[c];
            c++;
        }

        return arr;

    }


    public static int getMedian(int[] values) {
        Arrays.sort(values);
        int length = values.length;
        return length % 2 == 0
                ? (int) ((values[length / 2] + values[length / 2 - 1]) / 2.0)
                : values[length / 2];
    }



    public static void ma( int[] transactionData,int priorDays) {


        if (transactionData.length > priorDays) {

            int counter = 0;


            while (true) {
                int[] slicedArr = new int[(transactionData.length - 1) - counter];

                if (slicedArr.length < priorDays) {
                    break;
                }

                int[] arr = getTransactionData(counter, priorDays, transactionData);

                if (arr[priorDays -1] >=  2 * getMedian(arr)) {
                    numOfNotifications++;
                }
                counter++;

            }


        }

        System.out.println("No of Notifications = "+numOfNotifications);;

    }



}


