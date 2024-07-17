package med.voll.api.controller.doctor;

import jakarta.validation.Valid;
import med.voll.api.entity.Doctor;
import med.voll.api.interfaces.repository.DoctorRepository;
import med.voll.api.record.doctor.MedicalDataList;
import med.voll.api.record.doctor.MedicalRegistrationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("medicos")
public class DoctorController {
    @Autowired
    private  DoctorRepository doctorRepository;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<String> create(@RequestBody @Valid  MedicalRegistrationData doctor ){

        this.doctorRepository.save(new Doctor(doctor));

        return ResponseEntity.ok("Novo médico cadastrado com sucesso!");
    }

    @GetMapping("/all")
    @Transactional
    public Page<MedicalDataList> all(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return this.doctorRepository.findAll(pageable).map(MedicalDataList::new);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        Doctor doctor = this.doctorRepository.findById(id).get();

        this.doctorRepository.delete(doctor);

        return ResponseEntity.ok("Dados excluidos com sucesso!");
    }
}
