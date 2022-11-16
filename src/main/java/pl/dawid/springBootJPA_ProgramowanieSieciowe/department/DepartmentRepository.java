package pl.dawid.springBootJPA_ProgramowanieSieciowe.department;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("Select dep from department dep")
    List<Department> findAllDepartments();

    @Query(value="select * from department dep " +
            "join departments_apps depAps on depAps.department_id = dep.id " +
            "join app_user au on depAps.appuser_id = au.id " +
            "where au.first_name = ?1 and au.last_name = ?2",nativeQuery = true)
    Department findDepartmentManagedByUser(String firstName, String lastName);
    @Query(value="select dep.id from department dep " +
            "join departments_apps depAps on depAps.department_id = dep.id " +
            "order by count(dep.id) desc " +
            "limit 1",nativeQuery = true)
    Department findDepartmentWithMaxNumberOfEmployees();
    @Query(value="select dep.id from department dep " +
            "join departments_apps depAps on depAps.department_id = dep.id " +
            "join app_user au on depAps.appuser_id = au.id " +
            "group by dep.id " +
            "order by sum(au.payment) desc " +
            "limit 1", nativeQuery = true)
    Department findDepartmentWithMaxUsersSalary();

}
