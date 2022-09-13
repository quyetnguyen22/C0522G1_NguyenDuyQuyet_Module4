package email.configuration.repository;

import email.configuration.model.Setting;

import java.util.List;

public interface ISettingRepository {
    List<String > languages();
    List<Integer> getPageSize();
    Setting getEmail();
    void saveConfig(Setting email);
}
