package pl.dawid.springBootJPA_ProgramowanieSieciowe.appUser;

import pl.dawid.springBootJPA_ProgramowanieSieciowe.department.Department;

import javax.persistence.*;
import java.util.Date;


@Entity(name="appUser")
@Table(name="appUser")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String description;
    private float payment;
    private float bonus;
    private Date dateOfPayment;
    @ManyToOne
    @JoinTable(
            name = "departments_apps",
            joinColumns = {@JoinColumn(name = "department_id")},
            inverseJoinColumns = {@JoinColumn(name = "appuser_id")}
    )
    private Department department;
    @Override
    public String toString() {
        return "AppUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", payment=" + payment +
                ", bonus=" + bonus +
                ", dateOfPayment=" + dateOfPayment +
                '}';
    }
    public AppUser() {};
    public AppUser(Long id) {
        this.id = id;
    };
    public AppUser(String userName, String password, String firstName, String lastName, String description, float payment, float bonus, Date dateOfPayment) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.payment = payment;
        this.bonus = bonus;
        this.dateOfPayment = dateOfPayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() {
        return description;
    }

    public float getPayment() {
        return payment;
    }

    public float getBonus() {
        return bonus;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public void setDateOfPayment(Date dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
