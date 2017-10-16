/*****************************************************************************
 * Copyright (c) 2017 Pierre GAUTIER.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *****************************************************************************/
package fr.xebia.mow.model;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum EMove.
 *
 * A decent evolution would be to internationalize the constants label.
 *
 * @author Pierre GAUTIER <pierre.pg.gautier@gmail.com>
 */
public enum EMove {

    /** The forward. */
    FORWARD('A', ECardinal.NORTH, ECardinal.EAST, ECardinal.SOUTH, ECardinal.WEST),

    /** The backward. */
    BACKWARD('B', ECardinal.SOUTH, ECardinal.WEST, ECardinal.NORTH, ECardinal.EAST),

    /** The strafe left. */
    LEFT('L', ECardinal.WEST, ECardinal.NORTH, ECardinal.EAST, ECardinal.SOUTH),

    /** The strafe right. */
    RIGHT('R', ECardinal.EAST, ECardinal.SOUTH, ECardinal.WEST, ECardinal.NORTH);

    /**
     * From label.
     *
     * @param label
     *            the label
     * @return the move
     */
    public static EMove fromLabel(final char label) {
        for (final EMove value : EMove.values()) {
            if (value.label == label) {
                return value;
            }
        }
        return null;
    }

    private final Map<ECardinal, ECardinal> mapping = new HashMap<>();
    private char                            label;

    private EMove(final char label, final ECardinal fromN, final ECardinal fromE, final ECardinal fromS, final ECardinal fromW) {
        this.label = label;
        this.mapping.put(ECardinal.NORTH, fromN);
        this.mapping.put(ECardinal.EAST, fromE);
        this.mapping.put(ECardinal.SOUTH, fromS);
        this.mapping.put(ECardinal.WEST, fromW);
    }

    /**
     * Apply the move to the given cardinal.
     *
     * @param from
     *            the cardinal where the object is turned to
     * @return the point thats represent the dela to apply on the current position
     */
    public Point apply(final ECardinal from) {
        final ECardinal cardinal = this.mapping.get(from);
        return Point.create(cardinal.x, cardinal.y);
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
