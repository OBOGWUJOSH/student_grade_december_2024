
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

        int studentCounter;
        int subjectCounter = 0;


        int[][] studentListB = new int[numberOfStudent][numberOfSubject];


        //INPUT COLLECTION POINT

        for (studentCounter = 0; studentCounter < numberOfStudent; studentCounter++) {

            for (subjectCounter = 0; subjectCounter < numberOfSubject; subjectCounter++) {

                System.out.println("Enter the scores of student " + (studentCounter + 1));
//
                System.out.print("subject " + (subjectCounter + 1) + ": ");
                int score = scannerOne.nextInt();

                System.out.println(greaterThan.repeat(20));
                System.out.println(successful);
                System.out.println(" ");

                studentListB[studentCounter][subjectCounter] = score;

                System.out.println(" ");
            }
        }


//      PRINTING THE TABLE
        String subject = ("SUB     ").repeat(numberOfSubject); //Make the SUB  increase

//      printing out the Table HEADER
        System.out.println(equals.repeat(60));

        System.out.print("STUDENTS     " + subject + "TOT     " + "AVE     " + "POS     ");
        System.out.println();

        System.out.println(equals.repeat(60));





        int ii;
        int jj;
        int position = 0;

        int[] totalArray = new int[numberOfStudent];
        double[] averageArray = new double[totalArray.length];
        double[] positionArray = new double[averageArray.length];


//      printing out the Table BODY
        for (ii = 0; ii < studentCounter; ii++) {


//      fix the spacing problem in front of the student
            System.out.printf("%s%3d%s", "Student", (ii + 1), "   ");


            for (jj = 0; jj < subjectCounter; jj++) {
                System.out.printf("%3d%s", studentListB[ii][jj], "     ");
                totalArray[ii] += studentListB[ii][jj];
                averageArray[ii] = (double) totalArray[ii] / numberOfSubject;
                positionArray[ii] = averageArray[ii];
            }

            //Total column print out
            System.out.printf("%3d%s", totalArray[ii], "    ");
            //Average column print out
            System.out.printf("%3.2f%s", averageArray[ii], "    ");


            //Position column print out;
//            int i;
//            for (i = 0; i < averageArray.length; i++) {
//
//            }
            position = findIndex(averageArray, positionArray[ii]);
            System.out.printf("%2d\n",position);

//            System.out.printf("%-20s\n",Arrays.toString(positionArray));//✅

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


    private static int findIndex(double[] positionArray, double averageArray) {
//        sortArray(positionArray);
        for (int ij = 0; ij < positionArray.length; ij++) {
            int i = 0;
            while (i <= positionArray.length) {
                if (positionArray[i] != averageArray) {
                    i++;
                } else if (positionArray[i] == averageArray) {
                    return i + 1;
                }
            }
        }
        return -1;
    }




    //THIS IS THE CLASS CLOSURE
}