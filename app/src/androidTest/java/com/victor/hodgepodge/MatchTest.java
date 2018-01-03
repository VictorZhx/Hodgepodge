package com.victor.hodgepodge;

import android.test.AndroidTestCase;

import com.victor.hodgepodge.match.MatchFood;


/**
 * Created by victor on 17-8-19.
 */

public class MatchTest extends AndroidTestCase {

    public void testMatch() {
        MatchFood matchFood = new MatchFood();
        matchFood.init();
        matchFood.matchFoodByMaterial();
    }
}
