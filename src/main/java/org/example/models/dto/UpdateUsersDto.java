package org.example.models.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.util.Date;

@Data
@Component()
public class UpdateUsersDto {
    @Id
    private int id;
    private String fullName;
    private String address;
    private Date dateOfBirth;
    private String sex;
    private String avatar;
    private String email;
    private String identityDocumentType;
    private String identityNumber;

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }


    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getEmail() {
        return email;
    }
    public String getIdentityDocumentType() {
        return identityDocumentType;
    }
    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdentityDocumentType(String identityDocumentType) {
        this.identityDocumentType = identityDocumentType;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }
}
