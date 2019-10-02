package com.example.diceout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import java.io.IOException;
import java.io.InputStream;

public class DieView extends android.support.v7.widget.AppCompatImageView {


    int group;
    int num;
    private Context context;

    public DieView(Context context) {
        super(context);
        init(context);
    }

    public DieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setImageResource(R.drawable.red_joker);
        this.context = context;
    }

    public void roll() {
        group = (int) (Math.random() *4);
        num = (int) (Math.random() *13);


        try {

                    InputStream stream = context.getAssets().open("die_" + num + ".png");
                    Drawable d = Drawable.createFromStream(stream, null);
                    setImageDrawable(d);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getValue() {
        return num;
    }
}
