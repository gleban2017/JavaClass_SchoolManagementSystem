package CoreJava.MainEntryPoint;

import CoreJava.DAO.AttendingDAO;
import CoreJava.DAO.CourseDAO;
import CoreJava.DAO.StudentDAO;
import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Student;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainRunner {
    public static void main(String[] args) throws IOException {
        System.out.println("Are you a(n)");
        System.out.println("1. Student");
        System.out.println("2. Quit");
        System.out.print("Answer: ");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        System.out.println("---------------------------------------------------");
        
        if(answer == 1){
            StudentDAO studentDAO = new StudentDAO();
            List<Student> studentList = studentDAO.getStudents();
            System.out.print("Enter your email: ");
            in.nextLine();
            String email = in.nextLine();
            System.out.print("Enter your password: ");
            String password = in.nextLine();
            System.out.println("---------------------------------------------------");

            if(studentDAO.validateUser(studentList, email, password)){
                CourseDAO courseDAO = new CourseDAO();
                AttendingDAO attendingDAO = new AttendingDAO();
                Student student = studentDAO.getStudentByEmail(studentList, email);
                List<Course> courseList = courseDAO.getAllCourses();
                List<Attending> attendingList = attendingDAO.getAttending();

                myClasses(student, courseList, attendingList);
                boolean is_active=true;
                
                while(is_active==true) {
		                System.out.println("---------------------------------------------------");
		                System.out.println("What would you like to do?");
		                System.out.println("1. Register for a new Class");
		                System.out.println("2. Log Out");
		                System.out.print("Answer: ");
		                answer = in.nextInt();

		                if(answer == 1){
		                    //Display a list of all Classes
		                	System.out.println("---------------------------------------------------");
		                    allClasses(courseList);
		                    System.out.print("Select Course by ID Number: ");
		                    int courseID = in.nextInt();
		                    System.out.println("Attempting to Register...");
		                    String s_courseID="CS00"+courseID;
		                    attendingDAO.registerStudentToCourse(attendingList, student.getEmail(), s_courseID);
		                    myClasses(student, courseList, attendingList);
		                }

		                else{System.out.println("Logging Out...");
		                is_active=false;}
                }
            }
            else {
                System.out.println("Invalid Email or Password.");
            }
        }

        System.out.println("Closing Program. Goodbye.");
    }

    public static void myClasses(Student student, List<Course> courseList, List<Attending> attendingList){
        System.out.println("My Classes: ");
        System.out.printf("%-5s|%-25s|%-25s", "#", "COURSE NAME", "INSTRUCTOR NAME");
        System.out.println("");
        AttendingDAO attendingDAO = new AttendingDAO();
        List<Course> courses = attendingDAO.getStudentCourses(courseList, attendingList, student.getEmail());
        for(Course course : courses){
            System.out.printf("%-5s|%-25s|%-25s", course.getID(), course.getName(), course.getInstructor());
            System.out.println("");
        }
    }

    public static void allClasses(List<Course> courseList){
        System.out.println("Available Classes: ");
        System.out.printf("%-5s|%-25s|%-25s", "#", "COURSE NAME", "INSTRUCTOR NAME");
        System.out.println("");
        for(Course course : courseList){
            System.out.printf("%-5s|%-25s|%-25s", course.getID(), course.getName(), course.getInstructor());
            System.out.println("");
        }
    }
}
