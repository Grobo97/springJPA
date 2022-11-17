package pl.dawid.springBootJPA_ProgramowanieSieciowe.department;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findAll();

    Department findByManager_FirstNameAndManager_LastName(String firstName, String lastName);

    Department findFirstByOrderByUsersDesc();


    Department findFirstByOrderByDepartmentCostDesc();

}
