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

import fr.xebia.mow.model.ECardinal;
import fr.xebia.mow.model.IMap;
import fr.xebia.mow.model.IMow;
import fr.xebia.mow.model.Point;
import fr.xebia.mow.model.controler.MowControler;
import fr.xebia.mow.model.impl.RectangularMap;
import fr.xebia.mow.model.impl.StandardMow;

/**
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 *
 */
public class ATestMowControler {

    protected IMow         mow;
    protected IMap         map;
    protected MowControler controler;

    @Before
    public void before() {
        this.mow = new StandardMow(Point.create(5, 5), ECardinal.NORTH);
        this.map = new RectangularMap(Point.create(10, 10));
        this.map.add(this.mow);
        this.controler = new MowControler(this.mow, this.map);
        this.customizeBefore();
    }

    protected void customizeBefore() {
        // do nothing
    }

}
