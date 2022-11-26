package pl.dawid.springBootJPA_ProgramowanieSieciowe.appUser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/appuser")
public class AppUserController {
    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService){
        this.appUserService = appUserService;
    }

    @GetMapping
    public List<AppUser> getAppUsers(){
        return appUserService.findAllUsers();
    }

    @GetMapping("/find")
    public AppUser findUser(@RequestParam(value = "firstName") String firstName,
                            @RequestParam(value = "lastName") String lastName,
                            @RequestParam(value = "departmentName") String departmentName ){
        return appUserService.findUser(firstName, lastName, departmentName);
    }

    @GetMapping("/findByDepartment")
    public List<AppUser> findUsersFromDepartment(@RequestParam(value = "departmentName") String departmentName ){
        return appUserService.findUsersFromDepartment(departmentName);
    }
    @GetMapping("/findUsersWithPaymentIsHigher")
    public List<AppUser> findUsersWithPaymentIsHigher(@RequestParam(value = "payment") float payment ){
        return appUserService.findUsersWithPaymentIsHigher(payment);
    }

    @GetMapping("/getUserYearlySalary")
    public float getUserYearlySalary(@RequestParam(value="lastName") String lastName){
        return appUserService.getUserYearlySalary(lastName);
    }

    @PostMapping
    public AppUserDTO addUser(@RequestBody AppUserDTO appUserDTO){
        return appUserService.createOrUpdateUser(appUserDTO);
    }

    @PostMapping("/update")
    public AppUserDTO updateUser(@RequestParam(name="id") Long id, @RequestBody AppUserDTO appUserDTO){
        appUserDTO.setId(id);
        return appUserService.createOrUpdateUser(appUserDTO);
    }

}
