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

package org.apache.fop.render.bitmap;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.MimeConstants;
import org.apache.fop.render.AbstractRendererMaker;
import org.apache.fop.render.Renderer;
import org.apache.fop.render.RendererConfigurator;

/**
 * RendererMaker for the TIFF Renderer.
 */
public class TIFFRendererMaker extends AbstractRendererMaker {

    private static final String[] MIMES = new String[] {MimeConstants.MIME_TIFF};

    /** {@inheritDoc} */
    public Renderer makeRenderer(FOUserAgent userAgent) {
        return new TIFFRenderer(userAgent);
    }

    /** {@inheritDoc} */
    public RendererConfigurator getConfigurator(FOUserAgent userAgent) {
        return new TIFFRendererConfigurator(userAgent);
    }

    /** {@inheritDoc} */
    public boolean needsOutputStream() {
        return true;
    }

    /** {@inheritDoc} */
    public String[] getSupportedMimeTypes() {
        return MIMES;
    }

}
