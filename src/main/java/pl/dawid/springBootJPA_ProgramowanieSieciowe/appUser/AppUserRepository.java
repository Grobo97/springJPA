package pl.dawid.springBootJPA_ProgramowanieSieciowe.appUser;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findAllByFirstNameAndLastNameAndDepartmentName(String firstName, String lastName, String departmentName);

    List<AppUser> findByDepartmentName(String departmentName);

    List<AppUser> findByPaymentGreaterThan(float payment);
}
