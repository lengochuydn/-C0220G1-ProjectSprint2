package com.codegym.dao.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_bill")
    private Integer id;

    @Column(name = "bill_name")
    private String billName;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "bill_status")
    private String billStatus;

    @Column(name = "processing_status")
    private String processingStatus;

    @Column(name = "shipping_status")
    private String shippingStatus;

    @Column(name = "payment_status")
    private String paymentStatus;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_type_bill")
    private TypeBill idTypeBill;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_storage_location")
    private StorageLocation idStorageLocation;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_ware_house")
    private WareHouse idWareHouse;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_transportation")
    private Transportation idTransportation;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_pay")
    private Pay idPay;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_distributor")
    private Distributor idDistributor;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_employee")
    private Employee idEmployee;

    @Column(name = "delete_flag")
    private Boolean deleteFlag;

    public Bill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public TypeBill getIdTypeBill() {
        return idTypeBill;
    }

    public void setIdTypeBill(TypeBill idTypeBill) {
        this.idTypeBill = idTypeBill;
    }

    public StorageLocation getIdStorageLocation() {
        return idStorageLocation;
    }

    public void setIdStorageLocation(StorageLocation idStorageLocation) {
        this.idStorageLocation = idStorageLocation;
    }

    public WareHouse getIdWareHouse() {
        return idWareHouse;
    }

    public void setIdWareHouse(WareHouse idWareHouse) {
        this.idWareHouse = idWareHouse;
    }

    public Transportation getIdTransportation() {
        return idTransportation;
    }

    public void setIdTransportation(Transportation idTransportation) {
        this.idTransportation = idTransportation;
    }

    public Pay getIdPay() {
        return idPay;
    }

    public void setIdPay(Pay idPay) {
        this.idPay = idPay;
    }

    public Distributor getIdDistributor() {
        return idDistributor;
    }

    public void setIdDistributor(Distributor idDistributor) {
        this.idDistributor = idDistributor;
    }

    public Employee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Employee idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
