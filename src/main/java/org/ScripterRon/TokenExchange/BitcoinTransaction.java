/*
 * Copyright 2016 Ronald W Hoffman.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ScripterRon.TokenExchange;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Bitcoin transaction
 */
class BitcoinTransaction {

    /** Bitcoin transaction identifier */
    private final byte[] bitcoinTxId;

    /** Bitcoin address */
    private final String bitcoinAddress;

    /** Bitcoin block height */
    private int height;

    /** Bitcoin transaction timestamp */
    private int timestamp;

    /** Bitcoin transaction amount */
    private final long bitcoinAmount;

    /** Nxt currency amount */
    private final long tokenAmount;

    /** Nxt account identifier */
    private final long accountId;

    /** Token issued */
    private boolean exchanged;

    /** Nxt transaction identifier */
    private long nxtTxId;

    /**
     * Create a Bitcoin transaction
     *
     * @param   bitcoinTxId     Bitcoin transaction identifier
     * @param   height          Bitcoin block height
     * @param   timestamp       Bitcoin transaction timestamp
     * @param   bitcoinAddress  Bitcoin address
     * @param   accountId       Nxt account identifier
     * @param   bitcoinAmount   Bitcoin transaction amount
     * @param   tokenAmount     Token units
     */
    BitcoinTransaction(byte[] bitcoinTxId, int height, int timestamp, String bitcoinAddress, long accountId,
                                long bitcoinAmount, long tokenAmount) {
        this.bitcoinTxId = bitcoinTxId;
        this.height = height;
        this.timestamp = timestamp;
        this.bitcoinAddress = bitcoinAddress;
        this.accountId = accountId;
        this.bitcoinAmount = bitcoinAmount;
        this.tokenAmount = tokenAmount;
    }

    /**
     * Create a Bitcoin transaction
     *
     * @param   rs              Result set
     * @throws  SQLException    SQL error occurred
     */
    BitcoinTransaction(ResultSet rs) throws SQLException {
        this.bitcoinTxId = rs.getBytes("bitcoin_txid");
        this.height = rs.getInt("height");
        this.timestamp = rs.getInt("timestamp");
        this.bitcoinAddress = rs.getString("bitcoin_address");
        this.bitcoinAmount = rs.getLong("bitcoin_amount");
        this.tokenAmount = rs.getLong("token_amount");
        this.accountId = rs.getLong("account_id");
        this.exchanged = rs.getBoolean("exchanged");
        this.nxtTxId = rs.getLong("nxt_txid");
    }

    /**
     * Get the Bitcoin transaction identifier
     *
     * @return                  Transaction identifier
     */
    byte[] getBitcoinTxId() {
        return bitcoinTxId;
    }

    /**
     * Get the Bitcoin address
     *
     * @return                  Bitcoin address
     */
    String getBitcoinAddress() {
        return bitcoinAddress;
    }

    /**
     * Get the Bitcoin block height
     *
     * @return                  Block height or 0 if not in block yet
     */
    int getHeight() {
        return height;
    }

    /**
     * Set the Bitcoin block height
     *
     * @param   height          Block height
     */
    void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get the Bitcoin transaction timestamp
     *
     * @return  timestamp       Transaction timestamp or 0 if not in block yet
     */
    int getTimestamp() {
        return timestamp;
    }

    /**
     * Set the Bitcoin transaction timestamp
     *
     * @param   height          Transaction timestamp
     */
    void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Get the Bitcoin amount
     *
     * @return                  Bitcoin amount
     */
    long getBitcoinAmount() {
        return bitcoinAmount;
    }

    /**
     * Get the token amount
     *
     * @return                  Token amount
     */
    long getTokenAmount() {
        return tokenAmount;
    }

    /**
     * Get the account identifier
     *
     * @return                  Account identifier
     */
    long getAccountId() {
        return accountId;
    }

    /**
     * Check if the transaction has been processed
     *
     * @return                  TRUE if the transaction has been processed
     */
    boolean isExchanged() {
        return exchanged;
    }

    /**
     * Set transaction processed
     *
     * @param   nxtTxId         Nxt transaction identifier
     */
    void setExchanged(long nxtTxId) {
        this.nxtTxId = nxtTxId;
        exchanged = true;
    }

    /**
     * Return the Nxt transaction identifier
     *
     * @return                  Nxt transaction identifier
     */
    long getNxtTxId() {
        return nxtTxId;
    }
}
