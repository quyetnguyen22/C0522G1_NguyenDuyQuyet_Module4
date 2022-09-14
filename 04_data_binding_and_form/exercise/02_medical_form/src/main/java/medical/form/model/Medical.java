package medical.form.model;

import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;


public class Medical {
    @Pattern(value = "Không được để trống")
    private String fullName;
//    @Min(value=18, message="must be equal or greater than 18")
//    @Max(value=45, message="must be equal or less than 45")
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private String idNumber;
    private String commuteInfo;
    private String vehicleId;
    private String seatNumber;
    private String beginDate;
    private String finishDate;
    private String stayedCity;

    public Medical() {

    }

    public Medical(String fullName, String dateOfBirth, String gender, String nationality, String idNumber,
                   String commuteInfo, String vehicleId, String seatNumber, String beginDate, String finishDate,
                   String stayedCity) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idNumber = idNumber;
        this.commuteInfo = commuteInfo;
        this.vehicleId = vehicleId;
        this.seatNumber = seatNumber;
        this.beginDate = beginDate;
        this.finishDate = finishDate;
        this.stayedCity = stayedCity;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCommuteInfo() {
        return commuteInfo;
    }

    public void setCommuteInfo(String commuteInfo) {
        this.commuteInfo = commuteInfo;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getStayedCity() {
        return stayedCity;
    }

    public void setStayedCity(String stayedCity) {
        this.stayedCity = stayedCity;
    }
}
