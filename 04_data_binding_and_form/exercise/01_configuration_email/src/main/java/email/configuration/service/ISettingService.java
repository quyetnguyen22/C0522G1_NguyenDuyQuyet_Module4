package email.configuration.service;

import email.configuration.model.Setting;

import java.util.List;

public interface ISettingService {
    List<String> getLanguages();
    List<Integer> getPageSize();
    Setting getEmail();
    void saveConfig(Setting email);
}
