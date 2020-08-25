package APIhttpClient.PayLoad;

public class payLoad {
	
	String FirstName;
	String LastName;
	int subjectID;
	int EmployeeID;
	int DepartmentID;
	String id;
	
	public payLoad() {
		
	}
	
	public payLoad(String FirstName, String LastName, int subjectID, int EmployeeID, int DepartmentID) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.subjectID = subjectID;
		this.EmployeeID = EmployeeID;
		this.DepartmentID = DepartmentID;
//		this.id=id;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public int getDepartmentID() {
		return DepartmentID;
	}

	public void setDepartmentID(int departmentID) {
		DepartmentID = departmentID;
	}

}
