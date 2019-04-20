package sushchnost;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "receive_t", schema = "public", catalog = "prac")
public class ReceiveTEntity {
    private int receivingId;
    private String receivingType;
    private Timestamp dateOfReceiving;
    private String express;
    private String adress;
    private Collection<TotalOrdersEntity> totalOrdersByReceivingId;

    @Id
    @Column(name = "receiving_id", nullable = false)
    public int getReceivingId() {
        return receivingId;
    }

    public void setReceivingId(int receivingId) {
        this.receivingId = receivingId;
    }

    @Basic
    @Column(name = "receiving_type", nullable = true, length = 15)
    public String getReceivingType() {
        return receivingType;
    }

    public void setReceivingType(String receivingType) {
        this.receivingType = receivingType;
    }

    @Basic
    @Column(name = "date_of_receiving", nullable = true)
    public Timestamp getDateOfReceiving() {
        return dateOfReceiving;
    }

    public void setDateOfReceiving(Timestamp dateOfReceiving) {
        this.dateOfReceiving = dateOfReceiving;
    }

    @Basic
    @Column(name = "express", nullable = true, length = 3)
    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    @Basic
    @Column(name = "adress", nullable = true, length = 50)
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiveTEntity that = (ReceiveTEntity) o;

        if (receivingId != that.receivingId) return false;
        if (receivingType != null ? !receivingType.equals(that.receivingType) : that.receivingType != null)
            return false;
        if (dateOfReceiving != null ? !dateOfReceiving.equals(that.dateOfReceiving) : that.dateOfReceiving != null)
            return false;
        if (express != null ? !express.equals(that.express) : that.express != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) receivingId;
        result = 31 * result + (receivingType != null ? receivingType.hashCode() : 0);
        result = 31 * result + (dateOfReceiving != null ? dateOfReceiving.hashCode() : 0);
        result = 31 * result + (express != null ? express.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "receiveTByReceivingId")
    public Collection<TotalOrdersEntity> getTotalOrdersByReceivingId() {
        return totalOrdersByReceivingId;
    }

    public void setTotalOrdersByReceivingId(Collection<TotalOrdersEntity> totalOrdersByReceivingId) {
        this.totalOrdersByReceivingId = totalOrdersByReceivingId;
    }
}
