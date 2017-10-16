/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model;

import java.util.Collection;

/**
 * The Interface IMap.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public interface IMap {

    /**
     * Add the positionned object to map.
     *
     * @param object
     *            object to be added on the map
     */
    void add(IPositionnedObject object);

    /**
     * Apply move from within the map.
     *
     * @param from
     *            from position
     * @param delta
     *            move to apply
     * @return return the valid destination or from
     */
    Point apply(Point from, Point delta);

    /**
     * Get the list of positionned objects present at the given position.
     *
     * @param position
     *            position of the returned objects
     * @return the list of objects present at the given position
     */
    Collection<IPositionnedObject> get(Point position);

    /**
     * Return the map size.
     *
     * @return the map size
     */
    Point getSize();

    /**
     * Remove the positionned object from the map.
     *
     * @param object
     *            to be removed from the map
     */
    void remove(IPositionnedObject object);

}
