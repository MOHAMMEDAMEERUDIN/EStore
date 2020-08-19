/*
 *
 *  * Copyright (c) 2016.
 *  * All rights reserved.
 *  *
 *  * This software is the confidential and proprietary information of CIQA
 *  * ("Confidential Information"). You shall not disclose such Confidential
 *  * Information and shall use it only in accordance with the terms of the
 *  * license agreement you entered into with CIQA Technologies.
 *
 */

package com.estore.entity.common;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity {

    @Column(name = "creation_time", nullable = false)
    @CreatedDate
    private Date creationDate = new Date();

    @Column(name = "modification_time")

    @LastModifiedDate
    private Date modificationDate = new Date();


    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
