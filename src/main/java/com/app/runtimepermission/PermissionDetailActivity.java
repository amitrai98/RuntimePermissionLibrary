package com.app.runtimepermission;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


/**
 * Created by amitrai on 11/5/17.
 * this class is used for :-
 */

public class PermissionDetailActivity extends AppCompatActivity {

    int PERMISSION_CAMERA = 101;
    int READ_CONTACTS = 102;
    int PERMISSION_WRITE_CONTACTS = 103;
    int PERMISSION_GET_ACCOUNTS = 104;
    int PERMISSION_ACCESS_FINE_LOCATION = 105;
    int PERMISSION_ACCESS_COARSE_LOCATION = 106;
    int PERMISSION_RECORD_AUDIO = 107;
    int PERMISSION_READ_PHONE_STATE = 108;
    int PERMISSION_CALL_PHONE = 109;
    int PERMISSION_READ_CALL_LOG = 110;
    int PERMISSION_WRITE_CALL_LOG = 111;
    int PERMISSION_ADD_VOICEMAIL = 112;
    int PERMISSION_USE_SIP = 113;
    int PERMISSION_PROCESS_OUTGOING_CALLS = 114;
    int PERMISSION_BODY_SENSORS = 115;
    int PERMISSION_SEND_SMS = 116;
    int PERMISSION_RECEIVE_SMS = 117;
    int PERMISSION_READ_SMS = 118;
    int PERMISSION_RECEIVE_WAP_PUSH = 119;
    int PERMISSION_RECEIVE_MMS = 120;
    int PERMISSION_READ_EXTERNAL_STORAGE = 121;
    int PERMISSION_WRITE_EXTERNAL_STORAGE= 122;

    Context context = null;
    public static PermissionListener listener;
    String permission_request = null;
    private final String TAG = getClass().getSimpleName();

    public static final String PARM_PERMISSION_REQUESTED = "requested_permission";

    private String PERMISSION_REJECTED = "permission has been Rejected by User";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_permission_handler);
        Log.e(TAG, "reached");
        context =this;
        if (getIntent().hasExtra(PARM_PERMISSION_REQUESTED)){
            permission_request = getIntent().getExtras().getString(PARM_PERMISSION_REQUESTED);
            requestPermission(permission_request);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * requests permission for the app
     * @param permission
     */
    private void requestPermission(String permission){
        if (ContextCompat.checkSelfPermission(this,
                permission)
                != PackageManager.PERMISSION_GRANTED) {

                String[] permission_array = context.getResources().getStringArray(R.array.dangerous_permissions);
                for (int i =0 ; i<permission_array.length; i++){
                    if (permission_array[i].equalsIgnoreCase(permission)){
                        ActivityCompat.requestPermissions(this,
                                new String[]{permission},
                                PERMISSION_CAMERA);
                    }
                }
        }else
            finish();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 101: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    listener.onGranted(permission_request);

                } else {
                    listener.onRejected(PERMISSION_REJECTED);
                }
            }
        }
        PermissionDetailActivity.this.finish();
    }
}
