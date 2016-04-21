package com.mvvm.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * 
 * @ClassName ActivityIntentUtils
 * @Description 页面跳转公共类
 * @author 汪乐骏
 */
public class IntentUtils {
	private Context context;
	public IntentUtils(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	private Intent getIntent(Context context , Class<?> dest){
		Intent intent = new Intent(context,dest);
		if(!(context instanceof Activity)){
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		}
		return intent;
	}

	/**
	 * 
	 * @Method: turnToNextActivity
	 * @Description: 跳转到指定页面，不传参，销毁当前
	 * @param @param dest
	 * @return void
	 * @throws
	 */
	public void turnToNextActivity(Class<?> dest) {
		Intent intent = getIntent(context, dest);
		context.startActivity(intent);
		((Activity)context).finish();
	}

	/**
	 * 
	 * @Method: turnToActivity
	 * @Description: 跳转到指定页面，不传参，不销毁当前
	 * @param @param dest
	 * @return void
	 * @throws
	 */
	public  void turnToActivity(Class<?> dest) {
		Intent intent = getIntent(context, dest);
		context.startActivity(intent);
	}

	/**
	 * 
	 * @Method: turnToActivity
	 * @Description: 跳转到指定页面，传参，不销毁当前
	 * @param @param dest
	 * @param @param bundle
	 * @return void
	 * @throws
	 */
	public  void turnToActivity(Class<?> dest, Bundle bundle) {
		try {
			Intent intent = getIntent(context, dest);
			intent.putExtras(bundle);
			context.startActivity(intent);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	/**
	 * 
	 * @Method: turnToActivity
	 * @Description: 跳转到指定页面，传参，不销毁当前 带上请求request code
	 * @param @param dest
	 * @param @param bundle
	 * @return void
	 * @throws
	 */
	public  void turnToActivityForReuslt(Activity activity,Class<?> dest,Bundle bundle,int requestCode) {
		try {
			Intent intent = getIntent(context, dest);
			intent.putExtras(bundle);
			activity.startActivityForResult(intent,requestCode);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * 
	 * @Method: turnToNextActivity
	 * @Description: 跳转到指定页面，传参，销毁当前
	 * @param @param dest
	 * @param @param bundle
	 * @return void
	 * @throws
	 */
	public void turnToNextActivity(Class<?> dest, Bundle bundle) {
		try {
			Intent intent = getIntent(context, dest);
			intent.putExtras(bundle);
			context.startActivity(intent);
			((Activity)context).finish();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
