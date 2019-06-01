package CoreJava.Models;

public class Attending {
	private String courseID;
	private String studentEmail;
	
	//Consructor1
	public Attending() {}
	
	
	//Constructor2
	public Attending(String id, String email) {
		courseID=id;
		studentEmail=email;
	};

	
	//Setters -Getters
    public void setCourseID(String courseID){this.courseID=courseID;

    }

    public String getCourseID(){return this.courseID;

    }

    public void setStudentEmail(String studentEmail){this.studentEmail=studentEmail;

    }

    public String getStudentEmail(){return this.studentEmail;

    }
}
