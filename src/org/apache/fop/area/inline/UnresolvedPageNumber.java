/*
 * $Id$
 * Copyright (C) 2001 The Apache Software Foundation. All rights reserved.
 * For details on use and redistribution please refer to the
 * LICENSE file included with these sources.
 */

package org.apache.fop.area.inline;

import org.apache.fop.area.PageViewport;
import org.apache.fop.area.Resolveable;

import java.util.ArrayList;

public class UnresolvedPageNumber extends Word implements Resolveable {
    boolean resolved = false;
    String pageRefId;

    public UnresolvedPageNumber(String id) {
        pageRefId = id;
        word = "?";
    }

    public String[] getIDs() {
        return new String[] {pageRefId};
    }

    public void resolve(String id, ArrayList pages) {
        resolved = true;
        PageViewport page = (PageViewport)pages.get(0);
        String str = page.getPageNumber();
        word = str;
    }

    public boolean isResolved() {
       return resolved;
    }
}
