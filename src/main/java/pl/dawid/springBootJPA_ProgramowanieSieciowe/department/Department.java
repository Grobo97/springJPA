package pl.dawid.springBootJPA_ProgramowanieSieciowe.department;


import pl.dawid.springBootJPA_ProgramowanieSieciowe.appUser.AppUser;

import javax.persistence.*;
import java.util.List;

@Entity(name="department")
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String mail;
    private String WWW;
    private String description;
    @OneToOne
    private AppUser manager;

    @OneToMany(mappedBy = "department")
    private List<AppUser> users;
    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", WWW='" + WWW + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    public Department() {};
    public Department(Long id) {
        this.id = id;
    };
    public Department(String name, String address, String phone, String mail, String WWW, String description) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.WWW = WWW;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWWW() {
        return WWW;
    }

    public void setWWW(String WWW) {
        this.WWW = WWW;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppUser getManager() {
        return manager;
    }

    public void setManager(AppUser manager) {
        this.manager = manager;
    }

    public List<AppUser> getUsers() {
        return users;
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }
}
