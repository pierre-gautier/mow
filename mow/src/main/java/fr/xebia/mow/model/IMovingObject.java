/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model;

/**
 * The Interface IMovingObject.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public interface IMovingObject {

    /**
     * Get the direction.
     *
     * @return direction
     */
    ECardinal getDirection();

    /**
     * Move the mow to the given position.
     *
     * @param move
     *            the move
     */
    void move(Point move);

    /**
     * Rotate the mow applying the given rotation.
     *
     * @param rotation
     *            the rotation
     */
    void rotate(ERotation rotation);

}
