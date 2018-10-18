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

import org.dspace.app.rest.converter.ChecksumHistoryConverter;
import org.dspace.app.rest.model.ChecksumHistoryRest;
import org.dspace.app.rest.model.hateoas.DSpaceResource;
import org.dspace.checker.ChecksumHistory;
import org.dspace.checker.service.ChecksumHistoryService;
import org.dspace.core.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * This is the repository responsible to manage the Checksum Rest object
 *
 * @author Pablo Prieto (pablo.prieto at almat.com.mx)
 */

@Component(ChecksumHistoryRest.CATEGORY + "." + ChecksumHistoryRest.NAME)
public class ChecksumHistoryRestRepository extends DSpaceRestRepository<ChecksumHistoryRest, String> {

    @Autowired
    ChecksumHistoryService crs;

    @Autowired
    ChecksumHistoryConverter converter;

    public ChecksumHistoryRestRepository() {
        System.out.println("Checksum repository initialized by Spring");
    }

    @Override
    public ChecksumHistoryRest findOne(Context context, String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Page<ChecksumHistoryRest> findAll(Context context, Pageable pageable) {
        List<ChecksumHistory> crit = new ArrayList<ChecksumHistory>();
        Iterator<ChecksumHistory> it = null;
        int total = 0;
        try {
            total = crs.countTotal(context);
            // TODO Allow offsets as in:
            it = crs.findAll(context, 0, 11);
            while (it.hasNext()) {
                crit.add(it.next());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        Page<ChecksumHistoryRest> page = new PageImpl<ChecksumHistory>(crit, pageable, total).map(converter);
        return page;
    }

    @Override
    public Class<ChecksumHistoryRest> getDomainClass() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DSpaceResource<ChecksumHistoryRest> wrapResource(ChecksumHistoryRest model, String... rels) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}