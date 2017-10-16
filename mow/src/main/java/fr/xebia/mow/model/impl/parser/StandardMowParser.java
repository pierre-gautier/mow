/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model.impl.parser;

import fr.xebia.mow.model.ECardinal;
import fr.xebia.mow.model.IMow;
import fr.xebia.mow.model.IParser;
import fr.xebia.mow.model.ParsingException;
import fr.xebia.mow.model.Point;
import fr.xebia.mow.model.impl.StandardMow;

/**
 * The Standard Mow Parser.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public class StandardMowParser implements IParser<IMow> {

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.io.IParser#parse(java.lang.String)
     */
    @Override
    public StandardMow parse(final String input) throws ParsingException {
        if (input == null) {
            throw new ParsingException("input cannot be null"); //$NON-NLS-1$
        }
        final String[] split = input.split(" "); //$NON-NLS-1$
        if (split == null || split.length < 3) {
            throw new ParsingException("input '" + input + "'is not valid it must be <integer integer char> where char is one of (NORTH, EAST, WEST, SOUTH)"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        try {
            final int x = Integer.parseInt(split[0]);
            final int y = Integer.parseInt(split[1]);
            final ECardinal cardinal = ECardinal.fromLabel(split[2].charAt(0));
            if (cardinal == null) {
                throw new ParsingException("cannot parse direction from input '" + input + "' it must be <integer integer char> where char is one of (NORTH, EAST, WEST, SOUTH)"); //$NON-NLS-1$ //$NON-NLS-2$
            }
            return new StandardMow(Point.create(x, y), cardinal);
        } catch (final NumberFormatException e) {
            throw new ParsingException("cannot parse mow position from input '" + input + "' it must be <integer integer char> where char is one of (NORTH, EAST, WEST, SOUTH)"); //$NON-NLS-1$ //$NON-NLS-2$
        }

    }

}
