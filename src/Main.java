

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        //STUDENT GRADE APPLICATION
        //teachers name
        //app ask for the amount of students in the classroom
        //the app ask for the amount of subjects that each student has
        //the app collects the subject and scores of every student to a list of students
        //scores must be between 0 and 100
        //app displays class summary after all the input collecting


        Scanner scannerOne = new Scanner(System.in);

//        System.out.print("Teachers Name: ");
//        String teacherName = scannerOne.nextLine();


        System.out.print("How Many Students Do You Have: ");
        int numberOfStudent = scannerOne.nextInt();


        System.out.print("How many Subject Do You Offer: ");
        int numberOfSubject = scannerOne.nextInt();


        String greaterThan = ">";
        String equals = "=";
        String successful = "Saved Successfully";

        System.out.println(greaterThan.repeat(20));
        System.out.println(successful);
        System.out.println(" ");

        int subjectCounter = 0;
        int studentCounter = 0;

        StringBuilder subject = new StringBuilder();



        int[][] studentList = new int[numberOfStudent][numberOfSubject];


        //INPUT COLLECTION POINT§
        for (studentCounter = 0; studentCounter < numberOfStudent; studentCounter++) {

            for (subjectCounter = 0; subjectCounter < numberOfSubject; subjectCounter++) {

                System.out.println("Enter the scores of student " + (studentCounter + 1));
//
                System.out.print("subject " + (subjectCounter + 1) + ": ");
                int score = scannerOne.nextInt();

                System.out.println(greaterThan.repeat(20));
                System.out.println(successful);
                System.out.println(" ");

                studentList[studentCounter][subjectCounter] = score;

                System.out.println(" ");

            }
        }



//      PRINTING THE TABLE1

//      printing out the Table HEADER
        System.out.println(equals.repeat(60));


        for (int i = 0; i <numberOfSubject;i++) {
            subject.append("SUB ").append(i+1).append("     " );//Make the SUB  increase
        }
        System.out.printf("%3s","STUDENTS     " + subject + "TOT     " + "AVE     " + "POS     ");
        System.out.println();

        System.out.println(equals.repeat(60));



        int ii;
        int jj;

        int[] totalArray = new int[numberOfStudent];
        double[] averageArray = new double[totalArray.length];
        double[] positionArray = new double[averageArray.length];


        int highestScoringStuPosition = 0;
        int lowestScoringStuPosition = 0;
        int lowestIndexPosition = 0;


//      printing out the Table BODY
        for (ii = 0; ii < studentCounter; ii++) {
//          fix the spacing problem in front of the student

            System.out.printf("%s%3d%s", "Student", (ii + 1), "   ");


            for (jj = 0; jj < subjectCounter; jj++) {
                System.out.printf("%3d%s", studentList[ii][jj], "       ");
                totalArray[ii] += studentList[ii][jj];
                averageArray[ii] = (double) totalArray[ii] / numberOfSubject;
                positionArray[ii] = averageArray[ii];
            }

            //Total column print out
            System.out.printf("%3d%s", totalArray[ii], "    ");
            //Average column print out
            System.out.printf("%3.2f%s", averageArray[ii], "    ");


            //Position column print out;
            sortArray(positionArray);

            System.out.println(Arrays.toString(averageArray));
            System.out.println(Arrays.toString(positionArray));

            int position = 0;
            for (int i = 0; i < averageArray.length; i++) {

                position = Arrays.binarySearch(averageArray, positionArray[i]);

            }

            System.out.printf("%2d\n", position + 1);

            //print out the position
            System.out.println(" ");
        }


//        System.out.print(Arrays.toString(positionArray));

        System.out.println(" ");
        System.out.println(equals.repeat(60));





        //SUBJECT SUMMARY
        for (int subSumCount = 0; subSumCount < numberOfSubject; subSumCount++) {

            System.out.println("Subject " + (subSumCount + 1));


            lowestIndexPosition = positionArray.length - 1;

            highestScoringStuPosition = 0;
            lowestScoringStuPosition = 0;

            for (int subSumCount2 = 0; subSumCount2 < numberOfSubject; subSumCount2++) {

                highestScoringStuPosition = Arrays.binarySearch(averageArray, (positionArray[0]));
                lowestScoringStuPosition = Arrays.binarySearch(averageArray, (positionArray[lowestIndexPosition]));

//                System.out.println(Arrays.toString(positionArray));
//                System.out.println(Arrays.toString(averageArray));

            }



            System.out.println("Highest scoring student is student " + (highestScoringStuPosition + 1) + " scoring: " + (positionArray[0]));
            System.out.println("The lowest scoring student is student " + (lowestScoringStuPosition + 1) + " scoring: " + (positionArray[lowestIndexPosition]));
            System.out.println("Total Score : #");
            System.out.println("Average Score : #");
            System.out.println("Number of Passes : #");
            System.out.println("Number of Failed Students : #");
            System.out.println("  ");

            System.out.println(equals.repeat(60));
        }


        System.out.println(" ");
        System.out.println(equals.repeat(60));
    }




    private static void sortArray(double[] arr){
        int i;
        for (i = 0; i < arr.length-1; i++) {
            if (arr[i] < arr[i + 1]) {
                double temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }


//    private static int findIndex(double[] positionArray, double[] averageArray){
////        sortArray(positionArray);
//        for (int ij = 0; ij < positionArray.length; ij++) {
//            int i = 0;
//            while (i < positionArray.length) {
//                if (averageArray[ij] == positionArray[i]) {
//                    return i + 1;
//                } else if (averageArray[ij] != positionArray[i]) {
//                    i++;
//                }
//            }
//        }
//        return -1;
//    }



    //THIS IS THE END
}