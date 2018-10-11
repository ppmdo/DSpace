/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dspace.app.rest.converter.ChecksumResultConverter;
import org.dspace.app.rest.model.ChecksumResultRest;
import org.dspace.app.rest.model.hateoas.DSpaceResource;
import org.dspace.checker.ChecksumResult;
import org.dspace.checker.ChecksumResultCode;
import org.dspace.checker.service.ChecksumResultService;
import org.dspace.core.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * This is the repository responsible to manage the Checksum Rest object
 *
 * @author Pablo Prieto (pablo.prieto at almat.com.mx)
 */

@Component(ChecksumResultRest.CATEGORY + "." + ChecksumResultRest.NAME)
public class ChecksumRepository extends DSpaceRestRepository<ChecksumResultRest, String> {

    @Autowired
    ChecksumResultService crs;

    @Autowired
    ChecksumResultConverter converter;

    public ChecksumRepository() {
        System.out.println("Checksum Repository initialized by Spring");
    }

    public ChecksumResultRest findOne(Context context, ChecksumResultCode code) {
        ChecksumResult checksumResult = null;
        try {
            checksumResult = crs.findByCode(context, code);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        if (checksumResult == null) {
            return null;
        }
        return converter.fromModel(checksumResult);
    }

    @Override
    public ChecksumResultRest findOne(Context context, String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Page<ChecksumResultRest> findAll(Context context, Pageable pageable) {
        List<ChecksumResult> crt = new ArrayList<ChecksumResult>();
        Iterator<ChecksumResult> it = null;
        int total = 0;
        try {
            total = crs.countTotal(context);
            it = crs.findAll(context, pageable.getPageSize(), pageable.getOffset());
            while (it.hasNext()) {
                crs.add(it.next());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        Page<BitstreamRest> page = new PageImpl<Bitstream>(bit, pageable, total).map(converter);
        return page;
    }

    @Override
    public Class<ChecksumResultRest> getDomainClass() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DSpaceResource<ChecksumResultRest> wrapResource(ChecksumResultRest model, String... rels) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}