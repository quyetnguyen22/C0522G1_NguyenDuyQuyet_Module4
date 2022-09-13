package email.configuration.service.impl;

import email.configuration.model.Setting;
import email.configuration.repository.ISettingRepository;
import email.configuration.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService implements ISettingService {
    @Autowired
    private ISettingRepository configuration;

    @Override
    public List<String> getLanguages() {
        return configuration.languages();
    }

    @Override
    public List<Integer> getPageSize() {
        return configuration.getPageSize();
    }

    @Override
    public Setting getEmail() {
        return configuration.getEmail();
    }

    @Override
    public void saveConfig(Setting email) {
        configuration.saveConfig(email);
    }
}
