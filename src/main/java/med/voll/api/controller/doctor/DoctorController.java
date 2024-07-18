package med.voll.api.controller.doctor;

import jakarta.validation.Valid;
import med.voll.api.entity.Doctor;
import med.voll.api.interfaces.repository.DoctorRepository;
import med.voll.api.record.doctor.DoctorDataList;
import med.voll.api.record.doctor.DoctorRegistrationData;
import med.voll.api.record.doctor.DoctorUpdateData;
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
    public ResponseEntity<String> create(@RequestBody @Valid DoctorRegistrationData doctor ){

        Doctor newDoctor = this.doctorRepository.save(new Doctor(doctor));

        return ResponseEntity.ok("O Novo médico "+ newDoctor.getName() +" foi cadastrado com sucesso!");
    }

    @GetMapping("/all")
    public Page<DoctorDataList> all(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return this.doctorRepository.findAll(pageable).map(DoctorDataList::new);
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<String> update(@RequestBody @Valid DoctorUpdateData doctorUpdateData){
        var doctor = this.doctorRepository.getReferenceById(doctorUpdateData.id());

        doctor.updateData(doctorUpdateData);

        return ResponseEntity.ok("Os dados do Dr(a). " + doctor.getName() + " foram atualizados com sucesso!");
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        var doctor = this.doctorRepository.getReferenceById(id);

        this.doctorRepository.delete(doctor);

        return ResponseEntity.ok("Dados do Dr(a) " + doctor.getName() + " excluidos com sucesso!");
    }
}
