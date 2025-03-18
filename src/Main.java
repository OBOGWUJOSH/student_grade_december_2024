import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scannerOne = new Scanner(System.in);

/*
        System.out.print("Teachers Name: ");
        String teacherName = scannerOne.nextLine();
 */

        System.out.println("How Many Students Do You Have: ");
        int numberOfStudents = scannerOne.nextInt();


        System.out.println("How many Subject Do You Offer: ");
        int numberOfSubjects = scannerOne.nextInt();


        String greaterThan = ">";
        String equals = "=";
        String exclamation = "!";
        String successful = "Saved Successfully";

        System.out.println(greaterThan.repeat(20));
        System.out.println(successful);
        System.out.println(" ");

        int subjectCounter = 0;
        int studentCounter = 0;



//        int numberOfAllImputedScores = numberOfStudents * numberOfSubjects;
        int[][] studentList = new int[numberOfStudents][numberOfSubjects];

        int score;


        //INPUT COLLECTION POINT

        for (studentCounter = 0; studentCounter < numberOfStudents; studentCounter++) {

            System.out.println("Enter A Score from 0 to 100");
            for (subjectCounter = 0; subjectCounter < numberOfSubjects; subjectCounter++) {
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


        System.out.println(equals.repeat(80));

        for (int i = 0; i < numberOfSubjects; i++) {
            subject.append("SUB ").append(i + 1).append("     ");//Make the SUB  increase
        }

        System.out.printf("%3s", "STUDENTS     " + subject + "TOT     " + "AVE     " + "POS     ");
        System.out.println();

        System.out.println(equals.repeat(70));



//      PRINTING OUT THE TABLE BODY
        int[] totalScoreForEachStudentArr = new int[numberOfStudents];
        int[] totalScoreForEachStudentArrSorted = new int[numberOfStudents];

        double[] averageArray = new double[totalScoreForEachStudentArr.length];
        double[] positionArray = new double[averageArray.length];
        double[] positionArraySorted = new double[averageArray.length];

        int[] allScoresPerSubject = new int[numberOfStudents];
        int[] allScoresPerSubjectSorted = new int[numberOfStudents];

        int lowestStudentsPositionIndex = numberOfStudents - 1;

        int ii;
        int jj;

        int totalScoresPerSubject;
        double averageScoresPerSubject;


        for (ii = 0; ii < studentCounter; ii++) {
            int position = 0;

            System.out.printf("%s%3d%s", "Student", (ii + 1), "   ");

            for (jj = 0; jj < subjectCounter; jj++) {
                System.out.printf("%3d%s", studentList[ii][jj], "       ");
                totalScoreForEachStudentArr[ii] += studentList[ii][jj];
                averageArray[ii] = (double) totalScoreForEachStudentArr[ii] / numberOfSubjects;
                positionArray[ii] = averageArray[ii];

//          printing out the position here
                System.arraycopy(positionArray,0,positionArraySorted,0,positionArray.length);
                sortArray(positionArraySorted);
                position = positionMethod(positionArraySorted, positionArray);
            }

            //Total column print out
            System.out.printf("%3d%s", totalScoreForEachStudentArr[ii], "    ");
            //Average column print out
            System.out.printf("%.2f%s", averageArray[ii], "    ");

//          PRINT OUT POSITION COLUMN
            System.out.println(position);
        }


        System.out.println(" ");
        System.out.println(equals.repeat(70));
        System.out.println(equals.repeat(70));

//      PRINTING SUBJECT SUMMARY

        int numberOfPasses = 0;
        int numberOfFails = 0;

        int highestScoringStudentsPosition = 0;
        int lowestScoringStudentsPosition = 0;

        int [] highestScores = new int[numberOfSubjects];
        int [] lowestScores = new int[numberOfSubjects];
        int [] highestScoresSorted = new int[numberOfSubjects];
        int [] lowestScoresSorted = new int[numberOfSubjects];

        int overallHighestSubjectIndex = 0;
        int overallLowestSubjectIndex = 0;


        int overallHighestScore = 0;
        int overallLowestScore = 0;

        int hardestSubjectIndex = 0;
        int easiestSubjectIndex = 0;

        int indexOfStudentWithHighestScore = 0;
        int indexOfStudentWithLowestScore = 0;

        double [] averageScoreOfSubjectArray = new double[numberOfSubjects];
        double [] averageScoresOfSubjectArraySorted = new double[numberOfSubjects];

        int [] passSubjectArray = new int [numberOfSubjects];
        int [] failSubjectArray = new int [numberOfSubjects];

//        int [] highestAndLowestScoresPerSubjectArray = new int [numberOfSubjects * 2];
        int [] totalScoreOfSubjectArray = new int [numberOfSubjects];

        for (int i = 0; i < numberOfSubjects; i++) {

            int numberOfStudentThatPassed;
            int numberOfStudentThatFailed;

            int lowestScoreArrayLength = lowestScoresSorted.length - 1;

            totalScoresPerSubject = 0;
            averageScoresPerSubject = 0;

            numberOfStudentThatPassed = 0;
            numberOfStudentThatFailed = 0;


            System.out.println(" ");
            System.out.println("Subject " + (i + 1));//PRINT OUT SUBJECT 1

//          creating the highestScoreSorted array
            for (int q = 0; q < numberOfStudents; q++) {
                allScoresPerSubject[q] = studentList[q][i];
                allScoresPerSubjectSorted[q] = allScoresPerSubject[q];

            }

            sortArrayInt(allScoresPerSubjectSorted);

//          Average Of Each Subject Stored in an Array
            for (int k : allScoresPerSubjectSorted) {
                totalScoresPerSubject += k;
                totalScoreOfSubjectArray[i] = totalScoresPerSubject;
                averageScoresPerSubject = (double) totalScoresPerSubject / numberOfStudents;
                averageScoreOfSubjectArray[i] = averageScoresPerSubject;
            }


            int passMark = 80;

            for (int j = 0; j < numberOfStudents; j++) {
                if (allScoresPerSubjectSorted[0] == allScoresPerSubject[j]) {
                    highestScoringStudentsPosition = j;
                } else if (allScoresPerSubjectSorted[numberOfStudents - 1] == allScoresPerSubject[j]) {
                    lowestScoringStudentsPosition = j;
                }
            }

            System.arraycopy(averageScoreOfSubjectArray, 0, averageScoresOfSubjectArraySorted, 0, numberOfSubjects);
            sortArray(averageScoresOfSubjectArraySorted);

            for (int j = 0; j < numberOfSubjects; j++) {
                if (averageScoresOfSubjectArraySorted[numberOfSubjects-1] == averageScoreOfSubjectArray[j]) {
                    hardestSubjectIndex = j + 1;
                }
                if(averageScoresOfSubjectArraySorted[0] == averageScoreOfSubjectArray[j]){
                    easiestSubjectIndex = j + 1;
                }
            }

            for (int scores : allScoresPerSubject) {
                if (scores <= passMark) {
                    numberOfStudentThatFailed += 1;
                    failSubjectArray[i] = numberOfStudentThatFailed;
                }

                if (scores > passMark){
                    numberOfStudentThatPassed +=1;
                    passSubjectArray[i] = numberOfStudentThatPassed;
                }
            }

            System.out.println(" ");

//          SUBJECT SUMMARY
            System.out.println("Highest scoring student is student " + (highestScoringStudentsPosition + 1) + " scoring: " + (allScoresPerSubjectSorted[0]));
            System.out.println("The lowest scoring student is student " + (lowestScoringStudentsPosition + 1) + " scoring: " + (allScoresPerSubjectSorted[lowestStudentsPositionIndex]));
            System.out.println("Total Score: " + totalScoresPerSubject);
            System.out.printf("%s%.2f\n", "Average Score : ", averageScoresPerSubject);
            System.out.println("Number of Passes: " + numberOfStudentThatPassed);
            System.out.println("Number of Failed Students: " + numberOfStudentThatFailed);
            System.out.println(" ");


            numberOfFails = failSubjectArray[hardestSubjectIndex-1];
            numberOfPasses = passSubjectArray[easiestSubjectIndex-1];

            highestScores[i] = allScoresPerSubjectSorted[0];
            lowestScores[i] = allScoresPerSubjectSorted[numberOfStudents-1];


            highestScoresSorted[i] = highestScores[i];
            lowestScoresSorted[i] = lowestScores[i];

            sortArrayInt(highestScoresSorted);
            sortArrayInt(lowestScoresSorted);


            overallHighestScore = highestScoresSorted[0];
            overallLowestScore = lowestScoresSorted[lowestScoreArrayLength];

            System.out.println(" ");


            for (int j = 0; j < numberOfSubjects; j++) {
                if(overallHighestScore == highestScores[j]) {
                    overallHighestSubjectIndex = j + 1;
                }
                if (overallLowestScore == lowestScores[j]) {
                    overallLowestSubjectIndex = j + 1;
                }
            }

            for(int o = 0; o < numberOfStudents; o++) {
                if (overallHighestScore == allScoresPerSubject[o]) {
                    indexOfStudentWithHighestScore = o + 1;
                }
            }

            for(int r = 0; r < numberOfSubjects; r++) {
                if (overallLowestScore == lowestScores[r]) {
                    indexOfStudentWithLowestScore = r + 1;
                }
            }

        }

        System.arraycopy(totalScoreForEachStudentArr,0,totalScoreForEachStudentArrSorted,0,numberOfStudents);
        sortArrayInt(totalScoreForEachStudentArrSorted);


        System.out.println("Total Score Array per subject Array");
        System.out.println(Arrays.toString(totalScoreOfSubjectArray));
        System.out.println("TotalScoreForEachStudentArr");
        System.out.println(Arrays.toString(totalScoreForEachStudentArrSorted));

        int totalScorePerClass = 0;
        for (int i = 0; i < numberOfStudents; i++) {
            totalScorePerClass += totalScoreForEachStudentArrSorted[i];
        }
        int averageOverallScore = totalScorePerClass/numberOfStudents;

        int bestGraduatingStudentIndex =  findIndexOf(totalScoreForEachStudentArr,totalScoreForEachStudentArrSorted[0],numberOfStudents);
        int worstGraduatingStudentIndex =  findIndexOf(totalScoreForEachStudentArr,totalScoreForEachStudentArrSorted[numberOfStudents-1],numberOfStudents);


        System.out.println(" ");
        System.out.printf("%s%d%s%d%s\n", "The Hardest Subject is Subject ", hardestSubjectIndex, " where ", numberOfFails, " student failed ");
        System.out.printf("%s%d%s%d%s\n", "The Easiest Subject is Subject ", easiestSubjectIndex, " where ", numberOfPasses, " student passed ");
        System.out.printf("%s%d%s%d%s%d\n", "The overall Highest score is scored by student ", indexOfStudentWithHighestScore, " in subject ", overallHighestSubjectIndex, " scoring ", overallHighestScore);
        System.out.printf("%s%d%s%d%s%d\n", "The overall Lowest score is scored by student ", indexOfStudentWithLowestScore, " in subject ", overallLowestSubjectIndex, " scoring ", overallLowestScore);
        System.out.println(" ");

//        System.out.println(" ");
//        System.out.println("highestScores/lowestScores");
//        System.out.println(Arrays.toString(highestScores));
//        System.out.println(Arrays.toString(lowestScores));
//        System.out.println(" ");
//        System.out.println("highestScoresSorted/lowestScoresSorted");
//        System.out.println(Arrays.toString(highestScoresSorted));
//        System.out.println(Arrays.toString(lowestScoresSorted));
//        System.out.println(" ");

//        System.out.println(" ");
//        System.out.println(overallHighestScore);
//        System.out.println(overallLowestScore);
//        System.out.println(" ");

        System.out.println(equals.repeat(80));

        System.out.println("\n");
        System.out.println("CLASS SUMMARY");
        System.out.println(equals.repeat(80));

        System.out.printf("%s%d%s%d\n","The Best Graduating Student is : Student ", bestGraduatingStudentIndex , " scoring " , totalScoreForEachStudentArrSorted[0] );

        System.out.println(equals.repeat(80));

        System.out.println(" ");
        System.out.println(exclamation.repeat(80));

        System.out.printf("%s%d%s%d\n","Worst Graduating Student is : Student ", worstGraduatingStudentIndex, " scoring " , totalScoreForEachStudentArrSorted[numberOfStudents-1]);

        System.out.println(exclamation.repeat(80));
        System.out.println(" ");

        System.out.println(equals.repeat(80));

        System.out.printf("%s%d\n","Class Total Score is   : ", totalScorePerClass );
        System.out.printf("%s%d\n","Class Average Score is : ", averageOverallScore );

        System.out.println(equals.repeat(80));

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

    private static int positionMethod (double [] sortedArr, double [] unsortedArr) {
        int pos = 0;
        for (int i = 0; i < sortedArr.length; i++) {
            for (double scores : sortedArr) {
//                double scores = sortedArr[j];
                if (scores == unsortedArr[i]) {
                    pos = i+1;
//                    break;
                }
            }
        }
        return pos;
    }

    private static int findIndexOf(int[]arr ,int indexToFind, int iterationLength){
        int foundIndex = 0;
        for (int i = 0; i < iterationLength; i++) {
            if (arr[i] == indexToFind){
                foundIndex =  i + 1;
            }
        }
        return foundIndex;
    }

    //THIS IS THE END
}

