# RuntimePermissionLibrary


RuntimePermission is a simple library that can be used to handle all your permission requests from user. See the example to see more detail.

<p align="center">
  <img src="https://github.com/amitrai98/MVVM/blob/master/runtime.gif" width="350"/>
</p>


## How to use

### Integration

Integrating the project is simple a refined all you need to do is follow the below steps

`

Step 1\. Add the dependency

```java
dependencies {
        compile 'com.app.runtimepermission:runtimepermission:0.0.2'
}
```

### Usage

Once the project has been added to gradle, the library can be easily used

```java
// to get single permission 
PermissionHandler.getPermission(getActivity(), Manifest.permission.READ_CONTACTS, new PermissionListener() {
            @Override
            public void onGranted(String message) {
                Log.e(TAG, message);               
            }

            @Override
            public void onError(String errorMessage) {
                Log.e(TAG, errorMessage);
            }

            @Override
            public void onRejected(String message) {
                Log.e(TAG, message);
            }
        });

// to check if permission is critical or not

         boolean value  = PermissionHandler.isCriticalPermission(getContext(),
                Manifest.permission.INTERNET);

        Log.e(TAG , Manifest.permission.INTERNET+" "+value);

// to get all permissions

        PermissionHandler.getAllPermissions(getActivity(), new PermissionListener() {
            @Override
            public void onGranted(String message) {
                Log.e(TAG, message);
            }

            @Override
            public void onError(String errorMessage) {
                Log.e(TAG, errorMessage);
            }

            @Override
            public void onRejected(String message) {
                Log.e(TAG, message);
            }
        });


```

That's it, all done.
