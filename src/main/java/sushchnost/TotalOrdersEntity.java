package sushchnost;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "total_orders", schema = "public", catalog = "prac")
public class TotalOrdersEntity {
    private int orderId;
    private Double totalCost;
    private Timestamp dateOfOrder;
    private Short receivingId;
    private Short customerId;
    private Collection<OrdersEntity> ordersByOrderId;
    private ReceiveTEntity receiveTByReceivingId;
    private CustomersEntity customersByCustomerId;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "total_cost", nullable = true, precision = 0)
    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    @Basic
    @Column(name = "date_of_order", nullable = true)
    public Timestamp getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Timestamp dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    @Basic
    @Column(name = "receiving_id", nullable = true)
    public Short getReceivingId() {
        return receivingId;
    }

    public void setReceivingId(Short receivingId) {
        this.receivingId = receivingId;
    }

    @Basic
    @Column(name = "customer_id", nullable = true)
    public Short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Short customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TotalOrdersEntity that = (TotalOrdersEntity) o;

        if (orderId != that.orderId) return false;
        if (totalCost != null ? !totalCost.equals(that.totalCost) : that.totalCost != null) return false;
        if (dateOfOrder != null ? !dateOfOrder.equals(that.dateOfOrder) : that.dateOfOrder != null) return false;
        if (receivingId != null ? !receivingId.equals(that.receivingId) : that.receivingId != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) orderId;
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        result = 31 * result + (dateOfOrder != null ? dateOfOrder.hashCode() : 0);
        result = 31 * result + (receivingId != null ? receivingId.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "totalOrdersByOrderId")
    public Collection<OrdersEntity> getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(Collection<OrdersEntity> ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "receiving_id", referencedColumnName = "receiving_id")
    public ReceiveTEntity getReceiveTByReceivingId() {
        return receiveTByReceivingId;
    }

    public void setReceiveTByReceivingId(ReceiveTEntity receiveTByReceivingId) {
        this.receiveTByReceivingId = receiveTByReceivingId;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    public CustomersEntity getCustomersByCustomerId() {
        return customersByCustomerId;
    }

    public void setCustomersByCustomerId(CustomersEntity customersByCustomerId) {
        this.customersByCustomerId = customersByCustomerId;
    }
}
