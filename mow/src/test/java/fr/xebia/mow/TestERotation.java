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
import fr.xebia.mow.model.ERotation;

/**
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 *
 */
public class TestERotation {

    @Test
    public void testFrom() {
        Assert.assertNull(ERotation.fromLabel('Z'));
        Assert.assertEquals(ERotation.LEFT, ERotation.fromLabel('G'));
        Assert.assertEquals(ERotation.RIGHT, ERotation.fromLabel('D'));
    }

    @Test
    public void testLeft() {
        final Map<ECardinal, ECardinal> mapping = new HashMap<>();
        mapping.put(ECardinal.NORTH, ECardinal.WEST);
        mapping.put(ECardinal.WEST, ECardinal.SOUTH);
        mapping.put(ECardinal.SOUTH, ECardinal.EAST);
        mapping.put(ECardinal.EAST, ECardinal.NORTH);
        this.test(ERotation.LEFT, mapping);
    }

    @Test
    public void testRight() {
        final Map<ECardinal, ECardinal> mapping = new HashMap<>();
        mapping.put(ECardinal.NORTH, ECardinal.EAST);
        mapping.put(ECardinal.EAST, ECardinal.SOUTH);
        mapping.put(ECardinal.SOUTH, ECardinal.WEST);
        mapping.put(ECardinal.WEST, ECardinal.NORTH);
        this.test(ERotation.RIGHT, mapping);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("D", ERotation.RIGHT.toString());
        Assert.assertEquals("G", ERotation.LEFT.toString());
    }

    private void test(final ERotation direction, final Map<ECardinal, ECardinal> mapping) {
        for (final Entry<ECardinal, ECardinal> entry : mapping.entrySet()) {
            Assert.assertEquals(entry.getValue(), direction.apply(entry.getKey()));
        }
    }

}
