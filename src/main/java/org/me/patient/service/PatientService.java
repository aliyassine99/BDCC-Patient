package org.me.patient.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.me.patient.model.Patient;
public interface PatientService {

    Patient save(Patient patient);
    void delete(Long id);
    Patient edit(Patient patient,Long id);
    Patient getPatient(Long id);
    Page<Patient> getPatients(Pageable pageable);
}
