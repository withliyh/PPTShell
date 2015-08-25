package com.nd.mvpcore.controllers;

import com.nd.mvpcore.util.Preconditions;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by liy on 2015/8/25.
 */
public abstract class BaseUiController<U extends BaseUiController.Ui<UC>, UC> extends BaseController {

    public interface Ui<UC> {
        void setCallbacks(UC callbacks);

        boolean isModal();
    }

    private final Set<U> mUis;
    private final Set<U> mUnmodifiableUis;

    public BaseUiController() {
        mUis = new CopyOnWriteArraySet<>();
        mUnmodifiableUis = Collections.unmodifiableSet(mUis);
    }


    @Override
    protected void onInited() {
        if (!mUis.isEmpty()) {
            for (U ui : mUis) {
                onUiAttached(ui);
                populateUi(ui);
            }
        }
    }

    public synchronized final void attachUi(U ui) {
        Preconditions.checkArgument(ui != null, "ui cannot be null");
        Preconditions.checkState(!mUis.contains(ui), "UI is already attached");

        mUis.add(ui);

        ui.setCallbacks(createUiCallbacks(ui));

        if (isInited()) {
            onUiAttached(ui);
            populateUi(ui);
        }
    }

    public synchronized final void detachUi(U ui) {
        Preconditions.checkArgument(ui != null, "ui cannot be null");
        Preconditions.checkState(mUis.contains(ui), "ui is not attached");
        onUiDetached(ui);
        ui.setCallbacks(null);

        mUis.remove(ui);
    }


    protected synchronized final void populateUis() {
        for (U ui : mUis) {
            populateUi(ui);
        }
    }

    protected void onUiDetached(U ui) {

    }

    protected void onUiAttached(U ui) {

    }

    protected void populateUi(U ui) {

    }

    protected abstract UC createUiCallbacks(U ui);


}
