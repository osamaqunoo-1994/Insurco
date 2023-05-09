package com.osama.insurco.Modules;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Orders {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("health")
    @Expose
    private List<Item> health;
    @SerializedName("motor")
    @Expose
    private List<Item> motor;
    @SerializedName("companies")
    @Expose
    private List<Companys> companies = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public List<Item> getHealth() {
        return health;
    }

    public List<Item> getMotor() {
        return motor;
    }

    public List<Companys> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Companys> companies) {
        this.companies = companies;
    }


    public class InsuranceType1 {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("name")
        @Expose
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


    public class Item {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("insurance_type_id")
        @Expose
        private Integer insuranceTypeId;
        @SerializedName("company_insurance_id")
        @Expose
        private Object companyInsuranceId;
        @SerializedName("send_email")
        @Expose
        private Integer sendEmail;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("date_birth")
        @Expose
        private Object dateBirth;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("license_issue_date")
        @Expose
        private Object licenseIssueDate;
        @SerializedName("id_number")
        @Expose
        private Object idNumber;
        @SerializedName("insurance_type")
        @Expose
        private InsuranceType1 insuranceType;
        @SerializedName("agency_id")
        @Expose
        private Object agencyId;
        @SerializedName("vehicle_type_id")
        @Expose
        private Object vehicleTypeId;
        @SerializedName("manufacturing_year")
        @Expose
        private String manufacturingYear;
        @SerializedName("cylinder_number")
        @Expose
        private Object cylinderNumber;
        @SerializedName("vehicle_structure_id")
        @Expose
        private Object vehicleStructureId;
        @SerializedName("motor_choice_id")
        @Expose
        private Object motorChoiceId;
        @SerializedName("traffic_code")
        @Expose
        private Object trafficCode;
        @SerializedName("driving_license_issuance_date")
        @Expose
        private Object drivingLicenseIssuanceDate;
        @SerializedName("driving_license_expiration_date")
        @Expose
        private Object drivingLicenseExpirationDate;
        @SerializedName("expiry_date_current_insurance")
        @Expose
        private Object expiryDateCurrentInsurance;
        @SerializedName("current_price")
        @Expose
        private Object currentPrice;
        @SerializedName("has_accident")
        @Expose
        private Object hasAccident;
        @SerializedName("ownership_photo_from_front")
        @Expose
        private String ownershipPhotoFromFront;
        @SerializedName("ownership_photo_from_back")
        @Expose
        private String ownershipPhotoFromBack;
        @SerializedName("driver_license_from_front")
        @Expose
        private String driverLicenseFromFront;
        @SerializedName("driver_license_from_back")
        @Expose
        private String driverLicenseFromBack;
        @SerializedName("activation_code")
        @Expose
        private Integer activationCode;
        @SerializedName("activation_code_used")
        @Expose
        private Integer activationCodeUsed;
        @SerializedName("emirate_id_front_image")
        @Expose
        private String emirateIdFrontImage;
        @SerializedName("emirate_id_back_image")
        @Expose
        private String emirateIdBackImage;
        @SerializedName("car_front_image")
        @Expose
        private String carFrontImage;
        @SerializedName("car_back_image")
        @Expose
        private String carBackImage;
        @SerializedName("car_right_side_image")
        @Expose
        private String carRightSideImage;
        @SerializedName("car_left_side_image")
        @Expose
        private String carLeftSideImage;
        @SerializedName("sent_insurance_policy")
        @Expose
        private String sentInsurancePolicy;
        @SerializedName("sent_invoice")
        @Expose
        private String sentInvoice;
        @SerializedName("invoice_image")
        @Expose
        private Object invoiceImage;
        @SerializedName("paid")
        @Expose
        private Integer paid;
        @SerializedName("type_car")
        @Expose
        private Object typeCar;
        @SerializedName("is_comprehensive")
        @Expose
        private Object isComprehensive;
        @SerializedName("insurance_validity")
        @Expose
        private Object insuranceValidity;
        @SerializedName("registry")
        @Expose
        private Object registry;
        @SerializedName("is_mortgaged")
        @Expose
        private Object isMortgaged;
        @SerializedName("name_mortgaged_bank")
        @Expose
        private Object nameMortgagedBank;
        @SerializedName("place_registration")
        @Expose
        private Object placeRegistration;
        @SerializedName("insurance_documents")
        @Expose
        private Object insuranceDocuments;
        @SerializedName("request_seen")
        @Expose
        private String requestSeen;
        @SerializedName("seen_by")
        @Expose
        private Integer seenBy;
        @SerializedName("request_paid_seen")
        @Expose
        private String requestPaidSeen;
        @SerializedName("seen_paid_by")
        @Expose
        private Object seenPaidBy;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("rate")
        @Expose
        private Object rate;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("ploicy_price")
        @Expose
        private Integer ploicyPrice;
        @SerializedName("invoices")
        @Expose
        private List<Object> invoices = null;
        @SerializedName("agency")
        @Expose
        private Object agency;
        @SerializedName("vehicle_type")
        @Expose
        private Object vehicleType;
        @SerializedName("vehicle_structure")
        @Expose
        private Object vehicleStructure;
        @SerializedName("company")
        @Expose
        private List<Company_> company;

        public Integer getId() {
            return id;
        }

        public List<Company_> getCompany() {
            return company;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getInsuranceTypeId() {
            return insuranceTypeId;
        }

        public void setInsuranceTypeId(Integer insuranceTypeId) {
            this.insuranceTypeId = insuranceTypeId;
        }

        public Object getCompanyInsuranceId() {
            return companyInsuranceId;
        }

        public void setCompanyInsuranceId(Object companyInsuranceId) {
            this.companyInsuranceId = companyInsuranceId;
        }

        public Integer getSendEmail() {
            return sendEmail;
        }

        public void setSendEmail(Integer sendEmail) {
            this.sendEmail = sendEmail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getDateBirth() {
            return dateBirth;
        }

        public void setDateBirth(Object dateBirth) {
            this.dateBirth = dateBirth;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getLicenseIssueDate() {
            return licenseIssueDate;
        }

        public void setLicenseIssueDate(Object licenseIssueDate) {
            this.licenseIssueDate = licenseIssueDate;
        }

        public Object getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(Object idNumber) {
            this.idNumber = idNumber;
        }

        public InsuranceType1 getInsuranceType() {
            return insuranceType;
        }

        public void setInsuranceType(InsuranceType1 insuranceType) {
            this.insuranceType = insuranceType;
        }

        public Object getAgencyId() {
            return agencyId;
        }

        public void setAgencyId(Object agencyId) {
            this.agencyId = agencyId;
        }

        public Object getVehicleTypeId() {
            return vehicleTypeId;
        }

        public void setVehicleTypeId(Object vehicleTypeId) {
            this.vehicleTypeId = vehicleTypeId;
        }

        public String getManufacturingYear() {
            return manufacturingYear;
        }

        public void setManufacturingYear(String manufacturingYear) {
            this.manufacturingYear = manufacturingYear;
        }

        public Object getCylinderNumber() {
            return cylinderNumber;
        }

        public void setCylinderNumber(Object cylinderNumber) {
            this.cylinderNumber = cylinderNumber;
        }

        public Object getVehicleStructureId() {
            return vehicleStructureId;
        }

        public void setVehicleStructureId(Object vehicleStructureId) {
            this.vehicleStructureId = vehicleStructureId;
        }

        public Object getMotorChoiceId() {
            return motorChoiceId;
        }

        public void setMotorChoiceId(Object motorChoiceId) {
            this.motorChoiceId = motorChoiceId;
        }

        public Object getTrafficCode() {
            return trafficCode;
        }

        public void setTrafficCode(Object trafficCode) {
            this.trafficCode = trafficCode;
        }

        public Object getDrivingLicenseIssuanceDate() {
            return drivingLicenseIssuanceDate;
        }

        public void setDrivingLicenseIssuanceDate(Object drivingLicenseIssuanceDate) {
            this.drivingLicenseIssuanceDate = drivingLicenseIssuanceDate;
        }

        public Object getDrivingLicenseExpirationDate() {
            return drivingLicenseExpirationDate;
        }

        public void setDrivingLicenseExpirationDate(Object drivingLicenseExpirationDate) {
            this.drivingLicenseExpirationDate = drivingLicenseExpirationDate;
        }

        public Object getExpiryDateCurrentInsurance() {
            return expiryDateCurrentInsurance;
        }

        public void setExpiryDateCurrentInsurance(Object expiryDateCurrentInsurance) {
            this.expiryDateCurrentInsurance = expiryDateCurrentInsurance;
        }

        public Object getCurrentPrice() {
            return currentPrice;
        }

        public void setCurrentPrice(Object currentPrice) {
            this.currentPrice = currentPrice;
        }

        public Object getHasAccident() {
            return hasAccident;
        }

        public void setHasAccident(Object hasAccident) {
            this.hasAccident = hasAccident;
        }

        public String getOwnershipPhotoFromFront() {
            return ownershipPhotoFromFront;
        }

        public void setOwnershipPhotoFromFront(String ownershipPhotoFromFront) {
            this.ownershipPhotoFromFront = ownershipPhotoFromFront;
        }

        public String getOwnershipPhotoFromBack() {
            return ownershipPhotoFromBack;
        }

        public void setOwnershipPhotoFromBack(String ownershipPhotoFromBack) {
            this.ownershipPhotoFromBack = ownershipPhotoFromBack;
        }

        public String getDriverLicenseFromFront() {
            return driverLicenseFromFront;
        }

        public void setDriverLicenseFromFront(String driverLicenseFromFront) {
            this.driverLicenseFromFront = driverLicenseFromFront;
        }

        public String getDriverLicenseFromBack() {
            return driverLicenseFromBack;
        }

        public void setDriverLicenseFromBack(String driverLicenseFromBack) {
            this.driverLicenseFromBack = driverLicenseFromBack;
        }

        public Integer getActivationCode() {
            return activationCode;
        }

        public void setActivationCode(Integer activationCode) {
            this.activationCode = activationCode;
        }

        public Integer getActivationCodeUsed() {
            return activationCodeUsed;
        }

        public void setActivationCodeUsed(Integer activationCodeUsed) {
            this.activationCodeUsed = activationCodeUsed;
        }

        public String getEmirateIdFrontImage() {
            return emirateIdFrontImage;
        }

        public void setEmirateIdFrontImage(String emirateIdFrontImage) {
            this.emirateIdFrontImage = emirateIdFrontImage;
        }

        public String getEmirateIdBackImage() {
            return emirateIdBackImage;
        }

        public void setEmirateIdBackImage(String emirateIdBackImage) {
            this.emirateIdBackImage = emirateIdBackImage;
        }

        public String getCarFrontImage() {
            return carFrontImage;
        }

        public void setCarFrontImage(String carFrontImage) {
            this.carFrontImage = carFrontImage;
        }

        public String getCarBackImage() {
            return carBackImage;
        }

        public void setCarBackImage(String carBackImage) {
            this.carBackImage = carBackImage;
        }

        public String getCarRightSideImage() {
            return carRightSideImage;
        }

        public void setCarRightSideImage(String carRightSideImage) {
            this.carRightSideImage = carRightSideImage;
        }

        public String getCarLeftSideImage() {
            return carLeftSideImage;
        }

        public void setCarLeftSideImage(String carLeftSideImage) {
            this.carLeftSideImage = carLeftSideImage;
        }

        public String getSentInsurancePolicy() {
            return sentInsurancePolicy;
        }

        public void setSentInsurancePolicy(String sentInsurancePolicy) {
            this.sentInsurancePolicy = sentInsurancePolicy;
        }

        public String getSentInvoice() {
            return sentInvoice;
        }

        public void setSentInvoice(String sentInvoice) {
            this.sentInvoice = sentInvoice;
        }

        public Object getInvoiceImage() {
            return invoiceImage;
        }

        public void setInvoiceImage(Object invoiceImage) {
            this.invoiceImage = invoiceImage;
        }

        public Integer getPaid() {
            return paid;
        }

        public void setPaid(Integer paid) {
            this.paid = paid;
        }

        public Object getTypeCar() {
            return typeCar;
        }

        public void setTypeCar(Object typeCar) {
            this.typeCar = typeCar;
        }

        public Object getIsComprehensive() {
            return isComprehensive;
        }

        public void setIsComprehensive(Object isComprehensive) {
            this.isComprehensive = isComprehensive;
        }

        public Object getInsuranceValidity() {
            return insuranceValidity;
        }

        public void setInsuranceValidity(Object insuranceValidity) {
            this.insuranceValidity = insuranceValidity;
        }

        public Object getRegistry() {
            return registry;
        }

        public void setRegistry(Object registry) {
            this.registry = registry;
        }

        public Object getIsMortgaged() {
            return isMortgaged;
        }

        public void setIsMortgaged(Object isMortgaged) {
            this.isMortgaged = isMortgaged;
        }

        public Object getNameMortgagedBank() {
            return nameMortgagedBank;
        }

        public void setNameMortgagedBank(Object nameMortgagedBank) {
            this.nameMortgagedBank = nameMortgagedBank;
        }

        public Object getPlaceRegistration() {
            return placeRegistration;
        }

        public void setPlaceRegistration(Object placeRegistration) {
            this.placeRegistration = placeRegistration;
        }

        public Object getInsuranceDocuments() {
            return insuranceDocuments;
        }

        public void setInsuranceDocuments(Object insuranceDocuments) {
            this.insuranceDocuments = insuranceDocuments;
        }

        public String getRequestSeen() {
            return requestSeen;
        }

        public void setRequestSeen(String requestSeen) {
            this.requestSeen = requestSeen;
        }

        public Integer getSeenBy() {
            return seenBy;
        }

        public void setSeenBy(Integer seenBy) {
            this.seenBy = seenBy;
        }

        public String getRequestPaidSeen() {
            return requestPaidSeen;
        }

        public void setRequestPaidSeen(String requestPaidSeen) {
            this.requestPaidSeen = requestPaidSeen;
        }

        public Object getSeenPaidBy() {
            return seenPaidBy;
        }

        public void setSeenPaidBy(Object seenPaidBy) {
            this.seenPaidBy = seenPaidBy;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getRate() {
            return rate;
        }

        public void setRate(Object rate) {
            this.rate = rate;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getPloicyPrice() {
            return ploicyPrice;
        }

        public void setPloicyPrice(Integer ploicyPrice) {
            this.ploicyPrice = ploicyPrice;
        }

        public List<Object> getInvoices() {
            return invoices;
        }

        public void setInvoices(List<Object> invoices) {
            this.invoices = invoices;
        }

        public Object getAgency() {
            return agency;
        }

        public void setAgency(Object agency) {
            this.agency = agency;
        }

        public Object getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(Object vehicleType) {
            this.vehicleType = vehicleType;
        }

        public Object getVehicleStructure() {
            return vehicleStructure;
        }

        public void setVehicleStructure(Object vehicleStructure) {
            this.vehicleStructure = vehicleStructure;
        }

    }


    public class Company {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("license_issue_date")
        @Expose
        private Object licenseIssueDate;
        @SerializedName("license_image")
        @Expose
        private String licenseImage;
        @SerializedName("company_owner_id_photo")
        @Expose
        private String companyOwnerIdPhoto;
        @SerializedName("contract_image")
        @Expose
        private String contractImage;
        @SerializedName("company_owner_name")
        @Expose
        private Object companyOwnerName;
        @SerializedName("name_contact_person")
        @Expose
        private Object nameContactPerson;
        @SerializedName("company_phone")
        @Expose
        private Object companyPhone;
        @SerializedName("license_expiry_date")
        @Expose
        private Object licenseExpiryDate;
        @SerializedName("practicing_insurance_activity")
        @Expose
        private String practicingInsuranceActivity;
        @SerializedName("company_owner_passport_image")
        @Expose
        private String companyOwnerPassportImage;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("address")
        @Expose
        private String address;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getLicenseIssueDate() {
            return licenseIssueDate;
        }

        public void setLicenseIssueDate(Object licenseIssueDate) {
            this.licenseIssueDate = licenseIssueDate;
        }

        public String getLicenseImage() {
            return licenseImage;
        }

        public void setLicenseImage(String licenseImage) {
            this.licenseImage = licenseImage;
        }

        public String getCompanyOwnerIdPhoto() {
            return companyOwnerIdPhoto;
        }

        public void setCompanyOwnerIdPhoto(String companyOwnerIdPhoto) {
            this.companyOwnerIdPhoto = companyOwnerIdPhoto;
        }

        public String getContractImage() {
            return contractImage;
        }

        public void setContractImage(String contractImage) {
            this.contractImage = contractImage;
        }

        public Object getCompanyOwnerName() {
            return companyOwnerName;
        }

        public void setCompanyOwnerName(Object companyOwnerName) {
            this.companyOwnerName = companyOwnerName;
        }

        public Object getNameContactPerson() {
            return nameContactPerson;
        }

        public void setNameContactPerson(Object nameContactPerson) {
            this.nameContactPerson = nameContactPerson;
        }

        public Object getCompanyPhone() {
            return companyPhone;
        }

        public void setCompanyPhone(Object companyPhone) {
            this.companyPhone = companyPhone;
        }

        public Object getLicenseExpiryDate() {
            return licenseExpiryDate;
        }

        public void setLicenseExpiryDate(Object licenseExpiryDate) {
            this.licenseExpiryDate = licenseExpiryDate;
        }

        public String getPracticingInsuranceActivity() {
            return practicingInsuranceActivity;
        }

        public void setPracticingInsuranceActivity(String practicingInsuranceActivity) {
            this.practicingInsuranceActivity = practicingInsuranceActivity;
        }

        public String getCompanyOwnerPassportImage() {
            return companyOwnerPassportImage;
        }

        public void setCompanyOwnerPassportImage(String companyOwnerPassportImage) {
            this.companyOwnerPassportImage = companyOwnerPassportImage;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    }


    public class CompanyInsurance {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("company_english_name")
        @Expose
        private String companyEnglishName;
        @SerializedName("company_id")
        @Expose
        private Integer companyId;
        @SerializedName("insurance_main_type")
        @Expose
        private String insuranceMainType;
        @SerializedName("insurance_type_id")
        @Expose
        private Integer insuranceTypeId;
        @SerializedName("insurance_against")
        @Expose
        private String insuranceAgainst;
        @SerializedName("agency_id")
        @Expose
        private Integer agencyId;
        @SerializedName("vehicle_type_id")
        @Expose
        private Integer vehicleTypeId;
        @SerializedName("manufacturing_year_from")
        @Expose
        private Object manufacturingYearFrom;
        @SerializedName("manufacturing_year_to")
        @Expose
        private Object manufacturingYearTo;
        @SerializedName("cylinder_number")
        @Expose
        private Integer cylinderNumber;
        @SerializedName("vehicle_structure_id")
        @Expose
        private Integer vehicleStructureId;
        @SerializedName("social_status")
        @Expose
        private Object socialStatus;
        @SerializedName("has_existing_active_healthinsurance")
        @Expose
        private Object hasExistingActiveHealthinsurance;
        @SerializedName("has_chronic_conditions")
        @Expose
        private Object hasChronicConditions;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("vat")
        @Expose
        private Integer vat;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("insurance_service")
        @Expose
        private List<services_provided> insurance_service = null;
        @SerializedName("company")
        @Expose
        private Company company;
        @SerializedName("insurance_type")
        @Expose
        private InsuranceType1 insuranceType;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCompanyEnglishName() {
            return companyEnglishName;
        }

        public void setCompanyEnglishName(String companyEnglishName) {
            this.companyEnglishName = companyEnglishName;
        }

        public Integer getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }

        public String getInsuranceMainType() {
            return insuranceMainType;
        }

        public void setInsuranceMainType(String insuranceMainType) {
            this.insuranceMainType = insuranceMainType;
        }

        public Integer getInsuranceTypeId() {
            return insuranceTypeId;
        }

        public void setInsuranceTypeId(Integer insuranceTypeId) {
            this.insuranceTypeId = insuranceTypeId;
        }

        public String getInsuranceAgainst() {
            return insuranceAgainst;
        }

        public void setInsuranceAgainst(String insuranceAgainst) {
            this.insuranceAgainst = insuranceAgainst;
        }

        public Integer getAgencyId() {
            return agencyId;
        }

        public void setAgencyId(Integer agencyId) {
            this.agencyId = agencyId;
        }

        public Integer getVehicleTypeId() {
            return vehicleTypeId;
        }

        public void setVehicleTypeId(Integer vehicleTypeId) {
            this.vehicleTypeId = vehicleTypeId;
        }

        public Object getManufacturingYearFrom() {
            return manufacturingYearFrom;
        }

        public void setManufacturingYearFrom(Object manufacturingYearFrom) {
            this.manufacturingYearFrom = manufacturingYearFrom;
        }

        public Object getManufacturingYearTo() {
            return manufacturingYearTo;
        }

        public void setManufacturingYearTo(Object manufacturingYearTo) {
            this.manufacturingYearTo = manufacturingYearTo;
        }

        public Integer getCylinderNumber() {
            return cylinderNumber;
        }

        public void setCylinderNumber(Integer cylinderNumber) {
            this.cylinderNumber = cylinderNumber;
        }

        public Integer getVehicleStructureId() {
            return vehicleStructureId;
        }

        public void setVehicleStructureId(Integer vehicleStructureId) {
            this.vehicleStructureId = vehicleStructureId;
        }

        public Object getSocialStatus() {
            return socialStatus;
        }

        public void setSocialStatus(Object socialStatus) {
            this.socialStatus = socialStatus;
        }

        public Object getHasExistingActiveHealthinsurance() {
            return hasExistingActiveHealthinsurance;
        }

        public void setHasExistingActiveHealthinsurance(Object hasExistingActiveHealthinsurance) {
            this.hasExistingActiveHealthinsurance = hasExistingActiveHealthinsurance;
        }

        public Object getHasChronicConditions() {
            return hasChronicConditions;
        }

        public void setHasChronicConditions(Object hasChronicConditions) {
            this.hasChronicConditions = hasChronicConditions;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getVat() {
            return vat;
        }

        public void setVat(Integer vat) {
            this.vat = vat;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public List<services_provided> getInsurance_service() {
            return insurance_service;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }

        public InsuranceType1 getInsuranceType() {
            return insuranceType;
        }

        public void setInsuranceType(InsuranceType1 insuranceType) {
            this.insuranceType = insuranceType;
        }

    }


    public class Company_ {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("motor_request_id")
        @Expose
        private Integer motorRequestId;
        @SerializedName("company_insurance_id")
        @Expose
        private Integer companyInsuranceId;
        @SerializedName("insurance_policy_price")
        @Expose
        private Integer insurancePolicyPrice;
        @SerializedName("vehicle_price")
        @Expose
        private Integer vehiclePrice;
        @SerializedName("endurance_value")
        @Expose
        private Integer enduranceValue;
        @SerializedName("repair_amount")
        @Expose
        private Integer repairAmount;
        @SerializedName("repair_place")
        @Expose
        private String repairPlace;
        @SerializedName("insurance_file")
        @Expose
        private String insurance_file;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("company_insurance")
        @Expose
        private CompanyInsurance companyInsurance;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getMotorRequestId() {
            return motorRequestId;
        }

        public void setMotorRequestId(Integer motorRequestId) {
            this.motorRequestId = motorRequestId;
        }

        public Integer getCompanyInsuranceId() {
            return companyInsuranceId;
        }

        public void setCompanyInsuranceId(Integer companyInsuranceId) {
            this.companyInsuranceId = companyInsuranceId;
        }

        public String getInsurance_file() {
            return insurance_file;
        }

        public Integer getInsurancePolicyPrice() {
            return insurancePolicyPrice;
        }

        public void setInsurancePolicyPrice(Integer insurancePolicyPrice) {
            this.insurancePolicyPrice = insurancePolicyPrice;
        }

        public Integer getVehiclePrice() {
            return vehiclePrice;
        }

        public void setVehiclePrice(Integer vehiclePrice) {
            this.vehiclePrice = vehiclePrice;
        }

        public Integer getEnduranceValue() {
            return enduranceValue;
        }

        public void setEnduranceValue(Integer enduranceValue) {
            this.enduranceValue = enduranceValue;
        }

        public Integer getRepairAmount() {
            return repairAmount;
        }

        public void setRepairAmount(Integer repairAmount) {
            this.repairAmount = repairAmount;
        }

        public String getRepairPlace() {
            return repairPlace;
        }

        public void setRepairPlace(String repairPlace) {
            this.repairPlace = repairPlace;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public CompanyInsurance getCompanyInsurance() {
            return companyInsurance;
        }

        public void setCompanyInsurance(CompanyInsurance companyInsurance) {
            this.companyInsurance = companyInsurance;
        }

    }

    public class services_provided2 {
        @SerializedName("id")
        @Expose
        private Integer id;


        @SerializedName("status")
        @Expose
        private String status;

        @SerializedName("yes_no")
        @Expose
        private String yes_no;

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;

        public Integer getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public String getName() {
            return name;
        }

        public String getStatus() {
            return status;
        }

        public String getYes_no() {
            return yes_no;
        }
    }
    public class services_provided {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("company_insurance_id")
        @Expose
        private String company_insurance_id;
        @SerializedName("yes_no")
        @Expose
        private String yes_no;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("created_at")
        @Expose
        private String created_at;
        @SerializedName("name")
        @Expose
        private String name;


        @SerializedName("services_provided")
        @Expose
        private services_provided2 servicesProvided = null;

        public Integer getId() {
            return id;
        }

        public String getCompany_insurance_id() {
            return company_insurance_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getName() {
            return name;
        }

        public String getStatus() {
            return status;
        }

        public String getYes_no() {
            return yes_no;
        }


        public services_provided2 getServicesProvided() {
            return servicesProvided;
        }
    }



}
