package com.jon_dhc.teletype;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;

/**
 * Created by jon_dhc on 7/19/17.
 */

public class TypeWriter extends android.support.v7.widget.AppCompatTextView{

    private CharSequence mText; //Text to display
    private int mIndex;         //Number of letter to display
    private long mDelay = 150; //in ms, delay between each letter displaying


    public TypeWriter(Context context) {
        super(context);
    }

    public TypeWriter(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    private Handler mHandler = new Handler();

    private Runnable characterAdder = new Runnable(){

        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));

            if(mIndex<=mText.length()){
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };

    public void animateText(CharSequence txt){
        mText=txt;
        mIndex=0;

        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void setCharacterDelay(long m){
        mDelay = m;
    }

}
