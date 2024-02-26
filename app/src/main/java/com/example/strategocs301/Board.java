

//A class that represents a board
package com.example.strategocs301;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo;
import android.util.AttributeSet;
import android.view.SurfaceView;

import androidx.core.content.res.ResourcesCompat;

import org.w3c.dom.Attr;

import java.lang.reflect.Array;
import java.util.Random;

public class Board extends SurfaceView {

    //instance Variables
    private final int WIDTH_CELLS = 10;
    private final int HEIGHT_CELLS = 8;
    private float dpHeight;
    private float dpWidth;
    private int[][] boardInfo;
    private Context boardContext;



    private void init() {
        //let it draw
        this.setWillNotDraw(false);

        //Set background
        Drawable board = ResourcesCompat.getDrawable(boardContext.getResources(), R.drawable.board, null);
        this.setBackground(board);

        Random gen = new Random();

        //fill boardInfo
       boardInfo = new int[WIDTH_CELLS][HEIGHT_CELLS];
        boardInfo[0][0] = 1;


        for (int col = 0; col < WIDTH_CELLS; col++) {
            for (int row = 0; row < HEIGHT_CELLS; row++) {
                boardInfo[col][row] = 1;
            }
        }
    }

    public Board(Context context, AttributeSet attrs) {
        super(context, attrs);
        boardContext = context;
        init();
    }

    public Board(Context context) {
        super(context);
        boardContext = context;
        init();
    }

    public Board(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        boardContext = context;
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        dpHeight = canvas.getHeight();
        dpWidth = canvas.getWidth();

        for (int col = 0; col < WIDTH_CELLS; col++) {
            for (int row = 0; row < HEIGHT_CELLS; row++) {
                drawBoardInfo(boardInfo[col][row], canvas, col, row);
            }
        }
        this.invalidate();
    }

    private void drawBoardInfo(int pieceVal, Canvas canvas, int col, int row) {
       switch (pieceVal) {
          case 1:
              Bitmap piece1 = BitmapFactory.decodeResource(getResources(),R.drawable.piece_1_red);
              piece1 = Bitmap.createScaledBitmap(piece1,75,110,false);
              //canvas.drawBitmap(piece1, (float)((dpWidth / (float)WIDTH_CELLS) * (float)col + 20),
              //        (float)((dpHeight / (float)HEIGHT_CELLS) * (float)row),null);
              canvas.drawBitmap(piece1, (dpWidth/WIDTH_CELLS) * col + 20, (dpHeight/HEIGHT_CELLS) * row + 5, null);
              break;
        }
    }


}
