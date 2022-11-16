package pl.dawid.springBootJPA_ProgramowanieSieciowe.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }
    @GetMapping()
    public List<Department> findAllDepartments(){
        return departmentService.findAllDepartments();
    };
    @GetMapping("/find")
    public Department findDepartmentManagedByUser(@RequestParam(name = "firstName") String firstName,
                                                  @RequestParam(name = "lastName") String lastName){
        return departmentService.findDepartmentManagedByUser(firstName, lastName);
    };
    @GetMapping("/findByMaxEmployees")
    public Department findDepartmentWithMaxNumberOfEmployees(){
        return departmentService.findDepartmentWithMaxNumberOfEmployees();
    };
    @GetMapping("/findByMaxSalary")
    public Department findDepartmentWithMaxUsersSalary(){
        return departmentService.findDepartmentWithMaxUsersSalary();
    };
}
