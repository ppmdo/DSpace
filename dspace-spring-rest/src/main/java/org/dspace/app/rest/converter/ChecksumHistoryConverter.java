/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.converter;

import org.dspace.app.rest.model.ChecksumHistoryRest;
import org.dspace.checker.ChecksumHistory;
import org.springframework.stereotype.Component;


/**
 * This is the converter from/to the ChecksumResult in the DSpace API data model and the REST data model
 *
 * @author Pablo Prieto (pablo.prieto at almat.com.mx)
 */
@Component
public class ChecksumHistoryConverter
    extends DSpaceConverter<org.dspace.checker.ChecksumHistory, org.dspace.app.rest.model.ChecksumHistoryRest> {

    @Override
    public ChecksumHistoryRest fromModel(ChecksumHistory obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ChecksumHistory toModel(ChecksumHistoryRest obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
