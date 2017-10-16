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
import fr.xebia.mow.model.impl.RectangularMap;

public class TestRectangularMap {

    @Test
    public void testConstructor() {
        this.createInvalid(null);
        // invlaid values
        this.createInvalid(Point.create(0, 0));
        this.createInvalid(Point.create(0, -1));
        this.createInvalid(Point.create(-1, 0));
        this.createInvalid(Point.create(-1, -1));
        // valud values
        this.create(Point.create(1, 1));
    }

    @Test
    public void testLimits() {
        final IMap map = this.create(Point.create(10, 10));
        // from origin
        final Point origin = Point.create(0, 0);
        Assert.assertEquals(origin.plus(0, 1), map.apply(origin, Point.create(0, 1)));
        Assert.assertEquals(origin.plus(1, 0), map.apply(origin, Point.create(1, 0)));
        Assert.assertEquals(origin, map.apply(origin, Point.create(-1, 0)));
        Assert.assertEquals(origin, map.apply(origin, Point.create(0, -1)));
        // from end
        final Point end = Point.create(9, 9);
        Assert.assertEquals(end, map.apply(end, Point.create(0, 1)));
        Assert.assertEquals(end, map.apply(end, Point.create(0, 1)));
        Assert.assertEquals(end.plus(-1, 0), map.apply(end, Point.create(-1, 0)));
        Assert.assertEquals(end.plus(0, -1), map.apply(end, Point.create(0, -1)));
    }

    protected IMap create(final Point point) {
        return new RectangularMap(point);
    }

    private void createInvalid(final Point point) {
        Exception expected = null;
        IMap map = null;
        // null
        try {
            map = this.create(point);
        } catch (final Exception e) {
            expected = e;
        }
        Assert.assertNull(map);
        Assert.assertNotNull(expected);
    }

}
