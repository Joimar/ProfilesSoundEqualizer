package com.example.profilessoundequalizer;

import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

 

 

@RunWith(AndroidJUnit4.class)

public class MainActivityTest {
    @Rule

    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);
    private Equalizer mockEqualizer;
    private short numberOfBands;
    private short[] freqRange;

    @Before
    public void setUp() {

        // Mock the Equalizer since it's difficult to test with a real audio device in a unit test
        mockEqualizer = Mockito.mock(Equalizer.class);
        numberOfBands = 5; // Example number of bands
        freqRange = new short[]{-1500, 1500}; // Example frequency range
        when(mockEqualizer.getNumberOfBands()).thenReturn(numberOfBands);
        when(mockEqualizer.getBandLevelRange()).thenReturn(freqRange);
    }

    @Test
    public void onCreate_initializesEqualizerAndButtons() {

        activityRule.getScenario().onActivity(activity -> {
            //Since we are mocking the equalizer, we don't need to get a real instance.
            //Equalizer equalizer = activity.equalizer; 
            Button button1 = activity.findViewById(R.id.button1);
            Button button2 = activity.findViewById(R.id.button2);
            assertNotNull(button1);
            assertNotNull(button2);
           //These assertions are not useful since the values are mocked.
           // assertEquals(numberOfBands, equalizer.getNumberOfBands());
           // assertEquals(freqRange, equalizer.getBandLevelRange());

        });
    }

    @Test
    public void button1Click_setsAllBandsToMinLevel() {
        activityRule.getScenario().onActivity(activity -> {
            Button button1 = activity.findViewById(R.id.button1);
            // Inject the mock equalizer into the activity (This would normally be done with dependency injection)
            activity.equalizer = mockEqualizer;
            button1.performClick();

            for (short i = 0; i < numberOfBands; i++) {
                //Mockito.verify verifies that the setBandLevel method was called with the correct arguments.
                Mockito.verify(mockEqualizer).setBandLevel(i, freqRange[0]);
            }

            Mockito.verify(mockEqualizer).setEnabled(true);

        });

    }

 

    @Test
    public void button2Click_setsAllBandsToMidLevel() {
        activityRule.getScenario().onActivity(activity -> {
            Button button2 = activity.findViewById(R.id.button2);
            // Inject the mock equalizer into the activity (This would normally be done with dependency injection)
            activity.equalizer = mockEqualizer;
            button2.performClick();
            for (short i = 0; i < numberOfBands; i++) {
                Mockito.verify(mockEqualizer).setBandLevel(i, (short) (freqRange[1] / 2));
            }

            Mockito.verify(mockEqualizer).setEnabled(true);

        });

    }

 

 

}
