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
        return departmentRepository.findAllDepartments();
    };
    public Department findDepartmentManagedByUser(String firstName, String lastName){
        return departmentRepository.findDepartmentManagedByUser(firstName, lastName);
    };
    public Department findDepartmentWithMaxNumberOfEmployees(){
        return departmentRepository.findDepartmentWithMaxNumberOfEmployees();
    };
    public Department findDepartmentWithMaxUsersSalary(){
        return departmentRepository.findDepartmentWithMaxUsersSalary();
    };
}
