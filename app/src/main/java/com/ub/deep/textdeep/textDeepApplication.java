package com.ub.deep.textdeep;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by deep on 4/10/15.
 */
public class textDeepApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "ioHlualHiGokDIxZfirr0F6tSRQus7VYQGJhsibl", "NQ5Qy7h0E3imwUQzlIyLfcx0zY38Kaf6Yb2fyZ7o");
/*
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();*/
    }
}
