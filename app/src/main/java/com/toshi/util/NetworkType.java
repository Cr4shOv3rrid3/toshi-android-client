package com.toshi.util;

import android.support.annotation.IntDef;

import com.toshi.R;
import com.toshi.view.BaseApplication;

public class NetworkType {
    @IntDef({ROPSTEN_TESTNET_STAGING, ROPSTEN_TESTNET, ROPSTEN_MAINNET})
    public @interface Type {}
    private static final int ROPSTEN_TESTNET_STAGING = 1;
    private static final int ROPSTEN_TESTNET = 2;
    private static final int ROPSTEN_MAINNET = 3;

    public static @NetworkType.Type int getNetworkType(final String network) {
        if (BaseApplication.get().getString(R.string.ropsten_testnet_staging).equals(network)) {
            return NetworkType.ROPSTEN_TESTNET_STAGING;
        } else if (BaseApplication.get().getString(R.string.ropsten_testnet).equals(network)) {
            return NetworkType.ROPSTEN_TESTNET;
        } else {
            return NetworkType.ROPSTEN_MAINNET;
        }
    }

    public static String getNetworkName(final @NetworkType.Type int networkType) {
        if (networkType == NetworkType.ROPSTEN_TESTNET_STAGING) {
            return BaseApplication.get().getString(R.string.ropsten_testnet_staging);
        } else if (networkType == NetworkType.ROPSTEN_TESTNET) {
            return BaseApplication.get().getString(R.string.ropsten_testnet);
        } else {
            return BaseApplication.get().getString(R.string.mainnet);
        }
    }
}
