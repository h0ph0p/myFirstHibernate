package sushchnost;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "characteristics", schema = "public", catalog = "prac")
public class CharacteristicsEntity {
    private int typeId;
    private String typeName;
    private String characteristic1;
    private String characteristic2;
    private String characteristic3;
    private String characteristic4;
    private String characteristic5;
    private String characteristic6;
    private Collection<GoodsEntity> goodsByTypeId;

    @Id
    @Column(name = "type_id", nullable = false)
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
    @Column(name = "characteristic_1", nullable = true, precision = 0)
    public String getCharacteristic1() {
        return characteristic1;
    }

    public void setCharacteristic1(String characteristic1) {
        this.characteristic1 = characteristic1;
    }

    @Basic
    @Column(name = "characteristic_2", nullable = true, precision = 0)
    public String getCharacteristic2() {
        return characteristic2;
    }

    public void setCharacteristic2(String characteristic2) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacteristicsEntity that = (CharacteristicsEntity) o;

        if (typeId != that.typeId) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
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

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) typeId;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (characteristic1 != null ? characteristic1.hashCode() : 0);
        result = 31 * result + (characteristic2 != null ? characteristic2.hashCode() : 0);
        result = 31 * result + (characteristic3 != null ? characteristic3.hashCode() : 0);
        result = 31 * result + (characteristic4 != null ? characteristic4.hashCode() : 0);
        result = 31 * result + (characteristic5 != null ? characteristic5.hashCode() : 0);
        result = 31 * result + (characteristic6 != null ? characteristic6.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "characteristicsByTypeId")
    public Collection<GoodsEntity> getGoodsByTypeId() {
        return goodsByTypeId;
    }

    public void setGoodsByTypeId(Collection<GoodsEntity> goodsByTypeId) {
        this.goodsByTypeId = goodsByTypeId;
    }

    public void setGoodsByTypeId(int i) {
    }
}
