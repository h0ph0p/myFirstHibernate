package sushchnost;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "customers", schema = "public", catalog = "prac")
public class CustomersEntity {
    private short customerId;
    private String login;
    private String pasword;
    private String fio;
    private Collection<TotalOrdersEntity> totalOrdersByCustomerId;

    @Id
    @Column(name = "customer_id", nullable = false)
    public short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(short customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "login", nullable = true, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "pasword", nullable = true, length = 50)
    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    @Basic
    @Column(name = "fio", nullable = true, length = 1000)
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomersEntity that = (CustomersEntity) o;

        if (customerId != that.customerId) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (pasword != null ? !pasword.equals(that.pasword) : that.pasword != null) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) customerId;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (pasword != null ? pasword.hashCode() : 0);
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customersByCustomerId")
    public Collection<TotalOrdersEntity> getTotalOrdersByCustomerId() {
        return totalOrdersByCustomerId;
    }

    public void setTotalOrdersByCustomerId(Collection<TotalOrdersEntity> totalOrdersByCustomerId) {
        this.totalOrdersByCustomerId = totalOrdersByCustomerId;
    }
}
