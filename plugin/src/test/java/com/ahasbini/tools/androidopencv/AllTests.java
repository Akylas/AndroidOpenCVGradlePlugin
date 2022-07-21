package fr.akylas.androidopencv;

import fr.akylas.androidopencv.functional.AllFunctionalTests;
import fr.akylas.androidopencv.integration.AllIntegrationTests;
import fr.akylas.androidopencv.unit.AllUnitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by ahasbini on 03-Nov-19.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AllUnitTests.class,
        AllIntegrationTests.class,
        AllFunctionalTests.class
})
public class AllTests {

}
