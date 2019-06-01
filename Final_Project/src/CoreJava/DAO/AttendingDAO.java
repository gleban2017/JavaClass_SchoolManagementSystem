package CoreJava.DAO;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AttendingDAO {
	
	String att_csv_loc="src/attending.csv";

    public List<Attending> getAttending() throws NumberFormatException, IOException{
    	
    	//generate FileReader
    	
    	File att_file=new File(att_csv_loc);
    	List<Attending> att_list=new ArrayList<Attending>();
    	BufferedReader c_breader=new BufferedReader(new FileReader(att_file));
    	
    	//Check each line in CSV, parse and import into Aattending Object
    	String line="";
    	while((line=c_breader.readLine())!=null) {
    		String[] tokens=line.split(",");
    		Attending att=new Attending();
    		att.setCourseID(tokens[0]);
    		att.setStudentEmail(tokens[1]);
    		
    		
    		//Add Attending object to the List
    		att_list.add(att);
    	}
    	return att_list;


    }

    public void registerStudentToCourse(List<Attending> attending, String studentEmail, String courseID) throws IOException{
    	boolean is_already_registered=false;
    	
    	for(Attending att: attending) {
    		if(att.getStudentEmail().equals(studentEmail) && att.getCourseID().equals(courseID)) {
    			is_already_registered=true;
    			System.out.println("You are already registered for this course");
    			System.out.println("---------------------------------------------------");
    			break;
    		}
    	}
    	
    	//If Student is not attending the course, add it to the list
    	if(is_already_registered!=true) {
    		Attending new_att=new Attending();
    		new_att.setCourseID(courseID);
    		new_att.setStudentEmail(studentEmail);
    		attending.add(new_att);
    		
    		System.out.println("You have successfully registered a new class.");
    		System.out.println("---------------------------------------------------");
    		System.out.println("");
    		saveAttending(attending);
    		
    	}
    	 	
    	

    }
    

    public List<Course> getStudentCourses(List<Course> courseList, List<Attending> attending, String studentEmail){
    	
    	List<Course> cs_list=new ArrayList<Course>();
    	
    	//Start looking through the Attending list
    	for(Attending att_list: attending) {
    		//If email is found in the Attending Object
    		if(att_list.getStudentEmail().equals(studentEmail)) {
    			String Att_id=att_list.getCourseID();
    			//Start looking through the Course object list
    			for(Course student_courses: courseList) {
    				//If Id in Course Object matches id in Attending object
    				if(student_courses.getID().equals(Att_id)) {
    					
    					Course temp=student_courses;
    					//Add Course to the list
    					cs_list.add(temp);
    				}
    			}
    			
    		}
    	}
    	return cs_list;
    }

    public void saveAttending(List<Attending> attending) throws IOException{
    	FileWriter fr=new FileWriter(att_csv_loc, false);
    	for(Attending att: attending) {
    		fr.write(att.getCourseID()+","+att.getStudentEmail()+"\n");
    		
    	}
    	fr.close();
    	

    }

}
