package med.voll.api.controller.doctor;

import med.voll.api.record.doctor.MedicalRegistrationData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class DoctorController {

    @PostMapping
    public void create(@RequestBody MedicalRegistrationData doctor ){
        System.out.println(doctor);
    }
}
