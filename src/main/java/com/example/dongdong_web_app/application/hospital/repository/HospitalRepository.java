package com.example.dongdong_web_app.application.hospital.repository;

import com.example.dongdong_web_app.application.hospital.entitiy.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, String> {

    @Query("FROM hospital WHERE ST_Distance_Sphere ( POINT(:lon, :lat), POINT(hospital_lot, hospital_lat) ) <= :distance")
    List<HospitalEntity> findNearHospital(final double lon, final double lat, final int distance);

}
