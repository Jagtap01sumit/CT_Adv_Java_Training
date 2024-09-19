package com.citiustech.stock;

import java.time.LocalDateTime;

public abstract class BaseEntity {
    protected int id;
    protected String createdBy = "Admin";
    protected LocalDateTime createdAt;

    BaseEntity() {
    	
        createdAt = LocalDateTime.now();
    }
    
  
}