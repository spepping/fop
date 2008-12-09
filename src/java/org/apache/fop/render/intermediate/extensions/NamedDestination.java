/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id$ */

package org.apache.fop.render.intermediate.extensions;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import org.apache.xmlgraphics.util.XMLizable;

import org.apache.fop.util.XMLConstants;

/**
 * This class is a named destination element for use in the intermediate format.
 */
public class NamedDestination implements XMLizable, DocumentNavigationExtensionConstants {

    /** Attribute name for the destination name */
    public static final String NAME = "name";

    private String name;
    private AbstractAction action;

    /**
     * Creates a new named destination.
     * @param name the destination's name
     * @param action the action performed when the destination is selected
     */
    public NamedDestination(String name, AbstractAction action) {
        this.name = name;
        this.action = action;
    }

    /**
     * Returns the destination's name.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the action performed when the destination is selected.
     * @return the action
     */
    public AbstractAction getAction() {
        return this.action;
    }

    /**
     * Sets the action performed when the destination is selected.
     * @param action the action
     */
    public void setAction(AbstractAction action) {
        this.action = action;
    }

    /** {@inheritDoc} */
    public void toSAX(ContentHandler handler) throws SAXException {
        if (getAction() == null) {
            throw new IllegalStateException("Action has not been set");
        }
        AttributesImpl atts = new AttributesImpl();
        atts.addAttribute(null, NAME, NAME, XMLConstants.CDATA, getName());
        if (getAction().isReference()) {
            atts.addAttribute(null, ACTION_REF, ACTION_REF,
                    XMLConstants.CDATA, getAction().getID());
        }
        handler.startElement(NAMED_DESTINATION.getNamespaceURI(),
                NAMED_DESTINATION.getLocalName(), NAMED_DESTINATION.getQName(), atts);
        if (!getAction().isReference()) {
            getAction().toSAX(handler);
        }
        handler.endElement(NAMED_DESTINATION.getNamespaceURI(),
                NAMED_DESTINATION.getLocalName(), NAMED_DESTINATION.getQName());
    }

}