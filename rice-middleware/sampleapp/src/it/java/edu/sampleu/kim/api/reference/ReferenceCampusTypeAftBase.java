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
package edu.sampleu.kim.api.reference;

import edu.sampleu.admin.AdminTmplMthdAftNavBase;
import org.kuali.rice.testtools.common.JiraAwareFailable;
import org.kuali.rice.testtools.selenium.AutomatedFunctionalTestUtils;
import org.kuali.rice.testtools.selenium.WebDriverUtils;

/**
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
public abstract class ReferenceCampusTypeAftBase extends AdminTmplMthdAftNavBase {

    /**
     * ITUtil.PORTAL + "?channelTitle=Campus%20Type&channelUrl=" 
     * + WebDriverUtils.getBaseUrlString() + ITUtil.KNS_LOOKUP_METHOD + "org.kuali.rice.location.impl.campus.CampusTypeBo&docFormKey=88888888&returnLocation=" +
     * ITUtil.PORTAL_URL + ITUtil.HIDE_RETURN_LINK;
     */
    public static final String BOOKMARK_URL = AutomatedFunctionalTestUtils.PORTAL + "?channelTitle=Campus%20Type&channelUrl="
            + WebDriverUtils.getBaseUrlString() + AutomatedFunctionalTestUtils.KNS_LOOKUP_METHOD +
            "org.kuali.rice.location.impl.campus.CampusTypeBo&docFormKey=88888888&returnLocation=" +
            AutomatedFunctionalTestUtils.PORTAL_URL + AutomatedFunctionalTestUtils.HIDE_RETURN_LINK ;

    @Override
    protected String getBookmarkUrl() {
        return BOOKMARK_URL;
    }

    /**
     * {@inheritDoc}
     * Campus Type
     * @return
     */
    @Override
    protected String getLinkLocator() {
        return "Campus Type";
    }
   
    public void testReferenceCampusTypeBookmark(JiraAwareFailable failable) throws Exception {
        testSearchEditCancel();
        passed();
    }

    public void testReferenceCampusTypeNav(JiraAwareFailable failable) throws Exception {
        testSearchEditCancel();
        passed();
    }
}
