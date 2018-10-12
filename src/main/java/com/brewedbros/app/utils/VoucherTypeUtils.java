package com.brewedbros.app.utils;

import com.brewedbros.app.constants.VoucherConstants;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

public class VoucherTypeUtils {
    private static final HashMap<String, String> VOUCHER_TYPES = new HashMap<>();

    static {
        VOUCHER_TYPES.put("events", VoucherConstants.EVENTS);
        VOUCHER_TYPES.put("spa", VoucherConstants.SPA);
        VOUCHER_TYPES.put("beauty", VoucherConstants.BEAUTY);
        VOUCHER_TYPES.put("adventure", VoucherConstants.ADVENTURE);
        VOUCHER_TYPES.put("eat-outs", VoucherConstants.EAT_OUTS);
        VOUCHER_TYPES.put("health", VoucherConstants.HEALTH);
        VOUCHER_TYPES.put("shopping", VoucherConstants.SHOPPING);
    }
    public static String valueOf(@NotNull @NotEmpty String type){
        return VOUCHER_TYPES.get(type);
    }
}
