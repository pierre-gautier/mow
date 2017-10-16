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

import fr.xebia.mow.model.EMove;
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
public class TestMowControlerMoveFlowers extends ATestMowControler {

    @Override
    public void customizeBefore() {
        this.map.add(new Flowers(Point.create(5, 4)));
        this.map.add(new Flowers(Point.create(4, 5)));
        this.controler.addRule(new AvoidType<>(MoveCommand.class, Flowers.class));
        this.map.add(new TerrifyingObject(Point.create(4, 5)));
        this.map.add(new TerrifyingObject(Point.create(6, 5)));
        this.map.add(new TerrifyingObject(Point.create(5, 4)));
        this.map.add(new TerrifyingObject(Point.create(5, 6)));
        this.controler.addRule(new AvoidType<>(RotateCommand.class, TerrifyingObject.class));
        this.map.add(new Flowers(Point.create(4, 5)));
    }

    @Test
    public void testB() {
        this.test(EMove.BACKWARD, 1, Point.create(5, 5));
        this.before();
        this.test(EMove.BACKWARD, 3, Point.create(5, 5));
        this.before();
        this.test(EMove.BACKWARD, 10, Point.create(5, 5));
    }

    @Test
    public void testCirlL() {
        this.controler.addCommand(new MoveCommand(EMove.BACKWARD));
        this.controler.addCommand(new MoveCommand(EMove.LEFT));
        this.controler.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler.addCommand(new MoveCommand(EMove.RIGHT));
        this.controler.run();
        Assert.assertEquals(Point.create(6, 6), this.mow.getPosition());
    }

    @Test
    public void testCirlR() {
        this.controler.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler.addCommand(new MoveCommand(EMove.RIGHT));
        this.controler.addCommand(new MoveCommand(EMove.BACKWARD));
        this.controler.addCommand(new MoveCommand(EMove.LEFT));
        this.controler.run();
        Assert.assertEquals(Point.create(5, 5), this.mow.getPosition());
    }

    @Test
    public void testF() {
        this.test(EMove.FORWARD, 1, Point.create(5, 6));
        this.before();
        this.test(EMove.FORWARD, 3, Point.create(5, 8));
        this.before();
        this.test(EMove.FORWARD, 10, Point.create(5, 9));
    }

    @Test
    public void testL() {
        this.test(EMove.LEFT, 1, Point.create(5, 5));
        this.before();
        this.test(EMove.LEFT, 3, Point.create(5, 5));
        this.before();
        this.test(EMove.LEFT, 10, Point.create(5, 5));
    }

    @Test
    public void testR() {
        this.test(EMove.RIGHT, 1, Point.create(6, 5));
        this.before();
        this.test(EMove.RIGHT, 3, Point.create(8, 5));
        this.before();
        this.test(EMove.RIGHT, 10, Point.create(9, 5));
    }

    private void test(final EMove move, final int times, final Point expected) {
        for (int i = 0; i < times; i++) {
            this.controler.addCommand(new MoveCommand(move));
        }
        this.controler.run();
        Assert.assertEquals(expected, this.mow.getPosition());
    }

}
