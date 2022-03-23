public class Student {
    private String OperationCode;
    private String studentNumber;
    private String studentLastName;
    private String homeDepartment;
    private String program;
    private String year;

    public Student(String data) {
        this.OperationCode = (data.substring(0, 1));
        this.studentNumber = (data.substring(1, 8));
        String d = (data.substring(8, 33));
        this.studentLastName = d.trim();
        this.homeDepartment = (data.substring(33, 37));
        this.program = (data.substring(37, 41));
        this.year = (data.substring(41, 42));
    }

    public Student() {
    }

    public String getOperationCode() {
        return this.OperationCode;
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }

    public String getStudentLastName() {
        return this.studentLastName;
    }

    public String getHomeDepartment() {
        return this.homeDepartment;
    }

    public String getProgram() {
        return this.program;
    }

    public String getYear() {
        return this.year;
    }

    public void setOperationCode(String operationCode) {
        this.OperationCode = operationCode;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public void setHomeDepartment(String homeDepartment) {
        this.homeDepartment = homeDepartment;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(String year) {
        this.year = year;
    }

    

}
