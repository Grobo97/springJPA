package pl.dawid.springBootJPA_ProgramowanieSieciowe.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAllDepartments(){
        return departmentRepository.findAll();
    };
    public Department findDepartmentManagedByUser(String firstName, String lastName){
        return departmentRepository.findByManager_FirstNameAndManager_LastName(firstName, lastName);
    };
    public Department findDepartmentWithMaxNumberOfEmployees(){
        return departmentRepository.findFirstByOrderByUsersDesc();
    };
    public Department findDepartmentWithMaxUsersSalary(){
        return departmentRepository.findFirstByOrderByDepartmentCostDesc();
    };
}
