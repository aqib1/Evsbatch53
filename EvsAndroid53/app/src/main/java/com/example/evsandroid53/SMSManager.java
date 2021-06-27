package com.example.evsandroid53;

import android.telephony.SmsManager;

import com.example.evsandroid53.SharedPreferences.SPManager;

import java.util.Objects;

public class SMSManager {

    private SmsManager manager;
    private static SMSManager smsManager;

    public SMSManager init() {
        manager = SmsManager.getDefault();
        return smsManager;
    }

    public SMSManager sendMessage(String message, String senderNumber, String receiverNumber) {
        manager.sendTextMessage(receiverNumber, senderNumber, message, null, null);
        return smsManager;
    }

    public static SMSManager getInstance() {
        if(Objects.isNull(smsManager)) {
            synchronized (SPManager.class) {
                if(Objects.isNull(smsManager))
                    smsManager = new SMSManager();
            }
        }
        return smsManager;
    }
    //Singleton pattern
    private SMSManager() {

    }
}
