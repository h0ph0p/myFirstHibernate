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
    private Collection<OrdersEntity> ordersByOrderId;
    private ReceiveTEntity receiveTByReceivingId;
    private CustomersEntity customersByCustomerId;

    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TotalOrdersEntity that = (TotalOrdersEntity) o;

        if (orderId != that.orderId) return false;
        if (totalCost != null ? !totalCost.equals(that.totalCost) : that.totalCost != null) return false;
        if (dateOfOrder != null ? !dateOfOrder.equals(that.dateOfOrder) : that.dateOfOrder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        result = 31 * result + (dateOfOrder != null ? dateOfOrder.hashCode() : 0);
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
