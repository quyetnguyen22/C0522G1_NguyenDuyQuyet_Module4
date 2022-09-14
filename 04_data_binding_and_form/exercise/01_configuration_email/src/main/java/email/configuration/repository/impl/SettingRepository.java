package email.configuration.repository.impl;

import email.configuration.model.Setting;
import email.configuration.repository.ISettingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SettingRepository implements ISettingRepository {
    static {
        Setting email = new Setting("Vietnam", 10, "Enable spams filter", "signature");
}
    public List<String > languages() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnam");
        languageList.add("French");
        languageList.add("Japanese");
        languageList.add("Chinese");
        return languageList;
    }
    public List<Integer> getPageSize() {
        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(20);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
        return pageSize;
    }

    @Override
    public Setting getEmail() {
        return new Setting("Vietnam", 10, "Enable spams filter", "signature");
    }

    @Override
    public Setting saveConfig(Setting email) {
        email.setLanguages(email.getLanguages());
        email.setPageSize(email.getPageSize());
        email.setSpamsFilter(email.getSpamsFilter());
        email.setSignature(email.getSignature());
        return getEmail();
    }
}
