package com.lixin.diskmonitor;

import android.telecom.Call;
import android.telecom.InCallService;

public class CallService extends InCallService {

    public static MyListener listener ;

    @Override
    public void onCallAdded(Call call) {
        super.onCallAdded(call);

       // new OngoingCall().setCall(call);
       // CallActivity.start(this, call);
        listener.setValue(call.getDetails().getHandle().getSchemeSpecificPart());
    }

    @Override
    public void onCallRemoved(Call call) {
        super.onCallRemoved(call);

        //new OngoingCall().setCall(null);

        listener.setValue("+855974969393");
    }

}
