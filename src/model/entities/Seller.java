package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Seller implements Serializable {

    private int id;
    private String email;
    private String name;
    private LocalDate birthDate;
    private Double baseSalary;

    private Department department;

    public Seller() {
    }

    public Seller(int id, String name, String email, LocalDate date, double baseSalary, Department obj) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.birthDate = date;
        this.baseSalary = baseSalary;
        this.department = obj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return getId() == seller.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", baseSalary=" + baseSalary +
                ", department=" + department +
                '}';
    }
}
