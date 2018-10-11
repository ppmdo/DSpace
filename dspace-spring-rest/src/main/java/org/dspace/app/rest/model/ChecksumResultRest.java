/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

package org.dspace.app.rest.model;

import org.dspace.app.rest.RestResourceController;

/**
 * The Checksum Result REST Resource.
 *
 * @author Pablo Prieto (pablo.prieto at almat.com.mx)
 */
public class ChecksumResultRest  extends BaseObjectRest<String> {
    public static final String PLURAL_NAME = "checksumresults";
    public static final String NAME = "checksumresult";
    public static final String CATEGORY = RestAddressableModel.CORE;

    String resultCode;
    String resultDescription;

    @Override
    public String getCategory() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Class getController() {
        return RestResourceController.class;
    }

    @Override
    public String getType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
