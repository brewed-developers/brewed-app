package com.brewedbros.app.repositories;

import com.brewedbros.app.entities.Voucher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends CrudRepository<Voucher, String> {

    //List<Voucher> find();

    //@Query("Delete from voucher where  id=?1")
    void deleteById(String id);

    List<Voucher> findTop5ByRatingGreaterThan(String rating);

    List<Voucher> findByVoucherTypeAndCity(String voucherType,String city);

    List<Voucher> findAllByOrderByRatingAsc();

    List<Voucher> findAllByOrderByRatingDesc();

    @Query("SELECT DISTINCT voucherType FROM Voucher")
    List<String> findDistinctVoucherType();

    List<Voucher> findByCityAndVoucherType(String city, String voucherType);

    List<Voucher> findByCityAndAreaAndVoucherType(String city, String area, String type);

    Voucher findByCityAndNameAndVoucherType(String city, String eventName, String voucherType);

    Voucher findOneById(String id);
}
