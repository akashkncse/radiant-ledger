package com.akashkn.radiantledger;
import com.akashkn.radiantledger.model.Account;

import java.math.BigInteger;
public class Main {
    public static void main(String[] args) {
        Account akash = new Account("1", new BigInteger(String.valueOf(1000000)), "akash");
        System.out.println(akash.getAccountID());
    }
}