package med.voll.api.interfaces.repository;
import med.voll.api.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    Page<Doctor> findAllByStatusTrue(Pageable pageable);
}
