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
 * The Class Point.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public final class Point {

    /** The Constant ORIGIN. */
    public static final Point ORIGIN = new Point(0, 0);

    /**
     * Creates the point.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the point
     */
    public static Point create(final int x, final int y) {
        if (x == 0 && y == 0) {
            return Point.ORIGIN;
        }
        return new Point(x, y);
    }

    /**
     * The x.
     */
    public final int x;

    /**
     * The y.
     */
    public final int y;

    /**
     * Instantiates a new point.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     */
    private Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.x;
        result = prime * result + this.y;
        return result;
    }

    /**
     * Plus.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the point
     */
    public final Point plus(final int x, final int y) {
        return Point.create(this.x + x, this.y + y);
    }

    /**
     * Plus.
     *
     * @param delta
     *            the delta
     * @return the point
     */
    public Point plus(final Point delta) {
        return Point.create(this.x + delta.x, this.y + delta.y);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.x + " " + this.y; //$NON-NLS-1$
    }

}
