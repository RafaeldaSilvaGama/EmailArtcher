package com.ms.email.model;


import com.ms.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emailId;
    private String email;
    private String usuario;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

}
