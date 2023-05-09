package com.osama.insurco.Modules;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SettingsModules {


    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("settings")
    @Expose
    private Settings settings;

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

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }


    public class AboutUs {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("views")
        @Expose
        private Integer views;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("slug")
        @Expose
        private Object slug;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("key_words")
        @Expose
        private Object keyWords;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Integer getViews() {
            return views;
        }

        public void setViews(Integer views) {
            this.views = views;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getSlug() {
            return slug;
        }

        public void setSlug(Object slug) {
            this.slug = slug;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getKeyWords() {
            return keyWords;
        }

        public void setKeyWords(Object keyWords) {
            this.keyWords = keyWords;
        }

    }


    public class Agency {

        @SerializedName("id")
        @Expose
        private Integer id;
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


    public class Emirate {

        @SerializedName("id")
        @Expose
        private Integer id;
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


    public class Privacy {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("views")
        @Expose
        private Integer views;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("slug")
        @Expose
        private Object slug;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("key_words")
        @Expose
        private Object keyWords;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Integer getViews() {
            return views;
        }

        public void setViews(Integer views) {
            this.views = views;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getSlug() {
            return slug;
        }

        public void setSlug(Object slug) {
            this.slug = slug;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getKeyWords() {
            return keyWords;
        }

        public void setKeyWords(Object keyWords) {
            this.keyWords = keyWords;
        }

    }


    public class Settings {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("logo")
        @Expose
        private String logo;
        @SerializedName("app_store_url")
        @Expose
        private String appStoreUrl;
        @SerializedName("play_store_url")
        @Expose
        private String playStoreUrl;
        @SerializedName("info_email")
        @Expose
        private String infoEmail;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("facebook")
        @Expose
        private String facebook;
        @SerializedName("twitter")
        @Expose
        private String twitter;
        @SerializedName("linked_in")
        @Expose
        private String linkedIn;
        @SerializedName("instagram")
        @Expose
        private String instagram;
        @SerializedName("whatsapp")
        @Expose
        private String whatsapp;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("rows_pagination_count")
        @Expose
        private Integer rowsPaginationCount;
        @SerializedName("about_us")
        @Expose
        private AboutUs aboutUs;
        @SerializedName("privacy")
        @Expose
        private Privacy privacy;
        @SerializedName("terms_conditions")
        @Expose
        private TermsConditions termsConditions;
        @SerializedName("agencies")
        @Expose
        private List<Agency> agencies = null;
        @SerializedName("vehicles_types")
        @Expose
        private List<VehiclesType> vehiclesTypes = null;
        @SerializedName("vehicles_structures")
        @Expose
        private List<VehiclesStructure> vehiclesStructures = null;
        @SerializedName("emirates")
        @Expose
        private List<Emirate> emirates = null;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("description")
        @Expose
        private String description;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getAppStoreUrl() {
            return appStoreUrl;
        }

        public void setAppStoreUrl(String appStoreUrl) {
            this.appStoreUrl = appStoreUrl;
        }

        public String getPlayStoreUrl() {
            return playStoreUrl;
        }

        public void setPlayStoreUrl(String playStoreUrl) {
            this.playStoreUrl = playStoreUrl;
        }

        public String getInfoEmail() {
            return infoEmail;
        }

        public void setInfoEmail(String infoEmail) {
            this.infoEmail = infoEmail;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getFacebook() {
            return facebook;
        }

        public void setFacebook(String facebook) {
            this.facebook = facebook;
        }

        public String getTwitter() {
            return twitter;
        }

        public void setTwitter(String twitter) {
            this.twitter = twitter;
        }

        public String getLinkedIn() {
            return linkedIn;
        }

        public void setLinkedIn(String linkedIn) {
            this.linkedIn = linkedIn;
        }

        public String getInstagram() {
            return instagram;
        }

        public void setInstagram(String instagram) {
            this.instagram = instagram;
        }

        public String getWhatsapp() {
            return whatsapp;
        }

        public void setWhatsapp(String whatsapp) {
            this.whatsapp = whatsapp;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Integer getRowsPaginationCount() {
            return rowsPaginationCount;
        }

        public void setRowsPaginationCount(Integer rowsPaginationCount) {
            this.rowsPaginationCount = rowsPaginationCount;
        }

        public AboutUs getAboutUs() {
            return aboutUs;
        }

        public void setAboutUs(AboutUs aboutUs) {
            this.aboutUs = aboutUs;
        }

        public Privacy getPrivacy() {
            return privacy;
        }

        public void setPrivacy(Privacy privacy) {
            this.privacy = privacy;
        }

        public TermsConditions getTermsConditions() {
            return termsConditions;
        }

        public void setTermsConditions(TermsConditions termsConditions) {
            this.termsConditions = termsConditions;
        }

        public List<Agency> getAgencies() {
            return agencies;
        }

        public void setAgencies(List<Agency> agencies) {
            this.agencies = agencies;
        }

        public List<VehiclesType> getVehiclesTypes() {
            return vehiclesTypes;
        }

        public void setVehiclesTypes(List<VehiclesType> vehiclesTypes) {
            this.vehiclesTypes = vehiclesTypes;
        }

        public List<VehiclesStructure> getVehiclesStructures() {
            return vehiclesStructures;
        }

        public void setVehiclesStructures(List<VehiclesStructure> vehiclesStructures) {
            this.vehiclesStructures = vehiclesStructures;
        }

        public List<Emirate> getEmirates() {
            return emirates;
        }

        public void setEmirates(List<Emirate> emirates) {
            this.emirates = emirates;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }


    public class TermsConditions {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("views")
        @Expose
        private Integer views;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("slug")
        @Expose
        private Object slug;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("key_words")
        @Expose
        private Object keyWords;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Integer getViews() {
            return views;
        }

        public void setViews(Integer views) {
            this.views = views;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getSlug() {
            return slug;
        }

        public void setSlug(Object slug) {
            this.slug = slug;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getKeyWords() {
            return keyWords;
        }

        public void setKeyWords(Object keyWords) {
            this.keyWords = keyWords;
        }

    }


    public class VehiclesStructure {

        @SerializedName("id")
        @Expose
        private Integer id;
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


    public class VehiclesType {

        @SerializedName("id")
        @Expose
        private Integer id;
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
}
