import java.util.*;
import java.time.*;

public class Placement_Cell {
    ArrayList<Student> students_college = new ArrayList<Student>();
    ArrayList<Company> companies = new ArrayList<Company>();
    ArrayList<Student> students_registered = new ArrayList<Student>();

    ArrayList<Company> companies_registered = new ArrayList<>();

    private LocalDateTime company_reg_start = LocalDateTime.of(99999,01,01,23,59); //Default time set very high to prevent any student or company from registering before the drive starts
    private LocalDateTime company_reg_end = LocalDateTime.of(99999,01,01,23,59);

    private LocalDateTime student_reg_start = LocalDateTime.of(99999,01,01,23,59);
    private LocalDateTime student_reg_end = LocalDateTime.of(99999,01,01,23,59);

    public void update_gpa(Student student, double gpa){
        student.setCgpa(gpa);
    }

    public LocalDateTime getCompany_reg_end() {
        return company_reg_end;
    }

    public LocalDateTime getCompany_reg_start() {
        return company_reg_start;
    }

    public void setCompany_reg_end(LocalDateTime company_reg_end) {
        this.company_reg_end = company_reg_end;
    }

    public void setCompany_reg_start(LocalDateTime company_reg_start) {
        this.company_reg_start = company_reg_start;
    }

    public LocalDateTime getStudent_reg_start() {
        return student_reg_start;
    }

    public LocalDateTime getStudent_reg_end() {
        return student_reg_end;
    }

    public void setStudent_reg_start(LocalDateTime student_reg_start) {
        this.student_reg_start = student_reg_start;
    }

    public void setStudent_reg_end(LocalDateTime student_reg_end) {
        this.student_reg_end = student_reg_end;
    }
}
