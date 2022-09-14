package medical.form.repository;

import java.util.List;

public interface IMedicalRepository{
    List<String> getGender();
    List<String> getNationality();
    List<String> getCommuteInfo();
}
