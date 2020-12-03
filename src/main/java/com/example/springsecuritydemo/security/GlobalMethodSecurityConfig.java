package com.example.springsecuritydemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class GlobalMethodSecurityConfig extends GlobalMethodSecurityConfiguration {
    @Autowired
    private RoleHierarchy roleHierarchy;

    @Override
    protected AccessDecisionManager accessDecisionManager() {
        AffirmativeBased affirmativeBased=(AffirmativeBased)super.accessDecisionManager();
        affirmativeBased.getDecisionVoters().add(new RoleHierarchyVoter(roleHierarchy));
        return affirmativeBased;
    }
}
