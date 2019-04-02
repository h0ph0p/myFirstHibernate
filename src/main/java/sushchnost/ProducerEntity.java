package sushchnost;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "producer", schema = "public", catalog = "prac")
public class ProducerEntity {
    private int producerId;
    private String producerName;
    private Double rating;
    private String logo;
    private Collection<GoodsEntity> goodsByProducerId;

    @Id
    @Column(name = "producer_id", nullable = false)
    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    @Basic
    @Column(name = "producer_name", nullable = true, length = 50)
    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    @Basic
    @Column(name = "rating", nullable = true, precision = 0)
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "logo", nullable = true, length = 50)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProducerEntity that = (ProducerEntity) o;

        if (producerId != that.producerId) return false;
        if (producerName != null ? !producerName.equals(that.producerName) : that.producerName != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = producerId;
        result = 31 * result + (producerName != null ? producerName.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "producerByProducerId")
    public Collection<GoodsEntity> getGoodsByProducerId() {
        return goodsByProducerId;
    }

    public void setGoodsByProducerId(Collection<GoodsEntity> goodsByProducerId) {
        this.goodsByProducerId = goodsByProducerId;
    }
}
