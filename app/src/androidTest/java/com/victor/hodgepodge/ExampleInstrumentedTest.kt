package com.victor.hodgepodge

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.victor.hodgepodge.match.MatchFood
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getTargetContext()
//        assertEquals("com.victor.hodgepodge", appContext.packageName)

        val matchFood = MatchFood()
        matchFood.init()
        matchFood.matchFoodByMaterial()

    }
}
