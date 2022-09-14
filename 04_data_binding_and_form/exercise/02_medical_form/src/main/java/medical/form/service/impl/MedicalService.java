package medical.form.service.impl;

import medical.form.repository.IMedicalRepository;
import medical.form.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalService implements IMedicalService {

    @Autowired
    IMedicalRepository medicalRepository;
    @Override
    public List<String> getGender() {
        return medicalRepository.getGender();
    }

    @Override
    public List<String> getNationality() {
        return medicalRepository.getNationality();
    }

    @Override
    public List<String> getCommuteInfo() {
        return medicalRepository.getCommuteInfo();
    }
}
