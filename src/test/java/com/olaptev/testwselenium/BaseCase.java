package com.olaptev.testwselenium;

import com.olaptev.testwselenium.utils.TSearch;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.assertj.core.api.Assertions;

public class BaseCase extends TSearch{
    @Test
    /**
     * Main scenario block
     */
    public void TScenario() throws InterruptedException {
        /** Assertion examples using TestNG asserts
         *
         */
//        assertTrue(!driver.getTitle().isEmpty(),"Title is empty");
//        assertEquals(driver.getTitle(),"YouTube","Wrong title is displayed");
        /**
         * Assertion examples using assertJ
         */
        Assertions.assertThat(!driver.getTitle().isEmpty()).as("Title is empty").isTrue();
        Assertions.assertThat(driver.getTitle()).as("Wrong title").isEqualToIgnoringCase("Youtube");

        WebElement elementField = driver.findElement(By.cssSelector("#content div.eom-button-row yt-button-shape button div div.yt-spec-touch-feedback-shape__fill"));
        clickOnElement(elementField);

        WebElement searchField = driver.findElement(By.name("search_query"));
        clickOnElement(searchField);
        searchField.sendKeys("selenium java");
        searchField.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement videoPad = driver.findElement(By.cssSelector("div#dismissible div#details div#meta #video-title-link:first-of-type"));
        System.out.println(videoPad.getAttribute("aria-label"));
    }

}
