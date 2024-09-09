package med.voll.api.controller.patient;

import jakarta.validation.Valid;
import med.voll.api.domain.entity.Patient;
import med.voll.api.domain.repository.PatientRepository;
import med.voll.api.domain.record.patient.DataDetailPatient;
import med.voll.api.domain.record.patient.PatientDataList;
import med.voll.api.domain.record.patient.PatientRegistrationData;
import med.voll.api.domain.record.patient.PatientUpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("pacientes")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DataDetailPatient> create(@RequestBody PatientRegistrationData patient, UriComponentsBuilder uriComponentsBuilder){
        var newPatient = this.patientRepository.save(new Patient(patient));

        var uri = uriComponentsBuilder.path("pacientes/{id}").buildAndExpand(newPatient.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailPatient(newPatient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientDataList>> all(@PageableDefault(size = 10,page = 0,sort = {"name"}) Pageable pageable){
       var page =  this.patientRepository.findAllByStatusTrue(pageable).map(PatientDataList::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataDetailPatient> update(@RequestBody @Valid PatientUpdateData patient){
        var updatePatient = this.patientRepository.getReferenceById(patient.id());

        updatePatient.updateData(patient);

        return ResponseEntity.ok(new DataDetailPatient(updatePatient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable("id") Long id){

        Patient patient = this.patientRepository.getReferenceById(id);

        patient.setStatus(false);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataDetailPatient> getById(@PathVariable("id") Long id){
        var patient = this.patientRepository.getReferenceById(id);

        return ResponseEntity.ok(new DataDetailPatient(patient));
    }
}
