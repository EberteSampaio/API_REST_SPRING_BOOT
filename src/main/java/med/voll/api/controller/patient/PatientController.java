package med.voll.api.controller.patient;

import jakarta.validation.Valid;
import med.voll.api.entity.Patient;
import med.voll.api.interfaces.repository.PatientRepository;
import med.voll.api.record.patient.PatientDataList;
import med.voll.api.record.patient.PatientRegistrationData;
import med.voll.api.record.patient.PatientUpdateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("pacientes")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<String> create(@RequestBody PatientRegistrationData patient){
        var newPatient = this.patientRepository.save(new Patient(patient));

        return ResponseEntity.ok("O novo paciente "+ newPatient.getName()+ " foi cadastrado com sucesso!");
    }

    @GetMapping("/all")
    public Page<PatientDataList> all(@PageableDefault(size = 10,page = 0,sort = {"name"}) Pageable pageable){
       return  this.patientRepository.findAllByStatusTrue(pageable).map(PatientDataList::new);
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<String> update(@RequestBody @Valid PatientUpdateData patient){
        var updatePatient = this.patientRepository.getReferenceById(patient.id());

        updatePatient.updateData(patient);

        return ResponseEntity.ok("Os dados do paciente " + updatePatient.getName() + " foram atualizados com sucesso!");
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable("id") Long id){

        Patient patient = this.patientRepository.getReferenceById(id);

        patient.setStatus(false);

        return ResponseEntity.ok("O paciente "+ patient.getName()+ " foi inativado com sucesso!");
    }
}
