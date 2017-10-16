/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model.impl.parser;

import fr.xebia.mow.model.IMap;
import fr.xebia.mow.model.IParser;
import fr.xebia.mow.model.ParsingException;
import fr.xebia.mow.model.Point;
import fr.xebia.mow.model.impl.RectangularMap;

/**
 * The client wants to define a Map by the extrem top right point.
 * Programming habits tend to use the size for this kind of definition.
 * The extrem top right point is transformed into size adding 1 on each dimension.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public class RectangularMapParser implements IParser<IMap> {

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.io.IParser#parse(java.lang.String)
     */
    @Override
    public RectangularMap parse(final String input) throws ParsingException {
        if (input == null) {
            throw new ParsingException("input cannot be null"); //$NON-NLS-1$
        }
        final String[] split = input.split(" "); //$NON-NLS-1$
        if (split == null || split.length < 2) {
            throw new ParsingException("input '" + input + "'is not valid it must me <integer integer>"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        try {
            final int x = Integer.parseInt(split[0]) + 1;
            final int y = Integer.parseInt(split[1]) + 1;
            return new RectangularMap(Point.create(x, y));
        } catch (final NumberFormatException e) {
            throw new ParsingException("cannot parse map top right point from '" + input + "' it must me <integer integer>"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

}
