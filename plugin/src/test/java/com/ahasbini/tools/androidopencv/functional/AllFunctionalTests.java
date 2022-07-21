package fr.akylas.androidopencv.functional;

import fr.akylas.androidopencv.functional.android.AllAndroidTests;
import fr.akylas.androidopencv.functional.gradle.AllGradleTests;
import fr.akylas.androidopencv.functional.plugin.AllPluginTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by ahasbini on 05-Oct-19.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AllGradleTests.class,
        AllAndroidTests.class,
        AllPluginTests.class
})
public class AllFunctionalTests  {

}
