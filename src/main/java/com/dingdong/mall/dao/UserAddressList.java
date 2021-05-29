package com.dingdong.mall.dao;

public class UserAddressList {
    private Integer id;

    private Integer userId;

    private String consignee;

    private String phonenumber;

    private String address;

    private String detailedAddress;

    private Boolean ison;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public Boolean getIson() {
        return ison;
    }

    public void setIson(Boolean ison) {
        this.ison = ison;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", consignee=").append(consignee);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", address=").append(address);
        sb.append(", detailedAddress=").append(detailedAddress);
        sb.append(", ison=").append(ison);
        sb.append("]");
        return sb.toString();
    }
}