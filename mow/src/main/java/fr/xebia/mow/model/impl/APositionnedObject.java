/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model.impl;

import fr.xebia.mow.model.IPositionnedObject;
import fr.xebia.mow.model.Point;

/**
 * The Class APositionnedObject.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public abstract class APositionnedObject implements IPositionnedObject {

    /** The position. */
    protected Point position;

    /**
     * Instantiates a new a positionned object.
     *
     * @param position
     *            the position
     */
    protected APositionnedObject(final Point position) {
        this.position = position;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.IPositionnedObject#getPosition()
     */
    @Override
    public Point getPosition() {
        return this.position;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.position; //$NON-NLS-1$
    }

}