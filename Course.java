package CoreJava.Models;

public class Course {
	private String courseID;
	private String courseName;
	private String instructor;

	//Constructo1
	public Course() {}
	
	
	//Constructor2
	public Course(String id, String name, String prof) {
		courseID=id;
		courseName=name;
		instructor=prof;
	}
	
	
	//Setters-Getters
    public void setID(String courseid){this.courseID=courseid;

    }

    public String getID(){return this.courseID;

    }

    public void setName(String name){this.courseName=name;

    }

    public String getName(){return this.courseName;

    }

    public void setInstructor(String instructor){this.instructor=instructor;

    }

    public String getInstructor(){return this.instructor;

    }




}
