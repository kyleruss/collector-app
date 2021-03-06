//-------------------------------------------
//  KYLE RUSSELL
//  AUT UNIVERSITY 2016
//  https://github.com/denkers/collector-app
//-------------------------------------------

package com.kyleruss.collector.mobile.comms;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kyleruss.collector.mobile.R;

import org.json.JSONObject;

public class ServiceResponse
{
    private boolean status;
    private String message;
    private JSONObject data;

    public ServiceResponse()
    {
        this("", false);
    }

    public ServiceResponse(String message, boolean status)
    {
        this.message    =   message;
        this.status     =   status;
    }

    public String getMessage()
    {
        return message;
    }

    public boolean getStatus()
    {
        return status;
    }

    public void setMessage(String message)
    {
        this.message    =   message;
    }

    public void setStatus(boolean status)
    {
        this.status =   status;
    }

    public JSONObject getData()
    {
        return data;
    }

    public void setData(JSONObject data)
    {
        this.data   =   data;
    }

    public void showToastResponse(Activity activity)
    {
        LayoutInflater inflater =   activity.getLayoutInflater();
        View layout             =   inflater.inflate(R.layout.toast_layout, (ViewGroup) activity.findViewById(R.id.stoast_layout));
        TextView textView       =   (TextView) layout.findViewById(R.id.stoast_text);
        textView.setText(message);

        ImageView imageView     =   (ImageView) layout.findViewById(R.id.stoast_icon);
        imageView.setImageResource(status? R.drawable.successicon : R.drawable.failicon);

        Toast toast =   new Toast(activity.getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
