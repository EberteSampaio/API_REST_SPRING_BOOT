package med.voll.api.controller.patient;

import med.voll.api.record.patient.PatientRegistrationData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PatientController {

    @PostMapping
    public void create(@RequestBody PatientRegistrationData patient){
        System.out.println(patient);
    }
}
