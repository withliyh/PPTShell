package com.nd.mvpcore.controllers;

import android.content.Intent;

import com.nd.mvpcore.util.Preconditions;

/**
 * Created by liy on 2015/8/25.
 */
public class BaseController {

    private boolean mInited;

    public final void init() {
        Preconditions.checkState(mInited == false, "Already inited");
        mInited = true;
        onInited();
    }

    public final void suspend() {
        Preconditions.checkState(mInited == true, "Not inited");
        onSuspended();
        mInited = false;
    }

    public final boolean isInited() {
        return mInited;
    }

    protected void onSuspended() {
    }

    protected void onInited() {
    }

    public boolean handleIntent(Intent intent) {
        return false;
    }
}
