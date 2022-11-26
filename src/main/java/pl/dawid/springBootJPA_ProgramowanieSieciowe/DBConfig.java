package pl.dawid.springBootJPA_ProgramowanieSieciowe;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.dawid.springBootJPA_ProgramowanieSieciowe.appUser.AppUser;
import pl.dawid.springBootJPA_ProgramowanieSieciowe.appUser.AppUserRepository;
import pl.dawid.springBootJPA_ProgramowanieSieciowe.department.Department;
import pl.dawid.springBootJPA_ProgramowanieSieciowe.department.DepartmentRepository;

import java.util.Date;
import java.util.List;

@Configuration
public class DBConfig {
    @Bean
    CommandLineRunner commandLineRunner(DepartmentRepository departmentRepository, AppUserRepository appUserRepository) {
        return args -> {
            AppUser dawid = AppUser.builder().userName("dawgro")
                    .password("dgr")
                    .firstName("Dawid")
                    .lastName("Groberski")
                    .description("opis1")
                    .payment(10000f)
                    .bonus(5000f)
                    .dateOfPayment(new Date())
                    .build();

            AppUser daniel = AppUser.builder()
                    .userName("danbon")
                    .password("danbon")
                    .firstName("Daniel")
                    .lastName("Bond")
                    .description("opis2")
                    .payment(7500f)
                    .bonus(2500f)
                    .dateOfPayment(new Date())
                    .build();
            AppUser maniel = AppUser.builder()
                    .userName("manbon")
                    .password("manbon")
                    .firstName("Maniel")
                    .lastName("Bond")
                    .description("opis3")
                    .payment(5000f)
                    .bonus(1000f)
                    .dateOfPayment(new Date())
                    .build();

            AppUser kaniel = AppUser.builder()
                    .userName("kanbon")
                    .password("kanbon")
                    .firstName("Kaniel")
                    .lastName("Bond")
                    .description("opis4")
                    .payment(11000f)
                    .bonus(500f)
                    .dateOfPayment(new Date())
                    .build();

            AppUser taniel = AppUser.builder()
                    .userName("tanbon")
                    .password("tanbon")
                    .firstName("Taniel")
                    .lastName("Bond")
                    .description("opis5")
                    .payment(3000f)
                    .bonus(0f)
                    .dateOfPayment(new Date())
                    .build();

            AppUser financeTest1 = AppUser.builder()
                    .userName("financeTest1")
                    .password("financeTest1")
                    .firstName("financeTest1")
                    .lastName("Bond")
                    .description("opis6")
                    .payment(10000f)
                    .bonus(0f)
                    .dateOfPayment(new Date())
                    .build();


            Department finanse = Department.builder()
                    .name("Finanse")
                    .address("adres1")
                    .phone("555111333")
                    .mail("finanse@google.com")
                    .WWW("www.finanse.pl")
                    .description("Dzial finansow")
                    .build();

            Department it = Department.builder()
                    .name("IT")
                    .address("adres2")
                    .phone("555111334")
                    .mail("it@google.com")
                    .WWW("www.it.pl")
                    .description("Dzial IT")
                    .build();

            Department produkcja = Department.builder()
                    .name("Produkcja")
                    .address("adres3")
                    .phone("555111335")
                    .mail("produkcja@google.com")
                    .WWW("www.produkcja.pl")
                    .description("Dzial produkcji")
                    .build();

            appUserRepository.saveAll(List.of(dawid,daniel,maniel,kaniel,taniel,financeTest1));
            finanse.setManager(daniel);
            it.setManager(dawid);
            produkcja.setManager(kaniel);
            dawid.setDepartment(it);
            daniel.setDepartment(finanse);
            maniel.setDepartment(it);
            kaniel.setDepartment(produkcja);
            taniel.setDepartment(finanse);
            financeTest1.setDepartment(finanse);
            finanse.setUsers(List.of(daniel, taniel,financeTest1));
            it.setUsers(List.of(dawid,maniel));
            produkcja.setUsers(List.of(kaniel));
            departmentRepository.saveAll(List.of(finanse,it,produkcja));
            appUserRepository.saveAll(List.of(dawid,daniel,maniel,kaniel,taniel,financeTest1));
        };

    }
}
