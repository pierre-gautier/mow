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
import fr.xebia.mow.model.ERotation;
import fr.xebia.mow.model.controler.impl.RotateCommand;

/**
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 *
 */
public class TestMowControlerRotationNoRules extends ATestMowControler {

    @Test
    public void testL() {
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.run();
        Assert.assertEquals(ECardinal.WEST, this.mow.getDirection());
    }

    @Test
    public void testLL() {
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.run();
        Assert.assertEquals(ECardinal.SOUTH, this.mow.getDirection());
    }

    @Test
    public void testLLLL() {
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.run();
        Assert.assertEquals(ECardinal.NORTH, this.mow.getDirection());
    }

    @Test
    public void testLLLRRR() {
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler.run();
        Assert.assertEquals(ECardinal.NORTH, this.mow.getDirection());
    }

    @Test
    public void testR() {
        this.controler.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler.run();
        Assert.assertEquals(ECardinal.EAST, this.mow.getDirection());
    }

    @Test
    public void testRR() {
        this.controler.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler.run();
        Assert.assertEquals(ECardinal.SOUTH, this.mow.getDirection());
    }

    @Test
    public void testRRLL() {
        this.controler.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.run();
        Assert.assertEquals(ECardinal.NORTH, this.mow.getDirection());
    }

    @Test
    public void testRRRR() {
        this.controler.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler.run();
        Assert.assertEquals(ECardinal.NORTH, this.mow.getDirection());
    }

    @Test
    public void testToString() {
        Assert.assertEquals(RotateCommand.class.getSimpleName() + " " + "G", new RotateCommand(ERotation.LEFT).toString());
        Assert.assertEquals(RotateCommand.class.getSimpleName() + " " + "D", new RotateCommand(ERotation.RIGHT).toString());
    }

}
