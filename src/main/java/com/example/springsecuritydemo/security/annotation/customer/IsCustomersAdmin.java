package com.example.springsecuritydemo.security.annotation.customer;


import org.springframework.security.access.annotation.Secured;
import static com.example.springsecuritydemo.security.SecurityRoles.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Secured(ROLE_PREFIX + CUSTOMERS_ADMIN)
public @interface IsCustomersAdmin {
}
