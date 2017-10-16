/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

import fr.xebia.mow.model.ECardinal;
import fr.xebia.mow.model.EMove;
import fr.xebia.mow.model.Point;

/**
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 *
 */
public class TestEMove {

    @Test
    public void testBackward() {
        final Map<ECardinal, Point> mapping = new HashMap<>();
        mapping.put(ECardinal.NORTH, Point.create(0, -1));
        mapping.put(ECardinal.EAST, Point.create(-1, 0));
        mapping.put(ECardinal.WEST, Point.create(1, 0));
        mapping.put(ECardinal.SOUTH, Point.create(0, 1));
        this.test(EMove.BACKWARD, mapping);
    }

    @Test
    public void testForward() {
        final Map<ECardinal, Point> mapping = new HashMap<>();
        mapping.put(ECardinal.NORTH, Point.create(0, 1));
        mapping.put(ECardinal.EAST, Point.create(1, 0));
        mapping.put(ECardinal.WEST, Point.create(-1, 0));
        mapping.put(ECardinal.SOUTH, Point.create(0, -1));
        this.test(EMove.FORWARD, mapping);
    }

    @Test
    public void testFrom() {
        Assert.assertNull(EMove.fromLabel('Z'));
        Assert.assertEquals(EMove.FORWARD, EMove.fromLabel('A'));
        Assert.assertEquals(EMove.BACKWARD, EMove.fromLabel('B'));
        Assert.assertEquals(EMove.LEFT, EMove.fromLabel('L'));
        Assert.assertEquals(EMove.RIGHT, EMove.fromLabel('R'));
    }

    @Test
    public void testStrafeLeft() {
        final Map<ECardinal, Point> mapping = new HashMap<>();
        mapping.put(ECardinal.NORTH, Point.create(-1, 0));
        mapping.put(ECardinal.EAST, Point.create(0, 1));
        mapping.put(ECardinal.WEST, Point.create(0, -1));
        mapping.put(ECardinal.SOUTH, Point.create(1, 0));
        this.test(EMove.LEFT, mapping);
    }

    @Test
    public void testStrafeRight() {
        final Map<ECardinal, Point> mapping = new HashMap<>();
        mapping.put(ECardinal.NORTH, Point.create(1, 0));
        mapping.put(ECardinal.EAST, Point.create(0, -1));
        mapping.put(ECardinal.WEST, Point.create(0, 1));
        mapping.put(ECardinal.SOUTH, Point.create(-1, 0));
        this.test(EMove.RIGHT, mapping);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("B", EMove.BACKWARD.toString());
        Assert.assertEquals("A", EMove.FORWARD.toString());
        Assert.assertEquals("L", EMove.LEFT.toString());
        Assert.assertEquals("R", EMove.RIGHT.toString());
    }

    private void test(final EMove direction, final Map<ECardinal, Point> mapping) {
        for (final Entry<ECardinal, Point> entry : mapping.entrySet()) {
            Assert.assertEquals(entry.getValue(), direction.apply(entry.getKey()));
        }
    }

}
