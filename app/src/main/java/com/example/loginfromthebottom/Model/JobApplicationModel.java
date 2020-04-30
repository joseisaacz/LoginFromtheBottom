package com.example.loginfromthebottom.Model;

import java.util.Date;

public class JobApplicationModel {

    private int id;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String streetAddressSecondLineII;
    private String city;
    private String stateOrProvince;
    private int postalCode;
    private String country;
    private String emailAddress;
    private String areaCode;
    private String phoneNumber;
    private String applyingJob;
    private Date startDate;
    private String uploadFile;

    public JobApplicationModel() {

    }

    public JobApplicationModel(int id,String _firstName, String _lastName, String _streetAddress, String _streetAddressSecondLineII, String _city,
                               String _stateOrProvince, int _postalCode, String _country, String _emailAddress, String _areaCode,
                               String _phoneNumber, String _applyingJob, Date _startDate, String _uploadFile) {
        firstName = _firstName;
        lastName = _lastName;
        streetAddress = _streetAddress;
        streetAddressSecondLineII = _streetAddressSecondLineII;
        city = _city;
        stateOrProvince = _stateOrProvince;
        postalCode = _postalCode;
        country = _country;
        emailAddress = _emailAddress;
        areaCode = _areaCode;
        phoneNumber = _phoneNumber;
        applyingJob = _applyingJob;
        startDate = _startDate;
        uploadFile = _uploadFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getStreetAddressSecondLineII() {
        return streetAddressSecondLineII;
    }

    public String getCity() {
        return city;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getApplyingJob() {
        return applyingJob;
    }

    public Date getStartDate(){
        return startDate;
    }

    public String getUploadFile() {
        return uploadFile;
    }

    public void setFirstName(String _firstName) {
        firstName = _firstName;
    }

    public void setLastName(String _lastName) {
        lastName = _lastName;
    }

    public void setStreetAddress(String _streetAddress) {
        streetAddress = _streetAddress;
    }

    public void setStreetAddressSecondLineII(String _streetAddressSecondLineII) {
        streetAddressSecondLineII = _streetAddressSecondLineII;
    }

    public void setCity(String _city) {
        city = _city;
    }

    public void setStateOrProvince(String _stateOrProvince) {
        stateOrProvince = _stateOrProvince;
    }

    public void setPostalCode(int _postalCode) {
        postalCode = _postalCode;
    }

    public void setCountry(String _country) {
        country = _country;
    }

    public void setEmailAddress(String _emailAddress) {
        emailAddress = _emailAddress;
    }

    public void setAreaCode(String _areaCode) {
        areaCode = _areaCode;
    }

    public void setPhoneNumber(String _phoneNumber) {
        phoneNumber = _phoneNumber;
    }

    public void setApplyingJob(String _applyingJob) {
        applyingJob = _applyingJob;
    }

    public void setStartDate(Date _startDate) {
        startDate = _startDate;
    }

    public void setUploadFile(String _uploadFile) {
        uploadFile = _uploadFile;
    }

    @Override
    public String toString() {
        return this.getFirstName()+" "+getLastName()+"\n"+" Applying Job: "+applyingJob;
    }
}
