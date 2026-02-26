package com.akashkn.radiantledger.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordService {
    public String hashPassword(String pw) {
        return BCrypt.hashpw(pw, BCrypt.gensalt(12));
    }
    public boolean checkPassword(String pw, String pw_hash) {
        return BCrypt.checkpw(pw, pw_hash);
    }
}
