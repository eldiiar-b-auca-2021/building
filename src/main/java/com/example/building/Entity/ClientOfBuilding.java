//package com.example.building.Entity;
//
//import com.example.building.Enums.RoleName;
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.hibernate.annotations.NaturalId;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//import java.io.Serializable;
//import java.time.LocalDate;
//@Entity
//public class ClientOfBuilding implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer user_id;
//
//    @Size(max = 1024)
//    private String firstname;
//
//    @Size(max = 255)
//    private String lastname;
//    @Size(max = 255)
//    private String password;
//
//    @Size(max = 255)
//    private String email;
//    @NotBlank
//    private LocalDate birthDate;
//    @Enumerated(EnumType.STRING)
//    @NaturalId
//    @Column(length = 50)
//    private RoleName name;
//
////    public ClientOfBuilding(Integer user_id, String firstname, String lastname, String password, String email, LocalDate birthDate, RoleName name) {
////        this.user_id = user_id;
////        this.firstname = firstname;
////        this.lastname = lastname;
////        this.password = password;
////        this.email = email;
////        this.birthDate = birthDate;
////        this.name = name;
////    }
//    public ClientOfBuilding(){
//
//    }
//
//    public Integer getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(Integer user_id) {
//        this.user_id = user_id;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }
//
//    public RoleName getName() {
//        return name;
//    }
//
//    public void setName(RoleName name) {
//        this.name = name;
//    }
//}
