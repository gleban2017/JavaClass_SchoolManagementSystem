package CoreJava.DAO;

import CoreJava.Models.Course;
import CoreJava.Models.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public List<Course> getAllCourses() throws NumberFormatException, IOException{
    	
       	//generate FileReader
    	String course_csv_loc="src/courses.csv";
    	File course_file=new File(course_csv_loc);
    	List<Course> course_list=new ArrayList<Course>();
    	BufferedReader c_breader=new BufferedReader(new FileReader(course_file));
    	
    	//Check each line in CSV, parse and import into Courset Object
    	String line="";
    	while((line=c_breader.readLine())!=null) {
    		String[] tokens=line.split(",");
    		Course cs=new Course();
    		cs.setID(tokens[0]);
    		cs.setName(tokens[1]);
    		cs.setInstructor(tokens[2]);
    		
    		//Add Course object to the List
    		course_list.add(cs);
    	}
    	return course_list;

    }
}
