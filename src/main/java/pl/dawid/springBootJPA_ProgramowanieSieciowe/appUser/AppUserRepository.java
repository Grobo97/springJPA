package pl.dawid.springBootJPA_ProgramowanieSieciowe.appUser;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query("select au from appUser au")
    List<AppUser> findAllUsers();

    @Query(value="select au.* from app_user au " +
            "join departments_apps depAps on depAps.appuser_id = au.id " +
            "join department dep on depAps.department_id = dep.id " +
            "where au.first_name = ?1 and au.last_name = ?2 and dep.name = ?3", nativeQuery = true)
    AppUser findUser(String firstName, String lastName, String departmentName);

    @Query(value="select au.* from app_user au " +
            "join departments_apps depAps on depAps.appuser_id = au.id " +
            "join department dep on depAps.department_id = dep.id " +
            "where dep.name = ?1", nativeQuery = true)
    List<AppUser> findUsersFromDepartment(String departmentName);


    @Query("Select au From appUser au where au.payment > ?1")//, nativeQuery=true)
    List<AppUser> findUsersWithPaymentIsHigher(float payment);
}
