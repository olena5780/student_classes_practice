import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */

        int students = 0;
        int countMathStudents = 0;
        int countScienceStudents = 0;

        ArrayList<Student> listOfStudents = new ArrayList();

        while (students < 3) {
            System.out.println(UserQuestions.askToJoin);

            Scanner input = new Scanner(System.in);
            String ans = input.nextLine();

            if (ans.toLowerCase().contains("y"))
                System.out.println(UserQuestions.askFirstName);
                String firstName = input.nextLine();
                System.out.println(UserQuestions.askLastName);
                String lastName = input.nextLine();
                System.out.println(UserQuestions.askAge);
                int age = input.nextInt();
                input.nextLine();
                try {
                    if (age <= 20) throw new RuntimeException(age + " is not allowed!");
                } catch (RuntimeException c) {
                    c.printStackTrace();
                    input.nextLine();
                    continue;
                }
                System.out.println(UserQuestions.askGender);
                String gender = input.nextLine();
                System.out.println(UserQuestions.askClassName);
                String className = input.nextLine();

                try {
                    if (!className.equalsIgnoreCase("Math") && !className.equalsIgnoreCase("Science"))
                        throw new RuntimeException(className + " is not allowed!");
                } catch (RuntimeException c) {
                    c.printStackTrace();
                    continue;
                }

                if (className.toLowerCase().contains("math")) {
                    MathStudent mathStudent = new MathStudent(firstName, lastName, age, gender, className);
                    listOfStudents.add(mathStudent);
                    countMathStudents++;
                    students++;
                } else {
                    ScienceStudent scienceStudent = new ScienceStudent(firstName, lastName, age, gender, className);
                    listOfStudents.add(scienceStudent);
                    countScienceStudents++;
                    students++;

                }
            }


            for (Student s : listOfStudents) {
                System.out.println(s);
            }

            System.out.println("Math students = " + countMathStudents);
            System.out.println("Science students = " + countScienceStudents);


        }
    }







