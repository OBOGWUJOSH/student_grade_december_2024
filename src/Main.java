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
        int studentCounter;

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
        int[] totalArray = new int[numberOfStudents];

        double[] averageArray = new double[totalArray.length];
        double[] positionArray = new double[averageArray.length];

        int[] allScoresPerSubject = new int[numberOfStudents];
        int[] allScoresPerSubjectSorted = new int[numberOfStudents];

        int lowestStudentsPositionIndex = numberOfStudents - 1;

        int ii;
        int jj;

        int totalScoreOfSubject;
        double averageScoreOfSubject;



        for (ii = 0; ii < studentCounter; ii++) {

            System.out.printf("%s%3d%s", "Student", (ii + 1), "   ");

            for (jj = 0; jj < subjectCounter; jj++) {
                System.out.printf("%3d%s", studentList[ii][jj], "       ");
                totalArray[ii] += studentList[ii][jj];
                averageArray[ii] = (double) totalArray[ii] / numberOfSubjects;
                positionArray[ii] = averageArray[ii];
            }



            //Total column print out
            System.out.printf("%3d%s", totalArray[ii], "    ");
            //Average column print out
            System.out.printf("%.2f%s", averageArray[ii], "    ");


//          PRINT OUT POSITION COLUMN
            sortArray(positionArray);

//          printing out array indexes temporarily
//            System.out.print("[");

//            for (int x = 0; x < positionArray.length; x++) {
//                for (double numbers : averageArray) {
//                    if (numbers == positionArray[x]) {
//                        System.out.printf("%.2f%s", numbers, "");
//                    }
//                }
//            }
//            System.out.print("]");


//             printing out the position here
            int position;
            position = positionMethod(positionArray, averageArray);
            System.out.println(position);
        }

        System.out.println(" ");
        System.out.println(equals.repeat(70));
        System.out.println(equals.repeat(70));


//      PRINTING SUBJECT SUMMARY

        int hardestSubjectIndex = 0;
        int easiestSubjectIndex = 0;

        int numberOfStudentThatPassed;
        int numberOfStudentThatFailed;

        int [] passSubjectArray = new int [numberOfSubjects];
        int [] failSubjectArray = new int [numberOfSubjects];

        double [] averageScoreOfSubjectArray = new double[numberOfSubjects];
        double [] averageScoresOfSubjectArraySorted = new double[numberOfSubjects];

        int numberOfPasses = 0;
        int numberOfFails = 0;

        int highestScoringStudentsPosition = 0;
        int lowestScoringStudentsPosition = 0;

        int [] highestScores = new int[numberOfSubjects];
        int [] lowestScores = new int[numberOfSubjects];
        int [] highestScoresSorted = new int[numberOfSubjects];
        int [] lowestScoresSorted = new int[numberOfSubjects];

        int overallHighestStudentsIndex = 0;
        int overallLowestStudentsIndex = 0;

        int highestScoreArrayLength = highestScoresSorted.length;
        int lowestScoreArrayLength = lowestScoresSorted.length;

        int overallHighestScore = 0;
        int overallLowestScore = 0;

        int studentWithLowestScore = 0;
        int studentWithHighestScore = 0;

        for (int i = 0; i < numberOfSubjects; i++) {

            totalScoreOfSubject = 0;
            averageScoreOfSubject = 0;

            numberOfStudentThatPassed = 0;
            numberOfStudentThatFailed = 0;

            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Subject " + (i + 1));//PRINT OUT SUBJECT 1


//            creating the highestScoreSorted array
            for (int q = 0; q < numberOfStudents; q++) {
                allScoresPerSubject[q] = studentList[q][i];
                allScoresPerSubjectSorted[q] = allScoresPerSubject[q];
            }

            sortArrayInt(allScoresPerSubjectSorted);


//            Average Of Each Subject Stored in an Array
            for (int k : allScoresPerSubjectSorted) {
                totalScoreOfSubject += k;
                averageScoreOfSubject = (double) totalScoreOfSubject / numberOfSubjects;
                averageScoreOfSubjectArray[i] = averageScoreOfSubject;
            }


            int passMark = 80;

            for (int j = 0; j < numberOfStudents; j++) {
                if (allScoresPerSubjectSorted[0] == allScoresPerSubject[j]) {
                    highestScoringStudentsPosition = j;
                } else if (allScoresPerSubjectSorted[numberOfStudents - 1] == allScoresPerSubject[j]) {
                    lowestScoringStudentsPosition = j;
                }
            }


//            System.out.println(Arrays.toString(averageScoreOfSubjectArray));

            for (int j = 0; j < numberOfSubjects; j++) {
                averageScoresOfSubjectArraySorted[j] = averageScoreOfSubjectArray[j];
            }
            sortArray(averageScoresOfSubjectArraySorted);


//            System.out.println(Arrays.toString(averageScoresOfSubjectArraySorted));

            for (int j = 0; j < numberOfSubjects; j++) {
                if(averageScoresOfSubjectArraySorted[0] == averageScoreOfSubjectArray[j]){
                    easiestSubjectIndex = j + 1;
                }
                else if (averageScoresOfSubjectArraySorted[numberOfSubjects-1] == averageScoreOfSubjectArray[j]) {
                    hardestSubjectIndex = j + 1;
                }
            }

            for (int scores : allScoresPerSubject) {
                if (scores < passMark) {
                    numberOfStudentThatFailed +=1;
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
            System.out.println("Total Score: " + totalScoreOfSubject);
            System.out.printf("%s%.2f\n", "Average Score : ", averageScoreOfSubject);
            System.out.println("Number of Passes: " + numberOfStudentThatPassed);
            System.out.println("Number of Failed Students: " + numberOfStudentThatFailed);
            System.out.println(" ");

//            System.out.println(Arrays.toString(averageScoreOfSubjectArray));
//            System.out.println(Arrays.toString(averageScoresOfSubjectArraySorted));

//            System.out.println(" ");
//            System.out.println(Arrays.toString(failSubjectArray));
//            System.out.println(Arrays.toString(passSubjectArray));
//            System.out.println(" ");
//
//            System.out.println(hardestSubjectIndex);
//            System.out.println(easiestSubjectIndex);
//            System.out.println(" ");
//
//            System.out.println(failSubjectArray[hardestSubjectIndex-1]);
//            System.out.println(passSubjectArray[easiestSubjectIndex-1]);

            numberOfFails = failSubjectArray[hardestSubjectIndex-1];
            numberOfPasses = passSubjectArray[easiestSubjectIndex-1];

            System.out.println("all scores per subject");
            System.out.println(Arrays.toString(allScoresPerSubject));
            System.out.println(Arrays.toString(allScoresPerSubjectSorted));

            highestScores[i] = allScoresPerSubjectSorted[0];
            lowestScores[i] = allScoresPerSubjectSorted[numberOfStudents-1];
        }

        for (int j = 0; j < highestScoreArrayLength; j++) {
            highestScoresSorted[j] = highestScores[j];
            lowestScoresSorted[j] = lowestScores[j];
        }

        sortArrayInt(highestScoresSorted);
        sortArrayInt(lowestScoresSorted);


        for (int j = 0; j < highestScoreArrayLength; j++) {

            if (highestScoresSorted[0] == highestScores[j]) {
                overallHighestStudentsIndex = j + 1;
                overallHighestScore = highestScoresSorted[0];

            }else if (lowestScoresSorted[highestScoreArrayLength-1] == lowestScores[j]) {
                overallLowestStudentsIndex = j + 1;
                overallLowestScore = lowestScoresSorted[highestScoreArrayLength-1];
            }

            if(lowestScores[j] == overallLowestScore) {
                studentWithLowestScore = j;
            }
        }

        System.out.println(studentWithLowestScore);

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("all highest scores");
        System.out.println(Arrays.toString(highestScores));
        System.out.println(Arrays.toString(highestScoresSorted));
        System.out.println(" ");
        System.out.println("all lowest scores");
        System.out.println(Arrays.toString(lowestScores));
        System.out.println(Arrays.toString(lowestScoresSorted));


        System.out.println(" ");
        System.out.printf("%s%d%s%d%s\n", "The Hardest Subject is Subject ", hardestSubjectIndex, " where ", numberOfFails, " student failed ");
        System.out.printf("%s%d%s%d%s\n", "The Easiest Subject is Subject ", easiestSubjectIndex, " where ", numberOfPasses, " student passed ");
        System.out.printf("%s%d%s%d%s%d\n", "The overall Highest score is scored by student ", 1234, " in subject ", overallHighestStudentsIndex, " scoring ", overallHighestScore);
        System.out.printf("%s%d%s%d%s%d\n", "The overall Lowest score is scored by student ", 1234, " in subject ", overallLowestStudentsIndex, " scoring ", overallLowestScore);
        System.out.println(" ");
    }



//        overall highest and lowest score
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

