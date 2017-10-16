/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow;

import org.junit.Assert;
import org.junit.Test;

import fr.xebia.mow.model.IMap;
import fr.xebia.mow.model.Point;
import fr.xebia.mow.model.impl.WrappedRectangularMap;

public class TestWrappedRectangularMap extends TestRectangularMap {

    @Test
    @Override
    public void testLimits() {
        final IMap map = this.create(Point.create(10, 10));
        // from origin
        final Point origin = Point.create(0, 0);
        Assert.assertEquals(origin.plus(0, 1), map.apply(origin, Point.create(0, 1)));
        Assert.assertEquals(origin.plus(1, 0), map.apply(origin, Point.create(1, 0)));
        Assert.assertEquals(Point.create(9, 0), map.apply(origin, Point.create(-1, 0)));
        Assert.assertEquals(Point.create(0, 9), map.apply(origin, Point.create(0, -1)));
        // from end
        final Point end = Point.create(9, 9);
        Assert.assertEquals(Point.create(9, 0), map.apply(end, Point.create(0, 1)));
        Assert.assertEquals(Point.create(0, 9), map.apply(end, Point.create(1, 0)));
        Assert.assertEquals(end.plus(-1, 0), map.apply(end, Point.create(-1, 0)));
        Assert.assertEquals(end.plus(0, -1), map.apply(end, Point.create(0, -1)));
    }

    @Override
    protected IMap create(final Point point) {
        return new WrappedRectangularMap(point);
    }

}
