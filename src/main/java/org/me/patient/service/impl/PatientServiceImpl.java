package org.me.patient.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.me.patient.dao.PatientRepository;
import org.me.patient.model.Patient;
import org.me.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {


    @Autowired
    PatientRepository patientRepository;
    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void delete(Long id) {
            Patient deletedPatient = getPatient(id);
            patientRepository.delete(deletedPatient);

    }

    @Override
    public Patient edit(Patient patient, Long id) {
        Patient editedPatient = getPatient(id);
        editedPatient.setNom(patient.getNom());
        editedPatient.setDateNaissance(patient.getDateNaissance());
        editedPatient.setMalade(patient.isMalade());
        editedPatient.setScore(patient.getScore());
        return patientRepository.save(editedPatient);
    }

    @Override
    public Patient getPatient(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.get();
    }

    @Override
    public Page<Patient> getPatients(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }
}
