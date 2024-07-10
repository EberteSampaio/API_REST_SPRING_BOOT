package med.voll.api.interfaces.repository;
import med.voll.api.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface doctorRepository extends JpaRepository<Doctor,Long> {

}
