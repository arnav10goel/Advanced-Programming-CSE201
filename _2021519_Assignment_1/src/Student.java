import java.util.*;
import java.time.*;
public class Student {
    private String name;
    private int roll_no;
    private double cgpa;
    private String branch;

    private double pay_package;

    private String status;

    private LocalDateTime student_reg_time;

    private boolean registered;
    private boolean blocked;
    private boolean placed;
    static int number_reg = 0;

    private ArrayList<Company> offers = new ArrayList<>();
    private ArrayList<Company> eligible_comp = new ArrayList<>();
    private ArrayList<Company> interested_comp = new ArrayList<>();

    private ArrayList<Company> accepted_comp = new ArrayList<>();

    Student(String x, int y, double z, String e){
        this.name = x;
        this.roll_no = y;
        this.cgpa = z;
        this.branch = e;
        this.pay_package = 0;
        this.status = "Not Applied";
        this.registered = false;
        this.blocked = false;
        this.placed = false;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getBranch() {
        return branch;
    }

    public LocalDateTime getStudent_reg_time() {
        return student_reg_time;
    }

    public double getPay_package() {
        return pay_package;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public boolean isRegistered() {
        return registered;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public ArrayList<Company> getOffers() {
        return offers;
    }

    public ArrayList<Company> getEligible_comp() {
        return eligible_comp;
    }

    public ArrayList<Company> getInterested_comp() {
        return interested_comp;
    }

    public ArrayList<Company> getAccepted_comp() {
        return accepted_comp;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPay_package(double pay_package) {
        this.pay_package = pay_package;
    }

    public void setStudent_reg_time(LocalDateTime student_reg_time) {
        this.student_reg_time = student_reg_time;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
        number_reg += 1;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
        this.status = "Blocked";
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }
}

