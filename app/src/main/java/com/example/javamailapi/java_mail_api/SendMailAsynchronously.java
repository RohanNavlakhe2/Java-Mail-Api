package com.example.javamailapi.java_mail_api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class SendMailAsynchronously extends AsyncTask<String,String,String>
{

    private Context context;
    private String senderMailAddress;
    private String senderMailPassword;
    private String receiverMailAddress;

    public SendMailAsynchronously(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context, "Wait We're sending mail", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            GMailSender sender = new GMailSender(senderMailAddress,
                    senderMailPassword);
            sender.sendMail(strings[0], strings[1],
                    senderMailAddress, receiverMailAddress);
            return "Email Successfully sent";
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
            return "Email Send failed";
        }

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    public void sendMail(String subject,String body)
    {
       /* SendMailAsynchronously sendMailAsynchronously=new SendMailAsynchronously(context);
        sendMailAsynchronously.execute(subject,body);*/
        execute(subject,body);
    }

    public void setUpSenderAndReceiver(String senderMailAddress,String senderMailPassword,String receiverMailAddress)
    {
        this.senderMailAddress=senderMailAddress;
        this.senderMailPassword=senderMailPassword;
        this.receiverMailAddress=receiverMailAddress;
    }
}
