/**
 * Copyright 2005-2018 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl2.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.sampleu.krad.reference;

import org.junit.Test;
import org.kuali.rice.testtools.selenium.AutomatedFunctionalTestUtils;
import org.kuali.rice.testtools.selenium.WebDriverLegacyITBase;
import org.kuali.rice.testtools.selenium.WebDriverUtils;

/**
 * Tests the Component section in Rice.
 *
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
public class AffiliationTypeAft extends WebDriverLegacyITBase {

    /**
     *  AutomatedFunctionalTestUtils.PORTAL + "?channelTitle=Affiliation%20Type&channelUrl="
     *   + WebDriverUtils.getBaseUrlString() + AutomatedFunctionalTestUtils.KRAD_LOOKUP_METHOD +
     *   "org.kuali.rice.kim.impl.identity.affiliation.EntityAffiliationTypeBo&returnLocation="
     *   + AutomatedFunctionalTestUtils.PORTAL_URL + AutomatedFunctionalTestUtils.HIDE_RETURN_LINK;
     */
    public static final String BOOKMARK_URL = AutomatedFunctionalTestUtils.PORTAL + "?channelTitle=Affiliation%20Type&channelUrl="
            + WebDriverUtils.getBaseUrlString() + AutomatedFunctionalTestUtils.KRAD_LOOKUP_METHOD +
            "org.kuali.rice.kim.impl.identity.affiliation.EntityAffiliationTypeBo&returnLocation="
            + AutomatedFunctionalTestUtils.PORTAL_URL + AutomatedFunctionalTestUtils.HIDE_RETURN_LINK;
  
    @Override
    protected String getBookmarkUrl() {
        return BOOKMARK_URL;
    }

    @Override
    protected void navigate() throws InterruptedException {
        waitAndClickKRAD();
        waitAndClickByLinkText("Affiliation Type");
    }

    //Code for KRAD Test Package.
    protected void testAffiliationType() throws Exception {
        selectFrameIframePortlet();

        //Search by "Both" Filter in Active Indicator
        clickSearch();
        String[][] data = {{"AFLT", "Affiliate", "d"},
                {"FCLTY", "Faculty", "b"},
                {"STAFF", "Staff", "c"}};
        assertTextPresent(data);
        waitAndClickClearValues();

        //Search by "Yes" Filter in Active Indicator
        waitAndClickByXpath("//input[@name='lookupCriteria[active]' and @value='Y']");
        clickSearch();
        assertTextPresent(data);
        waitAndClickClearValues();

        //Search by "No" Filter in Active Indicator
        waitAndClickByXpath("//input[@name='lookupCriteria[active]' and @value='N']");
        clickSearch();
        waitForTextPresent("No values match this search.");
        waitAndClickClearValues();

        //Search by Code Filter
        waitAndTypeByName("lookupCriteria[code]","AFLT");
        clickSearch();
        String[] assertSearchResultForTypeCode = {"AFLT", "Affiliate", "d"};
        assertTextPresent(assertSearchResultForTypeCode);
        waitAndClickClearValues();

        //Search by Name Filter
        waitAndTypeByName("lookupCriteria[name]","Affiliate");
        clickSearch();
        String[] assertSearchResultForTypeName = {"AFLT", "Affiliate", "d"};
        assertTextPresent(assertSearchResultForTypeName);
        waitAndClickClearValues();
    }

    protected void clickSearch() throws InterruptedException {
        waitAndClickSearchByText();
    }

    @Test
    public void testAffiliationTypeBookmark() throws Exception {
        testAffiliationType();
        passed();
    }

    @Test
    public void testAffiliationTypeNav() throws Exception {
        testAffiliationType();
        passed();
    }
}
