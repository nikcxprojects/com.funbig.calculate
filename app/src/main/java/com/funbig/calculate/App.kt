package com.funbig.calculate

import android.app.Application
import com.onesignal.OneSignal

class App : Application()  {

    private val ONESIGNAL_APP_ID = "982fd9d6-6b4b-45d8-a62f-babf9f18bbab"

    override fun onCreate() {
        super.onCreate()
        initOneConfig()
    }

    private fun initOneConfig() {
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this)

        OneSignal.unsubscribeWhenNotificationsAreDisabled(true)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}