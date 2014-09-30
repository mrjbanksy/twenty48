package com.jbapps.twenty48;

import java.util.ArrayList;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.GridLayout;
import android.widget.TextView;

// -------------------------------------------------------------------------
/**
 * The main screen
 *
 * @author Jeremy Banks
 * @version March 31, 2014
 */
public class MainActivity
    extends Activity
    implements GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener
{
    private TextView              textView1;
    private TextView              textView2;
    private TextView              textView3;
    private TextView              textView4;
    private TextView              textView5;
    private TextView              textView6;
    private TextView              textView7;
    private TextView              textView8;
    private TextView              textView9;
    private TextView              textView10;
    private TextView              textView11;
    private TextView              textView12;
    private TextView              textView13;
    private TextView              textView14;
    private TextView              textView15;
    private TextView              textView16;
    private TextView              scoreView;
    private TextView              highScoreView;
    private Model                 model;
    private Tile[][]              database;
    private static final int      SWIPE_MIN_DISTANCE       = 50;
    private static final int      SWIPE_THRESHOLD_VELOCITY = 100;
    private GestureDetectorCompat mDetector;
    private ArrayList<TextView>   textViews;
    private boolean               won;
    private int                   highScore;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        won = false;
        setTitle("2048");
        setContentView(R.layout.activity_main);
        SharedPreferences data =
            getSharedPreferences("com.jbapps.twenty48", MODE_PRIVATE);
        highScore = data.getInt("highScore", 0);
        model = new Model();
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView5 = (TextView)findViewById(R.id.textView5);
        textView6 = (TextView)findViewById(R.id.textView6);
        textView7 = (TextView)findViewById(R.id.textView7);
        textView8 = (TextView)findViewById(R.id.textView8);
        textView9 = (TextView)findViewById(R.id.textView9);
        textView10 = (TextView)findViewById(R.id.textView10);
        textView11 = (TextView)findViewById(R.id.textView11);
        textView12 = (TextView)findViewById(R.id.textView12);
        textView13 = (TextView)findViewById(R.id.textView13);
        textView14 = (TextView)findViewById(R.id.textView14);
        textView15 = (TextView)findViewById(R.id.textView15);
        textView16 = (TextView)findViewById(R.id.textView16);
        scoreView = (TextView)findViewById(R.id.textView17);
        highScoreView = (TextView)findViewById(R.id.textView18);
        textViews = new ArrayList<TextView>();
        textViews.add(textView1);
        textViews.add(textView2);
        textViews.add(textView3);
        textViews.add(textView4);
        textViews.add(textView5);
        textViews.add(textView6);
        textViews.add(textView7);
        textViews.add(textView8);
        textViews.add(textView9);
        textViews.add(textView10);
        textViews.add(textView11);
        textViews.add(textView12);
        textViews.add(textView13);
        textViews.add(textView14);
        textViews.add(textView15);
        textViews.add(textView16);
        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout1);
        gridLayout.addOnLayoutChangeListener(new OnLayoutChangeListener() {
			@Override
			public void onLayoutChange(View view, int arg1, int arg2, int arg3,
					int arg4, int arg5, int arg6, int arg7, int arg8) {
				int sideLength;
				if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
					sideLength = view.getWidth() / 4;
				} else {
					sideLength = view.getHeight() / 4;
				}
				for (TextView text : textViews)
		        {
		            text.setWidth(sideLength);
		            text.setHeight(sideLength);
		            text.setGravity(Gravity.CENTER);
		        }
			}
		});
        update();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    public boolean onDown(MotionEvent e)
    {
        return true;
    }


    public void update()
    {
        database = model.getDatabase();
        if (database[0][0].getCurrentValue() == 0)
        {
            textView1.setText("");
        }
        else
        {
            textView1
                .setText(Integer.toString(database[0][0].getCurrentValue()));
        }
        if (database[0][1].getCurrentValue() == 0)
        {
            textView2.setText("");
        }
        else
        {
            textView2
                .setText(Integer.toString(database[0][1].getCurrentValue()));
        }
        if (database[0][2].getCurrentValue() == 0)
        {
            textView3.setText("");
        }
        else
        {
            textView3
                .setText(Integer.toString(database[0][2].getCurrentValue()));
        }
        if (database[0][3].getCurrentValue() == 0)
        {
            textView4.setText("");
        }
        else
        {
            textView4
                .setText(Integer.toString(database[0][3].getCurrentValue()));
        }
        if (database[1][0].getCurrentValue() == 0)
        {
            textView5.setText("");
        }
        else
        {
            textView5
                .setText(Integer.toString(database[1][0].getCurrentValue()));
        }
        if (database[1][1].getCurrentValue() == 0)
        {
            textView6.setText("");
        }
        else
        {
            textView6
                .setText(Integer.toString(database[1][1].getCurrentValue()));
        }
        if (database[1][2].getCurrentValue() == 0)
        {
            textView7.setText("");
        }
        else
        {
            textView7
                .setText(Integer.toString(database[1][2].getCurrentValue()));
        }
        if (database[1][3].getCurrentValue() == 0)
        {
            textView8.setText("");
        }
        else
        {
            textView8
                .setText(Integer.toString(database[1][3].getCurrentValue()));
        }
        if (database[2][0].getCurrentValue() == 0)
        {
            textView9.setText("");
        }
        else
        {
            textView9
                .setText(Integer.toString(database[2][0].getCurrentValue()));
        }
        if (database[2][1].getCurrentValue() == 0)
        {
            textView10.setText("");
        }
        else
        {
            textView10.setText(Integer.toString(database[2][1]
                .getCurrentValue()));
        }
        if (database[2][2].getCurrentValue() == 0)
        {
            textView11.setText("");
        }
        else
        {
            textView11.setText(Integer.toString(database[2][2]
                .getCurrentValue()));
        }
        if (database[2][3].getCurrentValue() == 0)
        {
            textView12.setText("");
        }
        else
        {
            textView12.setText(Integer.toString(database[2][3]
                .getCurrentValue()));
        }
        if (database[3][0].getCurrentValue() == 0)
        {
            textView13.setText("");
        }
        else
        {
            textView13.setText(Integer.toString(database[3][0]
                .getCurrentValue()));
        }
        if (database[3][1].getCurrentValue() == 0)
        {
            textView14.setText("");
        }
        else
        {
            textView14.setText(Integer.toString(database[3][1]
                .getCurrentValue()));
        }
        if (database[3][2].getCurrentValue() == 0)
        {
            textView15.setText("");
        }
        else
        {
            textView15.setText(Integer.toString(database[3][2]
                .getCurrentValue()));
        }
        if (database[3][3].getCurrentValue() == 0)
        {
            textView16.setText("");
        }
        else
        {
            textView16.setText(Integer.toString(database[3][3]
                .getCurrentValue()));
        }

        for (TextView t : textViews)
        {

            if (t.getText().toString().equals(""))
            {
                t.setBackgroundResource(R.drawable.zero);
            }
            else if (t.getText().toString().equals("2"))
            {
                t.setBackgroundResource(R.drawable.two);
            }
            else if (t.getText().toString().equals("4"))
            {
                t.setBackgroundResource(R.drawable.four);
            }
            else if (t.getText().toString().equals("8"))
            {
                t.setBackgroundResource(R.drawable.eight);
            }
            else if (t.getText().toString().equals("16"))
            {
                t.setBackgroundResource(R.drawable.sixteen);
            }
            else if (t.getText().toString().equals("32"))
            {
                t.setBackgroundResource(R.drawable.thirtytwo);
            }
            else if (t.getText().toString().equals("64"))
            {
                t.setBackgroundResource(R.drawable.sixtyfour);
            }
            else if (t.getText().toString().equals("128"))
            {
                t.setBackgroundResource(R.drawable.onetwentyeight);
            }
            else if (t.getText().toString().equals("256"))
            {
                t.setBackgroundResource(R.drawable.twofiftysix);
            }
            else if (t.getText().toString().equals("512"))
            {
                t.setBackgroundResource(R.drawable.fivetwelve);
            }
            else if (t.getText().toString().equals("1024"))
            {
                t.setBackgroundResource(R.drawable.tentwentyfour);
            }
            else
            {
                if (!won)
                {
                    winGame();
                    won = true;
                }
                t.setBackgroundResource(R.drawable.twentyfourtyeight);
            }
        }

        scoreView.setText("Score: " + Integer.toString(model.getScore()));
        if (model.getScore() > highScore)
        {
            highScore = model.getScore();
            SharedPreferences data =
                getSharedPreferences("com.jbapps.twenty48", MODE_PRIVATE);
            SharedPreferences.Editor editor = data.edit();
            editor.putInt("highScore", highScore);
            editor.commit();
        }
        highScoreView.setText("High Score: " + highScore);
    }


    public boolean onFling(
        MotionEvent e1,
        MotionEvent e2,
        float velocityX,
        float velocityY)
    {
        if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
        {
            boolean result = model.leftSwipe();
            if (result)
            {
                update();
            }
            if (model.getTotalCount() == 16)
            {
                if (model.checkForGameOver())
                {
                    gameOver();
                }
            }
            return true;
        }
        else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
        {
            boolean result = model.rightSwipe();
            if (result)
            {
                update();
            }
            if (model.getTotalCount() == 16)
            {
                if (model.checkForGameOver())
                {
                    gameOver();
                }
            }
            return true;
        }

        if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE
            && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)
        {
            boolean result = model.upSwipe();
            if (result)
            {
                update();
            }
            if (model.getTotalCount() == 16)
            {
                if (model.checkForGameOver())
                {
                    gameOver();
                }
            }
            return true;
        }
        else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE
            && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY)
        {
            boolean result = model.downSwipe();
            if (result)
            {
                update();
            }
            if (model.getTotalCount() == 16)
            {
                if (model.checkForGameOver())
                {
                    gameOver();
                }
            }
            return true;
        }
        return false;
    }


    public void onLongPress(MotionEvent e)
    {
        // Intentionally blank
    }


    public boolean onScroll(
        MotionEvent e1,
        MotionEvent e2,
        float distanceX,
        float distanceY)
    {
        return false;
    }


    public void onShowPress(MotionEvent e)
    {
        // Intentionally blank
    }


    public boolean onSingleTapUp(MotionEvent e)
    {
        return false;
    }


    public boolean onDoubleTap(MotionEvent e)
    {
        return false;
    }


    public boolean onDoubleTapEvent(MotionEvent e)
    {
        return false;
    }


    public boolean onSingleTapConfirmed(MotionEvent e)
    {
        return false;
    }


    public void newGame()
    {
        model = new Model();
        update();
    }


    private void winGame()
    {
        WinDialog win = new WinDialog(this);
        win.onCreateDialog();
    }


    private void gameOver()
    {
        LossDialog loss = new LossDialog(this);
        loss.onCreateDialog();
    }

}
