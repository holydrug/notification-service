package com.popov.notification.service.repository.person.repository.phone;

import com.popov.notification.service.entity.person.phone.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

    @Query(value = "SELECT * FROM phones WHERE carrier_code=:carrierCode", nativeQuery = true)
    List<PhoneNumber> getFilteredPhonesWithCarrierCode(@Param("carrierCode") String carrierCode);
}
