package top.cciradih.spring.data.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author hidarichaochen@gmail.com
 * @version 0.1
 */
@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false, length = 16)
    private Long internalOrder;

    @Column(unique = true)
    private Long externalOrder;

    private Boolean paymentStatus = false;

    @Column(nullable = false, updatable = false, length = 16)
    private Long userId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false, updatable = false)
    private Double orderAmount;

    @Column(updatable = false)
    private Date createTime = new Date();

    private Date endTime;

    @Column(nullable = false)
    private String paymentMethod;

    public Transaction() {
    }

    public Transaction(Long internalOrder, Long userId, String productName, Double orderAmount, String paymentMethod) {
        this.internalOrder = internalOrder;
        this.userId = userId;
        this.productName = productName;
        this.orderAmount = orderAmount;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInternalOrder() {
        return internalOrder;
    }

    public void setInternalOrder(Long internalOrder) {
        this.internalOrder = internalOrder;
    }

    public Long getExternalOrder() {
        return externalOrder;
    }

    public void setExternalOrder(Long externalOrder) {
        this.externalOrder = externalOrder;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", internalOrder=" + internalOrder +
                ", externalOrder=" + externalOrder +
                ", paymentStatus=" + paymentStatus +
                ", userId=" + userId +
                ", productName='" + productName + '\'' +
                ", orderAmount=" + orderAmount +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
