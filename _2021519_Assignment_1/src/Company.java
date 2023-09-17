import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.time.*;
public class Company {

    Random random = new Random();
    private String name;
    private String role;
    private double ctc;
    private double gpa;

    private boolean registered;
    private LocalDateTime company_reg_time;
    private ArrayList<Student> interested_students = new ArrayList<>();

    private ArrayList<Student> selected_students = new ArrayList<>();

    static int num_reg = 0;
    Company(String x, String y, double z, double w){
        this.name = x;
        this.role = y;
        this.ctc = z;
        this.gpa = w;
        this.registered = false;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getGpa() {
        return gpa;
    }

    public double getCtc() {
        return ctc;
    }

    public LocalDateTime getCompany_reg_time() {
        return company_reg_time;
    }

    public ArrayList<Student> getInterested_students() {
        return interested_students;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setCtc(double ctc) {
        this.ctc = ctc;
    }

    public void setCompany_reg_time(LocalDateTime company_reg_time) {
        this.company_reg_time = company_reg_time;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
        num_reg += 1;
    }

    public void select_students(@NotNull ArrayList<Student> interested_students) { //ASSUMPTION - I am assuming a company at random selects 3 students at max
        if(interested_students.size() == 0){
            return;
        }
        else if(interested_students.size() <= 3){
            for(int i = 0; i < interested_students.size(); i++){
                this.selected_students.add(interested_students.get(i));
            }
        }
        else{
            int len = interested_students.size();
            int random_num = random.nextInt(len);
            this.selected_students.add(interested_students.get((random_num)%(len)));
            this.selected_students.add(interested_students.get((random_num+1)%(len)));
            this.selected_students.add(interested_students.get((random_num+2)%(len)));
        }
    }

    public ArrayList<Student> getSelected_students() {
        return selected_students;
    }
}

