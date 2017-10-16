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
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 * @param <T>
 *            the Type of created object from parsing
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public interface IParser<T> {

    /**
     * Parse the input string and create a <T>
     *
     * @param input
     *            the string input
     * @return the object created from input stream
     * @throws ParsingException
     *             if anything prevents the parsing
     */
    T parse(String input) throws ParsingException;
}
