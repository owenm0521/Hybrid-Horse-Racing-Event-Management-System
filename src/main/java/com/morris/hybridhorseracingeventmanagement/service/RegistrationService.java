package com.morris.hybridhorseracingeventmanagement.service;

import com.morris.hybridhorseracingeventmanagement.model.Registration;
import com.morris.hybridhorseracingeventmanagement.repository.RegistrationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Registration Service
 */
@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public void saveRegistration(Registration registration) {
    	registrationRepository.save(registration); 
    }
    
    public void deleteRegistration(long id) {
    	registrationRepository.deleteById(id);
    }	

}

