package os.ransj.eleven;

import android.app.SearchManager;
import android.graphics.Canvas;
import android.os.Handler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ransj on 1/3/16.
 */
public class Compat {

    public static String ICU_getIcuVersion(){
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            Method method = cls.getDeclaredMethod("getIcuVersion");
            return (String) method.invoke(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "50.1.1";
    }

    public static void Canvas_release(Canvas canvas){
        try {
            Method method = Canvas.class.getDeclaredMethod("release");
            method.invoke(canvas);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static String SearchManager_SEARCH_MODE() {
        try {
            Field field = SearchManager.class.getDeclaredField("SEARCH_MODE");
            return (String) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "search_mode";
    }

    public static boolean Handler_hasCallbacks(Handler handler, Runnable task){
        try {
            Method method = Handler.class.getDeclaredMethod("hasCallbacks", Runnable.class);
            return (boolean) method.invoke(handler, task);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

}
