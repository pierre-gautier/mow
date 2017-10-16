/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import fr.xebia.mow.model.IMap;
import fr.xebia.mow.model.IPositionnedObject;
import fr.xebia.mow.model.Point;

/**
 * The Class RectangularMap.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public class RectangularMap implements IMap {

    /**
     * The rectangular size.
     */
    protected final Point                 size;

    /**
     * The objects present on the map.
     */
    private final Set<IPositionnedObject> objects = new HashSet<>();

    /**
     * Create a {@link RectangularMap} from its size.
     *
     * First valid position is (0,0), last valid is (x-1, y-1).
     *
     * @param size
     *            the size
     */
    public RectangularMap(final Point size) {
        if (size == null || size.x < 1 || size.y < 1) {
            throw new IllegalArgumentException("size must be non-null and positive"); //$NON-NLS-1$
        }
        this.size = size;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.IMap#add(fr.xebia.mow.IPositionnedObject)
     */
    @Override
    public void add(final IPositionnedObject object) {
        this.objects.add(object);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.IMap#apply(fr.xebia.mow.Point, fr.xebia.mow.Point)
     */
    @Override
    public final Point apply(final Point from, final Point move) {
        final Point to = this.checkValid(from.plus(move));
        return to == null ? from : to;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.IMap#get(fr.xebia.mow.Point)
     */
    @Override
    public Collection<IPositionnedObject> get(final Point position) {
        if (position == null) {
            return Collections.emptyList();
        }
        final Collection<IPositionnedObject> result = new LinkedList<>();
        for (final IPositionnedObject existing : this.objects) {
            if (existing.getPosition().equals(position)) {
                result.add(existing);
            }
        }
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.IMap#getSize()
     */
    @Override
    public Point getSize() {
        return this.size;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xebia.mow.IMap#remove(fr.xebia.mow.IPositionnedObject)
     */
    @Override
    public void remove(final IPositionnedObject object) {
        this.objects.remove(object);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.size; //$NON-NLS-1$
    }

    /**
     * Check valid.
     *
     * This method can be ovrriden.
     *
     * @param to
     *            the to
     * @return valid position or null
     */
    protected Point checkValid(final Point to) {
        if (to == null || to.x < 0 || to.x >= this.size.x || to.y < 0 || to.y >= this.size.y) {
            return null;
        }
        return to;
    }

}
