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
package org.kuali.rice.krad.demo.uif.library.validation;

import org.junit.Test;

import org.kuali.rice.testtools.selenium.WebDriverLegacyITBase;

/**
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
public class LibraryValidationFixedPointConstraintsAft extends WebDriverLegacyITBase {

    /**
     * /kr-krad/kradsampleapp?viewId=Demo-FixedPointPatternConstraintView&methodToCall=start
     */
    public static final String BOOKMARK_URL = "/kr-krad/kradsampleapp?viewId=Demo-FixedPointPatternConstraintView&methodToCall=start";
    
    @Override
    protected String getBookmarkUrl() {
        return BOOKMARK_URL;
    }

    @Override
    protected void navigate() throws Exception {
        waitAndClickLibraryLink();
        waitAndClickByLinkText("Validation");
        waitAndClickByLinkText("Fixed Point Constraint");
    }

    protected void testValidationFixedPointConstraints() throws Exception {
        waitAndClickByLinkText("Basic Example");

        //Scenario-1
        assertFocusTypeBlurError("inputField1","1234.12");
    }
    
    protected void testValidationFixedPointConstraintsAdditional() throws Exception {
        waitAndClickByLinkText("Additional Examples");
        
        //Scenario-1
        assertFocusTypeBlurError("inputField2","12.3");
        assertFocusTypeBlurError("inputField3","2334.89");
    }
    
    @Test
    public void testValidationFixedPointConstraintsNav() throws Exception {
        testValidationFixedPointConstraints();
        testValidationFixedPointConstraintsAdditional();
        passed();
    }
    
    @Test
    public void testValidationFixedPointConstraintsBookmark() throws Exception {
        testValidationFixedPointConstraints();
        testValidationFixedPointConstraintsAdditional();
        passed();
    }
}
