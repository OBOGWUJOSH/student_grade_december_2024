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
        String exclamation = "!";
        String successful = "Saved Successfully";

        System.out.println(greaterThan.repeat(20));
        System.out.println(successful);
        System.out.println(" ");

        int subjectCounter = 0;
        int studentCounter;


        int[][] studentList = new int[numberOfStudent][numberOfSubject];


        //INPUT COLLECTION POINT
        for (studentCounter = 0; studentCounter < numberOfStudent; studentCounter++) {

            System.out.println("Enter A Score from 0 to 100");
            for (subjectCounter = 0; subjectCounter < numberOfSubject; subjectCounter++) {
                int score;

                do {
                    System.out.println("Enter the scores of student " + (studentCounter + 1));
                    System.out.print("subject " + (subjectCounter + 1) + ": ");
                    score = scannerOne.nextInt();
                    if (score < 0 || score > 100) {
                        System.out.println("Score must be between 0 and 100.");
                    }

                } while (score < 0 || score > 100);

                System.out.println(greaterThan.repeat(20));
                System.out.println(successful);
                System.out.println(" ");
                studentList[studentCounter][subjectCounter] = score;
                System.out.println(" ");
            }
        }


//      PRINTING THE TABLE
        StringBuilder subject = new StringBuilder();

        System.out.println(equals.repeat(110));

        for (int i = 0; i < numberOfSubject; i++) {
            subject.append("SUB ").append(i + 1).append("     ");//Make the SUB  increase
        }

        System.out.printf("%3s", "STUDENTS     " + subject + "TOT     " + "AVE     " + "POS     ");
        System.out.println();

        System.out.println(equals.repeat(100));


//      PRINTING OUT THE TABLE BODY
        int[] totalArray = new int[numberOfStudent];
        int[] totalArraySorted = new int[numberOfStudent];

        double[] averageArray = new double[totalArray.length];
        double[] positionArray = new double[averageArray.length];

        int[] highestScore = new int[studentList.length];
        int[] highestScoreSorted = new int[studentList.length];

        int lowestPositionIndex = numberOfSubject - 1;
        int passMark = 80;

        int ii;
        int jj;

        int totalScoreOfSubject = 0;
        double averageScoreOfSubject = 0;

        int passes = 0;
        int fails = 0;

        for (ii = 0; ii < studentCounter; ii++) {

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
            System.out.printf("%.2f%s", averageArray[ii], "    ");


//          PRINT OUT POSITION COLUMN
            sortArray(positionArray);

//          printing out array indexes[temporary]
            System.out.print("[");
            for (int x = 0; x < positionArray.length; x++) {
                for (double numbers : averageArray) {
                    if (numbers == positionArray[x]) {
                        System.out.printf("%.2f%s ", positionArray[x], " ");
                    }
                }
            }
            System.out.print("]");


//             printing out the position here
            int position;
            position = positionMethod(positionArray, averageArray);
            System.out.println(position);

        }
        System.out.println(" ");
        System.out.println(equals.repeat(100));
        System.out.println(equals.repeat(110));


//      PRINTING SUBJECT SUMMARY


        passes = 0;
        fails = 0;

        int numberOfStudentThatPassed = 0;
        int numberOfStudentThatFailed = 0;

        int easySubjectIndex = 0;
        int hardSubjectIndex = 0;

        for (int i = 0; i < studentList.length; i++) {


            totalScoreOfSubject = 0;
            averageScoreOfSubject = 0;

            numberOfStudentThatPassed = 0;
            numberOfStudentThatFailed = 0;

            System.out.println("Subject " + (i + 1));//PRINT OUT SUBJECT 1

            for (int q = 0; q < studentList.length; q++) {
                highestScore[q] = studentList[q][i];
                highestScoreSorted[q] = highestScore[q];
            }

            sortArrayInt(highestScoreSorted);

//            System.out.println(" ");
//            System.out.println(Arrays.toString(highestScore));
//            System.out.println(Arrays.toString(highestScoreSorted));
//            System.out.println(" ");

            for (int k : highestScoreSorted) {
                totalScoreOfSubject += k;
                averageScoreOfSubject = (double) totalScoreOfSubject / numberOfSubject;
            }

            int highestScoringStudentsPosition = 0;
            int lowestScoringStudentsPosition = 0;


            for (int j = 0; j < numberOfSubject; j++) {
                if (highestScoreSorted[0] == highestScore[j]) {
                    highestScoringStudentsPosition = j;
                } else if (highestScoreSorted[numberOfStudent - 1] == highestScore[j]) {
                    lowestScoringStudentsPosition = j;
                }
            }


            //Counting the number of students who passed and failed
            for (int score : highestScore) {
                if (score > passMark) {
                    numberOfStudentThatPassed += 1;
                }
                if (score < passMark) {
                    numberOfStudentThatFailed += 1;
                }
            }

//          SUBJECT SUMMARY
            System.out.println("Highest scoring student is student " + (highestScoringStudentsPosition + 1) + " scoring: " + (highestScoreSorted[0]));
            System.out.println("The lowest scoring student is student " + (lowestScoringStudentsPosition + 1) + " scoring: " + (highestScoreSorted[lowestPositionIndex]));
            System.out.println("Total Score: " + totalScoreOfSubject);
            System.out.printf("%s%.2f\n", "Average Score : ", averageScoreOfSubject);
            System.out.println("Number of Passes: " + numberOfStudentThatPassed);
            System.out.println("Number of Failed Students: " + numberOfStudentThatFailed);
            System.out.println(" ");


            if (numberOfStudentThatPassed > numberOfStudentThatFailed) {
                passes += 1;
            } else if (numberOfStudentThatFailed > numberOfStudentThatPassed) {
                fails += 1;
            }
            if (fails > passes) {
                hardSubjectIndex = i;
            } else if (passes > fails) {
                easySubjectIndex = i;
            }
            System.out.println(" ");


        }
        if (fails == 0) {
            System.out.println("no hard subjects");
        } else {
            System.out.printf("%s%d%s%d%s\n", "The Hardest Subject is Subject ", hardSubjectIndex + 1, " where ", numberOfStudentThatFailed, " student failed ");
        }
        System.out.printf("%s%d%s%d%s\n", "The Easiest Subject is Subject ", easySubjectIndex + 1, " where ", numberOfStudentThatPassed, " student passed ");

        System.out.printf("%s%d%s%d%s%d\n", "The overall Highest score is scored by student ", 1234, " in subject ", 1234, " scoring ", 1234);
        System.out.printf("%s%d%s%d%s%d\n", "The overall Lowest score is scored by student ", 1234, " in subject ", 1234, " scoring ", 1234);

    }




//        int p = 0;
//
//        for (p = 0; p < numberOfSubject; p++) {
//            passes = 0;
//            fails = 0;
//        }

//            overall highest and lowest score
//        System.out.println(Arrays.toString(totalArray));
//
//        for (int i = 0; i < totalArray.length; i++) {
//            totalArraySorted[i] = totalArray[i];
//            sortArrayInt(totalArraySorted);
//        }
//        System.out.println(Arrays.toString(totalArraySorted));





//            System.out.println(equals.repeat(100));
//            System.out.println(equals.repeat(110));

//          SUBJECT SUMMARY

//    }


//        System.out.println(equals.repeat(110));
//
//        System.out.println("\n");
//        System.out.println("CLASS SUMMARY");
//        System.out.println(equals.repeat(110));
//
//        System.out.printf("%s%d%s%d\n","The Best Graduating Student is : Student ", 1234 , " scoring " , 1234 );
//
//        System.out.println(equals.repeat(110));
//
//        System.out.println(" ");
//        System.out.println(exclamation.repeat(110));
//
//        System.out.printf("%s%d%s%d\n","Worst Graduating Student is : Student ", 1234, " scoring " , 1234);
//
//        System.out.println(exclamation.repeat(110));
//        System.out.println(" ");
//
//        System.out.println(equals.repeat(110));
//
//        System.out.printf("%s%d\n","Class Total Score is   : ", 1234 );
//        System.out.printf("%s%d\n","Class Average Score is : ", 1234 );
//
//        System.out.println(equals.repeat(110));






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

    private static int positionMethod (double [] sortedArr, double [] unsortedArr) {
        int pos = 0;
        for (int i = 0; i < sortedArr.length; i++) {
            for (double scores : unsortedArr) {
                if (sortedArr[i] == scores) {
//                    pos = i + 1;
                    pos = i;
                    break;
                }
            }
        }
        return pos;
    }

    //THIS IS THE END
}

