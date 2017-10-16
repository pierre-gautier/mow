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

import fr.xebia.mow.model.ECardinal;

/**
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 *
 */
public class TestECardinal {

    @Test
    public void testFrom() {
        Assert.assertNull(ECardinal.fromLabel('Z'));
        Assert.assertEquals(ECardinal.NORTH, ECardinal.fromLabel('N'));
        Assert.assertEquals(ECardinal.EAST, ECardinal.fromLabel('E'));
        Assert.assertEquals(ECardinal.SOUTH, ECardinal.fromLabel('S'));
        Assert.assertEquals(ECardinal.WEST, ECardinal.fromLabel('W'));
    }

}
