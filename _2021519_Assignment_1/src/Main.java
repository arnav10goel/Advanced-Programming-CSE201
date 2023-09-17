import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args){
        Placement_Cell placement_cell = new Placement_Cell();

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Welcome to FutureBuilder");
            System.out.println("Enter the number for your corresponding choice:");
            System.out.println("1. Enter the Application");
            System.out.println("2. Exit the Application");
            int choice1 = scanner.nextInt();
            scanner.nextLine();
            if(choice1 == 2){
                System.out.println("Thanks for using Future Builder");
                break;
            }
            else{
                while(true){
                    System.out.println("Choose the mode you want to enter into: (Enter corresponding number)");
                    System.out.println("1. Enter as Student Mode");
                    System.out.println("2. Enter as Company Mode");
                    System.out.println("3. Enter as Placement Cell Mode");
                    System.out.println("4. Back");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    if(choice2 == 1){ //Student Mode
                        while(true){
                            System.out.println("Choose the Student Query to Perform (Enter the Number):");
                            System.out.println("1. Enter as Student (Give Student Name, Roll No, etc)");
                            System.out.println("2. Add Students");
                            System.out.println("3. Back");
                            int choice3 = scanner.nextInt();
                            scanner.nextLine();
                            if(choice3 == 1){
                                if(placement_cell.students_college.size() == 0){
                                    System.out.println("There are no students added right now");
                                }
                                else{
                                    System.out.print("Name: ");
                                    String name_in = scanner.nextLine();
                                    System.out.print("Roll No: ");
                                    int roll_in = scanner.nextInt();
                                    scanner.nextLine();
                                    int flag = 0;
                                    int indx = 0;
                                    for(int i = 0; i < placement_cell.students_college.size(); i++){
                                        if(name_in.equals(placement_cell.students_college.get(i).getName()) && roll_in == placement_cell.students_college.get(i).getRoll_no()){
                                            flag = 1;
                                            indx = i;
                                            break;
                                        }
                                    }
                                    Student current_student = placement_cell.students_college.get(indx);
                                    if(flag == 0){
                                        System.out.println("Student " + name_in + "doesn't exist");
                                    }
                                    else{
                                        while (true) {
                                            System.out.println("Welcome " + name_in);
                                            System.out.println("1. Register for Placement Drive");
                                            System.out.println("2. Register for Company");
                                            System.out.println("3. Get all Available Companies");
                                            System.out.println("4. Get Current Status");
                                            System.out.println("5. Update CGPA");
                                            System.out.println("6. Accept Offer");
                                            System.out.println("7. Reject Offer");
                                            System.out.println("8. Back");
                                            System.out.print("Choose the corresponding number: ");
                                            int choice_stu = scanner.nextInt();
                                            scanner.nextLine();
                                            if(choice_stu == 1){
                                                System.out.println("Enter the Date and Time for your Registration: ");
                                                System.out.print("Date-(dd/mm/yyyy)-format: ");
                                                String date_studentreg = scanner.nextLine();
                                                String[] arr_date_start = date_studentreg.split("/", 4); //Splits input date into dd/mm/yyyy
                                                System.out.print("Time: 24-hr (hh:mm)-format: ");
                                                String time_studentreg = scanner.nextLine();
                                                String[] arr_time_start = time_studentreg.split(":", 3); //Splits time into hh/mm

                                                LocalDateTime studentreg = LocalDateTime.of(Integer.parseInt(arr_date_start[2]), Integer.parseInt(arr_date_start[1]), Integer.parseInt(arr_date_start[0]), Integer.parseInt(arr_time_start[0]), Integer.parseInt(arr_time_start[1]));
                                                current_student.setStudent_reg_time(studentreg);
                                                if(studentreg.isAfter(placement_cell.getStudent_reg_end())){
                                                    System.out.println("Sorry you are late for student registrations, please try again next time");
                                                }
                                                else if(studentreg.isBefore(placement_cell.getStudent_reg_start())){
                                                    System.out.println("Student Registrations have not started yet, please try again later");
                                                }
                                                else{
                                                    placement_cell.students_registered.add(current_student);
                                                    current_student.setRegistered(true);
                                                    System.out.println(name_in+" is registered for the Placement Drive at IIITD!!");
                                                    System.out.println("Your details are as follows:");
                                                    System.out.println("Name " + current_student.getName());
                                                    System.out.println("Roll Number " + current_student.getRoll_no());
                                                    System.out.println("CGPA " + current_student.getCgpa());
                                                    System.out.println("Branch " + current_student.getBranch());
                                                }
                                            }
                                            else if(choice_stu == 2){
                                                if(!current_student.isRegistered()){
                                                    System.out.println("You have not registered for the placement drive");
                                                }
                                                else if(current_student.isBlocked()){
                                                    System.out.println("You are not eligible for this.");
                                                }
                                                else{
                                                    System.out.print("Enter name of the Company: ");
                                                    String company_choice = scanner.nextLine();
                                                    int flag2 = 0;
                                                    int indx2 = 0;
                                                    for(int i = 0; i < current_student.getEligible_comp().size(); i++){
                                                        if(current_student.getEligible_comp().get(i).getName().equals(company_choice)){
                                                            flag2 = 1;
                                                            indx2 = i;
                                                        }
                                                    }
                                                    if(flag2 == 0){
                                                        System.out.println("You are not eligible to apply for this company");
                                                    }
                                                    else{
                                                        Company current_company = current_student.getEligible_comp().get(indx2);
                                                        current_company.getInterested_students().add(current_student);
                                                        current_student.getInterested_comp().add(current_company);
                                                        current_student.setStatus("Applied");
                                                        System.out.println("Successfully registered for "+ current_company.getRole()+ " role at " + current_company.getName());
                                                    }
                                                }
                                            }
                                            else if(choice_stu == 3){
                                                current_student.getEligible_comp().clear();
                                                if(!current_student.isRegistered()){
                                                    System.out.println("You have not registered for the placement drive");
                                                }
                                                else if(current_student.isBlocked()){
                                                    System.out.println("You are not eligible for this.");
                                                }
                                                else if(!current_student.isPlaced()){ //Condition for unplaced student
                                                    System.out.println("List of all available companies is as follows: ");
                                                    for(int i = 0; i < placement_cell.companies_registered.size(); i++){
                                                        if(placement_cell.companies_registered.get(i).getGpa() <= current_student.getCgpa()){
                                                            Company current_company = placement_cell.companies_registered.get(i);
                                                            current_student.getEligible_comp().add(current_company);
                                                            System.out.println((i+1)+")");
                                                            System.out.println("Company Name: " + current_company.getName());
                                                            System.out.println("Company Role Offering: " + current_company.getRole());
                                                            System.out.println("Company Package: " + current_company.getCtc());
                                                            System.out.println("Company CGPA Criteria: " + current_company.getGpa());
                                                        }
                                                        else{
                                                            System.out.println("You are not eligible to apply for this company.");
                                                        }
                                                    }
                                                }
                                                else{ //Condition for Placed Student but Eligible for further placements
                                                    for(int i = 0; i < placement_cell.companies_registered.size(); i++){
                                                        if(placement_cell.companies_registered.get(i).getCtc() >= (3*current_student.getPay_package())){
                                                            if(placement_cell.companies_registered.get(i).getGpa() <= current_student.getCgpa()){
                                                                Company current_company = placement_cell.companies_registered.get(i);
                                                                current_student.getEligible_comp().add(current_company);
                                                                System.out.println((i+1)+")");
                                                                System.out.println("Company Name: " + current_company.getName());
                                                                System.out.println("Company Role Offering: " + current_company.getRole());
                                                                System.out.println("Company Package: " + current_company.getCtc());
                                                                System.out.println("Company CGPA Criteria: " + current_company.getGpa());
                                                            }
                                                            else{
                                                                System.out.println("You are not eligible to apply for this company.");
                                                            }
                                                        }
                                                        else{
                                                            System.out.println("You are not eligible to apply for this company.");
                                                        }
                                                    }
                                                }
                                            }
                                            else if(choice_stu == 4){
                                                if(!current_student.isRegistered()){
                                                    System.out.println("You have not registered for the placement drive");
                                                }
                                                else if(current_student.isBlocked()){
                                                    System.out.println("You are not eligible for this.");
                                                    System.out.println("Your status is: "+ current_student.getStatus());
                                                }
                                                else if(current_student.getOffers().size() == 0){
                                                    current_student.setStatus("Unoffered");
                                                    System.out.println("Your status is: "+ current_student.getStatus());
                                                    System.out.println("You haven't been offered yet");
                                                }
                                                else{
                                                    System.out.println("Your status is: "+ current_student.getStatus());
                                                    double max_ctc = 0;
                                                    int indx_company = 0;
                                                    for(int i = 0; i < current_student.getOffers().size(); i++){
                                                        if(current_student.getOffers().get(i).getCtc() > max_ctc){
                                                            max_ctc = current_student.getOffers().get(i).getCtc();
                                                            indx_company = i;
                                                        }
                                                    }
                                                    System.out.println("You have been offered a package of "+ max_ctc+ " lpa by the company " + current_student.getOffers().get(indx_company).getName());
                                                    System.out.println("Please accept the offer!!");

                                                }

                                            }
                                            else if(choice_stu == 5){
                                                System.out.println("Your current CGPA is "+ current_student.getCgpa());
                                                System.out.print("Enter your new CGPA: ");
                                                double gpa_updated = scanner.nextDouble();
                                                scanner.nextLine();
                                                placement_cell.update_gpa(current_student, gpa_updated);
                                            }
                                            else if(choice_stu == 6){
                                                if(!current_student.isRegistered()){
                                                    System.out.println("You have not registered for the placement drive");
                                                }
                                                else if(current_student.isBlocked()){
                                                    System.out.println("You are not eligible for this.");
                                                }
                                                else if(current_student.getOffers().size() == 0){
                                                    current_student.setStatus("Unoffered");
                                                    System.out.println("You haven't been offered yet");
                                                }
                                                else{
                                                    double max_ctc = 0;
                                                    int indx_company = 0;
                                                    for(int i = 0; i < current_student.getOffers().size(); i++){
                                                        if(current_student.getOffers().get(i).getCtc() > max_ctc){
                                                            max_ctc = current_student.getOffers().get(i).getCtc();
                                                            indx_company = i;
                                                        }
                                                    }
                                                    current_student.getAccepted_comp().add(current_student.getOffers().get(indx_company));
                                                    current_student.setPay_package(current_student.getOffers().get(indx_company).getCtc());
                                                    System.out.println("Congrats!! You have accepted the offer of "+ max_ctc+ " lpa by the company " + current_student.getOffers().get(indx_company).getName());
                                                }
                                            }
                                            else if(choice_stu == 7){
                                                if(!current_student.isRegistered()){
                                                    System.out.println("You have not registered for the placement drive");
                                                }
                                                else if(current_student.isBlocked()){
                                                    System.out.println("You are not eligible for this.");
                                                }
                                                else if(current_student.getOffers().size() == 0){
                                                    current_student.setStatus("Unoffered");
                                                    System.out.println("You haven't been offered yet");
                                                }
                                                else{
                                                    double max_ctc = 0;
                                                    int indx_company = 0;
                                                    for(int i = 0; i < current_student.getOffers().size(); i++){
                                                        if(current_student.getOffers().get(i).getCtc() > max_ctc){
                                                            max_ctc = current_student.getOffers().get(i).getCtc();
                                                            indx_company = i;
                                                        }
                                                    }
                                                    current_student.getOffers().remove(indx_company);
                                                    System.out.println("You have rejected the offer of "+ max_ctc+ " lpa by the company " + current_student.getOffers().get(indx_company).getName());
                                                    if(current_student.getOffers().size() == 0){
                                                        current_student.setBlocked(true);
                                                        current_student.setStatus("Blocked");
                                                        System.out.println("You rejected all available offers to you and hence you are Blocked from the Placement Process");
                                                    }
                                                }
                                            }
                                            else if(choice_stu == 8){
                                                break;
                                            }
                                            else{
                                                System.out.println("Not a Valid Choice");
                                            }
                                        }
                                    }
                                }
                            }
                            else if(choice3 == 2){
                                System.out.println("Please enter the number of students you want to enter:");
                                int num_students = scanner.nextInt();
                                scanner.nextLine();
                                for(int i = 0; i < num_students; i++){
                                    System.out.print("Name: ");
                                    String name = scanner.nextLine();
                                    System.out.print("Roll No: ");
                                    int roll_no = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("CGPA: ");
                                    double cgpa = scanner.nextDouble();
                                    scanner.nextLine();
                                    System.out.print("Branch: ");
                                    String branch = scanner.nextLine();
                                    Student student = new Student(name, roll_no, cgpa, branch);
                                    placement_cell.students_college.add(student);
                                }
                            }
                            else if(choice3 == 3){
                                break;
                            }
                            else{
                                System.out.println("Not a Valid Choice");
                            }
                        }
                    }
                    else if(choice2 == 2){ //Company Mode
                        while(true){
                            System.out.println("Choose the Company Query to Perform: (Enter corresponding number)");
                            System.out.println("1. Add Company and Details");
                            System.out.println("2. Choose Company");
                            System.out.println("3. Get Available Companies");
                            System.out.println("4. Back");

                            int choice4 = scanner.nextInt();
                            scanner.nextLine();
                            if(choice4 == 1){
                                System.out.print("Name: ");
                                String name = scanner.nextLine();
                                System.out.print("Role being Offered: ");
                                String role = scanner.nextLine();
                                System.out.print("CTC (lpa): ");
                                double ctc = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("CGPA (Requirement): ");
                                double cgpa = scanner.nextDouble();
                                scanner.nextLine();
                                Company company = new Company(name, role, ctc, cgpa);
                                placement_cell.companies.add(company);
                            }
                            else if(choice4 == 2){
                                System.out.println("Choose from the following Companies: ");
                                for(int i = 0; i < placement_cell.companies.size(); i++){
                                    System.out.println((i+1) + ". " + placement_cell.companies.get(i).getName());
                                }
                                System.out.print("Enter the corresponding number: ");
                                int indx = scanner.nextInt();
                                scanner.nextLine();
                                while (true){
                                    System.out.println("Welcome "+ placement_cell.companies.get(indx-1).getName());
                                    System.out.println("1. Update Role");
                                    System.out.println("2. Update Package");
                                    System.out.println("3. Update CGPA Criteria");
                                    System.out.println("4. Register to Institute Drive");
                                    System.out.println("5. Back");
                                    System.out.print("Enter the corresponding number: ");
                                    int company_choice = scanner.nextInt();
                                    scanner.nextLine();
                                    if(company_choice == 1){
                                        System.out.print("New Role being Offered: ");
                                        String role = scanner.nextLine();
                                        placement_cell.companies.get(indx-1).setRole(role);
                                    }
                                    else if(company_choice == 2){
                                        System.out.print("New CTC (lpa): ");
                                        double ctc = scanner.nextDouble();
                                        scanner.nextLine();
                                        placement_cell.companies.get(indx-1).setCtc(ctc);
                                    }
                                    else if(company_choice == 3){
                                        System.out.print("New CGPA (Requirement): ");
                                        double cgpa = scanner.nextDouble();
                                        scanner.nextLine();
                                        placement_cell.companies.get(indx-1).setGpa(cgpa);
                                    }
                                    else if(company_choice == 4){
                                        System.out.println("Enter the Date and Time for the Registration of your Company: ");
                                        System.out.print("Date-(dd/mm/yyyy)-format: ");
                                        String date_companyreg = scanner.nextLine();
                                        String[] arr_date_start = date_companyreg.split("/", 4); //Splits input date into dd/mm/yyyy
                                        System.out.print("Time: 24-hr (hh:mm)-format: ");
                                        String time_companyreg = scanner.nextLine();
                                        String[] arr_time_start = time_companyreg.split(":", 3); //Splits time into hh/mm

                                        LocalDateTime companyreg = LocalDateTime.of(Integer.parseInt(arr_date_start[2]), Integer.parseInt(arr_date_start[1]), Integer.parseInt(arr_date_start[0]), Integer.parseInt(arr_time_start[0]), Integer.parseInt(arr_time_start[1]));
                                        placement_cell.companies.get(indx-1).setCompany_reg_time(companyreg);
                                        if(companyreg.isBefore(placement_cell.getCompany_reg_start())){
                                            System.out.println("Company Registrations haven't started yet, please try again later.");
                                        }
                                        else if(companyreg.isAfter(placement_cell.getCompany_reg_end())){
                                            System.out.println("Company Registrations have ended, please try again in the next placement cycle");
                                        }
                                        else{
                                            placement_cell.companies_registered.add(placement_cell.companies.get(indx-1));
                                            placement_cell.companies.get(indx-1).setRegistered(true);
                                            System.out.println("Registered!");
                                        }
                                    }
                                    else if(company_choice == 5){
                                        break;
                                    }
                                    else{
                                        System.out.println("This is not a valid choice");
                                    }
                                }
                            }
                            else if(choice4 == 3){
                                System.out.println("The available companies are: ");
                                for(int i = 0; i < placement_cell.companies_registered.size(); i++){
                                    System.out.println((i+1) + ". " + placement_cell.companies_registered.get(i).getName());
                                }
                            }
                            else if(choice4 == 4){
                                break;
                            }
                            else{
                                System.out.println("This is not a valid choice");
                            }
                        }
                    }
                    else if(choice2 == 3){ //Placement Cell Mode
                        while(true){
                            System.out.println("Welcome to IIITD Placement Cell:");
                            System.out.println("1. Open Student Registrations");
                            System.out.println("2. Open Company Registrations");
                            System.out.println("3. Get Number of Student Registrations");
                            System.out.println("4. Get Number of Company Registrations");
                            System.out.println("5. Get Number of Offered/UnOffered/Blocked Students");
                            System.out.println("6. Get Student Details");
                            System.out.println("7. Get Company Details");
                            System.out.println("8. Get Average Package");
                            System.out.println("9. Get Company Process Results");
                            System.out.println("10. Back");
                            int choice5 = scanner.nextInt();
                            scanner.nextLine();
                            if(choice5 == 1){
                                System.out.println("Fill in the details: ");
                                System.out.println("Set the Opening Time for Student Registrations:");
                                System.out.print("Date-(dd/mm/yyyy)-format: ");
                                String date_studentreg = scanner.nextLine();
                                String[] arr_date_start = date_studentreg.split("/", 4); //Splits input date into dd/mm/yyyy
                                System.out.print("Time: 24-hr (hh:mm)-format: ");
                                String time_studentreg = scanner.nextLine();
                                String[] arr_time_start = time_studentreg.split(":", 3); //Splits time into hh/mm

                                LocalDateTime studentreg_start = LocalDateTime.of(Integer.parseInt(arr_date_start[2]), Integer.parseInt(arr_date_start[1]), Integer.parseInt(arr_date_start[0]), Integer.parseInt(arr_time_start[0]), Integer.parseInt(arr_time_start[1]));

                                System.out.println("Set the Ending Time for Student Registrations:");
                                System.out.print("Date-(dd/mm/yyyy)-format: ");
                                String date_studentreg2 = scanner.nextLine();
                                String[] arr_date_end = date_studentreg2.split("/", 4); //Splits input date into dd/mm/yyyy
                                System.out.print("Time: 24-hr (hh:mm)-format: ");
                                String time_studentreg2 = scanner.nextLine();
                                String[] arr_time_end = time_studentreg2.split(":", 3); //Splits time into hh/mm

                                LocalDateTime studentreg_end = LocalDateTime.of(Integer.parseInt(arr_date_end[2]), Integer.parseInt(arr_date_end[1]), Integer.parseInt(arr_date_end[0]), Integer.parseInt(arr_time_end[0]), Integer.parseInt(arr_time_end[1]));

                                if(studentreg_start.isBefore(placement_cell.getCompany_reg_end())){
                                    System.out.println("Student Registrations can't start before Company Registrations are over. Please try again later");
                                }
                                else{
                                    placement_cell.setStudent_reg_start(studentreg_start);
                                    placement_cell.setStudent_reg_end(studentreg_end);
                                }
                            }
                            else if(choice5 == 2){
                                System.out.println("Fill in the details: ");
                                System.out.println("Set the Opening Time for Company Registrations:");
                                System.out.print("Date-(dd/mm/yyyy)-format: ");
                                String date_companyreg = scanner.nextLine();
                                String[] arr_date_start = date_companyreg.split("/", 4); //Splits input date into dd/mm/yyyy
                                System.out.print("Time: 24-hr (hh:mm)-format: ");
                                String time_companyreg = scanner.nextLine();
                                String[] arr_time_start = time_companyreg.split(":", 3); //Splits time into hh/mm

                                LocalDateTime companyreg_start = LocalDateTime.of(Integer.parseInt(arr_date_start[2]), Integer.parseInt(arr_date_start[1]), Integer.parseInt(arr_date_start[0]), Integer.parseInt(arr_time_start[0]), Integer.parseInt(arr_time_start[1]));

                                System.out.println("Set the Ending Time for Company Registrations:");
                                System.out.print("Date-(dd/mm/yyyy)-format: ");
                                String date_companyreg2 = scanner.nextLine();
                                String[] arr_date_end = date_companyreg2.split("/", 4); //Splits input date into dd/mm/yyyy
                                System.out.print("Time: 24-hr (hh:mm)-format: ");
                                String time_companyreg2 = scanner.nextLine();
                                String[] arr_time_end = time_companyreg2.split(":", 3); //Splits time into hh/mm

                                LocalDateTime companyreg_end = LocalDateTime.of(Integer.parseInt(arr_date_end[2]), Integer.parseInt(arr_date_end[1]), Integer.parseInt(arr_date_end[0]), Integer.parseInt(arr_time_end[0]), Integer.parseInt(arr_time_end[1]));

                                placement_cell.setCompany_reg_start(companyreg_start);
                                placement_cell.setCompany_reg_end(companyreg_end);
                            }
                            else if(choice5 == 3){
                                System.out.println("The total number of registered students are: "+ Student.number_reg);
                            }
                            else if(choice5 == 4){
                                System.out.println("The total number of registered companies are: "+ Company.num_reg);
                            }
                            else if(choice5 == 5){
                                int blocked_stud = 0;
                                int offered_stud = 0;
                                int unoffered_stud = 0;
                                System.out.println("The following students are blocked: ");
                                for(int i = 0; i < placement_cell.students_registered.size(); i++){
                                    if(placement_cell.students_registered.get(i).isBlocked()){
                                        blocked_stud += 1;
                                        System.out.println((blocked_stud + ")"));
                                        System.out.println("Name: " + placement_cell.students_registered.get(i).getName());
                                        System.out.println("Roll No: " + placement_cell.students_registered.get(i).getRoll_no());
                                        System.out.println("CGPA: " + placement_cell.students_registered.get(i).getCgpa());
                                        System.out.println("Branch: " + placement_cell.students_registered.get(i).getBranch());
                                    }
                                }
                                System.out.println(blocked_stud + " number of students are blocked.");
                                System.out.println("The following students have received offers: ");
                                for(int i = 0; i < placement_cell.students_registered.size(); i++){
                                    if(placement_cell.students_registered.get(i).isPlaced()){
                                        offered_stud += 1;
                                        System.out.println((offered_stud + ")"));
                                        System.out.println("Name: " + placement_cell.students_registered.get(i).getName());
                                        System.out.println("Roll No: " + placement_cell.students_registered.get(i).getRoll_no());
                                        System.out.println("CGPA: " + placement_cell.students_registered.get(i).getCgpa());
                                        System.out.println("Branch: " + placement_cell.students_registered.get(i).getBranch());
                                        System.out.println("Package: "+ placement_cell.students_registered.get(i).getPay_package());
                                    }
                                }
                                System.out.println(offered_stud + " number of students have received offers.");
                                System.out.println("The following students have not received any offers: ");
                                for(int i = 0; i < placement_cell.students_registered.size(); i++){
                                    if(!placement_cell.students_registered.get(i).isPlaced() && !placement_cell.students_registered.get(i).isBlocked()){
                                        unoffered_stud += 1;
                                        System.out.println((unoffered_stud + ")"));
                                        System.out.println("Name: " + placement_cell.students_registered.get(i).getName());
                                        System.out.println("Roll No: " + placement_cell.students_registered.get(i).getRoll_no());
                                        System.out.println("CGPA: " + placement_cell.students_registered.get(i).getCgpa());
                                        System.out.println("Branch: " + placement_cell.students_registered.get(i).getBranch());
                                    }
                                }
                                System.out.println(unoffered_stud + " number of students have received offers.");
                            }
                            else if(choice5 == 6){
                                System.out.print("Name: ");
                                String name_in = scanner.nextLine();
                                System.out.print("Roll No: ");
                                int roll_in = scanner.nextInt();
                                scanner.nextLine();
                                int flag = 0;
                                int indx_stu = 0;
                                for(int i = 0; i < placement_cell.students_registered.size(); i++){
                                    if(name_in.equals(placement_cell.students_registered.get(i).getName()) && roll_in == placement_cell.students_registered.get(i).getRoll_no()){
                                        flag = 1;
                                        indx_stu = i;
                                        break;
                                    }
                                }
                                if(flag == 0){
                                    System.out.println("Student " + name_in + "doesn't exist");
                                }
                                else{
                                    Student current_student = placement_cell.students_registered.get(indx_stu);
                                    if(current_student.isBlocked()){
                                        System.out.println(current_student.getName() + " is blocked from the Placement Process");
                                    }
                                    else if(!current_student.isPlaced() && !current_student.isBlocked()){
                                        System.out.println(current_student.getName() + " applied for the following companies: ");
                                        for(int i = 0; i < current_student.getInterested_comp().size(); i++){
                                            System.out.println((i+1) +". "+ current_student.getInterested_comp().get(i).getName());
                                        }
                                        System.out.println(current_student.getName() + " has not received any offers");
                                    }
                                    else{
                                        System.out.println(current_student.getName() + " applied for the following companies: ");
                                        for(int i = 0; i < current_student.getInterested_comp().size(); i++){
                                            System.out.println((i+1) +". "+ current_student.getInterested_comp().get(i).getName());
                                        }
                                        System.out.println(current_student.getName() + " received offers from the following companies: ");
                                        for(int i = 0; i < current_student.getOffers().size(); i++){
                                            System.out.println((i+1) +". "+ current_student.getOffers().get(i).getName());
                                        }
                                        System.out.println(current_student.getName() + " accepted the offer in the company " + current_student.getAccepted_comp().get(0).getName());
                                    }
                                }
                            }
                            else if(choice5 == 7){
                                System.out.println("The available companies are: ");
                                for(int i = 0; i < placement_cell.companies_registered.size(); i++){
                                    System.out.println((i+1) + ". " + placement_cell.companies_registered.get(i).getName());
                                }
                                System.out.print("Enter the name of the Company you want results for: ");
                                String company_results = scanner.nextLine();
                                int flag = 0;
                                int indx3 = 0;
                                for(int i = 0; i < placement_cell.companies_registered.size(); i++){
                                    if(company_results.equals(placement_cell.companies_registered.get(i).getName())){
                                        indx3 = i;
                                        flag = 1;
                                        break;
                                    }
                                }
                                if(flag == 0){
                                    System.out.println("No such company name exists");
                                }
                                else{
                                    Company company_req = placement_cell.companies_registered.get(indx3);
                                    System.out.println(("Company Name: " + company_req.getName()));
                                    System.out.println(("Role: " + company_req.getRole()));
                                    System.out.println(("CTC(lpa): " + company_req.getCtc()));
                                    System.out.println(("CGPA Requirement: " + company_req.getGpa()));
                                    company_req.select_students(company_req.getInterested_students());
                                    System.out.println("The students offered by the Company " + company_req.getName() + " are: ");
                                    for(int i = 0; i < company_req.getSelected_students().size(); i++){
                                        company_req.getSelected_students().get(i).getOffers().add(company_req);
                                        System.out.println((i+1 + ")"));
                                        System.out.println("Name: " + company_req.getSelected_students().get(i).getName());
                                        System.out.println("Roll No: " + company_req.getSelected_students().get(i).getRoll_no());
                                    }
                                }
                            }
                            else if(choice5 == 8){
                                int count = 0;
                                int package_sum = 0;
                                for(int i = 0; i < placement_cell.students_registered.size(); i++){
                                    package_sum += placement_cell.students_registered.get(i).getPay_package();
                                    if(placement_cell.students_registered.get(i).getPay_package() != 0){
                                        count += 1;
                                    }
                                }
                                if(count == 0){
                                    System.out.println("Placement season hasn't begun yet");
                                }
                                else{
                                    double avg_package = package_sum/count;
                                    System.out.println("The average package for this Placement Drive is: " + avg_package);
                                }
                            }
                            else if(choice5 == 9){
                                System.out.println("The available companies are: ");
                                for(int i = 0; i < placement_cell.companies_registered.size(); i++){
                                    System.out.println((i+1) + ". " + placement_cell.companies_registered.get(i).getName());
                                }
                                System.out.print("Enter the name of the Company you want results for: ");
                                String company_results = scanner.nextLine();
                                int flag = 0;
                                int indx3 = 0;
                                for(int i = 0; i < placement_cell.companies_registered.size(); i++){
                                    if(company_results.equals(placement_cell.companies_registered.get(i).getName())){
                                        indx3 = i;
                                        flag = 1;
                                        break;
                                    }
                                }
                                if(flag == 0){
                                    System.out.println("No such company name exists");
                                }
                                else{
                                    Company company_req = placement_cell.companies_registered.get(indx3);
                                    company_req.select_students(company_req.getInterested_students());
                                    System.out.println("The selected students for Company " + company_req.getName() + " are: ");
                                    for(int i = 0; i < company_req.getSelected_students().size(); i++){
                                        company_req.getSelected_students().get(i).getOffers().add(company_req);
                                        company_req.getSelected_students().get(i).setStatus("Offered");
                                        System.out.println((i+1 + ")"));
                                        System.out.println("Name: " + company_req.getSelected_students().get(i).getName());
                                        System.out.println("Roll No: " + company_req.getSelected_students().get(i).getRoll_no());
                                        System.out.println("CGPA: " + company_req.getSelected_students().get(i).getCgpa());
                                        System.out.println("Branch: " + company_req.getSelected_students().get(i).getBranch());
                                    }
                                }
                            }
                            else if(choice5 == 10){
                                break;
                            }
                            else{
                                System.out.println("Not a valid choice");
                            }
                        }
                    }
                    else if(choice2 == 4){
                        break;
                    }
                    else{
                        System.out.println("Not a valid choice");
                    }
                }
            }
        }
        scanner.close();
    }
}
