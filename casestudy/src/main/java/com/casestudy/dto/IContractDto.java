package com.casestudy.dto;

import java.util.Date;

public interface IContractDto {
    Integer getId();
    String getCustomerName();
    String getEmployeeName();
    String getServiceName();
    Date getBeginDate();
    Date getEndDate();
    String getDeposit();
    String getTotalCost();
}
