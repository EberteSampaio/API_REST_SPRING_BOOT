package med.voll.api.controller.doctor;

import jakarta.validation.Valid;
import med.voll.api.entity.Doctor;
import med.voll.api.interfaces.repository.DoctorRepository;
import med.voll.api.record.doctor.MedicalRegistrationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class DoctorController {
    @Autowired
    private  DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid  MedicalRegistrationData doctor ){
        this.doctorRepository.save(new Doctor(doctor));
    }
}
