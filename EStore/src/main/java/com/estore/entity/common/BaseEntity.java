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

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@MappedSuperclass
public class BaseEntity extends AuditEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "PK")
    private String pk;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
