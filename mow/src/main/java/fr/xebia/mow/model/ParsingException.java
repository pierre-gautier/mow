/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model;

/**
 * The parsing exception.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 *
 */
public class ParsingException extends Exception {

    /**
     * The generated serial version uid
     */
    private static final long serialVersionUID = -5761352176327592492L;

    /**
     * Create a {@link ParsingException} from a message
     *
     * @param message
     */
    public ParsingException(final String message) {
        super(message);
    }

}
