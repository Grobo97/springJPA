package pl.dawid.springBootJPA_ProgramowanieSieciowe.appUser;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import pl.dawid.springBootJPA_ProgramowanieSieciowe.department.Department;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@Entity(name="appUser")
@Table(name="appUser")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
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
    @JoinColumn(name="department", referencedColumnName = "DEP_ID")
    @JsonBackReference
    private Department department;

}
