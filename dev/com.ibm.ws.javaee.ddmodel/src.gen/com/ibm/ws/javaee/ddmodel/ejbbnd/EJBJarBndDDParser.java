/*******************************************************************************
 * Copyright (c) 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
// NOTE: This is a generated file. Do not edit it directly.
package com.ibm.ws.javaee.ddmodel.ejbbnd;

import com.ibm.ws.javaee.ddmodel.DDParser;
import com.ibm.wsspi.adaptable.module.Container;
import com.ibm.wsspi.adaptable.module.Entry;

public class EJBJarBndDDParser extends DDParser {
    private final boolean xmi;

    public EJBJarBndDDParser(Container ddRootContainer, Entry ddEntry, boolean xmi) throws DDParser.ParseException {
        super(ddRootContainer, ddEntry, com.ibm.ws.javaee.dd.ejb.EJBJar.class);
        this.xmi = xmi;
    }

    public com.ibm.ws.javaee.dd.ejbbnd.EJBJarBnd parse() throws ParseException {
        super.parseRootElement();
        return (com.ibm.ws.javaee.dd.ejbbnd.EJBJarBnd) rootParsable;
    }

    @Override
    protected ParsableElement createRootParsable() throws ParseException {
        if (!xmi && "ejb-jar-bnd".equals(rootElementLocalName)) {
            return createXMLRootParsable();
        }
        if (xmi && "EJBJarBinding".equals(rootElementLocalName)) {
            DDParser.ParsableElement rootParsableElement = createXMIRootParsable();
            namespace = null;
            idNamespace = "http://www.omg.org/XMI";
            return rootParsableElement;
        }
        throw new ParseException(invalidRootElement());
    }

    private ParsableElement createXMLRootParsable() throws ParseException {
        if (namespace == null) {
            throw new ParseException(missingDeploymentDescriptorNamespace());
        }
        String versionString = getAttributeValue("", "version");
        if (versionString == null) {
            throw new ParseException(missingDeploymentDescriptorVersion());
        }
        if ("http://websphere.ibm.com/xml/ns/javaee".equals(namespace)) {
            if ("1.0".equals(versionString)) {
                version = 10;
                return new com.ibm.ws.javaee.ddmodel.ejbbnd.EJBJarBndType(getDeploymentDescriptorPath());
            }
            if ("1.1".equals(versionString)) {
                version = 11;
                return new com.ibm.ws.javaee.ddmodel.ejbbnd.EJBJarBndType(getDeploymentDescriptorPath());
            }
            if ("1.2".equals(versionString)) {
                version = 12;
                return new com.ibm.ws.javaee.ddmodel.ejbbnd.EJBJarBndType(getDeploymentDescriptorPath());
            }
            throw new ParseException(invalidDeploymentDescriptorVersion(versionString));
        }
        throw new ParseException(invalidDeploymentDescriptorNamespace(versionString));
    }

    private DDParser.ParsableElement createXMIRootParsable() throws ParseException {
        if (namespace == null) {
            throw new ParseException(missingDeploymentDescriptorNamespace());
        }
        if ("ejbbnd.xmi".equals(namespace)) {
            version = 9;
            return new com.ibm.ws.javaee.ddmodel.ejbbnd.EJBJarBndType(getDeploymentDescriptorPath(), true);
        }
        throw new ParseException(missingDeploymentDescriptorVersion());
    }
}
