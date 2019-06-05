package com.app.runtimepermission;

/**
 * Created by amitrai on 11/5/17.
 * this class is used for :-
 */

public interface PermissionListener {
    void onGranted(String message);
    void onError(String errorMessage);
    void onRejected(String message);
}
