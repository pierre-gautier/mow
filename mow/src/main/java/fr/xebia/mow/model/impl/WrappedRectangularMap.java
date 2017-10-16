/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model.impl;

import fr.xebia.mow.model.Point;

/**
 * The Class RectangularMap.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public class WrappedRectangularMap extends RectangularMap {

    /**
     * Create a {@link WrappedRectangularMap} from its size
     *
     * First valid position is (0,0), last valid is (x-1, y-1).
     *
     * @param size
     *            the size
     */
    public WrappedRectangularMap(final Point size) {
        super(size);
    }

    /**
     * Check valid.
     *
     * This method can be ovrriden.
     *
     * @param to
     *            the to
     * @return valid position or null
     */
    @Override
    protected Point checkValid(final Point to) {
        if (to == null) {
            return null;
        }
        final int x = to.x < 0 ? this.size.x - 1 : to.x >= this.size.x ? 0 : to.x;
        final int y = to.y < 0 ? this.size.y - 1 : to.y >= this.size.y ? 0 : to.y;
        return Point.create(x, y);
    }

}
