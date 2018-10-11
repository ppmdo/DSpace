/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.converter;

import org.dspace.app.rest.model.ChecksumResultRest;
import org.dspace.checker.ChecksumResult;
import org.springframework.stereotype.Component;


/**
 * This is the converter from/to the ChecksumResult in the DSpace API data model and the REST data model
 *
 * @author Pablo Prieto (pablo.prieto at almat.com.mx)
 */
@Component
public class ChecksumResultConverter
    extends DSpaceConverter<org.dspace.checker.ChecksumResult, org.dspace.app.rest.model.ChecksumResultRest> {

    @Override
    public ChecksumResultRest fromModel(ChecksumResult obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ChecksumResult toModel(ChecksumResultRest obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
