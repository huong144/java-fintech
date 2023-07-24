package org.example.models.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component()
public class CreateUsersDto {
    private String username;
    private String password;
    private int isCustomer;
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public int getIsCustomer(){
        return isCustomer;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsCustomer(int isCustomer) {
        this.isCustomer = isCustomer;
    }
}
