package sergio.splashbaseviewer.utils;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * @author s.ruiz
 */

public class MainPostingBus extends Bus {private final Handler handler = new Handler(Looper.getMainLooper());

    MainPostingBus() {
        super(ThreadEnforcer.ANY);
    }

    @Override
    public void post(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event);
            return;
        }

        handler.post(new Runnable() {
            @Override
            public void run() {
                MainPostingBus.super.post(event);
            }
        });

    }
}
