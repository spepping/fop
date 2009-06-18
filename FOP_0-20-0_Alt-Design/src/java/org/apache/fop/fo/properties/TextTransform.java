/*
 * $Id$
 *
 *
 * Copyright 1999-2003 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *  
 */
package org.apache.fop.fo.properties;

import org.apache.fop.fo.expr.PropertyException;

public class TextTransform extends Property  {
    public static final int dataTypes = ENUM | NONE | INHERIT;

    public int getDataTypes() {
        return dataTypes;
    }

    public static final int traitMapping = REFINE;

    public int getTraitMapping() {
        return traitMapping;
    }

    public static final int initialValueType = NONE_IT;

    public int getInitialValueType() {
        return initialValueType;
    }

    public static final int CAPITALIZE = 1;
    public static final int UPPERCASE = 2;
    public static final int LOWERCASE = 3;
    public static final int inherited = COMPUTED;

    public int getInherited() {
        return inherited;
    }


    private static final String[] rwEnums = {
        null
        ,"capitalize"
        ,"uppercase"
        ,"lowercase"
    };
    public int getEnumIndex(String enumval) throws PropertyException {
        return enumValueToIndex(enumval, rwEnums);
    }
    public String getEnumText(int index) {
        return rwEnums[index];
    }
}
