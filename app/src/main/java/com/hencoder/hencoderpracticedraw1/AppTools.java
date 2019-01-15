package com.hencoder.hencoderpracticedraw1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.WindowManager;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by zx on 2016/5/10.
 */
public class AppTools {
    private static final String TAG = AppTools.class.getSimpleName();
    public static String INTERFACE_VERSION_NEW = "2.0";
    public static String INTERFACE_VERSION_OLD = "1.0";
    public static String getAppVersion(Context ctx) {
        String appVersion;
        // 获取APP版本信息
        PackageManager packageManager = ctx.getPackageManager();
        PackageInfo packInfo;
        try {
            packInfo = packageManager.getPackageInfo(ctx.getPackageName(), 0);
            appVersion = packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            appVersion = "2.0";
        }

        return appVersion;
    }

    public static String getVersion(){
        return  AppTools.INTERFACE_VERSION_OLD;
    }
    public static String getNewVersion(){
        return  AppTools.INTERFACE_VERSION_NEW;
    }

    public static int getVersionCode(Context ctx) {
        int versionCode = -1;
        PackageManager packageManager = ctx.getPackageManager();
        PackageInfo packInfo;
        try {
            packInfo = packageManager.getPackageInfo(ctx.getPackageName(), 0);
            versionCode = packInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, e.getMessage());
        }
        return versionCode;
    }

    public static String getInterfaceAppVersion() {
        String appVersion = "2.0";

        return appVersion;
    }

    public static String getClient(Context ctx) {
        String client = "supercode," + getAppVersion(ctx) + ",android";
        return client;
    }
    public static int dp2px(Context context,int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    /*
* check the app is installed
*/
    public static boolean isAviliblePackage( Context context, String packageName )
    {
        final PackageManager packageManager = context.getPackageManager();
        // 获取所有已安装程序的包信息
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        for ( int i = 0; i < pinfo.size(); i++ )
        {
            if(pinfo.get(i).packageName.equalsIgnoreCase(packageName))
                return true;
        }
        return false;
    }

    public static void install(File apkFile, Context context){
        String[] command1 = {"chmod", "777", apkFile.getParentFile().getAbsolutePath()};
        String[] command2 = {"chmod", "777", apkFile.getAbsolutePath()};
        try {
            ProcessBuilder builder = new ProcessBuilder(command1);
            builder.start();
            builder = new ProcessBuilder(command2);
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        //判断是否是AndroidN以及更高的版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".fileProvider", apkFile);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    public static boolean isApkDebugable(Context ctx) {
        try {
            PackageInfo pkginfo;
            pkginfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
            if (pkginfo != null) {
                ApplicationInfo info = pkginfo.applicationInfo;
                return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
            }
        } catch (Exception e) {
            ;
        }
        return false;
    }


    public static boolean isTestApk(Context ctx) {
        if (isApkDebugable(ctx)) {
            return true;
        }
        if (!TextUtils.isEmpty(getAppVersion(ctx)) && getAppVersion(ctx).toLowerCase().contains("beta")) {
            return true;
        }
        return false;
    }

    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }
}
