package me.blog.eyeballss.android_api.Interfaces;

import android.view.MotionEvent;

/**
 * Created by david on 18. 3. 29.
 */

public interface GestureListenerInterface {

    boolean onSingleTapConfirmed(MotionEvent e);

    boolean onDoubleTap(MotionEvent e);

    boolean onDoubleTapEvent(MotionEvent e);

    boolean onDown(MotionEvent e);

    void onShowPress(MotionEvent e);

    boolean onSingleTapUp(MotionEvent e);

    boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);

    void onLongPress(MotionEvent e);

    boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) ;
}
