package com.neoshinri.greendaoexample;

import android.app.Application;

import com.neoshinri.greendaoexample.entity.DaoMaster;
import com.neoshinri.greendaoexample.entity.DaoMaster.DevOpenHelper;
import com.neoshinri.greendaoexample.entity.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by EliteBook2540 on 16/05/2017.
 */

public class App extends Application {

    private boolean ENCRYPTED = false;

    private final static String DB_NAME = "neoplay_media_db";
    private final static String DB_ENCRYPTED_NAME = "encrypted_media_db";
    private final static String DB_ENCRYPTED_PASSWORD = "noencriptado";

    private DaoSession daoSession;

    public void onCreate() {
        super.onCreate();

        DevOpenHelper helper = new DevOpenHelper(this, ENCRYPTED ? DB_ENCRYPTED_NAME : DB_NAME);
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb(DB_ENCRYPTED_PASSWORD) : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
