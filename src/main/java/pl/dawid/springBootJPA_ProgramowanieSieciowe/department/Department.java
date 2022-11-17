package pl.dawid.springBootJPA_ProgramowanieSieciowe.department;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import pl.dawid.springBootJPA_ProgramowanieSieciowe.appUser.AppUser;
import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@Entity(name="department")
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEP_ID")
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String mail;
    private String WWW;
    private String description;
    @OneToOne
    private AppUser manager;

    @OneToMany(targetEntity = AppUser.class, mappedBy = "department")
    @JsonManagedReference
    private List<AppUser> users;

    private float departmentCost;

    public void setDepartmentCost(){
        this.departmentCost = 0f;
        for(AppUser appUser : users){
            this.departmentCost = this.departmentCost + appUser.getPayment() + appUser.getBonus();
        }
    }

}
