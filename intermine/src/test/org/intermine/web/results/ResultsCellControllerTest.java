package org.flymine.web.results;

/*
 * Copyright (C) 2002-2003 FlyMine
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  See the LICENSE file for more
 * information or http://www.gnu.org/copyleft/lesser.html.
 *
 */

import java.util.HashMap;
import java.util.Map;

import servletunit.struts.MockStrutsTestCase;
import org.apache.struts.tiles.ComponentContext;

import org.flymine.objectstore.ObjectStore;
import org.flymine.objectstore.ObjectStoreFactory;
import org.flymine.objectstore.query.Query;
import org.flymine.objectstore.query.Results;

import org.flymine.model.testmodel.Company;

public class ResultsCellControllerTest extends MockStrutsTestCase
{
    public ResultsCellControllerTest(String arg1) {
        super(arg1);
    }

    public void testBusinessObject() throws Exception {
        ComponentContext context = new ComponentContext();
        ComponentContext.setContext(context, getRequest());
        setRequestPathInfo("/initResultsCell");

        getRequest().setAttribute("object", new Company());
        actionPerform();
        assertNotNull(context.getAttribute("cld"));
    }

    public void testNonBusinessObject() throws Exception {
        ComponentContext context = new ComponentContext();
        ComponentContext.setContext(context, getRequest());
        setRequestPathInfo("/initResultsCell");

        getRequest().setAttribute("object", "test string");
        actionPerform();
        assertNull(context.getAttribute("cld"));
    }

}
