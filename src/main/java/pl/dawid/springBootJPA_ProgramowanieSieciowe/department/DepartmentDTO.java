package pl.dawid.springBootJPA_ProgramowanieSieciowe.department;

import lombok.Data;
import pl.dawid.springBootJPA_ProgramowanieSieciowe.appUser.AppUser;

import java.util.List;

@Data
public class DepartmentDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String mail;
    private String www;
    private String description;
    private AppUser manager;
    private List<AppUser> users;

    public DepartmentDTO buildDTO(Department department) {
        if(department != null) {
            this.setId(department.getId());
            this.setName(department.getName());
            this.setAddress(department.getAddress());
            this.setPhone(department.getPhone());
            this.setMail(department.getMail());
            this.setWww(department.getWWW());
            this.setDescription(department.getDescription());
            this.setManager(department.getManager());
            this.setUsers(department.getUsers());
        }
        return this;
    }

    public Department toEntity() {
        Department department = new Department();
        department.setId(this.getId());
        department.setName(this.getName());
        department.setAddress(this.getAddress());
        department.setPhone(this.getPhone());
        department.setMail(this.getMail());
        department.setWWW(this.getWww());
        department.setDescription(this.getDescription());
        department.setManager(this.getManager());
        department.setUsers(this.getUsers());
        return department;
    }
}
