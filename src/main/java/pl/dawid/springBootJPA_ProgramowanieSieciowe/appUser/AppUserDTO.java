package pl.dawid.springBootJPA_ProgramowanieSieciowe.appUser;


import lombok.Data;
import pl.dawid.springBootJPA_ProgramowanieSieciowe.department.Department;

import java.util.Date;

@Data
public class AppUserDTO {
    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String description;
    private float payment;
    private float bonus;
    private Date dateOfPayment;
    private Department department;

    public AppUserDTO buildDTO(AppUser appUser) {
        if(appUser != null) {
            this.setId(appUser.getId());
            this.setUserName(appUser.getUserName());
            this.setPassword(appUser.getPassword());
            this.setFirstName(appUser.getFirstName());
            this.setLastName(appUser.getLastName());
            this.setDescription(appUser.getDescription());
            this.setPayment(appUser.getPayment());
            this.setBonus(appUser.getBonus());
            this.setDateOfPayment(appUser.getDateOfPayment());
            this.setDepartment(appUser.getDepartment());
        }
        return this;
    }

    public AppUser toEntity() {
        AppUser appUser = new AppUser();
        appUser.setId(this.getId());
        appUser.setUserName(this.getUserName());
        appUser.setPassword(this.getPassword());
        appUser.setFirstName(this.getFirstName());
        appUser.setLastName(this.getLastName());
        appUser.setDescription(this.getDescription());
        appUser.setPayment(this.getPayment());
        appUser.setBonus(this.getBonus());
        appUser.setDateOfPayment(this.getDateOfPayment());
        appUser.setDepartment(this.getDepartment());
        return appUser;
    }
}
