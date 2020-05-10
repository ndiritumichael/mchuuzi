package com.mchuuzi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionReceiver extends BroadcastReceiver {
    public TransactionReceiver() { }

    @Override
    public void onReceive(Context context, Intent intent) {
        String uuid = intent.getStringExtra("uuid");
        String confirmationCode = null, amount = null, recipientName = null, recipientPhone = null, date = null, time=null, balance=null, fee=null;
        if (intent.hasExtra("parsed_variables")) {
            HashMap<String, String> parsed_variables = (HashMap<String, String>) intent.getSerializableExtra("parsed_variables");
            if (parsed_variables.containsKey("confirmCode"))
                confirmationCode = parsed_variables.get("confirmCode");
            if (parsed_variables.containsKey("balance"))
                balance = parsed_variables.get("balance");
            if (parsed_variables.containsKey("amount"))
                amount = parsed_variables.get("amount");
            if (parsed_variables.containsKey("recipientName"))
                recipientName = parsed_variables.get("recipientName");
            if (parsed_variables.containsKey("recipientPhone"))
                recipientPhone = parsed_variables.get("recipientPhone");
            if (parsed_variables.containsKey("date"))
                date = parsed_variables.get("date");
            if (parsed_variables.containsKey("time"))
                time = parsed_variables.get("time");
            if (parsed_variables.containsKey("fee"))
                fee = parsed_variables.get("fee");

            String [] arr = {confirmationCode, amount, recipientName, recipientPhone, date, time, balance, fee};
            Intent toActivityIntent = new Intent("HoverReceiver");
            toActivityIntent.putExtra("HOVER MESSAGE", arr);

            context.sendBroadcast(toActivityIntent);
//            Log.e("Hover Receiver", "data: " + confirmationCode+amount+recipientName+recipientPhone+date+time+balance+fee);
        }else{
            Log.e("Hover Receiver", "no parsed variables");
        }

    }
}
