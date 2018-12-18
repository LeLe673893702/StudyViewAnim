package com.newler.studyview;

import android.app.Application;

import com.tencent.wstt.gt.client.AbsGTParaLoader;
import com.tencent.wstt.gt.client.GT;
import com.tencent.wstt.gt.client.InParaManager;
import com.tencent.wstt.gt.client.OutParaManager;

/**
 * @author newler
 * @what
 * @date 2018/7/5
 */
public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GT.connect(getApplicationContext(), new AbsGTParaLoader() {
            @Override
            public void loadInParas(InParaManager inParaManager) {

            }

            @Override
            public void loadOutParas(OutParaManager outParaManager) {

            }
        });
    }
}
