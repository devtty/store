package org.devtty.store.test.functional;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.archive.importer.MavenImporter;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Denis Renning <denis@devtty.de>
 */
public class FunctionalTest {
    
    @Drone
    protected WebDriver browser;
    
    @ArquillianResource
    protected URL deploymentUrl;
 
    @Deployment(testable = false)
    public static WebArchive createDeployment(){
        return ShrinkWrap.create(MavenImporter.class).loadPomFromFile("pom.xml").importBuildOutput().as(WebArchive.class);
    }
    
    @Before
    public void setup(){
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }
}
