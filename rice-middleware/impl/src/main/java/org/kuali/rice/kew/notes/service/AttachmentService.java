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
package org.kuali.rice.kew.notes.service;

import java.io.File;

import org.kuali.rice.kew.notes.Attachment;
import org.springframework.core.io.Resource;

/**
 * A service providing access for attachments.
 * 
 * @see Attachment
 *
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
public interface AttachmentService {

	void persistAttachedFileAndSetAttachmentBusinessObjectValue(Attachment attachment) throws Exception;
	
	/**
	 * @deprecated use {@link #findAttachedResource(Attachment)} instead
	 */
	@Deprecated
	File findAttachedFile(Attachment attachment) throws Exception;
	
	Resource findAttachedResource(Attachment attachment);
	
	void deleteAttachedFile(Attachment attachment) throws Exception;
	
}
