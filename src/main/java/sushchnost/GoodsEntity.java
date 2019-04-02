package sushchnost;

import javax.persistence.*;

@Entity
@Table(name = "goods", schema = "public", catalog = "prac")
public class GoodsEntity {
    private int id;
    private String typeName;
    private Short producerId;
    private String image;
    private String dimensions;
    private String description;
    private Double characteristic1;
    private Double characteristic2;
    private String characteristic3;
    private String characteristic4;
    private String characteristic5;
    private String characteristic6;
    private String availability;
    private Short typeId;
    private CharacteristicsEntity characteristicsByTypeId;
    private ProducerEntity producerByProducerId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type_name", nullable = true, length = 50)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "producer_id", nullable = true)
    public Short getProducerId() {
        return producerId;
    }

    public void setProducerId(Short producerId) {
        this.producerId = producerId;
    }

    @Basic
    @Column(name = "image", nullable = true, length = 50)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "dimensions", nullable = true, length = 50)
    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "characteristic_1", nullable = true, precision = 0)
    public Double getCharacteristic1() {
        return characteristic1;
    }

    public void setCharacteristic1(Double characteristic1) {
        this.characteristic1 = characteristic1;
    }

    @Basic
    @Column(name = "characteristic_2", nullable = true, precision = 0)
    public Double getCharacteristic2() {
        return characteristic2;
    }

    public void setCharacteristic2(Double characteristic2) {
        this.characteristic2 = characteristic2;
    }

    @Basic
    @Column(name = "characteristic_3", nullable = true, length = 50)
    public String getCharacteristic3() {
        return characteristic3;
    }

    public void setCharacteristic3(String characteristic3) {
        this.characteristic3 = characteristic3;
    }

    @Basic
    @Column(name = "characteristic_4", nullable = true, length = 50)
    public String getCharacteristic4() {
        return characteristic4;
    }

    public void setCharacteristic4(String characteristic4) {
        this.characteristic4 = characteristic4;
    }

    @Basic
    @Column(name = "characteristic_5", nullable = true, length = 50)
    public String getCharacteristic5() {
        return characteristic5;
    }

    public void setCharacteristic5(String characteristic5) {
        this.characteristic5 = characteristic5;
    }

    @Basic
    @Column(name = "characteristic_6", nullable = true, length = 50)
    public String getCharacteristic6() {
        return characteristic6;
    }

    public void setCharacteristic6(String characteristic6) {
        this.characteristic6 = characteristic6;
    }

    @Basic
    @Column(name = "availability", nullable = true, length = 3)
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsEntity that = (GoodsEntity) o;

        if (id != that.id) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
        if (producerId != null ? !producerId.equals(that.producerId) : that.producerId != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (dimensions != null ? !dimensions.equals(that.dimensions) : that.dimensions != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (characteristic1 != null ? !characteristic1.equals(that.characteristic1) : that.characteristic1 != null)
            return false;
        if (characteristic2 != null ? !characteristic2.equals(that.characteristic2) : that.characteristic2 != null)
            return false;
        if (characteristic3 != null ? !characteristic3.equals(that.characteristic3) : that.characteristic3 != null)
            return false;
        if (characteristic4 != null ? !characteristic4.equals(that.characteristic4) : that.characteristic4 != null)
            return false;
        if (characteristic5 != null ? !characteristic5.equals(that.characteristic5) : that.characteristic5 != null)
            return false;
        if (characteristic6 != null ? !characteristic6.equals(that.characteristic6) : that.characteristic6 != null)
            return false;
        if (availability != null ? !availability.equals(that.availability) : that.availability != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (producerId != null ? producerId.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (dimensions != null ? dimensions.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (characteristic1 != null ? characteristic1.hashCode() : 0);
        result = 31 * result + (characteristic2 != null ? characteristic2.hashCode() : 0);
        result = 31 * result + (characteristic3 != null ? characteristic3.hashCode() : 0);
        result = 31 * result + (characteristic4 != null ? characteristic4.hashCode() : 0);
        result = 31 * result + (characteristic5 != null ? characteristic5.hashCode() : 0);
        result = 31 * result + (characteristic6 != null ? characteristic6.hashCode() : 0);
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "type_id", nullable = true)
    public Short getTypeId() {
        return typeId;
    }

    public void setTypeId(Short typeId) {
        this.typeId = typeId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    public CharacteristicsEntity getCharacteristicsByTypeId() {
        return characteristicsByTypeId;
    }

    public void setCharacteristicsByTypeId(CharacteristicsEntity characteristicsByTypeId) {
        this.characteristicsByTypeId = characteristicsByTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "producer_id")
    public ProducerEntity getProducerByProducerId() {
        return producerByProducerId;
    }

    public void setProducerByProducerId(ProducerEntity producerByProducerId) {
        this.producerByProducerId = producerByProducerId;
    }
}
