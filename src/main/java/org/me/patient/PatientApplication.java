package org.me.patient;

import jakarta.annotation.PostConstruct;
import org.me.patient.dao.PatientRepository;
import org.me.patient.model.Patient;
import org.me.patient.service.PatientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }

    @PostConstruct
    public void test(PatientService patientService){


        //Test Add patient
        for (int i = 0 ; i<10; i++){
            Patient patient = Patient.builder()
                    .nom("John")
                    .dateNaissance(LocalDate.of(2022,02,02))
                    .malade(true)
                    .score(3)
                    .build();

            patientService.save(patient);
        }

        //Test retrieve list of patients

        Page<Patient> patientList = patientService.getPatients(PageRequest.of(0,10));

        patientList.forEach(System.out::println);

        //Test retrieve of patient

        Patient patient = patientService.getPatient(1L);
        System.out.println(patient);

        //Test patient modification

        Patient editedPatient = patientService.getPatient(1L);

        editedPatient.setNom("Future");

        patientService.edit(editedPatient, 1L);

        //Test patient delete

        patientService.delete(1L);



    }
}
