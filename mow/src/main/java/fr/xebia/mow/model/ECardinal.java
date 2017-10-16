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
 * The Enum ECardinal.
 *
 * A decent evolution would be to internationalize the constants label.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public enum ECardinal {

    /** The North instance. */
    NORTH('N', 0, 1),

    /** The East instance. */
    EAST('E', 1, 0),

    /** The West instance. */
    WEST('W', -1, 0),

    /** The South instance. */
    SOUTH('S', 0, -1);

    /**
     * From label.
     *
     * @param label
     *            the label
     * @return the cardinal
     */
    public static ECardinal fromLabel(final char label) {
        for (final ECardinal value : ECardinal.values()) {
            if (value.label == label) {
                return value;
            }
        }
        return null;
    }

    private final char label;

    /** The x. */
    public final int   x;

    /** The y. */
    public final int   y;

    /**
     * @param label
     * @param value
     */
    private ECardinal(final char label, final int x, final int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return String.valueOf(this.label);
    }

}
