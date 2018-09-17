package com.brewedbros.app.services;

import com.brewedbros.app.constants.VoucherConstants;
import com.brewedbros.app.entities.Voucher;
import com.brewedbros.app.repositories.TicketRepository;
import com.brewedbros.app.repositories.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VoucherService {
    @Autowired
    VoucherRepository voucherRepository;
    @Autowired
    TicketRepository ticketRepository;


    public Iterable<Voucher> getAllVouchers() {
        return voucherRepository.findAll();
    }

    public List<Voucher> getAllVoucherByRating() {
        List<Voucher> voucherList = voucherRepository.findTop5ByRatingGreaterThan("2");
        voucherList.forEach((voucher) ->
                voucher.setTicketCount(ticketRepository.findByVoucherId(voucher.getId()).size())
        );
        return voucherList;

    }

    public List<Voucher> getVoucherByType(String voucherType) {
        return voucherRepository.findByVoucherType(voucherType);
    }

    public List<Voucher> getVoucherByRatingAsc() {
        return voucherRepository.findAllByOrderByRatingAsc();
    }

    public List<Voucher> getVoucherByRatingDesc() {
        return voucherRepository.findAllByOrderByRatingDesc();
    }

    public LinkedHashMap<String, List<Voucher>> getAllVoucherByType() {

        int ticketCount = 0;
        List<String> list = voucherRepository.findDistinctVoucherType();
        List<Voucher> ls = new ArrayList<Voucher>();
        LinkedHashMap<String, List<Voucher>> vocherMapByType = new LinkedHashMap<String, List<Voucher>>();
        for (String voucher : list) {

            ls = voucherRepository.findByVoucherType(voucher);
            for (Voucher singleVoucher : ls) {

                singleVoucher.setTicketCount(ticketRepository.findByVoucherId(singleVoucher.getId()).size());


            }

            vocherMapByType.put(voucher, ls);
        }

        return vocherMapByType;
    }

    public void deleteVoucher(String id) {
        if (id != null) {
            voucherRepository.deleteById(id);

        }

    }

    public boolean saveVoucher(Voucher voucher) {
        voucher.setId(UUID.randomUUID().toString());
        voucherRepository.save(voucher);
        return true;
    }

    public Optional<Voucher> getVoucher(String voucherid) {
        return voucherRepository.findById(voucherid);
    }

    /**
     * This method assumes Voucher Type as EVENT
     *
     * @param city: For which City Vouchers should be returned back
     * @return List of Event Vouchers (Voucher of Type Event)
     */
    public List<Voucher> getEvents(String city) {
        return getVouchersByCityAndVoucherType(city, VoucherConstants.EVENTS);
    }

    /**
     * This method assumes Voucher Type as EVENT
     *
     * @param city: For which City Vouchers should be returned back
     * @param area: For which Area Vouchers should be returned back
     * @return List of Event Vouchers (Voucher of Type Event)
     */
    public List<Voucher> getEventsByCityAndArea(String city, String area) {
        return getVochersByCityAreaAndVoucherType(city, area, VoucherConstants.EVENTS);
    }

    /**
     * Loading an Event Based on Event Name
     *
     * @param city      : Name of City
     * @param eventName : Name of Event
     * @return: Single Event Vouchers (Voucher of Type Event)
     */
    public List<Voucher> getSingleEvents(String city, String eventName) {
        return voucherRepository.findByCityAndNameAndVoucherType(city, eventName, VoucherConstants.EVENTS);
    }

    private List<Voucher> getVouchersByCityAndVoucherType(String city, String type) {
        return voucherRepository.findByCityAndVoucherType(city, type);
    }

    private List<Voucher> getVochersByCityAreaAndVoucherType(String city, String area, String type) {
        return voucherRepository.findByCityAndAreaAndVoucherType(city, area, type);
    }


}
