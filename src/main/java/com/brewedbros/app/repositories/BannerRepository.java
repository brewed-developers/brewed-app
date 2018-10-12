package com.brewedbros.app.repositories;

import com.brewedbros.app.entities.Banner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BannerRepository extends CrudRepository<Banner, String> {

	List<Banner> findByCity(String city);

}
