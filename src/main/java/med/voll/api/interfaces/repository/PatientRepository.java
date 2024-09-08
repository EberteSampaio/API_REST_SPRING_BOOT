package med.voll.api.interfaces.repository;

import io.micrometer.observation.ObservationFilter;
import med.voll.api.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findAllByStatusTrue(Pageable pageable);
}
