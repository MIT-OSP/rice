/*
 * Copyright 2005-2011 The Kuali Foundation
 *
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
package org.kuali.rice.kew.api.validation;

import org.apache.commons.collections.CollectionUtils;
import org.kuali.rice.core.api.CoreConstants;
import org.kuali.rice.core.api.mo.AbstractDataTransferObject;
import org.kuali.rice.core.api.mo.ModelBuilder;
import org.kuali.rice.kew.api.rule.RuleContract;
import org.kuali.rice.kew.api.rule.RuleDelegationContract;
import org.kuali.rice.kew.api.rule.RuleResponsibility;
import org.kuali.rice.kew.api.rule.RuleResponsibilityContract;
import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A set of results from validation of a field of data.
 *
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
@XmlRootElement(name = ValidationResults.Constants.ROOT_ELEMENT_NAME)
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = ValidationResults.Constants.TYPE_NAME, propOrder = {
    ValidationResults.Constants.RESULTS_LIST_PROPERTY,
    CoreConstants.CommonElements.FUTURE_ELEMENTS
})
public class ValidationResults
    extends AbstractDataTransferObject
    implements ValidationResultsContract {

	public static final String GLOBAL = "org.kuali.rice.kew.api.validation.ValidationResults.GLOBAL";

    @XmlElement(name = Elements.ERROR, required = false)
    private final List<ValidationResult> results;

    @SuppressWarnings("unused")
    @XmlAnyElement
    private final Collection<Element> _futureElements = null;

    /**
     * Private constructor used only by JAXB.
     */
    private ValidationResults() {
        this.results = new ArrayList<ValidationResult>();
    }

    private ValidationResults(Builder builder) {
       List<ValidationResult> results = new ArrayList<ValidationResult>();
       if (builder.getValidationResults() != null) {
           for (ValidationResult.Builder validationResultBuilder: builder.getValidationResults()) {
               results.add(validationResultBuilder.build());
           }
       }
       this.results = results;
    }

    @Override
	public List<ValidationResult> getValidationResults() {
		return results;
	}

    /**
     * A builder which can be used to construct {@link ValidationResults} instances.  Enforces the constraints of the {@link ValidationResultsContract}.
     *
     */
    public final static class Builder
        implements Serializable, ModelBuilder, ValidationResultsContract
    {

        private List<ValidationResult.Builder> results = new ArrayList<ValidationResult.Builder>();

        private Builder() {
        }

        public static Builder create() {
            return new Builder();
        }

        public static Builder create(ValidationResultsContract contract) {
            if (contract == null) {
                throw new IllegalArgumentException("contract was null");
            }
            Builder builder = create();

            if (CollectionUtils.isNotEmpty(contract.getValidationResults())) {
                List<ValidationResult.Builder> resultBuilders= new ArrayList<ValidationResult.Builder>();
                for (ValidationResultContract c : contract.getValidationResults()) {
                    resultBuilders.add(ValidationResult.Builder.create(c));
                }
                builder.setValidationResults(resultBuilders);
            }
            return builder;
        }

        public ValidationResults build() {
            return new ValidationResults(this);
        }

        @Override
        public List<ValidationResult.Builder> getValidationResults() {
            return this.results;
        }

        public void setValidationResults(List<ValidationResult.Builder> results) {
            this.results = results;
        }

        /**
         * Convenience method for adding an error message
         * @param errorMessage
         */
        public void addValidationResult(String errorMessage) {
            addValidationResult(GLOBAL, errorMessage);
        }

        /**
         * Convenience method for adding an error message for a given field
         * @param errorMessage
         */
        public void addValidationResult(String fieldName, String errorMessage) {
            ValidationResult.Builder b = ValidationResult.Builder.create();
            b.setFieldName(fieldName);
            b.setErrorMessage(errorMessage);
            results.add(b);
        }
    }

    /**
     * Defines some internal constants used on this class.
     */
    static class Constants {
        final static String ROOT_ELEMENT_NAME = "validationResults";
        final static String TYPE_NAME = "ValidationResultsType";
        final static String RESULTS_LIST_PROPERTY = "results";
    }
    /**
     * A private class which exposes constants which define the XML element names to use when this object is marshalled to XML.
     */
    static class Elements {
        final static String ERROR = "error";
    }
}