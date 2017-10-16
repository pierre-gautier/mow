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
import fr.xebia.mow.model.Point;
import fr.xebia.mow.model.controler.impl.AvoidType;
import fr.xebia.mow.model.controler.impl.MoveCommand;
import fr.xebia.mow.model.controler.impl.RotateCommand;
import fr.xebia.mow.model.impl.Flowers;
import fr.xebia.mow.model.impl.TerrifyingObject;

/**
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 *
 */
public class TestMowControlerRotationTerrifying extends ATestMowControler {

    @Override
    public void customizeBefore() {
        this.map.add(new Flowers(Point.create(5, 4)));
        this.map.add(new TerrifyingObject(Point.create(4, 5)));
        this.controler.addRule(new AvoidType<>(RotateCommand.class, TerrifyingObject.class));
        this.map.add(new Flowers(Point.create(5, 6)));
        this.map.add(new Flowers(Point.create(5, 4)));
        this.map.add(new Flowers(Point.create(4, 5)));
        this.map.add(new Flowers(Point.create(6, 5)));
        this.controler.addRule(new AvoidType<>(MoveCommand.class, Flowers.class));
    }

    @Test
    public void testL() {
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.run();
        Assert.assertEquals(ECardinal.NORTH, this.mow.getDirection());
    }

    @Test
    public void testLL() {
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler.addCommand(new RotateCommand(ERotation.LEFT));
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

}
