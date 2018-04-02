package me.blog.eyeballss.android_api.Utils;

import android.view.GestureDetector;
import android.view.MotionEvent;

import me.blog.eyeballss.android_api.Interfaces.GestureListenerInterface;


/**
 * Created by david on 18. 3. 29.
 */

public class MyGestureDetector implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

    private GestureListenerInterface mGestureListenerInterface;

    public MyGestureDetector(GestureListenerInterface mGestureListenerInterface) {
        this.mGestureListenerInterface = mGestureListenerInterface;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        mGestureListenerInterface.onSingleTapConfirmed(e);
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        mGestureListenerInterface.onDoubleTap(e);
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        mGestureListenerInterface.onDoubleTapEvent(e);
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        mGestureListenerInterface.onDown(e);
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        mGestureListenerInterface.onShowPress(e);
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        mGestureListenerInterface.onSingleTapUp(e);
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        mGestureListenerInterface.onScroll(e1,e2,distanceX,distanceY);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        mGestureListenerInterface.onLongPress(e);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        mGestureListenerInterface.onFling(e1,e2,velocityX,velocityY);
        return false;
    }


}
