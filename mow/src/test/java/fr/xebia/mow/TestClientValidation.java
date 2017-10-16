/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow;

import org.junit.Before;
import org.junit.Test;

import fr.xebia.mow.model.ECardinal;
import fr.xebia.mow.model.EMove;
import fr.xebia.mow.model.ERotation;
import fr.xebia.mow.model.IMap;
import fr.xebia.mow.model.IMow;
import fr.xebia.mow.model.Point;
import fr.xebia.mow.model.controler.MowControler;
import fr.xebia.mow.model.controler.impl.MoveCommand;
import fr.xebia.mow.model.controler.impl.RotateCommand;
import fr.xebia.mow.model.impl.RectangularMap;
import fr.xebia.mow.model.impl.StandardMow;

/**
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 *
 */
public class TestClientValidation {

    protected IMap         map;
    protected IMow         mow1;
    protected IMow         mow2;
    protected MowControler controler1;
    protected MowControler controler2;

    @Before
    public void before() {
        this.mow1 = new StandardMow(Point.create(1, 2), ECardinal.NORTH);
        this.mow2 = new StandardMow(Point.create(3, 3), ECardinal.EAST);
        this.map = new RectangularMap(Point.create(6, 6));
        this.map.add(this.mow1);
        this.map.add(this.mow2);
        this.controler1 = new MowControler(this.mow1, this.map);
        this.controler2 = new MowControler(this.mow2, this.map);
    }

    @Test
    public void validate() {
        this.controler1.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler1.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler1.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler1.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler1.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler1.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler1.addCommand(new RotateCommand(ERotation.LEFT));
        this.controler1.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler1.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler1.run();

        this.controler2.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler2.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler2.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler2.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler2.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler2.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler2.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler2.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler2.addCommand(new RotateCommand(ERotation.RIGHT));
        this.controler2.addCommand(new MoveCommand(EMove.FORWARD));
        this.controler2.run();
    }

}
