package CoreJava.Models;

public class Student {
	private String name;
	private String email;
	private String pass;

	
	//Constructor1
	public Student() {}
	
	//Constructor2
	public Student(String name, String email, String pass) {
		this.name=name;
		this.email=email;
		this.pass=pass;
	}
	
	
	
	//Setters - Getters
    public void setEmail(String email){
    	this.email=email;

    }

    public String getEmail(){return this.email;

    }

    public void setName(String name){this.name=name;

    }

    public String getName(){return this.name;

    }

    public void setPass(String pass){this.pass=pass;

    }

    public String getPass(){return this.pass;

    }
}