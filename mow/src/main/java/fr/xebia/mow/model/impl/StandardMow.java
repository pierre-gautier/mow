/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model.impl;

import fr.xebia.mow.model.ECardinal;
import fr.xebia.mow.model.ERotation;
import fr.xebia.mow.model.IMow;
import fr.xebia.mow.model.Point;

/**
 * The Class StandardMow.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public class StandardMow extends APositionnedObject implements IMow {

    private ECardinal direction;

    /**
     * Instantiates a new standard mow.
     *
     * @param position
     *            the postion
     * @param direction
     *            the direction
     */
    public StandardMow(final Point position, final ECardinal direction) {
        super(position);
        this.direction = direction;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.IMovingObject#getDirection()
     */
    @Override
    public ECardinal getDirection() {
        return this.direction;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.IMovingObject#move(fr.xebia.mow.Point)
     */
    @Override
    public void move(final Point move) {
        this.position = move;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.IMovingObject#rotate(fr.xebia.mow.ERotation)
     */
    @Override
    public void rotate(final ERotation rotation) {
        this.direction = rotation.apply(this.direction);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.impl.APositionnedObject#toString()
     */
    @Override
    public String toString() {
        return this.position + " " + this.direction; //$NON-NLS-1$
    }

}
