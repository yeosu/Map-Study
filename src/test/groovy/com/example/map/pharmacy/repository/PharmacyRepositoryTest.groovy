package com.example.map.pharmacy.repository

import com.example.map.AbstractIntegrationContainerBaseTest
import com.example.map.pharmacy.entity.Pharmacy
import org.springframework.beans.factory.annotation.Autowired

class PharmacyRepositoryTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    private PharmacyRepository pharmacyRepository

    def setup(){
        pharmacyRepository.deleteAll()
    }

    def "PharmacyRepository save"() {
        given:
        String address = "경기도 남양주시 호평동"
        String name = "호평 약국"
        double latitude = 36.11
        double longitude = 128.11

        def pharmacy= Pharmacy.builder()
            .pharmacyAddress(address)
            .pharmacyName(name)
            .latitude(latitude)
            .longitude(longitude)
            .build()

        when:
        def result = pharmacyRepository.save(pharmacy)

        then:
        result.getPharmacyAddress() == address
        result.getPharmacyName() == name
        result.getLatitude() == latitude
        result.getLongitude() == longitude
    }

    def "PharmacyRepository saveAll"(){
        given:
        given:
        String address = "경기도 남양주시 호평동"
        String name = "호평 약국"
        double latitude = 36.11
        double longitude = 128.11

        def pharmacy= Pharmacy.builder()
                .pharmacyAddress(address)
                .pharmacyName(name)
                .latitude(latitude)
                .longitude(longitude)
                .build()

        when:
        pharmacyRepository.saveAll(Arrays.asList(pharmacy))
        def result = pharmacyRepository.findAll()

        then:
        result.size() == 1
    }
}
