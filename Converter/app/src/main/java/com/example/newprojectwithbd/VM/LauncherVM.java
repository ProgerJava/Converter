package com.example.newprojectwithbd.VM;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newprojectwithbd.model.LauncherModel;
import com.example.newprojectwithbd.model.PojoClass;
import com.example.newprojectwithbd.view.LauncherActivity;

import java.util.ArrayList;
import java.util.List;

public class LauncherVM extends AndroidViewModel {
    public MutableLiveData<List<String>> list = new MutableLiveData <>();
    LauncherModel launcherModel = new LauncherModel();
    Controller controller = new Controller();
    Thread thread = new Thread(controller);
    private String request = null;
    private String currency = null;

    public LauncherVM(@NonNull Application application) {
        super(application);
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }


    public void onStart () {
        if (thread.isAlive()) {
            Toast.makeText(getApplication(), "Идет выполнение запроса,\nесли вы ожидаете более 5 секунд,\nперезагрузите приложение и проверьте соединение с интернетом", Toast.LENGTH_LONG).show();
        }else {
            thread.start();
        }
    }
    public class Controller implements Runnable {
        @Override
        public void run() {
            launcherModel.onStart(getCurrency(), getRequest());
            while (launcherModel.getChangesList().size() == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            update();
        }
    }
    public void update () {
        list.postValue(launcherModel.getChangesList());
        if (!thread.isInterrupted()) {
            thread.interrupt();
        }
        System.out.println("--------" + launcherModel.getChangesList().toString() + "------");
    }
}
