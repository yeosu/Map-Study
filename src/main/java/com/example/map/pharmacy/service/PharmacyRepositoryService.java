package com.example.map.pharmacy.service;

import com.example.map.pharmacy.entity.Pharmacy;
import com.example.map.pharmacy.repository.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PharmacyRepositoryService {
    private final PharmacyRepository pharmacyRepository;

    @Transactional
    public void updateAddress(Long id, String address){
        Pharmacy entity = pharmacyRepository.findById(id).orElse(null);

        if(Objects.isNull(entity)){
            log.error("[pharmacyRepository updateAddress] not found id : {}", id);
            return;
        }

        entity.changePharmacyAddress(address);
    }

    public void updateAddressWithoutTransaction(Long id, String address){
        Pharmacy entity = pharmacyRepository.findById(id).orElse(null);

        if(Objects.isNull(entity)){
            log.error("[pharmacyRepository updateAddress] not found id : {}", id);
            return;
        }

        entity.changePharmacyAddress(address);
    }
}
