package medical.form.repository.impl;

import medical.form.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRepository implements IMedicalRepository {

    public List<String> getGender() {
        List<String> genderList = new ArrayList<>();
        genderList.add("Nam");
        genderList.add("Nữ");
        genderList.add("LGBT");
        return genderList;
    }

    public List<String> getNationality() {
        List<String> nationalityList = new ArrayList<>();
        nationalityList.add("Việt Nam");
        nationalityList.add("Trung Quốc");
        nationalityList.add("Hàn Quốc");
        return nationalityList;
    }

    public List<String> getCommuteInfo() {
        List<String> commuteInfoList = new ArrayList<>();
        commuteInfoList.add("Máy bay");
        commuteInfoList.add("Tàu thuyền");
        commuteInfoList.add("Ô tô");
        commuteInfoList.add("Khác");
        return commuteInfoList;
    }
}
