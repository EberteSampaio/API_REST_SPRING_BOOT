package med.voll.api.controller.doctor;

import jakarta.validation.Valid;
import med.voll.api.domain.entity.Doctor;
import med.voll.api.domain.repository.DoctorRepository;
import med.voll.api.domain.record.doctor.DataDetailDoctor;
import med.voll.api.domain.record.doctor.DoctorDataList;
import med.voll.api.domain.record.doctor.DoctorRegistrationData;
import med.voll.api.domain.record.doctor.DoctorUpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("medicos")
public class DoctorController {
    @Autowired
    private  DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DataDetailDoctor> create(@RequestBody @Valid DoctorRegistrationData doctor, UriComponentsBuilder uriComponentsBuilder){
        Doctor newDoctor = this.doctorRepository.save(new Doctor(doctor));

        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(newDoctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailDoctor(newDoctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorDataList>> all(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        var page = this.doctorRepository.findAllByStatusTrue(pageable).map(DoctorDataList::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataDetailDoctor> update(@RequestBody @Valid DoctorUpdateData doctorUpdateData){
        var doctor = this.doctorRepository.getReferenceById(doctorUpdateData.id());

        doctor.updateData(doctorUpdateData);

        return ResponseEntity.ok(new DataDetailDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable("id") Long id){
        var doctor = this.doctorRepository.getReferenceById(id);

        doctor.setStatus(false);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDetailDoctor> getById(@PathVariable("id") Long id){
        var doctor = this.doctorRepository.getReferenceById(id);

        return ResponseEntity.ok(new DataDetailDoctor(doctor));
    }
}
