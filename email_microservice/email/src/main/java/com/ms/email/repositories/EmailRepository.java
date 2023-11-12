package com.ms.email.repositories;

import com.ms.email.model.Email;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository  extends JpaRepository<Email, UUID> {



}
