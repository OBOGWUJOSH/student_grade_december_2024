
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

/*
        System.out.print("Teachers Name: ");
        String teacherName = scannerOne.nextLine();
 */


        System.out.println("How Many Students Do You Have: ");
        int numberOfStudent = scannerOne.nextInt();


        System.out.println("How many Subject Do You Offer: ");
        int numberOfSubject = scannerOne.nextInt();



        String greaterThan = ">";
        String equals = "=";
        String successful = "Saved Successfully";

        System.out.println(greaterThan.repeat(20));
        System.out.println(successful);
        System.out.println(" ");

        int subjectCounter = 0;
        int studentCounter;

        StringBuilder subject = new StringBuilder();
        int[][] studentList = new int[numberOfStudent][numberOfSubject];



        //INPUT COLLECTION POINT
        for (studentCounter = 0; studentCounter < numberOfStudent; studentCounter++) {

            System.out.println("Enter A Score from 0 to 100");
            for (subjectCounter = 0; subjectCounter < numberOfSubject; subjectCounter++) {
                int score;

                do{
                    System.out.println("Enter the scores of student " + (studentCounter + 1));
                    System.out.print("subject " + (subjectCounter + 1) + ": ");
                    score = scannerOne.nextInt();

                }while(score < 0 || score > 100);


                System.out.println(greaterThan.repeat(20));
                System.out.println(successful);
                System.out.println(" ");

                studentList[studentCounter][subjectCounter] = score;

                System.out.println(" ");

            }
        }



//      PRINTING THE TABLE

//      printing out the Table header
        System.out.println(equals.repeat(110));
        for (int i = 0; i < numberOfSubject;i++) {
            subject.append("SUB ").append(i+1).append("     " );//Make the SUB  increase
        }
        System.out.printf("%3s","STUDENTS     " + subject + "TOT     " + "AVE     " + "POS     ");
        System.out.println();

        System.out.println(equals.repeat(100));


//      PRINTING OUT THE TABLE BODY
        int[] totalArray = new int[numberOfStudent];
        double[] averageArray = new double[totalArray.length];
        double[] positionArray = new double[averageArray.length];

        int ii;
        int jj;

        for (ii = 0; ii < studentCounter; ii++) {

            System.out.printf("%s%3d%s", "Student", (ii + 1), "   ");
            for (jj = 0; jj < subjectCounter; jj++) {
                System.out.printf("%3d%s", studentList[ii][jj], "       ");
                totalArray[ii] += studentList[ii][jj];
                averageArray[ii] = (double) totalArray[ii]/numberOfSubject;
                positionArray[ii] = averageArray[ii];
            }

            //Total column print out
            System.out.printf("%3d%s", totalArray[ii], "    ");
            //Average column print out
            System.out.printf("%.2f%s", averageArray[ii], "    ");



//            PRINT OUT POSITION COLUMN

//            sort(positionArray);
            sortArray(positionArray);


            System.out.print("[ ");
            for(double numbers : positionArray){
                System.out.printf("%s%.2f,%s", " ",numbers," ");
            }
            System.out.print(" ]");

            //PRINT OUT THE INDEX
            int a;
            int position = 0;
            for(a = 1; a < positionArray.length; a++) {
                position = Arrays.binarySearch(positionArray,averageArray[a]);
            }
            System.out.printf("%3d\n", position);
        }

        System.out.println(" ");
        System.out.println(equals.repeat(100));
        System.out.println(equals.repeat(110));


//        SORT SUBJECT LIST
        int[] highestScore = new int[studentList.length];
        int[] highestScoreSorted = new int[studentList.length];
        int totalScoreOfSubject = 0;
        double averageScoreOfSubject = 0;

        for (int i = 0; i < studentList.length; i++) {
            for (int j = 0; j < studentList.length; j++) {
                highestScore[j] = studentList[j][i];
                highestScoreSorted[j] = highestScore[j];
//                System.out.println(highestScoreSorted[j]);
            }

            sortArrayInt(highestScoreSorted);

            System.out.println(Arrays.toString(highestScore));
            System.out.println(Arrays.toString(highestScoreSorted));
            System.out.println(" ");

            for (int scores : highestScoreSorted) {
                totalScoreOfSubject += scores;
                averageScoreOfSubject = (double)totalScoreOfSubject/numberOfSubject;
            }


//            SUBJECT SUMMARY
            System.out.println("Subject " + (i + 1));//PRINT OUT SUBJECT 1

            int highestPositionIndex = 0;
            int lowestPositionIndex = numberOfSubject - 1;

            int highestScoringStudentsPosition;
            int lowestScoringStudentsPosition;

//            highestScoringStudentsPosition = Arrays.binarySearch(highestScore, highestScoreSorted[0]);
//            lowestScoringStudentsPosition = Arrays.binarySearch(highestScore, highestScoreSorted[lowestPositionIndex]);

            highestScoringStudentsPosition = Arrays.binarySearch(highestScore, highestScoreSorted[0]);
            lowestScoringStudentsPosition = Arrays.binarySearch(highestScore, highestScoreSorted[lowestPositionIndex]);


//            for (int subSumCount = 0; subSumCount < numberOfSubject; subSumCount++) {
//                if (highestScoringStudentsPosition < 0 || lowestScoringStudentsPosition < 0) {
//                    highestScoringStudentsPosition = highestPositionIndex;
//                    lowestScoringStudentsPosition = highestPositionIndex;
//
//                }
//            }

            System.out.println("Highest scoring student is student " + (highestScoringStudentsPosition + 1) + " scoring: " + (highestScoreSorted[0]));
            System.out.println("The lowest scoring student is student " + (lowestScoringStudentsPosition + 1) + " scoring: " + (highestScoreSorted[lowestPositionIndex]));
            System.out.println("Total Score: " + totalScoreOfSubject);
            System.out.printf("%s%.2f\n", "Average Score : ", averageScoreOfSubject);
            System.out.println("Number of Passes: #");
            System.out.println("Number of Failed Students: #");
            System.out.println(" ");
        }

        System.out.println(equals.repeat(100));
        System.out.println(equals.repeat(110));
    }


    private static void sortArray(double[] arr){
        int i;
        for (i = 0; i < arr.length-1; i++){
            while (arr[i] < arr[i + 1]){
                if (arr[i] <= arr[i + 1]) {
                    double temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
                sortArray(arr);
            }
        }
    }



    private static void sortArrayInt(int[] arr){
        int i;
        for (i = 0; i < arr.length-1; i++){
            while (arr[i] < arr[i + 1]){
                if (arr[i] <= arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
                sortArrayInt(arr);
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
