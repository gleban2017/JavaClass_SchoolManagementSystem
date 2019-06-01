package CoreJava.DAO;


import CoreJava.Models.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

public class StudentDAO {
    public List<Student>  getStudents() throws IOException{
    	
    	//generate FileReader
    	String student_csv_loc="src/students.csv";
    	File student_file=new File(student_csv_loc);
    	List<Student> student_list=new ArrayList<Student>();
    	BufferedReader breader=new BufferedReader(new FileReader(student_file));
    	
    	//Check each line in CSV, parse and import into Student Object
    	String line="";
    	while((line=breader.readLine())!=null) {
    		String[] tokens=line.split(",");
    		Student st=new Student();
    		st.setEmail(tokens[0]);
    		st.setName(tokens[1]);
    		st.setPass(tokens[2]);
    		
    		//Add Student object to the List
    		student_list.add(st);
    	}
    	return student_list;

    }

    public Student getStudentByEmail(List<Student> studentList, String studentEmail){
    	
    	Student found_Student=new Student();
    	for(Student each_student: studentList) {
    		
    		// For each Student object, compare Student's credentials vs the ones given
    		  if((each_student.getEmail().equals(studentEmail))) {
    			found_Student=each_student;
    		}
    	}
    	
    	return found_Student;

    }

    public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass){
    	boolean is_found=false;
    	
    	for(Student each_student: studentList) {
    		// For each Student object, compare Student's credentials vs the ones given
    		if((each_student.getEmail().equals(studentEmail)) && (each_student.getPass().equals(studentPass))) {
    			is_found=true;
    			break;
    		}
    	}
    	return is_found;

    }
}
